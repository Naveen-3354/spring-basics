package com.springBoot.relationships.services;

import com.springBoot.relationships.components.security.JwtUtils;
import com.springBoot.relationships.models.entity.User;
import com.springBoot.relationships.models.request.Login;
import com.springBoot.relationships.models.request.Register;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    public String register(Register register) {
        var user = User.builder()
                .name(register.getName())
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .number(register.getNumber());
        userService.insertUser(user.build());
        return "User Added Successfully";
    }

    public ResponseEntity<String > authenticate(Login login) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        String token = jwtUtils.generateToken();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, createSetCookieHeader("token", token, "/", 60*24, true));
        return new ResponseEntity<>("Login successful", headers,HttpStatus.OK);
    }

    private String createSetCookieHeader(String name, String value, String path, int maxAge, boolean httpOnly) {
        StringBuilder cookie = new StringBuilder();
        cookie.append(name).append("=").append(value).append(";");
        cookie.append("Path=").append(path).append(";");
        cookie.append("Max-Age=").append(maxAge).append(";");
        if (httpOnly) {
            cookie.append("HttpOnly;");
        }
        return cookie.toString();
    }
}
