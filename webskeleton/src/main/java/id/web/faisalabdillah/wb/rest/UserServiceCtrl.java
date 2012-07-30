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

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import id.web.faisalabdillah.common.IResultBean;
import id.web.faisalabdillah.common.JsonResultBean;
import id.web.faisalabdillah.common.PaginationResult;
import id.web.faisalabdillah.domain.User;
import id.web.faisalabdillah.service.IUserService;
import id.web.faisalabdillah.wb.model.UserModel;

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
@RequestMapping("/service/user")
public class UserServiceCtrl {

	@Autowired
	IUserService userService;
	
	/*
	 * Insert new User
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public @ResponseBody IResultBean<Object> insert(UserModel userModel){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		User user=userModel.toUser();
		user.setCreatetm(new Date());
		if(userService.insert(user)){
			json.setSuccess(true);
			json.setMessage("User "+userModel.getId()+" stored");
		}
		return json;
	}
	
	/*
	 * Update User
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public @ResponseBody IResultBean<Object> update(UserModel userModel){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		User user=userModel.toUser();
		if(userService.update(user)){
			json.setSuccess(true);
			json.setMessage("User "+userModel.getId()+" updated");
		}
		return json;
	}
	
	/*
	 * Delete User
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody IResultBean<Object> delete(@PathVariable("id") String id){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		if(userService.delete(id)){
			json.setSuccess(true);
			json.setMessage(id+" deleted");
			json.setResult(1);
		}
		return json;
	}
	
	/*
	 * get User
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody IResultBean<User> get(@PathVariable("id") String id){
		JsonResultBean<User> json=new JsonResultBean<User>();
		json.setResult(userService.findById(id, true));
		return json;
	}
	
	/**
	 * Search User pagination
	 * @param query
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public IResultBean<List<UserModel>> search(@RequestParam(value="q",required=false) String query,@RequestParam(value="first",required=false) int firstResult,@RequestParam(value="max",required=false) int maxResult){
		JsonResultBean<List<UserModel>> json=new JsonResultBean<List<UserModel>>();
		User user=new User();
		user.setId(query);
		user.setName(query);
		user.setAddress(query);
		PaginationResult<User> userp;
		if(query!=null && query.equalsIgnoreCase("")){
			userp=userService.findByExample(user, firstResult, maxResult,true);
		}else{
			userp=userService.findAllPaged(true,firstResult, maxResult);
		}
		json.setSize(userp.getResultSize());
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
	
	/**
	 * Advanced Search With Form
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public IResultBean<Object> searchAdv(@ModelAttribute User user){
		JsonResultBean<Object> json=new JsonResultBean<Object>();
		return json;
	}
}
