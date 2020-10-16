package events;

import model.Images;

public interface OnMessageListener {
	
	public void onImagesReceive(Images image);

}
