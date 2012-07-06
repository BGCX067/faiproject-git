package id.web.faisalabdillah.dto;

import id.web.faisalabdillah.domain.Group;
import id.web.faisalabdillah.domain.User;
import id.web.faisalabdillah.domain.UserDetail;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DTOUser extends UserDetail{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DTOUser() {
	}
	
	private User user;
	public DTOUser(User user) {
		this.user=user;
		loadUser(user);
	}

	public void loadUser(User user){
		this.setId			(user.getId());
		this.setLastlogin	(user.getLastlogin());
		this.setStatus		(user.getStatus());
		this.setActive(user.isActive());
		this.setName(user.getName());
		this.setAddress(user.getAddress());
		this.setCreateby(user.getCreateby());
		this.setCreatetm(user.getCreatetm());
		this.setLastupdby(user.getLastupdby());
		this.setLastupdtm(user.getLastupdtm());
		this.setDeleted(user.isDeleted());
	}
	
	/**
	 * Return User Without Role
	 * @return
	 */
	public User getUser(){
		UserDetail detail=(UserDetail)this;
		User user=(User) detail;
		user.setId(this.id);
		user.setPassword(this.password);
		user.setLastlogin(this.lastlogin);
		user.setActive(this.active);
		user.setStatus(this.status);
		return user;
	}
	private String id;
	
	private char[] password;
	
	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}
	private Date lastlogin;
	private boolean active;
	
	private String status;

	
	public Set<String> getGroupCodes() {
		Set<Group> groups=user.getGroup();
		Set<String> groupIds=null;
		if(groups!=null){
			groupIds=new HashSet<String>();
		for (Group group : groups) {
			groupIds.add(group.getCode());
		}
		}
		return groupIds;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
