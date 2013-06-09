package phd.image;

import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import phd.image.filter.SARFilter;

public class MappingTest {

	private static final String TEST_IMAGE="src/test/resources/mapImage.jpg";
	private static final String STREET_IMAGE = "src/test/resources/streetImage.jpg";
	private static final String RESULT_IMAGE = "src/test/resources/finalImage.jpg";
	
	@Test
	public void test() throws IOException {
		Coordinates x = new Coordinates(1,3);
		Coordinates y = new Coordinates(3,4);
		OpticalImage mapImage = new OpticalImage(x, y);
		File file = new File(TEST_IMAGE);
		BufferedImage bufferedImage = ImageIO.read(file);
		mapImage.setImage(bufferedImage);

		OpticalImage streetImage = new OpticalImage(x, y);		
		File streetfile = new File(STREET_IMAGE);
		BufferedImage bufferedImageStreet = ImageIO.read(streetfile);
		streetImage.setImage(bufferedImageStreet);
		
		SARImage sarImage = new SARImage(x, y);
		
		SARFilter filter = new SARFilter();
		OpticalImage resultImage = filter.filter(sarImage, streetImage, mapImage);
		
		File resultImageFile = new File(RESULT_IMAGE);
		resultImageFile.delete();
		ImageIO.write(resultImage.getImage(), "jpg", resultImageFile);
		
		assertTrue(resultImageFile.exists());

	}
}
