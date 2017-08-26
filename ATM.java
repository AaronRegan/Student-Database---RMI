/*
 * Aaron Regan - 13446668 - 4BP1
 * Distributed Systems Assignment
 * Des Chambers
 */
package assignment1;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class ATM {

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) throws Exception {
		// get user’s input, and perform the operations
		Accounts acc1 = new Accounts(1111, 1010, UUID.randomUUID().toString(),
				"Aaron", 3200);
		Accounts acc2 = new Accounts(1112, 1100, UUID.randomUUID().toString(),
				"Joe", 680);
		Accounts acc3 = new Accounts(1113, 1001, UUID.randomUUID().toString(),
				"Jane", 1000);
		//get login details from user accounts and store them
		String login1 = acc1.getAcc_holder();
		int pin1 = acc1.getAcc_pin();
		String login2 = acc2.getAcc_holder();
		int pin2 = acc2.getAcc_pin();
		String login3 = acc3.getAcc_holder();
		int pin3 = acc3.getAcc_pin();

		int option = 0;

		try {
			Registry reg = LocateRegistry.getRegistry("127.0.0.1", 4447); //calling registry on localhost through port 4446 
			BankInterface bankint = (BankInterface) reg.lookup("Server");	//creating an instance of bank interface//
			System.out.println("Connected to Server");						//with the lookup of the name "server"//
			
			System.out.println("Enter Account Holder");				//gather user details//
			String holder = sc.next();
			System.out.println("Enter Pin");
			String pin = sc.next();
			String holder_pin = bankint.login(holder, pin);

			ATM atm = new ATM();							//createing a new ATM object//

			if (holder_pin.equals(login1 + "," + pin1)) {			//if statements to enter into each account depending//
																	//on what has been entered//
				String username = acc1.getAcc_holder();
				int accnum = acc1.getAcc_id();
				String sid = acc1.getSessionID();
				int amount = acc1.getInit_amount();
				System.out.println("Session :" + sid + " has started");			//notifying the begging of session and displaying//
				atm.ATM_method(option, amount, bankint, username, accnum, sid);	//sessionID//
				System.out.println("Session :" + sid
						+ " has ended. Please Log back in");
			} else if (holder_pin.equals(login2 + "," + pin2)) {
				String username = acc2.getAcc_holder();
				int accnum = acc2.getAcc_id();
				String sid = acc2.getSessionID();
				int amount = acc2.getInit_amount();
				System.out.println("Session :" + sid + " has started");
				atm.ATM_method(option, amount, bankint, username, accnum, sid);
				System.out.println("Session :" + sid
						+ " has ended. Please Log back in");
			} else if (holder_pin.equals(login3 + "," + pin3)) {
				String username = acc3.getAcc_holder();
				int accnum = acc3.getAcc_id();
				String sid = acc3.getSessionID();
				int amount = acc3.getInit_amount();
				System.out.println("Session :" + sid + " has started");
				atm.ATM_method(option, amount, bankint, username, accnum, sid);
				System.out.println("Session :" + sid
						+ " has ended. Please Log back in");
			} else {
				System.out.println("Incorrect Username or password");	//final statement for a incorrectly entered detail
			}
		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}

	}

	public ArrayList<Transactions> trans = new ArrayList<Transactions>();	//for storing our transaction objects

	private void ATM_method(int option, int amount, BankInterface bankint,
			String username, int accnum, String sid) throws RemoteException {
		// TODO create method to handle withdraw , deposit , inquiry and
		// statement
		do {
			System.out.print("Enter your choice\n"
					+ "(enter number value):\n\n" + "\t1.Withdraw\n"
					+ "\t2.Deposit\n" + "\t3.Balance\n" + "\t4.Statement\n"
					+ "\t5.Exit");
			//case statements are used depending on users input//
			option = Integer.parseInt(sc.next());
			switch (option) {
			case 1:
				System.out.print("Enter Amount to Withdraw:");
				int withdraw = Integer.parseInt(sc.next());

				if (withdraw > amount)
					System.out.println("Insufficient Funds!");
				else {
					amount = bankint.withdraw(amount, withdraw);
					trans.add(new Transactions(new Date(), "Debit", amount,
							withdraw));							//adds details of transaction as a object to our ArrayList
					System.out.println("Username: " + username
							+ "\nAccount Number: " + accnum + "\nSession ID: "
							+ sid + "\n\nBALANCE: " + amount);
				}
				try {
					System.in.read();		//allows for user prompt to give time to read info on screen//
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter Amount to Deposit:");
				int deposit = Integer.parseInt(sc.next());

				amount = bankint.deposit(amount, deposit);
				trans.add(new Transactions(new Date(), "Credit", amount,
						deposit));
				System.out.println(new Transactions(new Date(), "Credit",
						amount, deposit));
				System.out.println("Username: " + username
						+ "\nAccount Number: " + accnum + "\nSession ID: "
						+ sid + "\n\nBALANCE: " + amount);
				try {
					System.in.read();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
			case 3:
				amount = bankint.inquiry(amount);
				System.out.println("Username: " + username
						+ "\nAccount Number: " + accnum + "\nSession ID: "
						+ sid + "\n\nBALANCE: " + amount);
				try {
					System.in.read();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 4:

				StatementClass statement = new StatementClass(trans, accnum,
						username);						//creates an instance of the statement object when called//
				System.out.println(statement.toString());	//our transaction arraylist is passed into here//
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				return;
			}
		} while (option > 0 && option < 5);		//provides loop for multiple entries until specified for exit//
	}
}
