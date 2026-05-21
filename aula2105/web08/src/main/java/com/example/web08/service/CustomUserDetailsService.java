package com.example.web08.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import com.example.web08.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        // Injeção de dependência por construtor, seguindo o padrão que você usou no controller
        this.userRepository = userRepository; 
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.web08.model.User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Retorna o objeto User padrão do Spring Security mapeando os dados do nosso banco
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRole()) // Define os papéis de acesso do usuário
                .build();
    }
}