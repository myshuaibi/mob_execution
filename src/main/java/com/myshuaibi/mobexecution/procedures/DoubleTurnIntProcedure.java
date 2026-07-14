package com.myshuaibi.mobexecution.procedures;

public class DoubleTurnIntProcedure {
	public static String execute(double num) {
		String text_int = "";
		text_int = "" + num;
		return text_int.substring(0, text_int.indexOf(".", 0));
	}
}