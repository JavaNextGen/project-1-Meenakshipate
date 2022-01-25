package com.util.controller;

public class ConstantVariable {

	public static String APPROVED = "Approved";
	public static String PENDING = "Pending";
	public static String DECLINED = "Declined";

	public static String statusFinder(int statusid) {
		if (statusid == 1)
			return APPROVED;
		else if (statusid == 0)
			return PENDING;
		else if (statusid == 2)
			return DECLINED;
		else
			return null;

	}

}
