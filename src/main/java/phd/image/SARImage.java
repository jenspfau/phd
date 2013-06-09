package phd.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SARImage extends Image {


	private OpticalImage image;
	private int[][] elevationData;

	private static final String SAR_HEAT_IMAGE_MOCK="src/test/resources/sarHeatImage.jpg";
	
	public SARImage(Coordinates x, Coordinates y) {
		super(x, y);
		
		try {
			mockSAR(SAR_HEAT_IMAGE_MOCK);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void mockSAR(String filename) throws IOException {
		File file = new File(filename);
		BufferedImage bufferImage = ImageIO.read(file);
		
		elevationData = new int[bufferImage.getHeight()][bufferImage.getWidth()];
		for(int x =0; x < bufferImage.getHeight(); x++){
			for(int y = 0; y < bufferImage.getWidth(); y++){
				
				Color color = new Color(bufferImage.getRGB(y, x));
				int red = color.getRed();
				int blue = color.getBlue();
				
				int elevation = blue - red;
				
				elevationData[x][y] = elevation;
			}
		}
		
	}
	
	public int[][] getElevationData(){
		return elevationData;
	}

}
