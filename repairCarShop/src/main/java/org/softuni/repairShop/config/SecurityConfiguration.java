package org.softuni.repairShop.config;

import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.repository.ClientRepository;
import org.softuni.repairShop.repository.UserRepository;
import org.softuni.repairShop.service.impl.RepairShopUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    private final AuthHandler authHandler;

    public SecurityConfiguration(AuthHandler authHandler) {
        this.authHandler = authHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
             //   .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorizeRequests -> authorizeRequests
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                         //     .anyRequest().permitAll()
                                //GUEST
                                .requestMatchers("/login", "/users/register","/clients/register","/").permitAll()
                                //CLIENT user
                                .requestMatchers("/client/**").hasRole(RoleEnum.CLIENT.name())
                                .requestMatchers("/error").permitAll()

                                .anyRequest().authenticated()

                )
                .formLogin(
                        formLogin -> formLogin
                                .loginPage("/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .successHandler(authHandler)
                           //    .defaultSuccessUrl("/")
                                .failureForwardUrl("/login/error")
                )
                .logout(
                        logout -> logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/")
                                .invalidateHttpSession(true)
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/")
                                .invalidateHttpSession(true)
                );
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository,
                                                 ClientRepository clientRepository) {
        return new RepairShopUserDetailsService(userRepository, clientRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}

