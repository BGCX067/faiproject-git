/**
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *	 
 */

package id.web.faisalabdillah.wb.rest;

import java.util.Date;
import java.util.List;

import id.web.faisalabdillah.common.IResultBean;
import id.web.faisalabdillah.common.JsonResultBean;
import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.domain.Role;
import id.web.faisalabdillah.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * id.web.faisalabdillah.wb.rest
 * @author
 * Muhamad Faisal Abdillah
 * <br/> Jul 17, 2012
 *
 */
@Controller
@RequestMapping("/service/role")
public class RoleServiceCtrl {
	
	
	@Autowired
	IRoleService roleService;
	
	/**
	 * Insert new Role
	 * @param role
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public @ResponseBody IResultBean<Object> insert(@ModelAttribute Role role){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		role.setCreatetm(new Date());
		role.setLastupdtm(new Date());
		if(roleService.insert(role)){
			json.setSuccess(true);
			
		}
		return json;
	};
	/**
	 * Update Role
	 * @param role
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public @ResponseBody IResultBean<Object> update(Role role){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		role.setLastupdtm(new Date());
		if(roleService.update(role)){
			json.setSuccess(true);
		}
		return json;
	};
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public @ResponseBody IResultBean<Object> update(@PathVariable String id,Role role){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		role.setCode(id);
		if(roleService.update(role)){
			json.setSuccess(true);
		}
		return json;
	};
	
	/**
	 * Delete Role
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody IResultBean<Object> delete(@PathVariable String id){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		if(roleService.delete(id)){
			json.setSuccess(true);
		}
		return json;
	};
	
	/**
	 * Get Role
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody IResultBean<Role> get(@PathVariable String id){
		System.out.println("dadadadadadadadadadadadada");
		System.out.println(id);
		System.out.println("ZTest Browazzz");
		JsonResultBean<Role> json=new JsonResultBean<Role>();
		Role role=roleService.findById(id);
		try{
		json.setResult(role);
		if(json.getResult()!=null){
			json.setSuccess(true);
		}}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Beres cuy di laksanakan");
		return json;
	};
	/**
	 * List Role with Search
	 * @param q
	 * @param maxResult
	 * @param firstResult
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public @ResponseBody IResultBean<List<Role>> search(@ModelAttribute Role role,@RequestParam(value="q",required=false) String q,@RequestParam(value="max",required=false) Integer maxResult,@RequestParam(value="first",required=false) Integer firstResult){
		System.out.println(role.getCode());
		if(maxResult==null)maxResult=0;
		if(firstResult==null)firstResult=0;
		JsonResultBean<List<Role>> json=new JsonResultBean<List<Role>>();
		PaginationResult<Role> rolep;
		if(q!=null && !q.equalsIgnoreCase("")){
		Role ex=new Role();
		ex.setDescription(q);
			rolep=roleService.searchByExample(ex, firstResult, maxResult);
		}else{
			rolep=roleService.findAll(firstResult, maxResult);
		}
		json.setSize(rolep.getResultSize());
		json.setResult(rolep.getResult());
		return json;
	};
}
