package phd.storage;

import java.util.List;

import phd.image.Coordinates;
import phd.image.Image;
import phd.image.OpticalImage;
import phd.image.SARImage;

public class DefaultProxy implements ImageProxy {

	@Override
	public void store(Image img) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SARImage> retrieve(OpticalImage reference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpticalImage retrieveOptical(List<Coordinates> coordinates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpticalImage retrieveStreetMap(List<Coordinates> coordinates) {
		// TODO Auto-generated method stub
		return null;
	}


}
