package client.model;

public class AccountValidators {
	public static boolean validUsername(String username) {
		return username.matches("[a-zA-Z]{1}[-a-zA-Z0-9_.]{2,}");
	}

	public static boolean validPassword(String password) {
		return password.matches("[-a-zA-Z0-9`~!@#$%^&*()_=+\\[\\]\\{\\}\\\\|;:'\",.<>/?]{3,}");
	}

	public static boolean validEmail(String email) {
		String[] strings = email.split("@");
		if (strings.length != 2) {
			return false;
		}
		String prefix = strings[0];
		String domain = strings[1];
		if (prefix.length() < 5 || domain.length() < 6) {
			return false;
		}

		String prefixRegex = "([a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*)";
		String suffixRegex = "(\\.[a-zA-Z]{2,})";
		return email.matches(prefixRegex + "@" + prefixRegex + suffixRegex);
	}
}
