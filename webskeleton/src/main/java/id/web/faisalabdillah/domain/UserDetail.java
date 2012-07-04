package id.web.faisalabdillah.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UserDetail extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private String name;
	@Column
	private String address;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
