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

package id.web.faisalabdillah.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
/**
 * 
 * id.web.faisalabdillah.domain
 * @author
 * Muhamad Faisal Abdillah
 * <br/> Jul 17, 2012
 *
 */
@MappedSuperclass
public class BaseDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
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
