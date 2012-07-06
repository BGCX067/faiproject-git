package id.web.faisalabdillah.dao;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.domain.Role;

import java.util.List;

public interface IRoleDao {
	
	public List<Role> findRoleByExample(Role role);
	public PaginationResult<Role> findRoleByExample(Role role,int firstIndex,int maxResult);

}
