package hu.elte.DogTrainingApplication.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/trainer/**", "/trainer/registration", "/").permitAll()   // important!
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(getBasicAuthEntryPoint())
                .and()
                .headers()      // important!
                .frameOptions().disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

}


//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private static final String USER="USER";
//    private static final String ADMIN="ADMIN";
//
//    @Autowired
//    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
//
//        auth
//            .inMemoryAuthentication()
//            .withUser("user").password("{noop}user").roles(USER)
//            .and()
//            .withUser("admin").password("{noop}admin").roles(ADMIN,USER);
//    }
//
//
//    @Override
//    protected  void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity
//                .authorizeRequests()
//                    .antMatchers("/dog/**").hasRole(USER)
//                    .antMatchers("/trainer/**").hasRole(ADMIN)
//                    .anyRequest().authenticated()
//                .and()
//                    .formLogin().permitAll()
//                .and()
//                    .httpBasic()
//                .and()
//                .logout().logoutSuccessUrl("/login?logout").permitAll();
//
//    }


//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//}