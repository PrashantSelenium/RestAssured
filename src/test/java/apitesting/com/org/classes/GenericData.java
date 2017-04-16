package apitesting.com.org.classes;

public class GenericData {
	
	private String id;
	private String title;
	private String author;
	private Information[] info;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Information[] getInfo() {
		return info;
	}
	public void setInformation(Information[] info) {
		this.info = info;
	}

}
