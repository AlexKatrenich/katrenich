package katrenich.pattrens.AbstractFactory;

import katrenich.pattrens.AbstractFactory.interfaces.DivicesFactory;
import katrenich.pattrens.AbstractFactory.interfaces.Keyboard;
import katrenich.pattrens.AbstractFactory.interfaces.Mouse;
import katrenich.pattrens.AbstractFactory.interfaces.Touchpad;

public class MacDivicesFactory implements DivicesFactory {
	@Override
	public Keyboard createKeyboard() {
		return new MacKeyboard();
	}

	@Override
	public Mouse createMouse() {
		return new MacMouse();
	}

	@Override
	public Touchpad createTouchpad() {
		return new MacTouchpad();
	}
}
