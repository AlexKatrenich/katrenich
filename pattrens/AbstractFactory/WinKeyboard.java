package katrenich.pattrens.AbstractFactory;

import katrenich.pattrens.AbstractFactory.interfaces.Keyboard;

public class WinKeyboard implements Keyboard {

	@Override
	public void print() {
		System.out.println("Windows Keyboard: Print");
	}

	@Override
	public void println() {
		System.out.println("Windows Keyboard: Println");
	}
}
