package id.web.faisalabdillah.wb.ctrl;

import java.util.Date;
import java.util.List;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.domain.Role;
import id.web.faisalabdillah.service.IRoleService;

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
	private final int PAGE_SIZE=10;
	@Autowired
	IRoleService roleService;

	@RequestMapping(value="/add/{maxResult}/{pageNumber}",method=RequestMethod.GET)
	public String roleAddList(Model model,@PathVariable int maxResult,@PathVariable int pageNumber,@RequestParam(required=false) String q){
		Role role=new Role();
		model.addAttribute("roleCommand", role);
		PaginationResult<Role> rolep;
		List<Role> roles;
		try {
		if(q==null || q.equalsIgnoreCase("")){
			rolep=roleService.findAll(pageNumber, maxResult);
			roles=rolep.getResult();
		}else{
			Role ex=new Role();
			ex.setCode(q);
			ex.setDescription(q);
			rolep=roleService.searchByExample(ex, pageNumber, maxResult);
			roles=rolep.getResult();
		}
		model.addAttribute("testing","Tessting nih");
		model.addAttribute("q",q);
		model.addAttribute("roles", roles);
		model.addAttribute("nextIndex",rolep.getNextPageIndex());
		model.addAttribute("prevIndex",rolep.getPrevPageIndex());
		model.addAttribute("numberPage",rolep.getPageNumber());
		model.addAttribute("resultSize",rolep.getResultSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/role/add-role";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String roleAddList(Model model,@RequestParam(required=false) String q){
		return roleAddList(model,PAGE_SIZE,0,q);
	}
	@RequestMapping(value="/add*",method=RequestMethod.POST)
	public String roleAdd(Model model,@ModelAttribute Role roleCommand){
		roleCommand.setCreatetm(new Date());
		roleCommand.setCreateby("faiadmin");
		roleCommand.setLastupdby("faiadmin");
		roleService.insert(roleCommand);
		return roleAddList(model, "");
	}
	@RequestMapping(value="/add/{maxResult}",method=RequestMethod.GET)
	public String roleAddList(Model model,@PathVariable int maxResult,@RequestParam(required=false) String q){
		return roleAddList(model,maxResult,PAGE_SIZE,q);
	}
}
