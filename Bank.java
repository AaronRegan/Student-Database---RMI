/*
 * Aaron Regan - 13446668 - 4BP1
 * Distributed Systems Assignment
 * Des Chambers
 */
package assignment1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Bank extends UnicastRemoteObject implements BankInterface {

	/*
	 * bank object which extends the RemoteObject and implements the bank interface
	 * here the main functions of the of server/client interaction are created
	 * the RMI function is initiated on the server side in the classes main
	 */
	private static final long serialVersionUID = 1L;

	public Bank() throws RemoteException {
		super();
	}

	public int deposit(int account, int amount) throws RemoteException {
		account = account + amount;
		return (account);

	}

	public int withdraw(int account, int amount) throws RemoteException {
		account = account - amount;
		return (account);

	}

	public int inquiry(int amount) throws RemoteException {
		return amount;

	}

	public ArrayList<Object> getStatement() throws RemoteException {
		return null;
	}

	public String login(String username, String password)
			throws RemoteException {
		return username + "," + password;
	}

	public static void main(String args[]) throws Exception {
		/*
		 *  Initialise Bank server - see sample code in the notes for details
		 *  a registry at port 444X is created and the bank interface is binded to it with the 
		 *  title "server". The print out confirms it has worked.
		 */
		try {
			Registry reg = LocateRegistry.createRegistry(4447);

			reg.rebind("Server", new Bank());
			System.out.println("Name rebind completed");
			System.out.println("Server ready for requests!");
		} catch (Exception exc) {
			System.out.println("Error in main - " + exc.toString());
		}
	}

}
