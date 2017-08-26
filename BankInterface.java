/*
 * Aaron Regan - 13446668 - 4BP1
 * Distributed Systems Assignment
 * Des Chambers
 */
package assignment1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface BankInterface extends Remote {

	public String login(String username, String password)
			throws RemoteException;

	public int deposit(int accountnum, int amount) throws RemoteException;

	public int withdraw(int accountnum, int amount) throws RemoteException;

	public int inquiry(int amount) throws RemoteException;

	public ArrayList<Object> getStatement() throws RemoteException;

}
