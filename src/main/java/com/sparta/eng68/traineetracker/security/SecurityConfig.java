package com.sparta.eng68.traineetracker.security;

import com.sparta.eng68.traineetracker.services.CustomUserDetailsService;
import com.sparta.eng68.traineetracker.utilities.CSVLoginReader;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//        CSVLoginReader csvLoginReader = new CSVLoginReader("src/main/resources/login.csv");
//        String loginDetails = csvLoginReader.getNextCSVLine();
//        while (loginDetails != null) {
//            String[] loginCredentials = loginDetails.split(",");
//            auth.inMemoryAuthentication()
//                    .withUser(loginCredentials[0]).password(passwordEncoder().encode(loginCredentials[1])).roles(loginCredentials[2]);
//            loginDetails = csvLoginReader.getNextCSVLine();
//        }
//        csvLoginReader.close();
    }

//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("trainer@spartaglobal.com").password(passwordEncoder().encode("trainer")).roles("TRAINER")
////                .and()
////                .withUser("trainee@spartaglobal.com").password(passwordEncoder().encode("trainee")).roles("TRAINEE")
////                .and()
////                .withUser("a").password(passwordEncoder().encode("a")).roles("TRAINER")
////                .and()
////                .withUser("b").password(passwordEncoder().encode("b")).roles("TRAINEE");
//
//        CSVLoginReader csvLoginReader = new CSVLoginReader("src/main/resources/login.csv");
//        String loginDetails = csvLoginReader.getNextCSVLine();
//        while (loginDetails != null) {
//            String[] loginCredentials = loginDetails.split(",");
//            auth.inMemoryAuthentication()
//                    .withUser(loginCredentials[0]).password(passwordEncoder().encode(loginCredentials[1])).roles(loginCredentials[2]);
//            loginDetails = csvLoginReader.getNextCSVLine();
//        }
//        csvLoginReader.close();
//    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/trainer*").hasRole("TRAINER")
//                .antMatchers("/trainee*").hasRole("TRAINEE")
//                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/css/**", "/js/**", "/scss/**", "/vendor/**", "/webjars/**", "/index", "/", "/images/**", "/login*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/perform_login")
                .successHandler(new RoleUrlAuthenticationSuccessHandler())
//                .defaultSuccessUrl("http://localhost:8080/home")
//              .failureUrl("/login.html?error=true")
                .failureHandler(new FailureHandler("/loginFailure"))
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
