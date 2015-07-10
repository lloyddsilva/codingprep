package edu.cmu.lloyddsilva;

public class Driver {

	public static void main(String[] args) {
		ExcelColumn excel = new ExcelColumn();
		System.out.println(excel.titleToNumber("A"));
		System.out.println(excel.titleToNumber("B"));
		System.out.println(excel.titleToNumber("Z"));
		System.out.println(excel.titleToNumber("AA"));
		System.out.println(excel.titleToNumber("AB"));
		System.out.println(excel.titleToNumber("BA"));
	}
}
