package sean.springdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sean.springdemo.dao.CustomerDAO;
import sean.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomer(Model model) {
//		ModelAndView mv = new ModelAndView("list-customers");
		
//		Get the customers from the DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
//		Add the customers to the model
		model.addAttribute("customers",theCustomers);
		return "list-customers";
	}
}
