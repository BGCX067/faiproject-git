/**
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *	 
 */

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
