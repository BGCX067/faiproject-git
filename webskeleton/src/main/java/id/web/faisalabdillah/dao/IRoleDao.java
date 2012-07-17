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

package id.web.faisalabdillah.dao;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.domain.Role;

import java.util.List;

public interface IRoleDao {
	
	public List<Role> findRoleByExample(Role role);
	public PaginationResult<Role> findRoleByExample(Role role,int firstIndex,int maxResult);

}
