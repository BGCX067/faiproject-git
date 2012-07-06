package id.web.faisalabdillah.wb.rest;

import id.web.faisalabdillah.dto.JsonResultBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/service/user/")
public class UserServiceCtrl {

	@RequestMapping(value="insert",method=RequestMethod.POST)
	public JsonResultBean<Object> insert(){
		return null;
	}
	
	public JsonResultBean<Object> update(){
		return null;
	}
	
	public JsonResultBean<Object> delete(){
		return null;
	}
	
}
