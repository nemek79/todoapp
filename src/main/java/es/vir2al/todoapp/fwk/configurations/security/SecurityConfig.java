package es.vir2al.todoapp.fwk.configurations.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
// https://www.codejava.net/frameworks/spring-boot/fix-websecurityconfigureradapter-deprecated
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
             "/swagger-ui/**", 
             "/v3/api-docs/**"
     };
     
     @Autowired
     private JwtAuthenticationEntryPoint unauthorizedHandler;

     @Bean
     public JwtAuthenticationFilter jwtAuthenticationFilter() {
         return new JwtAuthenticationFilter();
     }

     @Override
     protected void configure(HttpSecurity http) throws Exception {

         http.cors().and().csrf().disable()
                 .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                 .anyRequest().authenticated();

         http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

     }
     
     public void configure(WebSecurity web) throws Exception {
         web.ignoring().antMatchers(AUTH_WHITELIST);
     }
 
}