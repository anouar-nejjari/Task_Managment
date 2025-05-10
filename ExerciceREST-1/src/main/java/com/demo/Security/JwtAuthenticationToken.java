package com.demo.Security;

import java.util.Collection;

public class JwtAuthenticationToken {
	private final Object principal;
    private final Object credentials;

    public JwtAuthenticationToken(Object principal, Object credentials, Collection authorities) {
        super();
        this.principal = principal;
        this.credentials = credentials;
    }

    public Object getCredentials() {
        return credentials;
    }

    public Object getPrincipal() {
        return principal;
    }
}
