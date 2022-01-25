package com.revature.models;

import java.sql.Timestamp;
import java.util.Date;

/**
 * This concrete Reimbursement class can include additional fields that can be
 * used for extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 * <li>Description</li>
 * <li>Creation Date</li>
 * <li>Resolution Date</li>
 * <li>Receipt Image</li>
 * </ul>
 *
 */
public class Reimbursement extends AbstractReimbursement {

	// public Reimbursement(int i, int j, Date timestamp, Date date, String string,
	// int l, int m, int n, int o, int p) {
	// super();
	// }

	/**
	 * This includes the minimum parameters needed for the
	 * {@link com.revature.models.AbstractReimbursement} class. If other fields are
	 * needed, please create additional constructors.
	 */

	public Reimbursement(int id, Status status, int author, int resolver, int amount) {
		super(id, status, author, resolver, amount);
	}
	// meena

	public Reimbursement(int id, int amount, Date submitted, Date resolved, String description, int receipt, int author,
			int resolver, int statusid, int typeid) {
		super(id, amount, submitted, resolved, description, receipt, author, resolver, statusid, typeid);

	}
	//check it

	public Reimbursement(int id, Status approved, User gENERIC_EMPLOYEE_1, User gENERIC_FINANCE_MANAGER_1, double d) {
		// TODO Auto-generated constructor stub
	}

}
