package domain.table_models;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import common.containers.Author;
import common.containers.Book;
import service.dao.AuthorDAO;
import service.dao.BookDAO;
import service.dao.GenreDAO;

@SuppressWarnings("serial")
public class BookTableModel extends AbstractTableModel {

	public BookTableModel() {
		try {
			data = BookDAO.getBookList();
		} catch (SQLException e) {
			throw new IllegalStateException("Book table model could not load!");
		}
		return;
	}

	private ArrayList<Book> data;
	
	//Call when updates in the database have occurred in order the data model to be updated.
	public void updateTableModel() {
		data.clear();
		try {
			data = BookDAO.getBookList();
		} catch (SQLException e) {
			throw new IllegalStateException("Book table model could not update!");
		}
		this.fireTableDataChanged();
		return;
	}
	
	private static int columnsNumber = 5;
	private static String[] columns = {"ID","Name","Location","Author","Genre"};
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnsNumber;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0:
			
				return data.get(rowIndex).bookID;
			
			case 1:
			
				return data.get(rowIndex).name;
			
			case 2:
			
				return data.get(rowIndex).location;
			
			case 3:
			
				try {
					Author a = AuthorDAO.getAuthor(data.get(rowIndex).authorID);
					return a.firstName.charAt(0)+". "+a.familyName;
				}catch(SQLException exc) {
					return data.get(rowIndex).authorID+" (ID)";
				}
			
			case 4:
				
				try {
					return GenreDAO.getGenre(data.get(rowIndex).genreID).genreName;
				}catch(SQLException exc) {
					return data.get(rowIndex).genreID;
				}
			
			default:
			return null;
		}
	}

}
