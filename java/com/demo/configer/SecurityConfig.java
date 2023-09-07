package com.demo.configer;

import java.io.IOException;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.spring.security.configer.UserDetailsServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	

	
	
	@Bean
	public UserDetailsService getUserDetailService() {
		return new EmployeeDetailsServiceImpl();
	}
 
  
 @Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {         	
		
	 http.csrf().disable()
	 .authorizeHttpRequests()
     .requestMatchers("/login3","/home").permitAll()
    
     .requestMatchers("/list-employee").hasRole("NORMAL")
     .requestMatchers("/edit-employee/{id}").hasRole("ADMIN")
     .anyRequest()
     .authenticated() 
     .and().formLogin()
     .loginPage("/login3")
     .loginProcessingUrl("/dologin")
     .successHandler(new AuthenticationSuccessHandler() {
         
         @Override
         public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                 Authentication authentication) throws IOException, ServletException {
              
        	 	System.out.println("start success Handler");
        	 String redirectUrl = "";
        	 
        	 System.out.println("hellow this auth methorun");
        	 
             UserDetails userDetails =  (UserDetails) authentication.getPrincipal();
             String username = userDetails.getUsername();
             System.out.println(username);
            
 	         Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
 	         System.out.println(roles);

 	        if (roles.contains("ROLE_NORMAL")) {
 	        	
 	        	 System.out.println("The user " + username + " has logged in."); 
 	        	redirectUrl = "/list-employee";
 	        	//response.sendRedirect(request.getContextPath()+"/user/getAllUsers");
 	        	
 	        } else if (roles.contains("ROLE_ADMIN")) {
 	        	
 	        	 System.out.println("The user " + username + " has logged in.");
 	        	redirectUrl = "/edit-employee/{id}";
 	        	//response.sendRedirect(request.getContextPath()+"/public/home");
 	        }
              
 	       new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);		
         }
     });
   
	  		  
  return http.build();
 
}

}