package id.web.faisalabdillah.dao;

import id.web.faisalabdillah.common.PaginationResult;

import java.io.Serializable;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractDao<T> {
	private Class<T> clazz;
	public AbstractDao(Class<T> clazz) {
		this.clazz = clazz;
	}
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Autowired
	private void setHibernateTemplate(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void delete(T entity){
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	public void update(T entity){
		sessionFactory.getCurrentSession().update(entity);
	}
	
	public void insert(T entity){
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}
	
	@SuppressWarnings("unchecked")
	public T load(Object id){
		return (T) sessionFactory.getCurrentSession().load(clazz.getClass(), (Serializable) id);
	}
	
	public List<T> findAll(){
		return sessionFactory.getCurrentSession().createQuery("select c from "+clazz.getName()+" c").list();
	}
	
	public PaginationResult<T> findAllPaginated(int startIndex,int maxResult){
		String query="select c from "+clazz.getName()+" c";
		return searchPaginationHQL(query, startIndex, maxResult);
	}
	
	public PaginationResult<T> searchPaginationHQL(String query,int startIndex,int maxResult){
		StringBuffer sb=new StringBuffer();
		sb.append("select count(1) from ");
		sb.append(" ( ");
		sb.append(query);
		sb.append(" ) ");
		int resultSize=((Integer) sessionFactory.getCurrentSession().createQuery(sb.toString()).uniqueResult()).intValue();
		List<T> list=sessionFactory.getCurrentSession().createQuery(query).setFirstResult(startIndex).setMaxResults(maxResult).list();
		return new PaginationResult<T>(list, resultSize, startIndex, maxResult);
	}
	
	public int getResultSize(Criteria crit){
		return ((Long) crit.setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}
	
	public int getResultSize(DetachedCriteria c){
		c.setProjection(Projections.rowCount());
		return (Integer) getHibernateTemplate().findByCriteria(c).get(0);
	}
}
