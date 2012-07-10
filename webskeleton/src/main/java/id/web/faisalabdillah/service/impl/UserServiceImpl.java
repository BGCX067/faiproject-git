package id.web.faisalabdillah.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.dao.impl.UserDaoImpl;
import id.web.faisalabdillah.domain.Group;
import id.web.faisalabdillah.domain.User;
import id.web.faisalabdillah.service.IUserService;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDaoImpl userDao;

	@Override
	@Transactional(readOnly = false)
	public boolean insert(User entity) {
		boolean success = false;
		try {
			userDao.insert(entity);
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean delete(Object id) {
		boolean success = false;
		try {
			userDao.delete(findById(id));
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean update(User entity) {
		boolean success = false;
		try {
			userDao.update(entity);
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public User findById(Object id) {
		return findById(id, false);
	}

	/**
	 * Find User from database Lazily
	 */
	@Override
	public List<User> findAll() {
		return findAll(false);
	}

	@Override
	public User findById(Object id, boolean eager) {
		User user = userDao.load(id);
		if (eager) {
			eagerFetch(user,true);
		}
		return user;
	}

	@Override
	public List<User> findAll(boolean eager) {
		List<User> users = userDao.findAll();
		if (eager) {
			for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				eagerFetch(user,true);
			}
		}
		return users;
	}
	
	@Override
	public PaginationResult<User> findAllPaged(boolean eager,int firstResult,int maxResult){
		PaginationResult<User> userp=userDao.findAllPaged(firstResult, maxResult);
		if(eager){
		List<User> users=userp.getResult();
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			eagerFetch(user,true);	
		}
		}
		return userp;
	}
	@Override
	public PaginationResult<User> findAllPaged(int firstResult,int maxResult){
		return findAllPaged(false, firstResult, maxResult);
	}
	protected void eagerFetch(User user,boolean all) {
		Set<Group> groups = user.getGroup();
		Hibernate.initialize(groups);
		if(all){
		if (groups != null) {
			for (Iterator<Group> iterator2 = groups.iterator(); iterator2
					.hasNext();) {
				Group group = (Group) iterator2.next();
				Hibernate.initialize(group.getRoles());
			}
		}
		}
	}

	@Override
	public List<User> findByExample(User entity, boolean eager) {
		List<User> users = userDao.findUserByExample(entity);
		if (eager) {
			for (User user : users) {
				eagerFetch(user,true);
			}
		}
		return users;
	}

	@Override
	public List<User> searchByExample(User entity) {
		return findByExample(entity, false);
	}

	@Override
	public PaginationResult<User> findUserByName(String name, int firstResult,
			int maxResult) {
		return userDao.findUserByName(name, firstResult, maxResult);
	}
	@Override
	public PaginationResult<User> findByExample(User user,int firstResult,int maxResult){
		return findByExample(user, firstResult, firstResult,false);
	}
	
	@Override
	public PaginationResult<User> findByExample(User user,int firstResult,int maxResult,boolean eager){
		PaginationResult<User> userp=userDao.findUserByExample(user, firstResult, firstResult);
		for (Iterator<User> iterator = userp.getResult().iterator(); iterator.hasNext();) {
			User u = (User) iterator.next();
			eagerFetch(u, false);
			
		}
		return userp;
	}

	@Override
	public PaginationResult<User> searchByExample(User entity, int firstResult,
			int maxResult) {
		return userDao.findUserByExample(entity, firstResult, maxResult);
	}

	@Override
	public List<User> findAll(int firstResult, int maxResult) {
		return userDao.findAll(firstResult,maxResult);
	}

}
