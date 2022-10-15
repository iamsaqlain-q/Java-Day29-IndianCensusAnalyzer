package com.bl.indian.census.analyzer;

public class CodeAnalyzerException extends Exception {
	
	private static final long serialVersionUID = 1L;

	enum ExceptionType {
		CENSUS_FILE_PROBLEM, WRONG_FILE_TYPE, INCORRECT_DELIMITER_OR_HEADER
	}

	ExceptionType type;

	public CodeAnalyzerException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public CodeAnalyzerException(String message, ExceptionType type, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}