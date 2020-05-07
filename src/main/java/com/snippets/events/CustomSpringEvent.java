package com.snippets.events;

import org.springframework.context.ApplicationEvent;

public class CustomSpringEvent extends ApplicationEvent{

	
	private static final long serialVersionUID = 1L;
	String message;
	
	public CustomSpringEvent(Object source) {
		super(source);
	}

	
	
	public CustomSpringEvent(Object source, String message) {
		super(source);
		this.message = message;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
