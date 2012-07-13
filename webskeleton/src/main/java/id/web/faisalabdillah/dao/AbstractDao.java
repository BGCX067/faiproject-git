package id.web.faisalabdillah.dao;

import id.web.faisalabdillah.common.PaginationResult;

import java.io.Serializable;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
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

	@SuppressWarnings("unused")
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
		return (T) sessionFactory.getCurrentSession().load(clazz, (Serializable) id);
	}
	
	public List<T> findAll(){
		return findAll(0, 0).getResult();
	}
	
	
	@SuppressWarnings("unchecked")
	public PaginationResult<T> findAll(int firstResult,int maxResult){
//		Query q=sessionFactory.getCurrentSession().createQuery("select c from "+clazz.getName()+" c");
//		q.setFirstResult(firstResult);
//		if(maxResult!=0)q.setMaxResults(maxResult);
		DetachedCriteria crit=DetachedCriteria.forClass(clazz);
		List<T> datas=hibernateTemplate.findByCriteria(crit,firstResult,maxResult);
		return new PaginationResult<T>(datas, getResultSize(crit), firstResult, maxResult);
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> searchByHql(String hql,int firstResult,int maxResult){
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setFirstResult(firstResult);
		
		if(maxResult>0)q.setMaxResults(maxResult);
		return q.list();
	}
	
	protected List<T> searchByQuery(String sql) {
		return searchByHql(sql, 0, 0);
	}
	
	
	protected PaginationResult<T> searchBySqlPagedResult(String sql,int firstResult,int maxResult){
		return new PaginationResult<T>(searchByHql(sql, firstResult, maxResult), getResultSize(sql), firstResult, maxResult);
	}
	
	protected List<T> searchByCriteria(Criteria criteria){
		return searchByCriteria(criteria,0,0);
	}
	@SuppressWarnings("unchecked")
	protected List<T> searchByCriteria(Criteria criteria,int firstResult,int maxResult){
		criteria.setFirstResult(firstResult);
		if(maxResult>0)criteria.setMaxResults(maxResult);
		return criteria.list();
	}
	
	protected PaginationResult<T> searchByCriteriaPagedResult(Criteria criteria,int firstResult,int maxResult){
		return new PaginationResult<T>( searchByCriteria(criteria, firstResult, maxResult), getResultSize(criteria), firstResult, maxResult);
	}
	
	@SuppressWarnings("unchecked")
	protected PaginationResult<T> searchByExample(Criterion example,int firstResult,int maxResult) {
		DetachedCriteria criterion=DetachedCriteria.forClass(clazz);
		criterion.add(example);
		List<T> datas=getHibernateTemplate().findByCriteria(criterion,firstResult,maxResult);
		int resultSize=getResultSize(criterion);
		return new PaginationResult<T>(datas, resultSize, firstResult, maxResult);
	}
	
	protected int getResultSize(String sql){
		StringBuffer sb=new StringBuffer();
		sb.append("select count(*) from ");
		sb.append(" ( ");
		sb.append(sql);
		sb.append(" )");
		sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();
		return ((Integer) sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult()).intValue();
	}
	protected int getResultSize(Criteria crit){
		return ((Long) crit.setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}
	
	protected int getResultSize(DetachedCriteria c){
		c.setProjection(Projections.rowCount());
		return ((Long) getHibernateTemplate().findByCriteria(c,0,0).get(0)).intValue();
	}
}
