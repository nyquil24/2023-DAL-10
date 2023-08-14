package org.nequiltaborn.imbibinglush.config;

import org.nequiltaborn.imbibinglush.services.UserService;
import org.nequiltaborn.imbibinglush.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Autowired
    private UserService userService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService((UserDetailsService) userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
              //  .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authz) ->
                    authz
                            .requestMatchers("/", "/login*",
                                    "/css/*", "/js/*", "/images/*","/png/*","/img/**","/registration","/home","liquor","/showNewLiquorForm","/logout"
                            ,"/saveLiquor").permitAll()
                            .requestMatchers("/home").hasAnyRole("users", "manager","employee")
                         .anyRequest().authenticated())

                           /* .requestMatchers(requestMatcher("/signin/**")).permitAll()
                        .requestMatchers(requestMatcher("/login")).permitAll()
                            .requestMatchers(requestMatcher("/js/**")).permitAll()
                            .requestMatchers(requestMatcher("/css/**")).permitAll()
                            .requestMatchers(requestMatcher("/images/**")).permitAll()
                            .requestMatchers(requestMatcher("/home")).permitAll()
                            .requestMatchers(requestMatcher("/registration")).permitAll()*/

                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/home")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login")
                                .permitAll());
        return http.build();
    }

    private RequestMatcher requestMatcher(String... patterns) {
        String pattern = String.join(",", patterns);
        return new AntPathRequestMatcher(pattern);
    }
}