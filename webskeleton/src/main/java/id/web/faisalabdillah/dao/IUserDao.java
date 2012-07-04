package id.web.faisalabdillah.dao;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.domain.User;

import java.util.List;

public interface IUserDao {
	public List<User> findUserByExample(User user);
	public PaginationResult<User> findUserByExample(User user,int firstIndex,int maxResult);
}
