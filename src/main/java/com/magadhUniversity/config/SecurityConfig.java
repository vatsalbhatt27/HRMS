//package com.magadhUniversity.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable()
//            .authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/**").permitAll()
//                .anyRequest().authenticated()
//            );
//
//        return http.build();
//    }
//}

//package com.magadhUniversity.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/students/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/employees/**").hasRole("ADMIN")
//                        .requestMatchers("/employees/attendance/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/attendance/**").hasRole("EMPLOYEE")
//                        .requestMatchers("/student-marks/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/subjects/**").hasRole("ADMIN")
//                        .requestMatchers("/mark_attendance").authenticated()
//                        .anyRequest().authenticated()
//                )
//                .formLogin().permitAll()
//                .and().logout().permitAll();
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}

//package com.magadhUniversity.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/students/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/employees/**").hasRole("ADMIN")
//                        .requestMatchers("/employees/attendance/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/attendance/**").hasRole("EMPLOYEE")
//                        .requestMatchers("/student-marks/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/subjects/**").hasRole("ADMIN")
//                        .requestMatchers("/mark_attendance").authenticated()
//                        .anyRequest().authenticated()
//                )
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .and()
//                .logout().permitAll();
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}

//package com.magadhUniversity.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/students/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/employees/**").hasRole("ADMIN")
//                        .requestMatchers("/employees/attendance/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/attendance/**").hasRole("EMPLOYEE")
//                        .requestMatchers("/student-marks/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/subjects/**").hasRole("ADMIN")
//                        .requestMatchers("/mark_attendance").authenticated()
//                        .anyRequest().authenticated()
//                )
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/home") // Default landing page URL after login
//                .and()
//                .logout().permitAll();
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
package com.magadhUniversity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disabling CSRF protection explicitly
                .authorizeRequests((requests) -> requests
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()  // Allow static resources without authentication
                        .requestMatchers("/students/**").hasAnyRole("ADMIN", "EMPLOYEE")  // Access for Admin and Employee roles
                        .requestMatchers("/employees/**").hasRole("ADMIN")  // Admin-only access for employees
                        .anyRequest().authenticated()  // All other requests need to be authenticated
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")  // Custom login page URL
                        .permitAll()  // Allow everyone to access the login page
                        .loginProcessingUrl("/login")  // URL for Spring Security to process the login form
                        .defaultSuccessUrl("/home", true)  // Default redirection URL after successful login
                        .failureUrl("/login?error=true")  // Redirect to login page on failure
                )
                .logout(logout -> logout
                        .permitAll()  // Allow everyone to log out
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Using BCrypt for password encoding
    }
}
