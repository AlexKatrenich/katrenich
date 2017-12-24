package katrenich.pattrens.AbstractFactory;

import katrenich.pattrens.AbstractFactory.interfaces.Keyboard;

public class MacKeyboard implements Keyboard {

	@Override
	public void print() {
		System.out.println("MacOS Keyboard: Print");
	}

	@Override
	public void println() {
		System.out.println("MacOS Keyboard: Println");
	}
}
