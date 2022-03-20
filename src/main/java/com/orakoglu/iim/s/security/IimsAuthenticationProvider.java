package com.orakoglu.iim.s.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class IimsAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String token = (String) authentication.getPrincipal();
		return checkToken(token);
	}

	private Authentication checkToken(String token) {
		if (token != null && token.equals("1"))
			return new PreAuthenticatedAuthenticationToken("Authenticated", "ROLE_ADMIN");
		else
			throw new AccessDeniedException("Invalid Token");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return PreAuthenticatedAuthenticationToken.class.equals(authentication);
	}

}
