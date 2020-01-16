package com.sample.model;

public class Librarian extends Person {
	private int librarianID;
	private static int numberOfLibrarians = 0;

	public Librarian(String name) {
		super(name);
		this.librarianID = numberOfLibrarians+1;
		numberOfLibrarians+=1;
	}

	public int getLibrarianID() {
		return librarianID;
	}

	public void setLibrarianID(int librarianID) {
		this.librarianID = librarianID;
	}
	
	public void withdrawForStudent (Student student, Book book) {
		if (book.isIn()) {
			if (student.getBooks().size()<5) {
				student.addBook(book);
				book.setIn(false);
				book.setCheckOutDate(Timecalc.getTime());
			}
			else {System.out.println("Cannot withdraw more than 5 books!");
			}
		}

		else {System.out.println("This book is currently signed out");
		}

	}

	public void depositForStudent (Student student, Book book) {
		int j = Timecalc.getTime().compareTo(book.getCheckOutDate());
		if (student.getBooks().contains(book)) {
			books.remove(book);
			System.out.println("Book deposited");
			if ( j > timeLimit) {
				System.out.println("more than 15");
				while (j > timeLimit) {
					this.balance -= .50;
					j-=1;
				}
			}
			else {System.out.println("Not more than 15");}
			book.setIn(true);
		}
		else {System.out.println(book.getName()+" was not checked out by "+student.getName());}
	}

	public void payForStudent (Student student, double pay) {
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


	
	public void getStudentsBalance(Student student) {
		System.out.println("\n"+student.getName()+"'s balance is: �"+student.balance+"\n");
	}


}
