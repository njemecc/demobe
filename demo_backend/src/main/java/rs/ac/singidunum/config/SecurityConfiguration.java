package rs.ac.singidunum.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpMethod.DELETE;
import static rs.ac.singidunum.enums.PermissionEnum.*;
import static rs.ac.singidunum.enums.RoleEnum.Admin;
import static rs.ac.singidunum.enums.RoleEnum.Employee;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

   @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http.csrf()
               .disable()
               .authorizeHttpRequests()
               .requestMatchers("/api/v1/auth/register", "/api/v1/auth/login")
               .permitAll()
               .requestMatchers("/api/v1/employee/**").hasAnyRole(Admin.name(), Employee.name())
               .requestMatchers("/api/v1/admin/get").hasAnyRole(Admin.name())
               .requestMatchers(GET, "/api/v1/employee/**").hasAnyAuthority(AdminRead.name(), EmployeeRead.name())
               .requestMatchers(POST, "/api/v1/employee/**").hasAnyAuthority(AdminCreate.name(), EmployeeCreate.name())
               .requestMatchers(PUT, "/api/v1/employee/**").hasAnyAuthority(AdminUpdate.name(), EmployeeUpdate.name())
               .requestMatchers(DELETE, "/api/v1/employee/**").hasAnyAuthority(AdminDelete.name(), EmployeeDelete.name())
               .anyRequest()
               .authenticated()
               .and()
               .sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .authenticationProvider(authenticationProvider)
               .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
               .logout()
               .logoutUrl("/api/v1/auth/logout")
               .addLogoutHandler(logoutHandler)
               .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());

       return http.build();
   }

}
