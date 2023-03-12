package com.company.project.exception;

import com.company.project.config.ErrorConfig;

public class DepartamentoNotFoundException extends Exception {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DepartamentoNotFoundException(ErrorConfig message) {
	        super(message.getValue());
	    }
}
