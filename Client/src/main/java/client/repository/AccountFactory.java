package client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import client.model.Account;
import client.model.UserType;

public class AccountFactory {
	public static List<Account> allAccounts() {
		ArrayList<Account> list = new ArrayList<Account>();

		String query = "select * from accounts;";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();

			for (; result.next();) {
				int id = result.getInt(1);
				String username = result.getString(2);
				String password = result.getString(3);
				String email = result.getString(4);
				UserType type = result.getBoolean(5) ? UserType.ADMIN : UserType.USER;
				list.add(Account.newInstance(id, username, password, email, type));
			}
			return list;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			ConnectionFactory.close(result);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	public static boolean createAccount(String username, String password, String email, UserType type) {
		if (username == null || password == null || email == null || type == null) {
			return false;
		}

		String query = "insert into accounts(username, password, email, isAdmin) values(";
		query += "\"" + username + "\",";
		query += "\"" + password + "\",";
		query += "\"" + email + "\",";
		query += (type.equals(UserType.ADMIN) ? "true" : "false") + ");";

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	public static Account readAccount(int id) {
		String query = "select * from accounts where id = " + id + ";";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();

			if (result.next()) {
				String username = result.getString(2);
				String password = result.getString(3);
				String email = result.getString(4);
				UserType type = result.getBoolean(5) ? UserType.ADMIN : UserType.USER;
				return Account.newInstance(id, username, password, email, type);
			}
			return null;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			ConnectionFactory.close(result);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	private enum LogInType {
		USERNAME {
			@Override
			public String toString() {
				return "username";
			}
		},
		EMAIL {
			@Override
			public String toString() {
				return "email";
			}
		};
	}

	private static Account readAccount(String identifier, String password, LogInType identifierType) {
		String query = "select * from accounts where " + identifierType.toString() + " = \"" + identifier
				+ "\" and password = \"" + password + "\";";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();

			if (result.next()) {
				int id = result.getInt(1);
				String username = result.getString(2);
				String email = result.getString(4);
				UserType type = result.getBoolean(5) ? UserType.ADMIN : UserType.USER;
				return Account.newInstance(id, username, password, email, type);
			}
			return null;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			ConnectionFactory.close(result);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	public static Account readAccountByUsername(String idendifier, String password) {
		return AccountFactory.readAccount(idendifier, password, LogInType.USERNAME);
	}

	public static Account readAccountByEmail(String idendifier, String password) {
		return AccountFactory.readAccount(idendifier, password, LogInType.EMAIL);
	}

	public static boolean updateAccount(int id, String columnName, String value) {
		if (columnName == null || value == null) {
			return false;
		}

		String query = "update accounts set " + columnName + " = \"" + value + "\" where id = " + id + ";";

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	public static boolean updateAccount(int id, String columnName, UserType type) {
		if (columnName == null || type == null) {
			return false;
		}

		String query = "update accounts set " + columnName + " = " + (type.equals(UserType.ADMIN) ? "true" : "false")
				+ " where id = " + id + ";";

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	public static boolean deleteAccount(int id) {
		String query = "delete from accounts where id = " + id + ";";

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
