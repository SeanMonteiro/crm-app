package sean.springdemo.dao;

import java.util.List;
import sean.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(Long theId);

}
