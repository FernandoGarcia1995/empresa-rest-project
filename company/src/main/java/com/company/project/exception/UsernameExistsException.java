package com.company.project.exception;

import com.company.project.config.ErrorConfig;

public class UsernameExistsException extends Exception{
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameExistsException(ErrorConfig message) {
	        super(message.getValue());
	    }
}
