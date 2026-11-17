package hh.backend.boulderbuddy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain configure (HttpSecurity http) throws Exception {

        http

        /* CSS authorized without login and authentication required by default*/
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/css/**").permitAll() 
            .anyRequest().authenticated()
        )

        /* Skip CSRF checks for H2 console requests */
        .csrf(csrf -> csrf
            .ignoringRequestMatchers("/h2-console/**")
        )

        /* Allow frames for H2 -console */
        .headers(headers -> headers
            .frameOptions(frame -> frame
                .sameOrigin()
            )
        )

        /* Redirect to /boulders after login */
        .formLogin( loginForm -> loginForm
            .defaultSuccessUrl("/boulders", true)
            .permitAll()
        )
        /* Log out enabled */
        .logout( logout -> logout
            .permitAll()
        );
        
        return http.build();
    }
    /* PasswordHash with BCrypt */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
