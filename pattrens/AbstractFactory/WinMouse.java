package katrenich.pattrens.AbstractFactory;


import katrenich.pattrens.AbstractFactory.interfaces.Mouse;

public class WinMouse implements Mouse {

	@Override
	public void click() {
		System.out.println("Wndows: click");
	}

	@Override
	public void doubleClick() {
		System.out.println("Wndows: doubleClick");
	}

	@Override
	public void scroll(int direction) {
		System.out.println("Wndows: direction - " + direction);
	}
}
