package com.qaqrz.onlinexam.util;

import java.io.*;
import java.sql.*;
import java.util.*;
import org.apache.commons.dbcp2.BasicDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBDataSource {
	public static String driverClassName;
	public static String url;
	public static String username;
	public static String password;
	public static int minPoolSize;
	public static int maxPoolSize;
	public static int initialSize;
	public static int minIdle;
	public static int maxIdle;
	public static int maxWaitMillis;
	public static int maxTotal;

	private static BasicDataSource bDataSource = null;
	private static ComboPooledDataSource cpDataSource = null;

	static {
		try {
			Properties config = new Properties();
			config.load(new FileReader(DBDataSource.class.getClassLoader().getResource("db.properties").getPath()));
			driverClassName = config.getProperty("driverClassName");
			url = config.getProperty("url");
			username = config.getProperty("username");
			password = config.getProperty("password");
			minPoolSize = Integer.parseInt(config.getProperty("minPoolSize"));
			maxPoolSize = Integer.parseInt(config.getProperty("maxPoolSize"));
			initialSize = Integer.parseInt(config.getProperty("initialSize"));
			minIdle = Integer.parseInt(config.getProperty("minIdle"));
			maxIdle = Integer.parseInt(config.getProperty("maxIdle"));
			maxWaitMillis = Integer.parseInt(config.getProperty("maxWaitMillis"));
			maxTotal = Integer.parseInt(config.getProperty("maxTotal"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void c3p0DataSource() throws Exception {
		cpDataSource = new ComboPooledDataSource();
		cpDataSource.setDriverClass(driverClassName);
		cpDataSource.setJdbcUrl(url);
		cpDataSource.setUser(username);
		cpDataSource.setPassword(password);
		cpDataSource.setMinPoolSize(minPoolSize);
		cpDataSource.setMaxPoolSize(maxPoolSize);
	}

	public static void dbcpDataSource() {
		bDataSource = new BasicDataSource();
		bDataSource.setDriverClassName(driverClassName);
		bDataSource.setUrl(url);
		bDataSource.setUsername(username);
		bDataSource.setPassword(password);
		bDataSource.setInitialSize(initialSize);
		bDataSource.setMinIdle(minIdle);
		bDataSource.setMaxIdle(maxIdle);
		bDataSource.setMaxWaitMillis(maxWaitMillis);
		bDataSource.setMaxTotal(maxTotal);
	}

	public static Connection getConnectionJdbc() throws Exception {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection getConnectionC3p0() throws Exception {
		if (cpDataSource == null) {
			c3p0DataSource();
		}
		Connection conn = null;
		if (cpDataSource != null) {
			conn = cpDataSource.getConnection();
		}
		return conn;
	}

	public static Connection getConnectionDbcp() throws SQLException {
		if (bDataSource == null) {
			dbcpDataSource();
		}
		Connection conn = null;
		if (bDataSource != null) {
			conn = bDataSource.getConnection();
		}
		return conn;
	}
}