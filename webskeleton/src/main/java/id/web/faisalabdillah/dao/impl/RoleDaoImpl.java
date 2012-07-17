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

package id.web.faisalabdillah.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.dao.AbstractDao;
import id.web.faisalabdillah.dao.IRoleDao;
import id.web.faisalabdillah.domain.Role;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements IRoleDao{

	public RoleDaoImpl(Class<Role> clazz) {
		super(clazz);
	}
	
	public RoleDaoImpl() {
		this(Role.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findRoleByExample(Role role) {
		Example example=Example.create(role);
		example.enableLike(MatchMode.ANYWHERE);
		return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Role.class).add(example));
	}

	@Override
	public PaginationResult<Role> findRoleByExample(Role role, int firstIndex,
			int maxResult) {
		Example example=Example.create(role);
		example.ignoreCase();
		example.enableLike(MatchMode.ANYWHERE);
		return searchByExample(example,firstIndex,maxResult);
	}
	

}
