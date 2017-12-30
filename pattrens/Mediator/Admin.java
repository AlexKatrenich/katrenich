package katrenich.pattrens.Mediator;

public class Admin extends User {

	public Admin(String name, Chat chat) {
		super(name, chat);
	}


	@Override
	void sendMessage(String message) {
		chat.sendMessage(message, this);
	}

	@Override
	void receiveMessage(String message) {
		System.out.println("Admin has receive the message: " + message);
	}
}
