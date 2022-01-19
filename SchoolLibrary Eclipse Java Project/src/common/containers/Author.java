package common.containers;

public class Author {
	
	public Author(int authorID, String firstName, String secondName) {
		this.authorID = authorID;
		this.firstName = firstName;
		this.familyName = secondName;
	}
	
	public Author() {
		this.authorID=0;
		this.firstName="";
		this.familyName="";
		return;
	}
	
	public int authorID;
	
	public String firstName;
	public String familyName;
	
	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", firstName=" + firstName + ", familyName=" + familyName + "]";
	}
	
}
