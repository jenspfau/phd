package phd.image.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import phd.image.OpticalImage;
import phd.image.SARImage;

public class CleanFilter implements ImageFilter<OpticalImage> {

	private SARImage sar;
	private OpticalImage streetMap;
	
	private static int[][] neighbours;
	static {
		neighbours = new int[][] {
			new int[] {-1, -1},
			new int[] {-1, 1},
			new int[] {1, -1},
			new int[] {1, 1},
			new int[] {0, 1},
			new int[] {0, -1},
			new int[] {1, 0},
			new int[] {-1, 0}};
	}

	public CleanFilter(SARImage sar, OpticalImage streetMap) {
		this.sar = sar;
		this.streetMap = streetMap;
	}

	@Override
	public OpticalImage filter(OpticalImage image) throws IOException {
		BufferedImage bufferImage = image.getImage();

		BufferedImage result = new BufferedImage(bufferImage.getWidth(), bufferImage.getHeight(), bufferImage.getType());
		
		double neighbourProportion;
		double elevationDifference;
		double roadDistance;
		for(int x =0; x < result.getHeight(); x++){
			for(int y = 0; y < result.getWidth(); y++){
				neighbourProportion = calculateNeighboursBlack(bufferImage, x, y);
				elevationDifference = calculateElevationDifference(bufferImage, x, y);
				roadDistance = calculateRoadDistance(x, y);
				
				
			}
		}
		OpticalImage filteredImage = new OpticalImage(
				image.getTopLeftCoords(),
				image.getBottomRightCoords());
		filteredImage.setImage(result);
		return filteredImage;
	}

	private float calculateRoadDistance(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	private float calculateElevationDifference(BufferedImage img, int x, int y) {
		int numNeighbours = 0;
		int differences = 0;
		
		for (int i = 0; i < neighbours.length; i++) {
			int nX = x + neighbours[i][0];
			int nY = y + neighbours[i][1];
			
			if (nX > 0 && nY > 0 && nY < img.getWidth() && nX < img.getHeight()) {
				numNeighbours++;
				differences += (sar.get(nX, nY) - sar.get(x, y));
			}
		}
		
		return differences/numNeighbours;
	}

	private double calculateNeighboursBlack(BufferedImage img, int x, int y) {
		int numNeighbours = 0;
		int numBlackNeighbours = 0;
		
		for (int i = 0; i < neighbours.length; i++) {
			int nX = x + neighbours[i][0];
			int nY = y + neighbours[i][1];
			
			if (nX > 0 && nY > 0 && nY < img.getWidth() && nX < img.getHeight()) {
				numNeighbours++;
				if (img.getRGB(y, x) == Color.BLACK.getRGB()) {
					numBlackNeighbours++;
				}
			}
		}
		
		return numBlackNeighbours/numNeighbours;
	}

}
