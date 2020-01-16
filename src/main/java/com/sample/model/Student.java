package com.sample.model;

public class Student extends Person {
	private int studentID;
	private static int numberOfStudents = 0;

	public Student(String name) {
		super(name);
		this.studentID = numberOfStudents+1;
		numberOfStudents+=1;
		// TODO Auto-generated constructor stub
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public void addBook(Book book) {
		this.books.add(book);
		book.setIn(true);
	}
}
