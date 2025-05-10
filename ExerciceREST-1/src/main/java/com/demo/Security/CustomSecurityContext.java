package com.demo.Security;

import java.security.Principal;

import org.springframework.security.core.context.DeferredSecurityContext;

import com.ecom.config.CustomUser;

import jakarta.servlet.http.HttpServletRequest;

public abstract class CustomSecurityContext implements DeferredSecurityContext {
	public abstract CustomUser loadUserByUsername(String username);

    private final HttpServletRequest request;

    public CustomSecurityContext(HttpServletRequest request) {
        this.request = request;
    }

    public Principal getUserPrincipal() {
        return request.getUserPrincipal();  
    }

    public boolean isUserInRole(String role) {
        return request.isUserInRole(role);
    }

    public String getAuthenticationScheme() {
        return "Bearer";  
    }
}
