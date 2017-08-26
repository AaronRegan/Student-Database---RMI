/*
 * Aaron Regan - 13446668 - 4BP1
 * Distributed Systems Assignment
 * Des Chambers
 */
package assignment1;
/*
 * Statement class which sotres the arraylist of transaction objects 
 * created by the Client as the user carries out transactions.
 */
import java.util.ArrayList;

public class StatementClass implements Statement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Transactions> transactions;
	int acc_num;
	String acc_holder;

	public StatementClass(ArrayList<Transactions> transactions, int acc_num,
			String acc_holder) {
		this.transactions = transactions;
		this.acc_num = acc_num;
		this.acc_holder = acc_holder;
	}

	public ArrayList<Transactions> getTransations() {
		return transactions;
	}

	public String getAcc_holder() {
		return acc_holder;
	}

	public int getAcc_num() {
		return acc_num;
	}

	public String toString() {
		String stat = "Transactions from account " + acc_num + " ~"
				+ acc_holder + " :\n";
		for (Transactions t : transactions) {
			stat += t.toString() + "\n";			//the too string method loops through the arrayList adding them to the
		}											//string to be printed upon request
		return stat;	
	}

}
