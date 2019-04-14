package com.isarelgomes.cursomc.services.execptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
//manda uma msg com o erro, e o que aconteceu antes disso (Throwable)	
public ObjectNotFoundException(String msg, Throwable cause) {
	super(msg, cause);
}
	
}
