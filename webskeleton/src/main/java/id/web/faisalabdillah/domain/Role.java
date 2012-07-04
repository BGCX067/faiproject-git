package id.web.faisalabdillah.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="MST_ROLE")
public class Role extends BaseDomain {
	
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
