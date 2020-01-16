package com.sample.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

abstract class  Person {
	String name;
	boolean librarian;
	double balance;
	ArrayList<Book> books = new ArrayList<>();
	protected int timeLimit = 15;

	public Person (String name) {this.name = name;};
	public Person (String name, boolean librarian) {this.name = name; this.librarian = librarian;}

	public void withdraw (Book book) {
		if (book.isIn()) {


			if (books.size()<5) {
				books.add(book);
				book.setIn(false);
				book.setCheckOutDate(Timecalc.getTime());
			}
			else {System.out.println("Cannot withdraw more than 5 books!");
			}
		}

		else {System.out.println("This book is currently signed out");
		}

	}

	public void deposit (Book book) {
		int i = Timecalc.getTime().compareTo(book.getCheckOutDate());
		if (books.contains(book)) {
			books.remove(book);
			System.out.println("Book deposited");
			if ( i > timeLimit) {
				System.out.println("more than 15");
				while (i > timeLimit) {
					this.balance -= .50;
					i-=1;
				}
			}
			else {System.out.println("Not more than 15");}
			book.setIn(true);
		}
		else {System.out.println(book.getName()+" was not checked out by "+this.name);}
	}

	public void pay (double pay) {
		if (this.balance > 0) {
			if (pay >0) {
				balance -= pay;
				System.out.println("Thank you for paying in "+pay);
			}
			else {System.out.println("Cannot pay in non-positive amount");
			}
		}
		else {System.out.println("No balance to pay");}
	}

	public void showWithdrawn() {
		if (books.size()==0) {System.out.println(this.name+" has no books withdrawn");}
		else {

			System.out.println(this.name+" has Withdrawn:");
			for (int i = 0; i < books.size(); i++) {
				System.out.println("ID: "+books.get(i).getCode()+", Name: "+books.get(i).getName());
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLibrarian() {
		return librarian;
	}

	public void setLibrarian(boolean librarian) {
		this.librarian = librarian;
	}

	public void getMyBalance() {
		System.out.println("\nyour balance is: �"+this.balance+"\n");;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
}
