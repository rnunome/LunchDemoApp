package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/css/**", "/js/**").permitAll()
			//.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
			.anyRequest().authenticated();

		http.formLogin()
			.loginPage("/login")
			.permitAll()
		    .usernameParameter("username")
		    .passwordParameter("password")
			.defaultSuccessUrl("/success")
			.failureUrl("/fail");

//		System.out.println("password : " + passwordEncoder().encode("password"));
	}
}
