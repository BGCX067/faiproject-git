package id.web.faisalabdillah.service;

import java.util.List;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.domain.User;

public interface IUserService extends BaseService<User>{

	User findById(Object id,boolean eager);
	
	List<User> findAll(boolean eager);
	
	List<User> findByExample(User entity,boolean eager);
	
	PaginationResult<User> findUserByName(String name,int firstResult,int maxResult);

	PaginationResult<User> findAllPaged(int firstResult, int maxResult);

	PaginationResult<User> findByExample(User user, int firstResult,
			int maxResult);

	PaginationResult<User> findByExample(User user, int firstResult,
			int maxResult, boolean eager);

	PaginationResult<User> findAllPaged(boolean eager, int firstResult,
			int maxResult);

	
	
	
}
