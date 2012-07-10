package id.web.faisalabdillah.wb.rest;

import java.util.List;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.domain.Role;
import id.web.faisalabdillah.dto.JsonResultBean;
import id.web.faisalabdillah.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/role/")
public class RoleServiceCtrl {
	
	
	@Autowired
	IRoleService roleService;
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public JsonResultBean<Object> insert(Role role){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		if(roleService.insert(role)){
			json.setSuccess(true);
		}
		return json;
	};
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public JsonResultBean<Object> update(Role role){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		if(roleService.update(role)){
			json.setSuccess(true);
		}
		return json;
	};
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.GET)
	public JsonResultBean<Object> delete(@PathVariable String id){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		if(roleService.delete(id)){
			json.setSuccess(true);
		}
		return json;
	};
	
	@RequestMapping(value="search/{maxResult}/{firstResult}",method=RequestMethod.GET)
	public JsonResultBean<List<Role>> search(@RequestParam String q,@PathVariable int maxResult,@PathVariable int firstResult){
		JsonResultBean<List<Role>> json=new JsonResultBean<List<Role>>();
		Role ex=new Role();
		ex.setCode(q);
		ex.setDescription(q);
		PaginationResult<Role> rolep=roleService.searchByExample(ex, firstResult, maxResult);
		json.setResultsize(rolep.getResultSize());
		json.setResult(rolep.getResult());
		return json;
	};
	
	@RequestMapping(value="search/{maxResult}",method=RequestMethod.GET)
	public JsonResultBean<List<Role>> search(@RequestParam String q,@PathVariable int maxResult){
		return search(q, maxResult, 0);
	}
	
	@RequestMapping(value="search}",method=RequestMethod.GET)
	public JsonResultBean<List<Role>> search(@RequestParam String q){
		return search(q, 0, 0);
	}
}
