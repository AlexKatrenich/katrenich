package katrenich.pattrens.Decorator;

public class App {
	public static void main(String[] args) {
		Component component = new ConcreteDecoratorA(new ConcreteDecoratorB(new ConcreteComponent()));
		component.operation("HI");
	}
}
