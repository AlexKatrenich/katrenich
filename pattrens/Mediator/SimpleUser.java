package katrenich.pattrens.Mediator;

public class SimpleUser extends User {

	public SimpleUser(String name, Chat chat) {
		super(name, chat);
	}

	@Override
	void sendMessage(String message) {
		chat.sendMessage(message, this);
	}

	@Override
	void receiveMessage(String message) {
		System.out.println("User has receive the message: " + message);
	}
}
