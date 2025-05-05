package com.residencia.apivalidacaocomentarios.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class SecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager gerenciadorUsuariosEmMemoria() {
//        UserDetails usuario = User.withUsername("user")
//                .password("{noop}user123")
//                .roles("USERS")
//                .build();
//
//        UserDetails administrador = User.withUsername("admin")
//                .password("{noop}master123")
//                .roles("MANAGERS")
//                .build();
//
//        return new InMemoryUserDetailsManager(usuario, administrador);
//    }
//
//    @Bean
//    public SecurityFilterChain cadeiaDeFiltros(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(autorizacao -> autorizacao
//                        .requestMatchers(
//                                "/h2-console/**",
//                                "/login",
//                                "/esqueci-senha",
//                                "/comentarios/**"
//                        ).permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login") // Página personalizada
//                        .defaultSuccessUrl("/comentarios", true) // Redirecionamento após login
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/login?logout")
//                        .permitAll()
//                )
//                .headers(headers -> headers
//                        .frameOptions(frame -> frame.sameOrigin())
//                )
//                .csrf(csrf -> csrf
//                        .ignoringRequestMatchers("/h2-console/**", "/comentarios/**")
//                );
//
//        return http.build();
//    }
}
