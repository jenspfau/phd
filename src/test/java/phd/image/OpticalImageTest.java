package phd.image;

import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import phd.image.filter.StreetsFilter;

public class OpticalImageTest {

	private static final String TEST_IMAGE="src/test/resources/testImage.jpg";
	private static final String RESULT_IMAGE = "src/test/resources/resultImage.jpg";
	
	@Test
	public void test() throws IOException {
		Coordinates x = new Coordinates(1,3);
		Coordinates y = new Coordinates(3,4);
		OpticalImage opticalImage = new OpticalImage(x, y);
		
		File file = new File(TEST_IMAGE);
		BufferedImage bufferedImage = ImageIO.read(file);
		opticalImage.setImage(bufferedImage);

		StreetsFilter filter = new StreetsFilter();
		OpticalImage resultImage = filter.filter(opticalImage);
		
		File resultImageFile = new File(RESULT_IMAGE);
		resultImageFile.delete();
		ImageIO.write(resultImage.getImage(), "jpg", resultImageFile);

		assertTrue(resultImageFile.exists());
	}

}
