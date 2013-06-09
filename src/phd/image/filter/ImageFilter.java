package phd.image.filter;

import java.io.IOException;

import phd.image.Image;

public interface ImageFilter<T extends Image> {
	T filter(T image) throws IOException; 
}
