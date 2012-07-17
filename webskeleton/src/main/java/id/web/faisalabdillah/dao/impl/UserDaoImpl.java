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
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.dao.AbstractDao;
import id.web.faisalabdillah.dao.IUserDao;
import id.web.faisalabdillah.domain.User;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements IUserDao{

	public UserDaoImpl(Class<User> clazz) {
		super(clazz);
	}
	public UserDaoImpl() {
		this(User.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> findUserByExample(User user) {
		Example example=Example.create(user);
		example.enableLike(MatchMode.ANYWHERE);
		example.excludeProperty("group");
		return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(User.class).add(example));
	}

	@SuppressWarnings("unchecked")
	public PaginationResult<User> findUserByExample(User user, int firstIndex, int maxResult) {
		Example example=Example.create(user);
		example.enableLike(MatchMode.ANYWHERE);
		example.excludeProperty("group");
		DetachedCriteria c=DetachedCriteria.forClass(User.class).add(example);
		List<User> list=getHibernateTemplate().findByCriteria(c, firstIndex, maxResult);
		return new PaginationResult<User>(list,1,firstIndex,maxResult);
	}
	@Override
	public PaginationResult<User> findUserByName(String name, int firstResult,
			int maxResult) {
		Criteria crit=getSessionFactory().getCurrentSession().createCriteria(User.class);
		crit.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		return searchByCriteriaPagedResult(crit, firstResult, maxResult);
	}
	@Override
	public PaginationResult<User> findAllPaged(int firstResult, int maxResult) {
		return searchByCriteriaPagedResult(getSessionFactory().getCurrentSession().createCriteria(User.class), firstResult, maxResult);
	}
	

}
