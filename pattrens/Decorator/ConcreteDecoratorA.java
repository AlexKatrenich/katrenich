package katrenich.pattrens.Decorator;

public class ConcreteDecoratorA extends Decorator{

	public ConcreteDecoratorA(Component component) {
		super(component);
	}

	@Override
	public void operation(String data) {
		System.out.print("\'");
		super.operation(data);
		System.out.print("\'");
	}
}
