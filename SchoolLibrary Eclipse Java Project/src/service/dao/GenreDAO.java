package service.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.containers.Genre;
import service.MySQLConnectionManager;

public class GenreDAO {

	public static void addGenre(Genre toAdd) throws SQLException {
		PreparedStatement st = MySQLConnectionManager.getPreparedStatement("insert into genres(genreName) values (?)");
		st.setString(1, toAdd.genreName);
		st.executeUpdate();
		st.close();
		return;
	}
	
	public static void deleteGenre(int id) throws SQLException {
		PreparedStatement ps = MySQLConnectionManager.getPreparedStatement("delete from genres where genreID =?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
		return;
	}
	
	public static Genre getGenre(int id) throws SQLException {
		PreparedStatement ps = MySQLConnectionManager.getPreparedStatement("select * from genres where genreID= ?");
		ps.setInt(1, id);
		Genre newGenre = new Genre();
		ResultSet rs = ps.executeQuery();
		if(!rs.next()) {
			throw new SQLException("Genre with this ID was not found!");
		}
		newGenre.genreID = rs.getInt("genreID");
		newGenre.genreName = rs.getString("genreName");
		ps.close();
		return newGenre;
	}
	
	public static ArrayList<Genre> getGenreList() throws SQLException {
		ArrayList<Genre> arr = new ArrayList<Genre>();
		Genre newGenre;
		PreparedStatement ps = MySQLConnectionManager.getPreparedStatement("select * from genres");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			newGenre = new Genre();
			newGenre.genreID = rs.getInt("genreID");
			newGenre.genreName = rs.getString("genreName");
			arr.add(newGenre);
		}
		return arr;
	}
	
	
}
