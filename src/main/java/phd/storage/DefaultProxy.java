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
	public OpticalImage retrieveOptical(Coordinates topLeftCoords, Coordinates bottomRightCoords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpticalImage retrieveStreetMap(Coordinates topLeftCoords, Coordinates bottomRightCoords) {
		// TODO Auto-generated method stub
		return null;
	}


}
