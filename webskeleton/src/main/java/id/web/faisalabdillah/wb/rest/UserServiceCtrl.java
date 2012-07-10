package id.web.faisalabdillah.wb.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.domain.User;
import id.web.faisalabdillah.dto.JsonResultBean;
import id.web.faisalabdillah.service.IUserService;
import id.web.faisalabdillah.wb.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/user/")
public class UserServiceCtrl {

	@Autowired
	IUserService userService;
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public JsonResultBean<Object> insert(UserModel userModel){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		User user=userModel.toUser();
		user.setCreatetm(new Date());
		if(userService.insert(user)){
			json.setSuccess(true);
			json.setMessage("User "+userModel.getId()+" stored");
		}
		return json;
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public JsonResultBean<Object> update(UserModel userModel){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		User user=userModel.toUser();
		if(userService.update(user)){
			json.setSuccess(true);
			json.setMessage("User "+userModel.getId()+" updated");
		}
		return json;
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.GET)
	public JsonResultBean<Object> delete(@PathVariable("id") String id){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		if(userService.delete(id)){
			json.setSuccess(true);
			json.setMessage(id+" deleted");
			json.setResult(1);
		}
		return json;
	}
	
	@RequestMapping(value="get/{id}")
	public JsonResultBean<User> get(@PathVariable("id") String id){
		JsonResultBean<User> json=new JsonResultBean<User>();
		json.setResult(userService.findById(id, true));
		return json;
	}
	
	@RequestMapping(value="search",method=RequestMethod.GET)
	public JsonResultBean<List<UserModel>> search(@RequestParam("q") String query){
		return search(query, 0, 0);
	}
	
	@RequestMapping(value="search/{maxResult}",method=RequestMethod.GET)
	public JsonResultBean<List<UserModel>> search(@RequestParam("q") String query,@PathVariable int maxResult){
		return search(query, 0, maxResult);
	}
	
	@RequestMapping(value="search/{maxResult}/{firstResult}",method=RequestMethod.GET)
	public JsonResultBean<List<UserModel>> search(@RequestParam("q") String query,@PathVariable int firstResult,@PathVariable int maxResult){
		JsonResultBean<List<UserModel>> json=new JsonResultBean<List<UserModel>>();
		User user=new User();
		user.setId(query);
		user.setName(query);
		user.setAddress(query);
		PaginationResult<User> userp=userService.findByExample(user, firstResult, maxResult,true);
		json.setResultsize(userp.getResultSize());
		List<UserModel> userModels=new ArrayList<UserModel>();
		List<User> users=userp.getResult();
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user2 = (User) iterator.next();
			UserModel userModel=new UserModel();
			userModel.toUserModel(user2);
			userModels.add(userModel);
		}
		json.setResult(userModels);
		return json;
	}
	
	@RequestMapping(value="search",method=RequestMethod.POST)
	public JsonResultBean<Object> searchAdv(@ModelAttribute User user){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		
		return json;
	}
}
