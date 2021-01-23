package sean.springdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sean.springdemo.entity.Customer;
import sean.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
//	@Autowired
//	private CustomerDAO customerDAO;
//	Lines above commented as the CustomerController will now interact with the CustomerService Layer
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
//		ModelAndView mv = new ModelAndView("list-customers");
		
//		Get the customers from the DAO
//		List<Customer> theCustomers = customerDAO.getCustomers();
		List<Customer> theCustomers = customerService.getCustomers();
//		Add the customers to the model
		model.addAttribute("customers",theCustomers);
		return "list-customers";
	}
}
