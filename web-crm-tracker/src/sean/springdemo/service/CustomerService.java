package sean.springdemo.service;

import java.util.List;

import sean.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(Long theId);
}
