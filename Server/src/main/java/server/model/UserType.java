package server.model;

public enum UserType {
	USER, ADMIN;

	public static UserType fromString(String type) {
		if (type == null) {
			return null;
		}
		switch (type.toUpperCase()) {
		case "USER":
			return UserType.USER;
		case "ADMIN":
			return UserType.ADMIN;
		default:
			return null;
		}
	}
}
