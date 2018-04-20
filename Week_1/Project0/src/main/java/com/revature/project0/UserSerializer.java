package com.revature.project0;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserSerializer {
	// puts a user into a file
	public static void serializeUser(User user, File file) {
		try (ObjectOutputStream userOutStream = new ObjectOutputStream(new FileOutputStream(file.getPath()))) {
				userOutStream.writeObject(user);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	// pulls down a user from a file
	public static User deSerializeUser(File file) {
		try (ObjectInputStream userInStream = new ObjectInputStream(new FileInputStream(file.getPath()))) {
			return(User) userInStream.readObject();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}