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

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.dao.AbstractDao;
import id.web.faisalabdillah.domain.Group;

/**
 * id.web.faisalabdillah.dao.impl
 * @author
 * Muhamad Faisal Abdillah
 * <br/> Jul 30, 2012
 * 
 */
public class GroupDaoImpl extends AbstractDao<Group>{

	/**
	 * @param clazz
	 */
	public GroupDaoImpl(Class<Group> clazz) {
		super(clazz);
	}
	
	public GroupDaoImpl(){
		this(Group.class);
	}
	
	public PaginationResult<Group> searchPaginated(Group group,int firstResult,int maxResult){
		DetachedCriteria dc=DetachedCriteria.forClass(Group.class);
		Disjunction disjuncion=Restrictions.disjunction();
		if(group.getCode()!=null)disjuncion.add(Restrictions.like("code", "%"+group.getCode()+"%"));
		if(group.getDescription()!=null)disjuncion.add(Restrictions.like("description", group.getDescription()));
		dc.add(disjuncion);
		return new PaginationResult<Group>(getHibernateTemplate().findByCriteria(dc, firstResult, maxResult), getResultSize(dc), firstResult, maxResult);
	}

}
