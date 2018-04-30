import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bank.model.Product;
import com.bank.model.User;
import com.bank.service.JunctionService;
import com.bank.service.ProductService;
import com.bank.service.UserService;

public class junit {

	User user = new User();
	Product product = new Product();
	
	@Test
	public void testUserInsertion() {
		user = new User("Firstname", "Lastname", "Password");
		assertTrue(UserService.insertUser(user));
	}

	@Test
	public void testProductInsertion() {
		product = new Product("Twinkies", .59, 200);
		assertTrue(ProductService.insertProduct(product));
	}
	
	@Test
	public void testJunctionAddToCart() {
		User user3 = new User("Samantha", "King", "Seaking");
		UserService.insertUser(user3);
		Product product3 = new Product("Turtles", .99, 20);
		ProductService.insertProduct(product3);
		assertTrue(JunctionService.addToCart(user3,product3));
	}
}
