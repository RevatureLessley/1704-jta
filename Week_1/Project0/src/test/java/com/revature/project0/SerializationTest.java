package com.revature.project0;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class SerializationTest {

	@Test
	
	// test to see if a user can be properly serialized and deserialized
	public void deSerializeTest() {
		User user = new User("daniel", "password");
		user.addMovie("Batman Begins");
		UserSerializer.serializeUser(user,new File("src/test/resources/testUser.txt"));
		User deUser = (User)UserSerializer.deSerializeUser(new File("src/test/resources/testUser.txt")); 
		assertEquals(user.username, deUser.username);
		assertEquals(user.password, deUser.password);
		assertEquals(user.movies, deUser.movies);
	}

}