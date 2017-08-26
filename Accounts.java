/*
 * Aaron Regan - 13446668 - 4BP1
 * Distributed Systems Assignment
 * Des Chambers
 */
package assignment1;
/*
 * Account class creating account object , 
 * this is where the user details are stored 
 * for use by the client
 */
public class Accounts {
	int acc_id;
	int acc_pin;
	String sessionID;
	int init_amount;
	String acc_holder;
	
	public Accounts(int acc_id, int acc_pin, String sessionID,
			String acc_holder, int init_amount) {
		this.acc_id = acc_id;
		this.acc_pin = acc_pin;
		this.sessionID = sessionID;
		this.acc_holder = acc_holder;
		this.init_amount = init_amount;
	}

	public int getAcc_id() {
		return acc_id;
	}

	public int getAcc_pin() {
		return acc_pin;
	}

	public String getSessionID() {
		return sessionID;
	}

	public String getAcc_holder() {
		return acc_holder;
	}

	public int getInit_amount() {
		return init_amount;
	}

	public String toString() {
		return "Account { " + acc_holder + "," + acc_pin + "," + acc_id + ","
				+ sessionID + "}";
	}
}
