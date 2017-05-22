package com.stackoverflow.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConectionJDBC {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/databasename";
	static final String USER = "username";
	static final String PASSWORD = "password";

	public static void main(String[] args) {

	}

	private List<String> getListOfUsers(Long id) {
		List<String> namesFromUsers = new ArrayList<String>();
		String sql = "SELECT name FROM Users Where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = executeQuery(sql, params);
		try {
			while (rs.next()) {
				String name = rs.getString("name");
				namesFromUsers.add(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return namesFromUsers;
	}

	private ResultSet executeQuery(String sql, List<Object> params) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			for (int x = 0; x < params.size(); x++) {
				preparedStatement.setObject(x, params.get(x));
			}
			resultSet = statement.executeQuery(sql);
			statement.close();
			connection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultSet;
	}
}