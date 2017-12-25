package katrenich.pattrens.Decorator;

public class ConcreteDecoratorB extends Decorator{

	public ConcreteDecoratorB(Component component) {
		super(component);
	}

	@Override
	public void operation(String data) {
		System.out.print("[");
		super.operation(data);
		System.out.print("]");
	}
}
