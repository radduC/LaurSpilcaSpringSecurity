package com.laurspilca.springsecurity.controllers;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public List<String> demo() {
        var user = SecurityContextHolder.getContext().getAuthentication();
        return user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
    }
}
