package id.web.faisalabdillah.wb.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainCtr {

	@RequestMapping
	public String get(){
		return "index";
	}
}
