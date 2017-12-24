package katrenich.pattrens.AbstractFactory;


import katrenich.pattrens.AbstractFactory.interfaces.DivicesFactory;
import katrenich.pattrens.AbstractFactory.interfaces.Keyboard;
import katrenich.pattrens.AbstractFactory.interfaces.Mouse;
import katrenich.pattrens.AbstractFactory.interfaces.Touchpad;

public class AbstractFactoryApp {
	public static void main(String[] args) {
		DivicesFactory factory = getDivicesFactoryByName("mac");
		Touchpad t = factory.createTouchpad();
		Mouse m = factory.createMouse();
		Keyboard k = factory.createKeyboard();

		t.track(14, 56);
		m.click();
		m.doubleClick();
		k.print();
		k.println();
	}

	public static DivicesFactory getDivicesFactoryByName(String name){
		switch (name){
			case "mac" :
				return new MacDivicesFactory();

			case "win" :
				return new WinDivicesFactory();

			default :
				throw new RuntimeException("Unsupported Factory Name: " + name);
 		}
	}
}
