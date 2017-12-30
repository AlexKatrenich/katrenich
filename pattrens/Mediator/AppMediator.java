package katrenich.pattrens.Mediator;

public class AppMediator {
	public static void main(String[] args) {
		TextChat chat = new TextChat();
		User admin = new Admin("Admin", chat);
		User user1 = new SimpleUser("Vasya", chat);
		User user2 = new SimpleUser("Petya",chat);
		User user3 = new SimpleUser("Shasha",chat);
		User user4 = new SimpleUser("Marina",chat);

		chat.setAdmin(admin);
		chat.setUser(user1);
		chat.setUser(user2);
		chat.setUser(user3);
		chat.setUser(user4);

		admin.sendMessage("Admin has register in chat.");
		user1.sendMessage("Hello guy`s!!!");
		user3.sendMessage("Hi to all! =)");
	}
}
