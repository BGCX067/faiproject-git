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

package id.web.faisalabdillah.service;

import java.io.Serializable;
import java.util.List;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.domain.User;

public interface IUserService extends BaseService<User>{

	User findById(Serializable id,boolean eager);
	
	List<User> findAll(boolean eager);
	
	List<User> findByExample(User entity,boolean eager);
	
	PaginationResult<User> findUserByName(String name,int firstResult,int maxResult);

	PaginationResult<User> findAllPaged(int firstResult, int maxResult);

	PaginationResult<User> findByExample(User user, int firstResult,
			int maxResult);

	PaginationResult<User> findByExample(User user, int firstResult,
			int maxResult, boolean eager);

	PaginationResult<User> findAllPaged(boolean eager, int firstResult,
			int maxResult);

	
	
	
}
