package katrenich.pattrens.AbstractFactory;

import katrenich.pattrens.AbstractFactory.interfaces.Touchpad;

public class WinTouchpad implements Touchpad {

	@Override
	public void track(int deltaX, int deltaY) {
		System.out.println("Windows: track [" + deltaX + "] [" + deltaY +"]");
	}
}
