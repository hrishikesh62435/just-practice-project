package com.demo.configer;
/*
 * package com.demo.security.config;
 * 
 * import java.io.IOException; import java.util.Set;
 * 
 * import org.springframework.security.core.Authentication; import
 * org.springframework.security.core.authority.AuthorityUtils; import
 * org.springframework.security.web.authentication.
 * SavedRequestAwareAuthenticationSuccessHandler; import
 * org.springframework.stereotype.Component;
 * 
 * import jakarta.servlet.ServletException; import
 * jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 * @Component public class LoginSuccessHandler extends
 * SavedRequestAwareAuthenticationSuccessHandler {
 * 
 * public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
 * HttpServletResponse httpServletResponse, Authentication authentication)
 * throws IOException, ServletException {
 * 
 * Set<String> roles =
 * AuthorityUtils.authorityListToSet(authentication.getAuthorities());
 * 
 * if (roles.contains("ADMIN")) {
 * httpServletResponse.sendRedirect("/list-employee"); } else if
 * (roles.contains("NORMAL")) { httpServletResponse.sendRedirect("/home"); } }
 * 
 * }
 */