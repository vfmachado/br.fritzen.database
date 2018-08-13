package br.fritzen.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDao {

	private Connection con;
	
	public PersonDao() {
		con = Database.getInstance().getConnection();
	}
	
	public void insert(Person person) throws SQLException {
		
		Statement stat = con.createStatement();
		stat.executeUpdate("insert into person values(" + person.getId() + ", '" + person.getName() + "')");
		stat.close();
	}
	
}
