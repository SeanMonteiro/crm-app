package sean.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sean.springdemo.dao.CustomerDAO;
import sean.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {


//	need to inject the Customer DAO
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

}
