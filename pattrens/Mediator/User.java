package katrenich.pattrens.Mediator;

public abstract class User {
	boolean isEnable;
	String name;
	Chat chat;

	public User(String name, Chat chat) {
		this.name = name;
		this.chat = chat;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setChat(Chat chat){
		this.chat = chat;
	}

	public void setEnable(boolean enable) {
		isEnable = enable;
	}

	abstract void sendMessage(String message);
	abstract void receiveMessage(String message);
}
