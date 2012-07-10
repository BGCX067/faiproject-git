package id.web.faisalabdillah.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
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
		example.enableLike(MatchMode.ANYWHERE);
		return searchByExample(example);
	}

}
