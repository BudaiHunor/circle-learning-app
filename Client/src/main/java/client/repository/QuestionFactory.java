package client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import client.model.Question;

public class QuestionFactory {
	public static List<Question> allQuestions() {
		ArrayList<Question> list = new ArrayList<Question>();

		String query = "select * from questions;";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();

			for (; result.next();) {
				int id = result.getInt(1);
				String q = result.getString(2);
				String a1 = result.getString(3);
				String a2 = result.getString(4);
				String a3 = result.getString(5);
				boolean c1 = result.getBoolean(6);
				boolean c2 = result.getBoolean(7);
				boolean c3 = result.getBoolean(8);
				list.add(Question.newInstance(id, q, a1, a2, a3, c1, c2, c3));
			}
			return list;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			ConnectionFactory.close(result);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	public static boolean createQuestion(String question, String answer1, String answer2, String answer3,
			boolean correct1, boolean correct2, boolean correct3) {
		if (question == null || answer1 == null || answer2 == null || answer3 == null) {
			return false;
		}

		String query = "insert into questions(question, answer1, answer2, answer3, correct1, correct2, correct3) values(";
		query += "\"" + question + "\",";
		query += "\"" + answer1 + "\",";
		query += "\"" + answer2 + "\",";
		query += "\"" + answer3 + "\",";
		query += (correct1 ? "true" : "false") + ",";
		query += (correct2 ? "true" : "false") + ",";
		query += (correct3 ? "true" : "false") + ");";

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

	public static Question readQuestion(int id) {
		String query = "select * from questions where id = " + id + ";";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();

			if (result.next()) {
				String q = result.getString(2);
				String a1 = result.getString(3);
				String a2 = result.getString(4);
				String a3 = result.getString(5);
				boolean c1 = result.getBoolean(6);
				boolean c2 = result.getBoolean(7);
				boolean c3 = result.getBoolean(8);
				return Question.newInstance(id, q, a1, a2, a3, c1, c2, c3);
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

	public static boolean updateQuestion(int id, String columnName, String value) {
		if (columnName == null || value == null) {
			return false;
		}

		String query = "update questions set " + columnName + " = \"" + value + "\" where id = " + id + ";";

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

	public static boolean updateQuestion(int id, String columnName, boolean value) {
		if (columnName == null) {
			return false;
		}

		String query = "update questions set " + columnName + " = " + (value ? "true" : "false") + " where id = " + id
				+ ";";

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

	public static boolean deleteQuestion(int id) {
		String query = "delete from questions where id = " + id + ";";

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
