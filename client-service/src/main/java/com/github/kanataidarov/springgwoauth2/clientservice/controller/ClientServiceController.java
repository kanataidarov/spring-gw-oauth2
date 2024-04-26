package com.github.kanataidarov.springgwoauth2.clientservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/client")
public class ClientServiceController {

    private final WebClient webClient;

    public ClientServiceController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/ping")
    @PreAuthorize("hasAuthority('spring-gw-oauth2')")
    public String ping() {
        String scopes = webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return "Backend service Scopes: " + scopes;
    }



}
