package id.web.faisalabdillah.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		UserPrincipal users=(UserPrincipal) auth.getPrincipal();
		if(users==null){
			throw new BadCredentialsException("User Not found");
		}
		if(!users.isActive()){
			throw new DisabledException(users.getUserid()+" is Disabled");
		}
		return auth;
	}

	@Override
	public boolean supports(Class<? extends Object> arg0) {
		return false;
	}

}
