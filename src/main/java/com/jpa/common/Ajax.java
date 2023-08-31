package com.jpa.common;

public enum Ajax {

	LIST("LIST", "list", "List"),
	MSG("MSG", "msg", "Msg"),
	SUCCESS("SUCCESS", "success", "Success"),
	FAIL("FAIL", "fail", "Fail");
	
	private final String upperCase;
	private final String lowerCase;
	private final String normalCase;
	
	Ajax(String upperCase, String lowerCase, String normalCase) {
		this.upperCase = upperCase;
		this.lowerCase = lowerCase;
		this.normalCase = normalCase;
	}
	
	public String upperCase() {
		return this.upperCase;
	}
	
	public String lowerCase() {
		return this.lowerCase;
	}
	
	public String normalCase() {
		return this.normalCase;
	}
}
