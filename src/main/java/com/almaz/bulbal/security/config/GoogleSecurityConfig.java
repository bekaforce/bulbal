//package com.almaz.bulbal.security.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Configuration
//public class GoogleSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .oauth2Login();
////        http.authorizeRequests()
////                .antMatchers("/swagger-ui/**").permitAll()
////                .antMatchers("/v3/api-docs/**").permitAll()
////                .anyRequest().authenticated()
////                .and().oauth2Login()
//////                .and().formLogin()
//////                .loginPage("/login").permitAll()
//////                .and().logout().permitAll()
//////                .antMatchers(SWAGGER_API_URL).permitAll()
//////                .antMatchers(SWAGGER_URL).permitAll() // Swagger endpoint
//////                .antMatchers(SWAGGER_RESOURCE_URL).permitAll()
//////                .antMatchers(SWAGGER_WEBJARS_URL).permitAll()
////
//////                .antMatchers("/**").fullyAuthenticated()
////                .and()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//////                .and()
//////                .oauth2ResourceServer().jwt()
////                .and()
////                .cors().and().csrf().disable();
//    }
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .anyRequest().authenticated()
////                .and()
////                .oauth2Login();
////        return http.build();
////    }
//}
