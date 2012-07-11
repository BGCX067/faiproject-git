package id.web.faisalabdillah.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MST_ROLE")
public class Role extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String code;
	@Column
	private String description;

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
