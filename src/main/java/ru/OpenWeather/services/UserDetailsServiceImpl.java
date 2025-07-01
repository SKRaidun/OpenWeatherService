package ru.OpenWeather.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.OpenWeather.DAO.UserDAO;
import ru.OpenWeather.models.User;
import ru.OpenWeather.security.UserDetailsSecurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public UserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findUser(username);

        System.out.println(user.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException("sign-in-with-errors");
        }
        return new UserDetailsSecurity(user);
    }
}
