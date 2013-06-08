package phd;

import phd.image.OpticalImage;
import phd.image.RandomSARImage;
import phd.image.SARImage;
import phd.image.filter.ImageFilter;
import phd.image.filter.StreetsFilter;
import phd.image.filter.StreetsMapFilter;
import phd.processing.Processing;
import phd.storage.DefaultProxy;
import phd.storage.ImageProxy;

public class Phd {
	public static void main(String[] args) {
		Processing p = new Processing();
		ImageProxy store = new DefaultProxy();
		ImageFilter<OpticalImage> streetsFilter = new StreetsFilter();
		ImageFilter<OpticalImage> streetsMapFilter;
		OpticalImage streetMap;
		
				
		for (int i = 0; i < 10; i++) {
			// Create a random SAR image that we are going to process
			SARImage sar = new RandomSARImage();
			
			// Retrieve optical image for the same coordinates as SAR image
			OpticalImage img = store.retrieveOptical(sar.getCoordinates());
			
			// Filter optical image for streets and return b/w image
			img = streetsFilter.filter(img);
			
			// Retrieve open street map image for same coordinates as SAR image
			streetMap = store.retrieveStreetMap(sar.getCoordinates());
			
			// Refine filtering of streets
			streetsMapFilter = new StreetsMapFilter(streetMap);
			img = streetsMapFilter.filter(img);

			// Apply elevation data from SAR image to b/w image
			OpticalImage result = p.analyse(img, sar);		
			store.store(result);			
		}
		
		
		
	}

}
