package phd.image.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import phd.image.OpticalImage;

public class StreetsFilter implements ImageFilter<OpticalImage> {

	@Override
	public OpticalImage filter(OpticalImage image) throws IOException {

		BufferedImage bufferImage = image.getImage();

		double intensityModel = calculateIntensity(bufferImage);

		BufferedImage result = new BufferedImage(bufferImage.getWidth(), bufferImage.getHeight(), bufferImage.getType());
		
		for(int x =0; x < result.getHeight(); x++){
			for(int y = 0; y < result.getWidth(); y++){
				
				Color color = new Color(bufferImage.getRGB(y, x));
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
	
				double intensity = 0.299 * red + 0.587 * green + 0.114 * blue;
				
				int rgb = Color.WHITE.getRGB();
				
				if(intensity < intensityModel){
					rgb = Color.BLACK.getRGB();
				}else{
					rgb = Color.WHITE.getRGB();
				}
				result.setRGB(y, x, rgb);
			}
		}
		
		OpticalImage filteredImage = new OpticalImage(
				image.getTopLeftCoords(),
				image.getBottomRightCoords());
		filteredImage.setImage(result);
		return filteredImage;
	}

	/**
	 * Calculates the model intensity to compare the pixels against.
	 * 
	 * @param bufferImage - the input image
	 * @return intensity model
	 */
	private double calculateIntensity(BufferedImage bufferImage) {
		double[] averages = new double[bufferImage.getHeight()];

		for (int x = 0; x < bufferImage.getHeight(); x++) {
			double sumOfIntensity = 0;
			for (int y = 0; y < bufferImage.getWidth(); y++) {

				Color color = new Color(bufferImage.getRGB(y, x));
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();

				double intensity = 0.299 * red + 0.587 * green + 0.114 * blue;
				sumOfIntensity += intensity;
			}
			double averageIntensity = sumOfIntensity / bufferImage.getWidth();
			averages[x] = averageIntensity;
		}

		double min = Double.MAX_VALUE;
		for (double d : averages) {
			if (d < min)
				min = d;
		}
		return min;
	}

}
