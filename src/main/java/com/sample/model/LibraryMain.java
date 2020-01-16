package com.sample.model;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) throws SQLException, ParseException {

//		ArrayList<Book> books = new ArrayList<>(Loader.loadBooks());
//		ArrayList<Student> students = new ArrayList<>(Loader.loadStudents());
//		ArrayList<Librarian> librarians = new ArrayList<>(Loader.loadLibrarians());

		//Testing
		//				for (int i = 0; i < books.size(); i++) {
		//					System.out.println(books.get(i).getName()+"  "+books.get(i).getCode());
		//				}
		//				System.out.println();
		//				for (int i = 0; i < librarians.size(); i++) {
		//					System.out.println(librarians.get(i).getName()+"  "+librarians.get(i).getLibrarianID());
		//				}
		//				System.out.println();
		//				for (int i = 0; i < students.size(); i++) {
		//					System.out.println(students.get(i).getName()+"  "+students.get(i).getStudentID());
		//				}

		//				students.get(1).withdraw(books.get(0));
		//				students.get(1).withdraw(books.get(1));
		//				students.get(1).withdraw(books.get(2));
		//				students.get(1).withdraw(books.get(3));
		//				students.get(1).withdraw(books.get(4));
		//				students.get(1).withdraw(books.get(5));
		//				students.get(0).withdraw(books.get(0));
		//				students.get(0).deposit(books.get(0));
		//				students.get(1).deposit(books.get(0));
		//				students.get(1).getBalance();
		//				students.get(1).showWithdrawn();
		//				students.get(0).showWithdrawn();
//		boolean rightname = true;
//		while (rightname == true) {	
//			boolean login = true;
//
//			Scanner sc = new Scanner(System.in);
//			System.out.print("Please enter your name: ");
//			String name = sc.nextLine();
//			while(login == true) {
//				for (int i = 0; i < librarians.size(); i++) {
//					if (name.equalsIgnoreCase(librarians.get(i).getName())) {
//						System.out.println("Hi "+name
//								+", would you like to:\n"
//								+ "1) check out a book for yourself\n"
//								+ "2) check in a book for yourself\n"
//								+ "3) check out a book for a student\n"
//								+ "4) check in a book for a student\n"
//								+ "5) check your balance\n"
//								+ "6) check a students balance\n"
//								+ "7) pay your balance\n"
//								+ "8) pay a student's balance\n"
//								+ "9) exit system\n"
//								+ "Please enter a number: ");
//						int select = sc.nextInt();
//						switch (select) {
//						case 1:
//							System.out.println("The books available are:");
//							for (int j = 0; j < books.size(); j++) {
//								if (books.get(j).isIn()) {
//									System.out.println(books.get(j).getName()+"  "+books.get(j).getCode());
//								}
//							};
//							System.out.println("Please enter the book code to withdraw: ");
//							int choice = sc.nextInt();
//							Book chosen = null;
//							for (int j = 0; j < books.size(); j++) {
//								if (books.get(j).getCode() == choice) {chosen = books.get(j);}
//							}
//							librarians.get(i).withdraw(chosen);
//							break;
//							
//						case 2:
//							System.out.println("The books you have are:");
//							if (librarians.get(i).getBooks().size() > 0) {
//								for (int j = 0; j<librarians.get(i).getBooks().size(); j++) {
//									System.out.println(librarians.get(i).getBooks().get(j).getName()+"  "+librarians.get(i).getBooks().get(j).getCode());
//								}
//								System.out.println("Please enter the book code to deposit: ");
//								int deposit = sc.nextInt();
//								Book dep = null;
//								for (int j = 0; j < librarians.get(i).getBooks().size(); j++) {
//									if (books.get(j).getCode() == deposit) {dep = books.get(j);}
//								}
//								if(dep != null) {
//									librarians.get(i).deposit(dep);}
//								else {System.out.println("invalid selection!");}
//							}
//							else {System.out.println("You have no books withdrawn!");}
//							break;
//							
//						case 3:
//							Student stuin = null;
//							Book stuchosen = null;
//							Scanner sc1 = new Scanner(System.in);
//							System.out.print("Please enter student's name: ");
//							String stuinname = sc1.nextLine();
//							for (int j = 0; j < students.size(); j++) {
//								if (stuinname.equalsIgnoreCase(students.get(j).getName())) {
//									stuin = students.get(j);
//								}
//							}
//								System.out.println("Available books are: ");
//								for (int k = 0; k < books.size(); k++) {
//									if (books.get(k).isIn()) {
//										System.out.println(books.get(k).getName()+"  "+books.get(k).getCode());
//									}
//								};
//								System.out.println("Please enter the book code to withdraw: ");
//								int stuchoice = sc.nextInt();
//								for (int k = 0; k < books.size(); k++) {
//									if (books.get(k).getCode() == stuchoice) {stuchosen = books.get(k);}
//								}
//							if (stuin == null) {System.out.println("null");}
//							if (stuchosen == null) {System.out.println("null");}	
//							librarians.get(i).withdrawForStudent(stuin, stuchosen);
//							break;
//							
//						case 4:
//							System.out.print("Please enter student's name: ");
//							Student stuout = null;
//							Scanner sc2 = new Scanner(System.in);
//							String stuoutname = sc2.nextLine();
//							for (int j = 0; j < students.size(); j++) {
//								if (stuoutname.equalsIgnoreCase(students.get(j).getName())) {
//									stuout = students.get(j);
//								}}
//
//							if (stuout.getBooks().size() > 0) {
//								System.out.println("The books "+stuoutname+" has are:");
//								for (int j = 0; j<stuout.getBooks().size(); j++) {
//									System.out.println(stuout.getBooks().get(j).getName()+"  "+stuout.getBooks().get(j).getCode());
//									System.out.println("Please enter the book code to deposit: ");
//									int deposit = sc.nextInt();
//									Book dep = null;
//									for (int k = 0; k < stuout.getBooks().size(); k++) {
//										if (books.get(k).getCode() == deposit) {dep = books.get(k);}
//									}
//									if(dep != null) {
//										librarians.get(i).depositForStudent(stuout, dep);;}
//									else {System.out.println("invalid selection!");}
//								}
//							}
//							else {System.out.println("They have no books withdrawn!");}
//							break;
//							
//						case 5:
//							students.get(i).getMyBalance();
//							break;
//							
//						case 6:
//							System.out.print("Please enter student's name: ");
//							Student stubal = null;
//							Scanner sc3 = new Scanner(System.in);
//							String stubalname = sc3.nextLine();
//							for (int j = 0; j < students.size(); j++) {
//								if (stubalname.equalsIgnoreCase(students.get(j).getName())) {
//									stubal = students.get(j);
//								}}
//							librarians.get(i).getStudentsBalance(stubal);
//							
//							break;
//							
//						case 7:
//							System.out.print("Please enter your amount to pay: ");
//							double pay = sc.nextDouble();
//							students.get(i).pay(pay);
//							break;
//							
//						case 8:
//							System.out.print("Please enter student's name: ");
//							Student stupay = null;
//							Scanner sc4 = new Scanner(System.in);
//							String stupayname = sc4.nextLine();
//							for (int j = 0; j < students.size(); j++) {
//								if (stupayname.equalsIgnoreCase(students.get(j).getName())) {
//									stupay = students.get(j);
//								}}
//							System.out.print("Please enter amount: ");
//							double amount = sc4.nextDouble();
//							librarians.get(i).payForStudent(stupay, amount);
//							break;
//							
//						case 9:
//							System.out.println("Logging out");
//							login = false;
//							break;
//						default:
//							break;
//						}
//					}
//				}
//
//				for (int i = 0; i < students.size(); i++) {
//					if (name.equalsIgnoreCase(students.get(i).getName())) {
//						System.out.println("Hi "+name
//								+ ", would you like to:\n"
//								+ "1) check out a book for yourself\n"
//								+ "2) check in a book for yourself\n"
//								+ "3) check your balance\n"
//								+ "4) pay your balance\n"
//								+ "5) exit system\n"
//								+ "Please enter a number: ");					
//						int select = sc.nextInt();
//						switch (select) {
//						case 1:
//							System.out.println("The books available are:");
//							for (int j = 0; j < books.size(); j++) {
//								if (books.get(j).isIn()) {
//									System.out.println(books.get(j).getName()+"  "+books.get(j).getCode());
//								}
//							};
//							System.out.println("Please enter the book code to withdraw: ");
//							int choice = sc.nextInt();
//							Book chosen = null;
//							for (int j = 0; j < books.size(); j++) {
//								if (books.get(j).getCode() == choice) {chosen = books.get(j);}
//							}
//							students.get(i).withdraw(chosen);
//							break;
//						case 2:
//							System.out.println("The books you have are:");
//							if (students.get(i).getBooks().size() > 0) {
//								for (int j = 0; j<students.get(i).getBooks().size(); j++) {
//									System.out.println(students.get(i).getBooks().get(j).getName()+"  "+students.get(i).getBooks().get(j).getCode());
//								}
//								System.out.println("Please enter the book code to deposit: ");
//								int deposit = sc.nextInt();
//								Book dep = null;
//								for (int j = 0; j < students.get(i).getBooks().size(); j++) {
//									if (books.get(j).getCode() == deposit) {dep = books.get(j);}
//								}
//								if(dep != null) {
//									students.get(i).deposit(dep);}
//								else {System.out.println("invalid selection!");}
//							}
//							else {System.out.println("You have no books withdrawn!");}
//							break;
//						case 3:
//							students.get(i).getMyBalance();
//							break;
//						case 4:
//							System.out.print("Please enter your amount to pay: ");
//							double pay = sc.nextDouble();
//							students.get(i).pay(pay);
//							break;
//						case 5:
//							System.out.println("Logging out");
//							login = false;
//							break;
//						default:
//							break;
//						}
//
//					}
//
//				}
//				
//login = false;
//System.out.println("Name not found, please try again");
//			}
//		}
//
//
//
//		//		ResultSet resultSet  = null;
//		//		String connectionURL = "jdbc:sqlserver://SQLEXPRESS:1433; databaseName = Books; user = STUDENT10; password = Admin";
//		//		try (Connection connection = DriverManager.getConnection(connectionURL);
//		//				Statement statement = connection.createStatement();){
//		//			String selectSQL = "select * from Books";
//		//			resultSet = statement.executeQuery(selectSQL);
//		//			
//		//			while (resultSet.next()) {
//		//				System.out.println(resultSet.getString(0)+" "+resultSet.getString(1));
//		//			}
//		//		}
//
//
//
	}
}



