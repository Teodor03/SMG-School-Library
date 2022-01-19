package domain.table_models;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import common.containers.Genre;
import service.dao.GenreDAO;

@SuppressWarnings("serial")
public class GenreTableModel extends AbstractTableModel {

	public GenreTableModel() {
		try {
			data = GenreDAO.getGenreList();
		} catch (SQLException e) {
			throw new IllegalStateException("Genre table model could not load!");
		}
		return;
	}

	private ArrayList<Genre> data;
	
	//Call when updates in the database have occurred in order the data model to be updated.
	public void updateTableModel() {
		data.clear();
		try {
			data = GenreDAO.getGenreList();
		} catch (SQLException e) {
			throw new IllegalStateException("Genre table model could not update!");
		}
		this.fireTableDataChanged();
		return;
	}
	
	private static int columnsNumber =2;
	private static String[] columns = {"ID","Name"};
	
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
			return data.get(rowIndex).genreID;
			case 1:
			return data.get(rowIndex).genreName;
			default:
			return null;
		}
	}

}
