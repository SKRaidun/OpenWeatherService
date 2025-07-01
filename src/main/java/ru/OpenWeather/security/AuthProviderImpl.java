package ru.OpenWeather.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.OpenWeather.services.UserDetailsServiceImpl;

import java.util.Collections;

//@Component
//public class AuthProviderImpl implements AuthenticationProvider {
//
//    private final UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    public AuthProviderImpl(UserDetailsServiceImpl userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//
//        UserDetails user = userDetailsService.loadUserByUsername(username);
//
//        String password = authentication.getCredentials().toString();
//
//        System.out.println(password);
//        System.out.println(user.getPassword());
//
//        if (!password.equals(user.getPassword())) {
//            throw new BadCredentialsException("Incorrect password");
//        }
//
//        return new UsernamePasswordAuthenticationToken(userDetailsService, password, Collections.emptyList());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return false;
//    }
//}
