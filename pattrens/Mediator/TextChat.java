package katrenich.pattrens.Mediator;

import java.util.ArrayList;
import java.util.List;

public class TextChat implements Chat{
	User admin;

	List<User> users;

	public TextChat() {
		this.users = new ArrayList<>();
	}

	public void setUser(User u){
		users.add(u);
	}

	public void removeUser(User u){
		users.remove(u);
	}

	public void setAdmin(User admin) {
		if(admin instanceof Admin){
			this.admin = admin;
		}
	}


	@Override
	public void sendMessage(String message, User user) {
		for (User u: users) {
			if(user != u){
				u.receiveMessage(message);
			}
		}
		if(admin != user){
			admin.receiveMessage(message);
		}
	}
}
