package com.laurspilca.springsecurity.config.security.filters;


import com.laurspilca.springsecurity.config.security.authentication.ApiKeyAuthentication;
import com.laurspilca.springsecurity.config.security.managers.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {
    private final String key;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        CustomAuthenticationManager manager = new CustomAuthenticationManager();
        ApiKeyAuthentication auth = new ApiKeyAuthentication(key);

        Authentication a = manager.authenticate(auth);
        filterChain.doFilter(request, response);
    }
}
