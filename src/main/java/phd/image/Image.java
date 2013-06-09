package phd.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class Image {
	
	private Date creationDate;
	private List<Coordinates> coordinates;
	private Coordinates x;
	private Coordinates y;
	private BufferedImage bufferImage;
	
	public Image(Coordinates x, Coordinates y) {
		this.x = x;
		this.y = y;
	}

	public List<Coordinates> getCoordinates() {
		return this.coordinates;
	}	
	
	public BufferedImage getImage() throws IOException {
		return this.bufferImage;
	}
	
	public void setImage(BufferedImage image){
		this.bufferImage = image;
	}
	
}
