package sean.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sean.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
//	@Transactional - Commented as the Transactions would now begin at the service layer. The Service Layer will determine the scope of the Transactions depending on the DAO's that get invoked inside the Layer
	public List<Customer> getCustomers() {
		
//		Get the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		
//		Create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
//		Execute query to the result list
		List<Customer> customers = theQuery.getResultList();
		
//		return the results
		return customers;
		
	}
}
