package service.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.containers.Book;
import service.MySQLConnectionManager;

public class BookDAO {
	
	public static void addBook(Book toAdd) throws SQLException {
		PreparedStatement st = MySQLConnectionManager.getPreparedStatement("insert into books(bookName, physicalLocation, bookDescription, authorID, genreID) values (?,?,?,?,?)");
		st.setString(1, toAdd.name);
		st.setString(2, toAdd.location);
		st.setString(3, toAdd.description);
		st.setInt(4, toAdd.authorID);
		st.setInt(5, toAdd.genreID);
		st.executeUpdate();
		st.close();
		return;
	}
	
	public static void deleteBook(int id) throws SQLException {
		PreparedStatement ps = MySQLConnectionManager.getPreparedStatement("delete from books where bookID=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
		return;
	}
	
	public static Book getBook(int id) throws SQLException {
		PreparedStatement ps = MySQLConnectionManager.getPreparedStatement("select * from books where bookID=?");
		ps.setInt(1, id);
		Book newBook = new Book();
		ResultSet rs = ps.executeQuery();
		if(!rs.next()) {
			throw new SQLException("Book with this ID was not found!");
		}
		newBook.bookID = rs.getInt("bookID");
		newBook.name = rs.getString("bookName");
		newBook.location = rs.getString("physicalLocation");
		newBook.description = rs.getString("bookDescription");
		newBook.authorID = rs.getInt("authorID");
		newBook.genreID = rs.getInt("genreID");
		ps.close();
		return newBook;
	}
	
	public static ArrayList<Book> getBookList() throws SQLException {
		ArrayList<Book> arr = new ArrayList<Book>();
		Book newBook;
		PreparedStatement ps = MySQLConnectionManager.getPreparedStatement("select * from books");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			newBook = new Book();
			newBook.bookID = rs.getInt("bookID");
			newBook.name = rs.getString("bookName");
			newBook.location = rs.getString("physicalLocation");
			newBook.description = rs.getString("bookDescription");
			newBook.authorID = rs.getInt("authorID");
			newBook.genreID = rs.getInt("genreID");
			arr.add(newBook);
		}
		return arr;
	}
	
	
}
