package com.example.interview.constants;

public enum RtnCode {

	SUCCESSFUL(200,"OK"), //
	ERROR_VOTENAME_NONE(400,"ERROR_VOTENAME_NONE"), // ด๚ธี
	FIND_VOTENAME_NONE(400,"FIND_VOTENAME_NONE"), //123
	VOTENAME_NONE(400,"VOTENAME_NONE"), //
	;
	
	private int code;
	
	private String message;

	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}


	
}
