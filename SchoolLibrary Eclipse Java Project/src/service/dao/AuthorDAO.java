package service.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.containers.Author;
import service.MySQLConnectionManager;

public class AuthorDAO {
	
	public static void addAuthor(Author toAdd) throws SQLException {
		PreparedStatement st = MySQLConnectionManager.getPreparedStatement("insert into authors(authorFirstName, authorFamilyName) values (?,?)");
		st.setString(1, toAdd.firstName);
		st.setString(2, toAdd.familyName);
		st.executeUpdate();
		st.close();
		return;
	}
	
	public static void deleteAuthor(int id) throws SQLException {
		PreparedStatement ps = MySQLConnectionManager.getPreparedStatement("delete from authors where authorID =?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
		return;
	}
	
	public static Author getAuthor(int id) throws SQLException {
		PreparedStatement ps = MySQLConnectionManager.getPreparedStatement("select * from authors where authorID= ?");
		ps.setInt(1, id);
		Author newAuthor = new Author();
		ResultSet rs = ps.executeQuery();
		if(!rs.next()) {
			throw new SQLException("Author with this ID was not found!");
		}
		newAuthor.authorID = rs.getInt("authorID");
		newAuthor.firstName = rs.getString("authorFirstName");
		newAuthor.familyName = rs.getString("authorFamilyName");
		ps.close();
		return newAuthor;
	}
	
	public static ArrayList<Author> getAuthorList() throws SQLException {
		ArrayList<Author> arr = new ArrayList<Author>();
		Author newAuthor;
		PreparedStatement ps = MySQLConnectionManager.getPreparedStatement("select * from authors");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			newAuthor = new Author();
			newAuthor.authorID = rs.getInt("authorID");
			newAuthor.firstName = rs.getString("authorFirstName");
			newAuthor.familyName = rs.getString("authorFamilyName");
			arr.add(newAuthor);
		}
		return arr;
	}
	
}
