//package hu.elte.DogTrainingApplication.config;
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


    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/dog/**", "/trainer/registration", "/trainer/login","season_tickets/**","trick/**","trainer/**").permitAll()   // important!
                .anyRequest().permitAll()
                //.anyRequest().authenticated()
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
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    private static final String USER="USER";
////    private static final String ADMIN="ADMIN";
////
////    @Autowired
////    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
////
////        auth
////            .inMemoryAuthentication()
////            .withUser("user").password("{noop}user").roles(USER)
////            .and()
////            .withUser("admin").password("{noop}admin").roles(ADMIN,USER);
////    }
//
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors()
//                .and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/dog/**", "/trainer/registration", "/trainer/login","season_tickets/**","tricks/**").permitAll()   // important!
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint(getBasicAuthEntryPoint())
//                .and()
//                .headers()      // important!
//                .frameOptions().disable()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//
//    @Bean
//    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
//        return new CustomBasicAuthenticationEntryPoint();
//    }
//
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    protected void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//}
//
//
////@Configuration
////@EnableGlobalMethodSecurity(securedEnabled = true)
////@EnableWebSecurity
////public class SecurityConfig extends WebSecurityConfigurerAdapter {
////    private static final String USER="USER";
////    private static final String ADMIN="ADMIN";
////
////    @Autowired
////    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
////
////        auth
////            .inMemoryAuthentication()
////            .withUser("user").password("{noop}user").roles(USER)
////            .and()
////            .withUser("admin").password("{noop}admin").roles(ADMIN,USER);
////    }
////
////
////    @Override
////    protected  void configure(HttpSecurity httpSecurity) throws Exception{
////        httpSecurity
////                .authorizeRequests()
////                    .antMatchers("/dog/**").hasRole(USER)
////                    .antMatchers("/trainer/**").hasRole(ADMIN)
////                    .anyRequest().authenticated()
////                .and()
////                    .formLogin().permitAll()
////                .and()
////                    .httpBasic()
////                .and()
////                .logout().logoutSuccessUrl("/login?logout").permitAll();
////
////    }
//
//
////    @Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
////}
