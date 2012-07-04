package id.web.faisalabdillah.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
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
	
	
	public List<User> findUserByExample(User user) {
		Example example=Example.create(user);
		example.enableLike(MatchMode.ANYWHERE);
		example.excludeProperty("group");
		return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(User.class).add(example));
	}

	public PaginationResult<User> findUserByExample(User user, int firstIndex, int maxResult) {
		Example example=Example.create(user);
		example.enableLike(MatchMode.ANYWHERE);
		example.excludeProperty("group");
		DetachedCriteria c=DetachedCriteria.forClass(User.class).add(example);
		List<User> list=getHibernateTemplate().findByCriteria(c, firstIndex, maxResult);
		return new PaginationResult<User>(list,1,firstIndex,maxResult);
	}

}
