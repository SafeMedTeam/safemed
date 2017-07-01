package com.bafal.dev.patient.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ComponentScan
@EnableWebSecurity
public class SafeMedSecureConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .exceptionHandling().and().headers().and().sessionManagement().and().securityContext().and().requestCache()
            .and().authorizeRequests()
				.antMatchers("/login", "/reset/**", "/logout", "/error", "/webjars/**")
				.permitAll().antMatchers("/safemedtheme/**", "/jquery/**").permitAll()
            .antMatchers("/static/patient.json").authenticated().anyRequest().authenticated().and().formLogin()
            .loginPage("/login").defaultSuccessUrl("/").permitAll().and().logout().invalidateHttpSession(true)
            .permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
        // auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

}
