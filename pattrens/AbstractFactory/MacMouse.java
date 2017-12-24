package katrenich.pattrens.AbstractFactory;


import katrenich.pattrens.AbstractFactory.interfaces.Mouse;

public class MacMouse implements Mouse {

	@Override
	public void click() {
		System.out.println("MacOS: click");
	}

	@Override
	public void doubleClick() {
		System.out.println("MacOS: doubleClick");
	}

	@Override
	public void scroll(int direction) {
		System.out.println("MacOS: direction - " + direction);
	}
}
