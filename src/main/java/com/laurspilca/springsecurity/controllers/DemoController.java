package com.laurspilca.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
//        var user = SecurityContextHolder.getContext().getAuthentication();
//        return user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        return "Demo!";
    }
}
