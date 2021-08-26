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

import com.gym.models.Contact;
import com.gym.models.Customer;
import com.gym.repo.ContactRepo;
import com.gym.repo.CustomerRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ContactTest 
{
	@Autowired
	ContactRepo repo;
	
	@Test
	@Rollback(false)
	public void testCreateContact()
	{
		Contact contact = new Contact("Raj Kumar", "abc@xyz.com","Feedback","Good");
		Contact savecontact = repo.save(contact);
		assertNotNull(savecontact);
	}
	
	@Test
	public void testListCustomer() 
	{ 
		 List<Contact> contacts = (List<Contact>) repo.findAll();
		 for ( Contact contact : contacts)
		 {
			 System.out.println(contact);
		 }
	     assertThat(contacts).size().isGreaterThan(0);
	}
}
