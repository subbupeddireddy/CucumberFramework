package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

	public static Connection connect;

	public static void connect() throws Exception {

		String url = "jdbc:postgresql://10.10.10.94:5444/central_qc3";
		String userName = "enterprisedb";
		String pass = "Oracle123";
		connect = DriverManager.getConnection(url, userName, pass);

	}

	public static void executeQuery(String query) throws SQLException {

		Statement statement = connect.createStatement();
		ResultSet result = statement.executeQuery(query);

	}

}
