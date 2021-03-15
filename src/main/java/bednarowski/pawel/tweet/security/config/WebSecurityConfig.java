package bednarowski.pawel.tweet.security.config;

import bednarowski.pawel.tweet.service.CreateUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CreateUserService createUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/*/**")
                .permitAll().anyRequest().authenticated()
                .and().headers().frameOptions().disable().and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("USER");
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(createUserService);
        return provider;
    }
}
