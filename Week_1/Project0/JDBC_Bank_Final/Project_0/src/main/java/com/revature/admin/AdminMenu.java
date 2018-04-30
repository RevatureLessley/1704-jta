package com.revature.admin;

import static com.revature.logger.BankLogger.logger;
import static com.revature.scanner.BankScanner.input;

import com.revature.factory.UserInterface;
import com.revature.jdbc.AccountService;
import com.revature.jdbc.TiCoService;
import com.revature.user.User;
import com.revature.user.UserMenu;

/**-
 * This class contains all the options that the Admin has to manage the users in the database.
 * @author Jesse
 *
 */

public class AdminMenu {

	// All of the admins options are here
	public static void menu(UserInterface currentUser) {
		System.out.println("\n\n\n\n\nAdministrator priviledges detected. Special Access and permissions granted.\n");
		// Scanner input = new Scanner(System.in);

		String choice = "";
		while (choice != "1" && choice != "2" && choice != "3" && choice != "4" && choice != "9") {
			System.out.println("======================");
			System.out.println("  ADMINISTRATOR MENU");
			System.out.println("======================");
			System.out.println("To view all existing users\t\tEnter 1");
			System.out.println("To view pending account requests (" + AccountService.getNumberOfPendingUsers() + ")\tEnter 2");
			System.out.println("To view total statement\t\t\tEnter 3");
			System.out.println("To view all transactions\t\tEnter 4");
			System.out.println("For user menu\t\t\t\tEnter 5");
			System.out.println("\n\n\t\tTo log out\t\tEnter 9");
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			choice = input.next();
			System.out.println(""); // whitespace
			switch (choice) {
			case "1": { // View all accounts
				optionOne(currentUser);
				choice = "0";
				break;
			}
			case "2": { // View all pending account requests
				optionTwo(currentUser);
				choice = "0";
				break;
			}
			case "3": { // View total balance
				System.out.println("Total TiCos in bank: " + TiCoService.getTotalBalance() + " TiCos");
				break;
			}
			case "4": { // View total transactions/all transactions
				System.out.println("Not implemented");
				break;
			}
			case "5": { // let the admin access his or her user menu
				logger.trace("User: " + currentUser.getFirstName() + " " + currentUser.getLastName() + " logged in.");
				UserMenu.menu(currentUser);
				break;
			}
			default: { // Ensure correct entries
				System.out.println("\n\nPlease enter a valid menu option\n\n");
				break;
			}
			case "9": { // Log out
				System.out.println("Successfully logged out. Bye " + currentUser.getFirstName());
				logger.trace("Admin: " + currentUser.getFirstName() + " " + currentUser.getLastName() + " logged out.");
				return;
			}

			}

		}
		// Secret menu option
	}

	// SubMenu of option 1
	public static void optionOne(UserInterface currentUser) {

		// Scanner input = new Scanner(System.in);
		String choice = "";
		while (choice != "1" && choice != "2" && choice != "3" && choice != "4" && choice != "9") {
			System.out.println("==================");
			System.out.println("  EXISTING USERS");
			System.out.println("==================");
			for (User user : AccountService.getAllUsers()) {
				if(user.isApproved() == 1) {
					System.out.println(user);
				}
			}
			System.out.println("===================");
			System.out.println("  ACCOUNT OPTIONS");
			System.out.println("===================");
			System.out.println("To lock an account, Enter 1 followed by the number of the"
					+ " account you want to lock (eg 1 4 to lock account 4)");
			System.out.println("To unlock an account, Enter 2 followed by the number of the"
					+ " account you want to unlock (eg 2 4 to unlock account 4)");
			System.out.println("To delete an account, Enter 3 followed by the number of the"
					+ " account you want to delete (eg 3 2 to delete account 2)");
			System.out.println("\n\t\tTo return to main admin menu\t Enter 9\n\n");
			choice = input.next();
			switch (choice) {

			
			
			case "1": { // Lock a single account
				choice = input.nextLine();
				try {
					if(AccountService.lockUser(Integer.parseInt(choice.replaceAll(" ", "")))) {
						logger.trace("Administator: " + currentUser.getFirstName() + " " + currentUser.getLastName()
						+ " locked an account.");
					}
					break;
				} catch (NumberFormatException nfe) { // This will detect if a non integer is input by the user
					System.out.println("Incorrect entry detected. You must input 2 numbers seperated by a space");
					logger.info("Entry error");
					break;
				}
			}

			
			
			case "2": { // Unlock a single account
				choice = input.nextLine();
				try {
					if(AccountService.unlockUser(Integer.parseInt(choice.replaceAll(" ", "")))) {
						logger.trace("Administator: " + currentUser.getFirstName() + " " + currentUser.getLastName()
						+ " unlocked an account.");
					}
					break;
				} catch (NumberFormatException nfe) { // This will detect if a non integer is input by the user
					System.out.println("Incorrect entry detected. You must input 2 numbers seperated by a space");
					logger.info("Entry error");
					break;
				}
			}

			
			
			case "3": { // Delete an account
				choice = input.nextLine();
				try {
					if(AccountService.deleteUser(Integer.parseInt(choice.replaceAll(" ", "")))) {
						logger.trace("Administator: " + currentUser.getFirstName() + " " + currentUser.getLastName()
						+ " deleted an account.");
					}
					break;
				} catch (NumberFormatException nfe) { // This will detect if a non integer is input by the user
					System.out.println("Incorrect entry detected. You must input 2 numbers seperated by a space");
					logger.info("Entry error");
					break;
				} 
			}
			
			
			
			default: { // catch entry errors
				System.out.println("\n\nPlease enter a valid menu option");
				break;
			}
			
			
			
			case "9": { // return to main admin menu
				return;
			}
			}

		}
	}

	
	
	// SubMenu of optionTwo
	public static void optionTwo(UserInterface currentUser) {

		String choice = "";
		while (choice != "1" && choice != "2" && choice != "3" && choice != "4" && choice != "9") {
			System.out.println("====================");
			System.out.println("  PENDING ACCOUNTS");
			System.out.println("====================");
			for (User user : AccountService.getAllUsers()) {
				if(user.isApproved() == 0) {
					System.out.println(user);
				}
			}
			System.out.println("===================");
			System.out.println("  ACCOUNT OPTIONS");
			System.out.println("===================");
			System.out.println("To approve a single account, Enter 1 followed by the number of the "
					+ "account that you wish to approve (eg 1 7 to approve account 7)");
			System.out.println("To approve all accounts, Enter 2");
			System.out.println("To deny a single account, Enter 3 followed by the number of the "
					+ "account that you wish to approve (eg 3 4 to deny account)");
			System.out.println("You view denied accounts, Enter 4");
			System.out.println("To permanently delete all denied accounts, Enter 5");
			System.out.println("To restore denied accounts back to pending, Enter 6");
			System.out.println("\n\t\tTo return to administrator menu, Enter 9\n\n\n\n");
			choice = input.next();
			switch (choice) {
			
			
			
			case "1": { // Approve a single account
				choice = input.nextLine();
				try {
					if(AccountService.approveUser(Integer.parseInt(choice.replaceAll(" ", "")))) {
						logger.trace("Administator: " + currentUser.getFirstName() + " " + currentUser.getLastName()
						+ " approved an account.");
					}
					break;
				} catch (NumberFormatException nfe) {
					System.out.println("Incorrect entry detected. You must input 2 numbers. Spacing does not matter");
					logger.info("Entry error");
					break;
				}
			}
			
			
			
			case "2": { // Approve all pending accounts
				for (User user : AccountService.getAllUsers()) {
					if (user.isApproved() == 0) {
						AccountService.approveUser(user.getAccountNumber());
					}
				}
				logger.trace("Administator: " + currentUser.getFirstName() + " " + currentUser.getLastName()
						+ " approved all pending accounts.");
				break;
			}
			
			
			
			case "3": { // Deny a single account
				choice = input.nextLine();
				try {
					if(AccountService.denyUser(Integer.parseInt(choice.replaceAll(" ", "")))) {
						logger.trace("Administator: " + currentUser.getFirstName() + " " + currentUser.getLastName()
						+ " denied an account.");
					}
					break;

				} catch (NumberFormatException nfe) {
					System.out.println("Incorrect entry detected. You must input 2 numbers. Spacing does not matter");
					logger.info("Entry error");
					break;
				} 
			}
			
			
			
			case "4": { // View denied accounts
				System.out.println("===================");
				System.out.println("  DENIED ACCOUNTS");
				System.out.println("===================");
				for (User user : AccountService.getAllUsers()) {
					if (user.isApproved() == -1) {
						System.out.println(user);
					}
				}
				break;
			}
			
			
			
			case "5": { // Delete denied accounts
				for (User user : AccountService.getAllUsers()) {
					if (user.isApproved() == -1) {
						AccountService.deleteUser(user.getAccountNumber());
					}
				}
				logger.trace("Administator: " + currentUser.getFirstName() + " " + currentUser.getLastName()
						+ " deleted denied accounts.");
				break;
			}

			
			
			case "6": { // Restore denied accounts
				for (User user : AccountService.getAllUsers()) {
					if (user.isApproved() == -1) {
						AccountService.pendUser(user.getAccountNumber());
					}
				}
				logger.trace("Administator: " + currentUser.getFirstName() + " " + currentUser.getLastName()
						+ " restored denied accounts.");
				break;
			}
			
			
			
			default: { // Catch entry errors
				System.out.println("\n\nPlease enter a valid menu option");
				break;
			}
			
			
			
			case "9": { // return to main admin menu
				return;
			}
			}

		}
	}
}
