package phd.image;

import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class GoogleImageTest {

	private static final String TEST_IMAGE_ROADS="src/test/resources/testImage2.jpg";
	private static final String RESULT_IMAGE="src/test/resources/testImage2-distances.jpg";
	
	@Test
	public void test() throws IOException {	
		GoogleImage image = new GoogleImage(new Coordinates(1,3), new Coordinates(3,4));
		File file = new File(TEST_IMAGE_ROADS);
		BufferedImage bufferedImage = ImageIO.read(file);
		image.setImage(bufferedImage);

		BufferedImage resultImage = new BufferedImage(
				bufferedImage.getHeight(), bufferedImage.getWidth(), 
				bufferedImage.getType());
		
		System.out.println(bufferedImage.getWidth());
		System.out.println(bufferedImage.getHeight());
		
		for (int x = 0; x < bufferedImage.getWidth(); x++) {
			for (int y = 0; y < bufferedImage.getHeight(); y++) {
				double distance = image.roadDistance(new Coordinates(x, y));
				if (y >= 627) {
					System.out.println(x);
					System.out.println(y);
				}
								
				bufferedImage.setRGB(x, y, (int)distance);
			}
		}
		
		File resultImageFile = new File(RESULT_IMAGE);
		resultImageFile.delete();
		ImageIO.write(resultImage, "jpg", resultImageFile);

		assertTrue(resultImageFile.exists());
	}

}