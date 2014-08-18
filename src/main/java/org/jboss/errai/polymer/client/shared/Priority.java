package org.jboss.errai.polymer.client.shared;

public enum Priority {
	
	NORMAL("Normal"), URGENT("Urgent"), CRITICAL("Critical");
	
	String priority;
	
	private Priority(String value) {
		priority = value;
	}
	
	@Override
	public String toString() {
		return priority;
	}

}
