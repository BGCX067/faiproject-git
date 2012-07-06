package id.web.faisalabdillah.service;

import java.util.List;

public interface BaseService<T> {
	
	public boolean insert(T entity);
	public boolean delete(Object id);
	public boolean update(T entity);
	public T findById(Object id);
	public List<T> findAll();
	public List<T> findByExample(T entity);
}
