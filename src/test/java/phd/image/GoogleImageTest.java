package phd.image;

import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class GoogleImageTest {

	private static final String TEST_IMAGE_ROADS="src/test/resources/testImage6.gif";
	private static final String RESULT_IMAGE="src/test/resources/testImage6-distances.jpg";
	
	@Test
	public void test() throws IOException {	
		GoogleImage image = new GoogleImage(new Coordinates(1,3), new Coordinates(3,4));
		File file = new File(TEST_IMAGE_ROADS);
		BufferedImage bufferedImage = ImageIO.read(file);
		image.setImage(bufferedImage);

		BufferedImage resultImage = new BufferedImage(
				bufferedImage.getWidth(), bufferedImage.getHeight(), 
				BufferedImage.TYPE_INT_RGB);
		
		System.out.println(bufferedImage.getWidth());
		System.out.println(bufferedImage.getHeight());
		
		double maxDistance = Math.sqrt(Math.pow(bufferedImage.getWidth(), 2) + 
				Math.pow(bufferedImage.getHeight(), 2));
		
		for (int x = 0; x < bufferedImage.getWidth(); x++) {
			for (int y = 0; y < bufferedImage.getHeight(); y++) {
				double distance = image.roadDistance(new Coordinates(x, y));
				double normalized = distance*255.0/maxDistance;
				
				if (normalized <= 1) {
					resultImage.setRGB(x, y, Color.BLACK.getRGB());
				} else {
					resultImage.setRGB(x, y, Color.WHITE.getRGB());
				}
			}
		}
		
		File resultImageFile = new File(RESULT_IMAGE);
		resultImageFile.delete();
		ImageIO.write(resultImage, "jpg", resultImageFile);

		assertTrue(resultImageFile.exists());
	}

}