package com.github.kanataidarov.springgwoauth2.backendservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend")
public class BackendServiceController {

    @GetMapping("/ping")
    @PreAuthorize("hasAuthority('spring-gw-oauth2')")
    public String ping() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return "Scopes: " + authentication.getAuthorities();
    }
}
