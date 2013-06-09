package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import phd.image.Coordinates;
import phd.image.OpticalImage;
import phd.image.filter.StreetsFilter;

public class TestClass {
	
	public static void main(String[] args){
		
		Coordinates x = new Coordinates(4,5);
		Coordinates y = new Coordinates(4,5);
		
		OpticalImage opticalImage = new OpticalImage(x, y);
		
		try {
			File file = new File("testImage.jpg");
			BufferedImage bufferImage = ImageIO.read(file);
			opticalImage.setImage(bufferImage);		
			
			StreetsFilter filter = new StreetsFilter();						
			OpticalImage resultImage = filter.filter(opticalImage);
			
		    File outputfile = new File("resultImage.jpg");
		    ImageIO.write(resultImage.getImage(), "jpg", outputfile);		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
