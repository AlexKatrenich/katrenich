package katrenich.pattrens.AbstractFactory;

import katrenich.pattrens.AbstractFactory.interfaces.DivicesFactory;
import katrenich.pattrens.AbstractFactory.interfaces.Keyboard;
import katrenich.pattrens.AbstractFactory.interfaces.Mouse;
import katrenich.pattrens.AbstractFactory.interfaces.Touchpad;

public class WinDivicesFactory implements DivicesFactory {
	@Override
	public Keyboard createKeyboard() {
		return new WinKeyboard();
	}

	@Override
	public Mouse createMouse() {
		return new WinMouse();
	}

	@Override
	public Touchpad createTouchpad() {
		return new WinTouchpad();
	}
}
