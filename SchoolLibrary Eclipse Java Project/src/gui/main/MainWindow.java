package gui.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import domain.table_models.AuthorTableModel;
import domain.table_models.BookTableModel;
import domain.table_models.GenreTableModel;
import gui.framework.CustomJTable;
import main.SchoolLibraryMain;

public class MainWindow {

	public MainWindow() {
		
		mainFrame = new JFrame("SMG Library Explorer");
		mainFrame.setBounds(100, 100, 900, 800);
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mainFrame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent event) {
		    	SchoolLibraryMain.terminate();
		    }
		});
		mainFrame.getContentPane().setLayout(null);	
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		
		
		openAboutPage = new JMenuItem();
		openAboutPage.setText("About");
		openAboutPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				return;
			}
		});
		
		helpMenu = new JMenu("Help");
		helpMenu.add(openAboutPage);
		
		insertBook = new JMenuItem();
		insertBook.setText("Insert book");
		insertBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				return;
			}
		});
		
		insertAuthor = new JMenuItem();
		insertAuthor.setText("Insert author");
		insertAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				return;
			}
		});
		
		insertGenre = new JMenuItem();
		insertGenre.setText("Insert genre");
		insertGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				return;
			}
		});
		
		insertMenu = new JMenu("Insert");
		insertMenu.add(insertBook);
		insertMenu.add(insertAuthor);
		insertMenu.add(insertGenre);
		
		menuBar = new JMenuBar();
		menuBar.add(insertMenu);
		menuBar.add(helpMenu);
		
		
		
		
		
		firstTab = new JPanel();
		firstTab.setLayout(new BorderLayout());
		
		bookData = new BookTableModel();
		bookTable = new CustomJTable(bookData);
		bookScrollPane = new JScrollPane(bookTable);
		bookTable.setFillsViewportHeight(true);
		firstTab.add(BorderLayout.CENTER,bookScrollPane);
		
		secondTab = new JPanel();
		secondTab.setLayout(new BorderLayout());
		
		authorData = new AuthorTableModel();
		authorTable = new CustomJTable(authorData);
		authorScrollPane = new JScrollPane(authorTable);
		authorTable.setFillsViewportHeight(true);
		secondTab.add(BorderLayout.CENTER,authorScrollPane);
		
		thirdTab = new JPanel();
		thirdTab.setLayout(new BorderLayout());
		
		genreData = new GenreTableModel();
		genreTable = new CustomJTable(genreData);
		genreScrollPane = new JScrollPane(genreTable);
		genreTable.setFillsViewportHeight(true);
		thirdTab.add(BorderLayout.CENTER,genreScrollPane);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Books", firstTab);
		tabbedPane.addTab("Authors",secondTab);
		tabbedPane.addTab("Genres",thirdTab);
		
		contentPanel.add(BorderLayout.CENTER,tabbedPane);
		
		mainFrame.setJMenuBar(menuBar);
		mainFrame.setContentPane(contentPanel);
		mainFrame.setVisible(true);
		return;
	}

	public JFrame mainFrame;
	private JPanel contentPanel;
	
	private JMenu helpMenu;
	private JMenuItem openAboutPage;
	
	private JMenu insertMenu;
	private JMenuItem insertBook;
	private JMenuItem insertAuthor;
	private JMenuItem insertGenre;
	
	private JMenuBar menuBar;
	
	private JTabbedPane tabbedPane;
	
	private JPanel firstTab;
	private JPanel secondTab;
	private JPanel thirdTab;
	
	private JScrollPane bookScrollPane;
	private BookTableModel bookData;
	private CustomJTable bookTable;
	
	private JScrollPane authorScrollPane;
	private AuthorTableModel authorData;
	private CustomJTable authorTable;
	
	private JScrollPane genreScrollPane;
	private GenreTableModel genreData;
	private CustomJTable genreTable;
	
}
