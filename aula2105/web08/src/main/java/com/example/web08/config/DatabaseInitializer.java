package com.example.web08.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.web08.model.User;
import com.example.web08.repository.UserRepository;

@Configuration
public class DatabaseInitializer {

    @Bean
    public CommandLineRunner initializeDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String adminUsername = "admin";

            // Verifica se o usuário 'admin' já existe no banco para não duplicar a cada reinício
            if (userRepository.findByUsername(adminUsername).isEmpty()) {
                User admin = new User();
                admin.setUsername(adminUsername);
                
                // Criptografa a senha "admin" usando o BCrypt automaticamente antes de salvar
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setRole("ROLE_ADMIN");

                userRepository.save(admin);
                System.out.println(">>> [Spring Security] Usuário padrão 'admin' criado com sucesso! <<<");
            } else {
                System.out.println(">>> [Spring Security] Usuário 'admin' já existente no banco de dados. <<<");
            }
        };
    }
}