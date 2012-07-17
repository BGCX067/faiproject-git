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

package id.web.faisalabdillah.wb.model;

import id.web.faisalabdillah.domain.Group;
import id.web.faisalabdillah.domain.User;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UserModel {
	
	private String id;
	
	private char[] password;

	private String[] group;
	
	private Date lastlogin;
	
	private boolean active;

	private String status;
	
	private String name;
	
	private String address;

	public User toUser(){
		User user=new User();
		Set<Group> groups=new HashSet<Group>();
		for (int i = 0; i < group.length; i++) {
			Group gr=new Group();
			gr.setCode(group[i]);
			groups.add(gr);
		}
		user.setGroup(groups);
		return user;
	}
	
	public void toUserModel(User user){
		this.id         =   user.getId          ();
        this.password   =   user.getPassword    ();
        Set<Group> grs=user.getGroup();
        this.group=new String[grs.size()];
        int i=0;
        for (Iterator<Group> iterator = grs.iterator(); iterator.hasNext();) {
			Group group = (Group) iterator.next();
			this.group[i]=group.getCode();
			i++;
		}
		this.lastlogin  =   user.getLastlogin   ();
		this.active     =   user.isActive      ();
		this.status     =   user.getStatus      ();
		this.name       =   user.getName        ();
		this.address    =   user.getAddress     ();
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

	

	public String[] getGroup() {
		return group;
	}

	public void setGroup(String[] group) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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
