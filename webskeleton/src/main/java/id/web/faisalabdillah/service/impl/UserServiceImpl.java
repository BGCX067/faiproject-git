package id.web.faisalabdillah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.web.faisalabdillah.dao.impl.UserDaoImpl;
import id.web.faisalabdillah.domain.User;
import id.web.faisalabdillah.service.IUserService;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserDaoImpl userDao;
	@Override
	@Transactional(readOnly=false)
	public boolean insert(User entity) {
		boolean success=false;
		try {
			userDao.insert(entity);
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean delete(Object id) {
		boolean success=false;
		try {
			userDao.delete(findById(id));
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean update(User entity) {
		boolean success=false;
		try {
			userDao.update(entity);
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	
	public User findById(Object id) {
		return userDao.load(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

}
