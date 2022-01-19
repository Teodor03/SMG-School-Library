package domain.table_models;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import common.containers.Author;
import service.dao.AuthorDAO;

@SuppressWarnings("serial")
public class AuthorTableModel extends AbstractTableModel {

	public AuthorTableModel() {
		try {
			data = AuthorDAO.getAuthorList();
		} catch (SQLException e) {
			throw new IllegalStateException("Author table model could not load!");
		}
		return;
	}
	
	private ArrayList<Author> data;
	
	//Call when updates in the database have occurred in order the data model to be updated.
	public void updateTableModel() {
		data.clear();
		try {
			data = AuthorDAO.getAuthorList();
		} catch (SQLException e) {
			throw new IllegalStateException("Author table model could not update!");
		}
		this.fireTableDataChanged();
		return;
	}
	
	private static int columnsNumber =3;
	private static String[] columns = {"ID","First Name","Family Name"};
	
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
			return data.get(rowIndex).authorID;
			case 1:
			return data.get(rowIndex).firstName;
			case 2:
			return data.get(rowIndex).familyName;
			default:
			return null;
		}
	}

}
