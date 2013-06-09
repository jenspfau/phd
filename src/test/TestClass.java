package test;

import java.io.File;
import java.io.IOException;

import phd.image.OpticalImage;
import phd.image.filter.StreetsFilterGoogle;

public class TestClass {
	
	public static void main(String[] args){
		
		OpticalImage opticalImage = new OpticalImage();
		opticalImage.setFile(new File("testImage.jpg"));
		opticalImage.setResultFileName("resultImage.jpg");
		
		StreetsFilterGoogle filter = new StreetsFilterGoogle();
		try {
			filter.filter(opticalImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
