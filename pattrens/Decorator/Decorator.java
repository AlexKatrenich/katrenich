package katrenich.pattrens.Decorator;

public abstract class Decorator implements Component{
	Component component;

	public Decorator(Component component){
		this.component = component;
	}

	@Override
	public void operation(String data) {
		component.operation(data);
	}
}
