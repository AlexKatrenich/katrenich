package katrenich.pattrens.AbstractFactory;

import katrenich.pattrens.AbstractFactory.interfaces.Touchpad;

public class MacTouchpad implements Touchpad {

	@Override
	public void track(int deltaX, int deltaY) {
		System.out.println("MacOS: track [" + deltaX + "] [" + deltaY +"]");
	}
}
