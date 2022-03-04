package main;

import gui.main.MainWindow;
import service.MySQLConnectionManager;

public class SchoolLibraryMain {

	public static void main(String[] args) {
		MySQLConnectionManager.initMySQLConnection("exampleUsername","examplePassword","schoollibrary");
		MainWindow w = new MainWindow();
		return;
	}
	
	public static void terminate() {
    	MySQLConnectionManager.closeMySQLConnection();
		System.exit(0);
		return;
	}

}


//try {
//ArrayList<Book> arr = BookDAO.getBookList();
//for(int i=0;i<arr.size();i++) {
//	System.out.println(arr.get(i).toString());
//}
//} catch (SQLException e) {
//	e.printStackTrace();
//}

//try {
//Book a = new Book(0,"Hajduti", "Section B", "A good but long poem.", 1, 2);
//BookDAO.addBook(a);
//}catch(Exception e) {
//e.printStackTrace();
//}

//try {
//	Author a = new Author(0,"PO","Err");
//	AuthorDAO.addAuthor(a);
//}catch(Exception e) {
//	e.printStackTrace();
//}

//try {
//ArrayList<Author> arr = AuthorDAO.getAuthorList();
//for(int i=0;i<arr.size();i++) {
//	System.out.println(arr.get(i).toString());
//}
//} catch (SQLException e) {
//	e.printStackTrace();
//}
