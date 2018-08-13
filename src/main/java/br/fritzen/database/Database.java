package br.fritzen.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static Database INSTANCE = null;
	
	private Connection connection = null;
	
	
	private Database() {
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite::resource:"
					 + TestDB.class.getResource("/res/sample.db"));
		} catch (SQLException e) {
			System.err.println("Houve um problema ao criar o arquivo do banco!");
			e.printStackTrace();
		}
		
	}
	
	
	public static Database getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new Database();
		}
		
		return INSTANCE;
		
	}
	
	
	public Connection getConnection() {
		return this.connection;
	}
	
	
	public void closeConnection() {
		
		try {
			this.connection.close();
		} catch (SQLException e) {
			System.err.println("Houve um erro ao fechar a conexão com banco!");
			e.printStackTrace();
		}
	}
}
