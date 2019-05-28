package com.isarelgomes.cursomc.services.execptions;

public class DataIntegrityException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
//manda uma msg com o erro, e o que aconteceu antes disso (Throwable)	
public DataIntegrityException(String msg, Throwable cause) {
	super(msg, cause);
}
	
}
