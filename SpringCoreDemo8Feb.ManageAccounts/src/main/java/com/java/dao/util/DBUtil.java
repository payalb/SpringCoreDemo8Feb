package com.java.dao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBUtil {
	
	static BasicDataSource connectionPool= new BasicDataSource();
	static Properties property= new Properties();
	static {
		try {
		property.load(DBUtil.class.getResourceAsStream("/database.properties"));
		connectionPool.setDriverClassName(property.getProperty("driverClassName"));
		connectionPool.setUrl(property.getProperty("url"));
		connectionPool.setUsername(property.getProperty("username"));
		connectionPool.setPassword(property.getProperty("password"));
		connectionPool.setMaxTotal(200);
		connectionPool.setMaxIdle(5);
		connectionPool.setMaxWaitMillis(2000);
		connectionPool.setDefaultAutoCommit(false);
		connectionPool.setDefaultQueryTimeout(2);
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() throws SQLException {
		return connectionPool.getConnection();
	}
/*
	static BlockingQueue<Connection> queue = new ArrayBlockingQueue<>(200);
	static {
		for (int i = 0; i < 200; i++) {
			Connection connection;
			try {
				connection = DriverManager.getConnection("postgresql://localhost:5432/postgres", "postgres",
						"postgres");
				connection.setAutoCommit(false);
				queue.add(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}*/

/*	public static Connection getConnection() throws ClassNotFoundException, SQLException, InterruptedException {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("postgresql://localhost:5432/postgres", "postgres",
				"postgres");
		connection.setAutoCommit(false);
		return connection;
		return queue.poll(2, TimeUnit.SECONDS);
	}
	*/

}
