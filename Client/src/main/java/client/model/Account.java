package client.model;

public class Account {
	private int id;
	private String username;
	private String password;
	private String email;
	private UserType type;

	// getters
	public int getId() {
		return this.id;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}

	public UserType getType() {
		return this.type;
	}

	// setters
	private void setId(int id) {
		this.id = id;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private void setType(UserType type) {
		this.type = type;
	}

	// validation methods
	public boolean isUsernameCorrect(String name) {
		return this.getUsername().equals(name);
	}

	public boolean isPasswordCorrect(String pass) {
		return this.getPassword().equals(pass);
	}

	// newInstance methods
	public static Account newInstance(int id, String username, String password, String email, UserType type) {
		if (id < 0 || username == null || password == null || email == null || type == null) {
			return null;
		}
		return new Account(id, username, password, email, type);
	}

	public static Account newInstance(int id, String username, String password, String email, String type) {
		UserType userType = UserType.fromString(type);
		if (id < 0 || username == null || password == null || email == null | type == null || userType == null) {
			return null;
		}
		return new Account(id, username, password, email, userType);
	}

	// constructors
	private Account(int id, String username, String password, String email, UserType type) {
		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setType(type);
	}
}
