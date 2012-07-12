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
