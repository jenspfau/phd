package phd.image.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import phd.image.OpticalImage;
import phd.image.SARImage;

public class CleanFilter implements ImageFilter<OpticalImage> {

	private SARImage sar;

	public CleanFilter(SARImage sar) {
		this.sar = sar;
	}

	@Override
	public OpticalImage filter(OpticalImage image) throws IOException {
		BufferedImage bufferImage = image.getImage();

		BufferedImage result = new BufferedImage(bufferImage.getWidth(), bufferImage.getHeight(), bufferImage.getType());
		
		float neighbourProportion;
		float elevationDifference;
		float roadDistance;
		for(int x =0; x < result.getHeight(); x++){
			for(int y = 0; y < result.getWidth(); y++){
				neighbourProportion = calculateNeighboursBlack(bufferImage, x, y);
				elevationDifference = calculateElevationDifference(bufferImage, sar, x, y);
				roadDistance = calculateRoadDistance(x, y);
				
				
			}
		}
	}

	private float calculateNeighboursBlack(BufferedImage img, int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

}
