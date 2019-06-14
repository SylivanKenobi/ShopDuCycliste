package ch.happy.cyclist.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Klasse zu konfigurierung von SpringSecurity
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Methode zur Zugriffskonfiguration
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()

                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/admin", true)
                .failureUrl("/login.html?error=true")
                .and()
                .logout()
                .logoutUrl("/kunde/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID");
    }
}
