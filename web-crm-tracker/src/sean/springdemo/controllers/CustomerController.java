package sean.springdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showFormForAdd")
	public String addCustomer(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
//		Save the customer using the service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") Long theId, Model theModel) {

//		Get customer from service
		Customer theCustomer = customerService.getCustomer(theId);
		
//		Set customer as model attribute to prepopulate the form
		theModel.addAttribute("customer", theCustomer);
		
//		Send over to our form
		return "customer-form";
	}
}
