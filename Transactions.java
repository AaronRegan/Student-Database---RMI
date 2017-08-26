/*
 * Aaron Regan - 13446668 - 4BP1
 * Distributed Systems Assignment
 * Des Chambers
 */
package assignment1;
/*
 * Transactions class where the transaction object is created 
 * here details of the user interaction with the server are stored for use in the getStatement method 
 * which invokes the statement class for printing
 */
import java.util.Date;

public class Transactions {

	Date date;
	String type;
	int balance;
	int amount;

	public Transactions(Date date, String type, int balance, int amount) {
		this.type = type;
		this.date = date;
		this.balance = balance;
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public String getType() {
		return type;
	}

	public int getBalance() {
		return balance;
	}

	public int getAmount() {
		return amount;
	}

	public String toString() {
		return "Date: " + date + " " + type + " " + amount + " New Balance: "
				+ balance;
	}
}
