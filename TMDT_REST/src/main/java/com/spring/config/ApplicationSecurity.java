package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.cors().and().csrf().disable().authorizeRequests()
         .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
         .anyRequest().authenticated()
         .and()
//         .addFilter(new JWTAuthenticationFilter(authenticationManager()))
         .addFilter(new JWTAuthorizationFilter(authenticationManager()))
         // this disables session creation on Spring Security
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	}

}
