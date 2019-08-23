package com.djsm.inscripcion.configuration;

import com.djsm.inscripcion.model.User;
import com.djsm.inscripcion.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by dsosa on 7/25/2019.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService detailsService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();

        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User s= new User();
        s.setName("dsosa");
        s.setPass(passwordEncoder.encode("321"));
        userRepository.save(s);

        auth.userDetailsService(detailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("ins/h2/**","/").permitAll()
                .anyRequest().authenticated();
                */
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
                .authorizeRequests().antMatchers("/h2/**").permitAll();
                http.csrf().disable();
                http.headers().frameOptions().disable();
       /* http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
                */
    }
}
