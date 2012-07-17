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

package id.web.faisalabdillah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.dao.impl.RoleDaoImpl;
import id.web.faisalabdillah.domain.Role;
import id.web.faisalabdillah.service.IRoleService;

@Service
@Transactional(readOnly=true)
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleDaoImpl roleDao;
	
	@Override
	@Transactional(readOnly=false)
	public boolean insert(Role entity) {
		boolean success=false;
		try {
			roleDao.insert(entity);
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean delete(Object id) {
		boolean success=false;
		try {
			roleDao.delete(findById(id));
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean update(Role entity) {
		boolean success=false;
		try {
			roleDao.update(entity);
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public Role findById(Object id) {
		return roleDao.load(id);
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}
	


	@Override
	public List<Role> searchByExample(Role entity) {
		return roleDao.findRoleByExample(entity);
	}

	@Override
	public PaginationResult<Role> searchByExample(Role entity, int firstResult,
			int maxResult) {
		return roleDao.findRoleByExample(entity, firstResult, maxResult);
	}

	@Override
	public PaginationResult<Role> findAll(int firstResult, int maxResult) {
		return roleDao.findAll(firstResult, maxResult);
	}
	

}
