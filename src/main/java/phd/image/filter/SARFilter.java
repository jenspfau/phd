package phd.image.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import phd.image.OpticalImage;
import phd.image.SARImage;

public class SARFilter {

	
	/**
	 * Updates the original map image with SAR's data, mapping only the areas where the roads are.
	 * 
	 * @param sarImage - SAR image
	 * @param streetImage - road map
	 * @param mapImage - original map image
	 * @return updated map image with SAR information
	 * @throws IOException
	 */
	public OpticalImage filter(SARImage sarImage, OpticalImage streetImage, OpticalImage mapImage) throws IOException{
		
		BufferedImage street = streetImage.getImage();
		BufferedImage map = mapImage.getImage();
		int[][] sarElevation = sarImage.getElevationData();
						
		for(int x = 0; x < street.getHeight(); x++){
			for(int y = 0; y < street.getWidth(); y++){
				if(street.getRGB(y, x) == Color.BLACK.getRGB()){
					map.setRGB(y, x, sarElevation[x][y]);
				}
			}
		}
		
		mapImage.setImage(map);
		return mapImage;
	}
	
	
}
