package sean.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/list")
	public ModelAndView listCustomer() {
		ModelAndView mv = new ModelAndView("list-customers");
		return mv;
	}
}
