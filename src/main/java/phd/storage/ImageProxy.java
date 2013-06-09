package phd.storage;

import java.util.List;

import phd.image.Coordinates;
import phd.image.GoogleImage;
import phd.image.Image;
import phd.image.OpticalImage;
import phd.image.SARImage;

public interface ImageProxy {
	public void store(Image img);
	public List<SARImage> retrieve(OpticalImage reference);
	
	// Retrieve optical image for given coordinates
	public OpticalImage retrieveOptical(Coordinates topLeftCoords, Coordinates bottomRightCoords);
	
	// Retrieve street map image for given coordinates
	public GoogleImage retrieveStreetMap(Coordinates topLeftCoords, Coordinates bottomRightCoords);
}
