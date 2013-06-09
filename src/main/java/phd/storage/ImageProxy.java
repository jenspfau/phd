package phd.storage;

import java.util.List;

import phd.image.Coordinates;
import phd.image.Image;
import phd.image.OpticalImage;
import phd.image.SARImage;

public interface ImageProxy {
	public void store(Image img);
	public List<SARImage> retrieve(OpticalImage reference);
	
	// Retrieve optical image for given coordinates
	public OpticalImage retrieveOptical(List<Coordinates> coordinates);
	
	// Retrieve street map image for given coordinates
	public OpticalImage retrieveStreetMap(List<Coordinates> coordinates);
}
