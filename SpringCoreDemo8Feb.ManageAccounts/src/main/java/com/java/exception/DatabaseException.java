package com.java.exception;
//checked exception: compiler will check whether i have handled this exception
public class DatabaseException extends Exception{

	private static final long serialVersionUID = -5190505470719030880L;

	public DatabaseException(String message) {
		super(message);
	}
}
