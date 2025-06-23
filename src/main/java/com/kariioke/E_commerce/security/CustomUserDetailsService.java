package com.kariioke.E_commerce.security;

import com.kariioke.E_commerce.entity.User;
import com.kariioke.E_commerce.exceptions.NotFoundException;
import com.kariioke.E_commerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new NotFoundException("User/ Email not found"));
        return AuthUser.builder()
                .user(user)
                .build();
    }
}
