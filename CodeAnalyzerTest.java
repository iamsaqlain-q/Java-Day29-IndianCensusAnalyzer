package com.bl.indian.census.analyzer;

import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

public class CodeAnalyzerTest {

	public class CodeAnalyserTest {
		private static final String INDIA_CODE_CSV_FILE_PATH = "C:\\Users\\$\\Downloads\\IndiaStateCode.csv";
		private static final String WRONG_CSV_FILE_PATH = "F:\\Users\\$\\Downloads\\IndiaStateCode.csv";
		private static final String WRONG_FILE_TYPE_PATH = "C:\\Users\\$\\Downloads\\IndiaStateCode.txt";
		private static final String WRONG_DELIMITER_FILE_PATH = "C:\\Users\\$\\Downloads\\WrongDelimiterIndiaStateCode.csv";
		private static final String WITHOUT_HEADER_FILE_PATH = "C:\\Users\\$\\Downloads\\WithoutHeaderIndiaStateCode.csv";

		// TC 1.1
		@Test
		public void given_IndianCodeCSVFile_ReturnsCorrectRecords() {
			try {
				CodeAnalyzer codeAnalyser = new CodeAnalyzer();
				int numOfRecords = codeAnalyser.loadIndiaCodeData(INDIA_CODE_CSV_FILE_PATH);
				Assert.assertEquals(29, numOfRecords);
			} catch (CodeAnalyzerException e) {
			}
		}

		// TC 1.2
		@Test
		public void given_IndiaCodeData_WithWrongFilePath_ShouldThrowException() {
			try {
				CodeAnalyzer codeAnalyser = new CodeAnalyzer();
				ExpectedException exceptionRule = ExpectedException.none();
				exceptionRule.expect(CodeAnalyzerException.class);
				codeAnalyser.loadIndiaCodeData(WRONG_CSV_FILE_PATH);
			} catch (CodeAnalyzerException e) {
				Assert.assertEquals(CodeAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			}
		}

		// TC 1.3
		@Test
		public void given_IndiaCodeData_WithWrongFileType_ShouldThrowException() {
			try {
				CodeAnalyzer codeAnalyser = new CodeAnalyzer();
				ExpectedException exceptionRule = ExpectedException.none();
				exceptionRule.expect(CodeAnalyzerException.class);
				codeAnalyser.loadIndiaCodeData(WRONG_FILE_TYPE_PATH);
			} catch (CodeAnalyzerException e) {
				Assert.assertEquals(CodeAnalyzerException.ExceptionType.WRONG_FILE_TYPE, e.type);
			}
		}

		// TC 1.4
		@Test
		public void given_IndiaCodeData_WithWrongFileDelimiter_ShouldThrowException() {
			try {
				CodeAnalyzer codeAnalyser = new CodeAnalyzer();
				ExpectedException exceptionRule = ExpectedException.none();
				exceptionRule.expect(CodeAnalyzerException.class);
				codeAnalyser.loadIndiaCodeData(WRONG_DELIMITER_FILE_PATH);
			} catch (CodeAnalyzerException e) {
				Assert.assertEquals(CodeAnalyzerException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.type);
			}
		}

		// TC 1.5
		@Test
		public void given_IndiaCodeData_WithoutHeader_ShouldThrowException() {
			try {
				CodeAnalyzer codeAnalyser = new CodeAnalyzer();
				ExpectedException exceptionRule = ExpectedException.none();
				exceptionRule.expect(CodeAnalyzerException.class);
				codeAnalyser.loadIndiaCodeData(WITHOUT_HEADER_FILE_PATH);
			} catch (CodeAnalyzerException e) {
				Assert.assertEquals(CodeAnalyzerException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.type);
			}
		}
	}
}

