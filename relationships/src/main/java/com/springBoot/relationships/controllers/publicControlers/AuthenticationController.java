package com.springBoot.relationships.controllers.publicControlers;

import com.springBoot.relationships.models.request.Login;
import com.springBoot.relationships.models.request.Register;
import com.springBoot.relationships.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService service;

    @GetMapping("/test")
    public String testApi(){
        return "TestApi works.";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register( @Valid @RequestBody Register register) {
        return ResponseEntity.ok().body(service.register(register));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login( @Valid @RequestBody Login login) {
        return service.authenticate(login);
    }
}
