package phd;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import phd.image.Coordinates;
import phd.image.OpticalImage;
import phd.image.RandomSARImage;
import phd.image.SARImage;
import phd.image.filter.CleanFilter;
import phd.image.filter.ImageFilter;
import phd.image.filter.StreetsFilter;
import phd.processing.Processing;
import phd.storage.DefaultProxy;
import phd.storage.ImageProxy;

public class Phd {
	public static void main(String[] args) {
		Processing p = new Processing();
		ImageProxy store = new DefaultProxy();
		ImageFilter<OpticalImage> streetsFilter = new StreetsFilter();
		CleanFilter cleanFilter;
		OpticalImage streetMap;

		Coordinates x = new Coordinates(1, 2);
		Coordinates y = new Coordinates(3, 4);
		
				
		for (int i = 0; i < 10; i++) {
			// Create a random SAR image that we are going to process
			SARImage sar = new RandomSARImage(x, y);
			
			// Retrieve optical image for the same coordinates as SAR image
			OpticalImage img = store.retrieveOptical(sar.getCoordinates());
				
			
			// Filter optical image for streets and return b/w image
			try {
				File file = new File("test.jpg");
				BufferedImage bufferImage = ImageIO.read(file);
				img.setImage(bufferImage);
				
				img = streetsFilter.filter(img);
			
				// Retrieve open street map image for same coordinates as SAR image
				streetMap = store.retrieveStreetMap(sar.getCoordinates());
				
				cleanFilter = new CleanFilter(sar, streetMap);
				img = cleanFilter.filter(img);
	
				// Apply elevation data from SAR image to b/w image
				OpticalImage result = p.analyse(img, sar);		
				store.store(result);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
