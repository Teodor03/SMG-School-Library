package common.containers;

public class Genre {

	public Genre(int genreID, String genreName) {
		super();
		this.genreID = genreID;
		this.genreName = genreName;
	}
	
	public Genre() {}
	
	public int genreID;
	public String genreName;
	
	@Override
	public String toString() {
		return "Genre [genreID=" + genreID + ", genreName=" + genreName + "]";
	}
	
}
