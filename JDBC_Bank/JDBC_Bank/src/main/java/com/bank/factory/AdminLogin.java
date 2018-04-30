package com.bank.factory;

import java.util.Scanner;

import com.bank.exception.UserNotFoundException;
import com.bank.mainmenu.MainMenu;
import com.bank.model.User;
import com.bank.service.UserService;
import com.bank.singleton.LogSingleton;

public class AdminLogin {

	public static void adminLogin(){
		LogSingleton.getInstance();			
			System.out.println("Welcome to the admin login!");	
			System.out.println("1. Approve an account");
			System.out.println("2. Lock an account");
			System.out.println("3. Unlock an account");
	
			try(Scanner scan = new Scanner(System.in)){
				int adminOption = scan.nextInt();
				
				switch(adminOption) {
				case 1:
					System.out.println(UserService.getUsers());
					System.out.println("Please enter the first name");
					String fname = scan.next();
					System.out.println("Please enter the last name");
					String lname = scan.next();1
				//	User tempUser = new User();
					UserService.getApproved(UserService.getUser(fname, lname));
					System.out.println(UserService.approveAccount(UserService.getUser(fname, lname)));
					
					break;
				case 2:
					break;
				case 3:
					break;
				}
			}
		
		
//		MainMenu.startMenu();
	}
}