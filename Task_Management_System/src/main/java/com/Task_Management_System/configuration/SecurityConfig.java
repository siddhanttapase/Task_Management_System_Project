package com.Task_Management_System.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf(csrf -> csrf.disable())
//				.authorizeHttpRequests(
//						auth -> auth.requestMatchers("/api/tasks/**").authenticated().anyRequest().permitAll())
//				.httpBasic();
//		return httpSecurity.build();
//
//	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.builder().username("user").password(passwordEncoder().encode("user"))
				.roles("User").build();
		UserDetails adminDetails = User.builder().username("admin").password(passwordEncoder().encode("admin"))
				.roles("Admin").build();
		return new InMemoryUserDetailsManager(userDetails,adminDetails);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();

	}

}
