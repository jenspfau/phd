package phd.image.filter;

import phd.image.Image;

public interface ImageFilter<T extends Image> {
	T filter(T image); 
}
