package com.demo.Security;

import java.io.IOException;

import com.ecom.config.CustomUser;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class JwtFilter implements Filter {

    @javax.inject.Inject
    private JwtUtil jwtUtil; 

    @javax.inject.Inject
    private CustomUserDetails customUserDetailsService; 

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String token = httpRequest.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);  // Extract token by removing "Bearer "

            String username = jwtUtil.extractUsername(token);  // Extract the username from the token

            if (username != null && httpRequest.getUserPrincipal() == null) {
                CustomUser userDetails = CustomUserDetails.loadUserByUsername(username);

                if (userDetails != null && !jwtUtil.isTokenExpired(token)) {
                    JwtAuthenticationToken authentication = new JwtAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    httpRequest.setAttribute("user", authentication);  

                }
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
