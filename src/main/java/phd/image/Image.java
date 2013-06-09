package phd.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

public abstract class Image {

	private Date creationDate;
	private Coordinates topLeftCoords;
	private Coordinates bottomRightCoords;
	private BufferedImage bufferImage;

	public Image(Coordinates topLeftCoords, Coordinates bottomRightCoords) {
		this.topLeftCoords = topLeftCoords;
		this.bottomRightCoords = bottomRightCoords;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public Coordinates getTopLeftCoords() {
		return topLeftCoords;
	}

	public Coordinates getBottomRightCoords() {
		return bottomRightCoords;
	}

	public BufferedImage getImage() throws IOException {
		return this.bufferImage;
	}

	public void setImage(BufferedImage image) {
		this.bufferImage = image;
	}

}
