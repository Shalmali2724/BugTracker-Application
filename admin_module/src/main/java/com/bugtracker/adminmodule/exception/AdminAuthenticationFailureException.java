package com.bugtracker.adminmodule.exception;

public class AdminAuthenticationFailureException extends RuntimeException {
	public AdminAuthenticationFailureException(String msg)
	{
		super(msg);
	}

}
