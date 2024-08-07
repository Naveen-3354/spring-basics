package com.springBoot.relationships.services;

import com.springBoot.relationships.models.entity.User;
import com.springBoot.relationships.models.securityModel.AuthUser;
import com.springBoot.relationships.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsImpl implements UserDetailsService {

    private final UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return AuthUser.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRoles().toString())
                .build();
    }
}
