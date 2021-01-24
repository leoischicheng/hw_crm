package com.smartbee.crm.config;

import com.smartbee.crm.service.UserS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService customUserDetailService() {
        return new UserS();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(customUserDetailService()).passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/**/update/**", "/**/delete/**").hasAnyAuthority("MANAGER", "SUPERUSER")
            .antMatchers("/**/create/**").hasAnyAuthority("OPERATOR", "SUPERUSER")
            .antMatchers("/**/query/**").hasAnyAuthority("OPERATOR", "MANAGER", "SUPERUSER")
            .anyRequest()
            .authenticated()
            .and().formLogin().permitAll().and()
            .httpBasic()
            .and().csrf().disable();
    }
}
