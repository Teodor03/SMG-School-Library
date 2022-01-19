package common.containers;

public class Book {
	
	public Book(int bookID, String name, String location, String description, int authorID, int genreID) {
		this.bookID = bookID;
		this.name = name;
		this.location = location;
		this.description = description;
		this.authorID = authorID;
		this.genreID = genreID;
	}
	
	public Book() {}

	public int bookID;
	
	public String name;
	public String location;
	public String description;
	
	public int authorID;
	public int genreID;
	
	@Override
	public String toString() {
		return "Book [BookID=" + bookID + ", name=" + name + ", location=" + location + ", description=" + description
				+ ", authorID=" + authorID + ", genreID=" + genreID + "]";
	}
	
}
