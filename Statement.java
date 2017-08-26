/*
 * Aaron Regan - 13446668 - 4BP1
 * Distributed Systems Assignment
 * Des Chambers
 */
package assignment1;

import java.io.Serializable;
import java.util.ArrayList;

public interface Statement extends Serializable {

	public ArrayList<Transactions> getTransations(); // returns list of
														// Transaction objects
														// that encapsulate
														// details about each
														// transaction

}
