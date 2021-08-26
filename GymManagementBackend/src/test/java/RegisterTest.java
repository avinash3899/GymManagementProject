import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;



import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.gym.models.Customer;
import com.gym.repo.CustomerRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RegisterTest 
{
	@Autowired
	CustomerRepo repo;
	
	@Test
	@Rollback(false)
	public void testCreateCustomer()
	{
		Customer customer = new Customer(1,"abc@xyz.com","1234","Raj","Kumar","03-01-2000","Bangalore","1234567890","3 months","Done");
		Customer savecustomer = repo.save(customer);
		assertNotNull(savecustomer);
	}
	
	@Test
	public void testListCustomer() 
	{ 
		 List<Customer> customers = (List<Customer>) repo.findAll();
		 for ( Customer customer : customers)
		 {
			 System.out.println(customer);
		 }
	     assertThat(customers).size().isGreaterThan(0);
	}
}
