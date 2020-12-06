package com.pl.giftshop.config;


import com.pl.giftshop.security.DatabaseUsersDetailsService;
import com.pl.giftshop.security.UsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter  {


        @Autowired
        private DatabaseUsersDetailsService databaseUsersDetailsService;

        @Autowired
        protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(databaseUsersDetailsService).passwordEncoder(restPasswordEncoder());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/api/**")
                    .cors() //cross origin request site
                    .and()
                    .csrf()
                    .disable()
                    .authorizeRequests()
                    //do not allow anything else
                    .antMatchers("/api/login").permitAll()
                    .antMatchers("/api/user/create-user").permitAll()
                    .anyRequest().authenticated();

            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http.addFilterBefore(new UsernameAndPasswordAuthenticationFilter(databaseUsersDetailsService),
                    UsernameAndPasswordAuthenticationFilter.class);


        }

        @Bean
        public PasswordEncoder restPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationManager manager() throws Exception {
            return super.authenticationManagerBean();
        }

    }
