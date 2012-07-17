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

import id.web.faisalabdillah.common.CommonMenuTree;
import java.util.Set;

public class UserPrincipal {
	private String userid;
	private String email;
	private Set<String> groupIds;
	private Set<String> roleIds;
	private boolean active;
	private Set<CommonMenuTree> menus;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Set<CommonMenuTree> getMenus() {
		return menus;
	}
	public void setMenus(Set<CommonMenuTree> menus) {
		this.menus = menus;
	}
	public Set<String> getGroupIds() {
		return groupIds;
	}
	public void setGroupIds(Set<String> groupIds) {
		this.groupIds = groupIds;
	}
	public Set<String> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Set<String> roleIds) {
		this.roleIds = roleIds;
	}
}
