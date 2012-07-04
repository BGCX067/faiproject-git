package id.web.faisalabdillah.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="MST_USER")
public class User extends UserDetail {

	@Id
	private String id;
	
	@Column
	private char[] password;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Group> group;
	
	@Column
	private Date lastlogin;
	
	@Column
	private boolean active;

	@Column
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public Set<Group> getGroup() {
		return group;
	}

	public void setGroup(Set<Group> group) {
		this.group = group;
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
	
	
	
}
