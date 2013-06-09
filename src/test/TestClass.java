package test;

import java.io.File;
import java.io.IOException;

import phd.image.OpticalImage;
import phd.image.filter.StreetsFilter;

public class TestClass {
	
	public static void main(String[] args){
		
		OpticalImage opticalImage = new OpticalImage();
		opticalImage.setFile(new File("testImage.jpg"));
		opticalImage.setResultFileName("resultImage.jpg");
		
		StreetsFilter filter = new StreetsFilter();
		try {
			filter.filter(opticalImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
