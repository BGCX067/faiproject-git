package id.web.faisalabdillah.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(columnDefinition="")
	private String createby;
	@Column
	private Date createtm;
	@Column
	private String lastupdby;
	@Column
	private Date lastupdtm;
	@Column
	private Boolean deleted;

	public Boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getCreatetm() {
		return createtm;
	}

	public void setCreatetm(Date createtm) {
		this.createtm = createtm;
	}

	public String getLastupdby() {
		return lastupdby;
	}

	public void setLastupdby(String lastupdby) {
		this.lastupdby = lastupdby;
	}

	public Date getLastupdtm() {
		return lastupdtm;
	}

	public void setLastupdtm(Date lastupdtm) {
		this.lastupdtm = lastupdtm;
	}

}
