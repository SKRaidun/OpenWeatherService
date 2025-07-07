package ru.OpenWeather.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.OpenWeather.DAO.LocationDAO;
import ru.OpenWeather.DAO.SessionDAO;
import ru.OpenWeather.DAO.UserDAO;
import ru.OpenWeather.models.Location;
import ru.OpenWeather.models.Sessions;
import ru.OpenWeather.models.User;
import ru.OpenWeather.security.UserDetailsSecurity;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Controller
@RequestMapping("/weather-service")
public class LocationController {

    private final UserDAO dao;
    private final SessionDAO sessionDAO;
    private  final LocationDAO locationDAO;
    private Sessions session;
    private final SessionValidator sessionValidator;
    private final LocationValidator locationValidator;

    @Autowired
    public LocationController(UserDAO dao, SessionDAO sessionDAO, LocationDAO locationDAO, SessionValidator sessionValidator, LocationValidator locationValidator) {
        this.dao = dao;
        this.sessionDAO = sessionDAO;
        this.locationDAO = locationDAO;
        this.sessionValidator = sessionValidator;
        this.locationValidator = locationValidator;
    }



    @GetMapping()
    public String login(Model model, HttpServletRequest request, @AuthenticationPrincipal UserDetailsSecurity userDetailsSecurity) {

        User user = userDetailsSecurity.getUser();

        List<Location> locations = null;

        try {
            locations = locationDAO.findLocationsByUserId(user.getId());
        } catch (NullPointerException e) {}

        for (Location loc : locations) {
            System.out.println(loc.getId());
        }

        model.addAttribute("locations", locations);
        model.addAttribute("username", user.getLogin());

        return "index";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, @AuthenticationPrincipal UserDetailsSecurity userDetailsSecurity) {
        User user = userDetailsSecurity.getUser();
        return "redirect:/login";
    }


    @PostMapping()
    private String addLocation(Model model, @ModelAttribute("location") String location, HttpServletRequest request, @AuthenticationPrincipal UserDetailsSecurity userDetailsSecurity) throws IOException, InterruptedException {
        Location newLocation = locationValidator.findLocationWithAPI(location);

        System.out.println("SISA");

        if (newLocation == null) {
            return "redirect:/weather-service";
        }

        User user = userDetailsSecurity.getUser();
        String locationName = newLocation.getName();
        int userID = user.getId();
        if (locationDAO.findLocationByNameAndId(locationName, userID)) return "redirect:/weather-service";
        newLocation.setUser(user);
        locationDAO.createLocation(newLocation);

        return "redirect:/weather-service";
    }



    @PostMapping("/delete-location")
    public String deleteLocationById(@RequestParam("id") int locationId,
                                 HttpServletRequest request, @AuthenticationPrincipal UserDetailsSecurity userDetailsSecurity) {


        System.out.println("UUUUUUUUU");
        System.out.println(locationId);
        User user = userDetailsSecurity.getUser();

        System.out.println("POPA");
        System.out.println(locationId);

        boolean userOwnsLocation = locationDAO.findLocationsByUserId(user.getId())
                .stream()
                .anyMatch(loc -> loc.getId() == locationId);

        if (userOwnsLocation) {
            locationDAO.deleteLocationById(locationId);
        }

        return "redirect:/weather-service";
    }
}
