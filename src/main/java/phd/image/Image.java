package phd.image;

import java.io.File;
import java.util.Date;
import java.util.List;

public abstract class Image {
	
	private File file;
	private Date creationDate;
	private List<Coordinates> coordinates;
	private String resultFileName;
	private Coordinates x;
	private Coordinates y;
	
	public Image(Coordinates x, Coordinates y) {
		this.x = x;
		this.y = y;
	}

	public List<Coordinates> getCoordinates() {
		return this.coordinates;
	}	
	
	public File getFile(){
		return this.file;		
	}
	
	public void setFile(File file){
		this.file = file;
	}
	
	public void setResultFileName(String name){
		this.resultFileName = name;
	}
	
	public String getResultFileName(){
		return resultFileName;
	}
	
}
