package id.web.faisalabdillah.wb.ctrl;

import id.web.faisalabdillah.domain.User;
import id.web.faisalabdillah.service.IUserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class TestController {

	@Autowired
	IUserService userService;
	
	@RequestMapping(value="test")
	public @ResponseBody Map<String, Object> testData(){
		Map<String,Object> map=new HashMap<String, Object>();
		User user=new User();
		user.setId("Faitz");
		user.setName("Muhamad Faisal Abdillah");
		userService.insert(user);
		map.put("success", true);
		return map;
	}
}
