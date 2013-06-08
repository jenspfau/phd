package phd.image;

import java.util.Date;
import java.util.List;

public abstract class Image {
	private Date creationDate;
	private List<Coordinates> coordinates;
	
	public List<Coordinates> getCoordinates() {
		return this.coordinates;
	}	
	
}
