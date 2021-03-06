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

package id.web.faisalabdillah.wb.ctrl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import id.web.faisalabdillah.common.CommandFormBean;
import id.web.faisalabdillah.common.CommonResultBean;
import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.domain.Role;
import id.web.faisalabdillah.service.IRoleService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/role")
public class RoleAdminCtrl {
	private final int PAGE_SIZE=3;
	private final Logger log=Logger.getLogger(getClass());
	@Autowired
	IRoleService roleService;

	@RequestMapping(value="/add/{maxResult}/{pageNumber}",method=RequestMethod.GET)
	public String roleAddList(Model model,@PathVariable int maxResult,@PathVariable int pageNumber,@RequestParam(required=false) String q){
		Role role=(Role) model.asMap().get("roleCommand");
		if(role==null){
			role=new Role();
		}
		model.addAttribute("roleCommand", role);
		CommonResultBean<List<Role>> result = new CommonResultBean<List<Role>>();
		PaginationResult<Role> rolep;
		int pageIndex=CommonResultBean.getIndex(pageNumber, maxResult);
		System.out.println(pageIndex);
		System.out.println(pageNumber);
		try {
		if(q==null || q.equalsIgnoreCase("")){
			rolep=roleService.findAll(pageIndex, maxResult);
		}else{
			Role ex=new Role();
			ex.setDescription(q);
			rolep=roleService.searchByExample(ex, pageIndex, maxResult);
		}
		result.setResult(rolep.getResult());
		result.setSize(rolep.getResultSize());
		result.setPageSize(maxResult);
		result.setCurrentPage(pageNumber);
		model.addAttribute("roles", result);
		model.addAttribute("query",q);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
		}
		
		return "admin/role/add-role";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String roleAddList(Model model,@RequestParam(required=false) String q){
		return roleAddList(model,PAGE_SIZE,1,q);
	}
	@RequestMapping(value={"/add","/add/**"},method=RequestMethod.POST)
	public String roleAdd(Model model,@ModelAttribute Role roleCommand){
		roleCommand.setCreatetm(new Date());
		roleCommand.setCreateby("faiadmin");
		roleCommand.setLastupdby("faiadmin");
		CommandFormBean cfb=new CommandFormBean();
		cfb.setSuccess(roleService.insert(roleCommand));
		if(cfb.isSuccess()){
			cfb.setMessage(roleCommand.getCode()+" successfull created");
		}else{
			cfb.setMessage(roleCommand.getCode()+" not created ");
		}
		model.addAttribute("cf", cfb);
		return roleAddList(model, "");
	}
	@RequestMapping(value="/add/{maxResult}",method=RequestMethod.GET)
	public String roleAddList(Model model,@PathVariable int maxResult,@RequestParam(required=false) String q){
		return roleAddList(model,maxResult,1,q);
	}
	
	@RequestMapping(value="/del/{id}",method=RequestMethod.GET)
	public String roleDelete(Model model,@PathVariable String id){
		CommandFormBean cfb=new CommandFormBean();
		cfb.setSuccess(roleService.delete(id));
		if(cfb.isSuccess()){
			cfb.setMessage("delete operation success");
		}else{
			cfb.setMessage("delete opration failed");
		}
		model.addAttribute("cf", cfb);
		return "redirect:/admin/role/add";
	}
}
