package id.web.faisalabdillah.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T> {
	private Class<T> clazz;
	public AbstractDao(Class<T> clazz) {
		this.clazz = clazz;
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
	
}
