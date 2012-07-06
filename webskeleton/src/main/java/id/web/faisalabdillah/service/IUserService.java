package id.web.faisalabdillah.service;

import java.util.List;

import id.web.faisalabdillah.domain.User;

public interface IUserService extends BaseService<User>{

	public User findById(Object id,boolean eager);
	
	public List<User> findAll(boolean eager);
	
	public List<User> findByExample(User entity,boolean eager);
}
