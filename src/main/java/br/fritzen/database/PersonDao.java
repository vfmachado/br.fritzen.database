package br.fritzen.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DATA ACCESS OBJECT
public class PersonDao {

	private Connection con;
	
	public PersonDao() {
		con = Database.getInstance().getConnection();
	}
	
	
	public void insert(Person person) throws SQLException {
		
		//Statement stat = con.createStatement();
		//stat.executeUpdate("insert into person values(" + person.getId() + ", '" + person.getName() + "')");
		
		PreparedStatement stat = con.prepareStatement(
				"insert into person values(?, ?)");
		
		stat.setInt(1, person.getId());
		stat.setString(2, person.getName());
		
		stat.execute();
		
		stat.close();
	}
	
	
	public void delete(int id) throws SQLException {
		Statement stat = con.createStatement();
		stat.executeUpdate("delete from person where person.id = " + id);
		stat.close();
	}
	
	
	public List<Person> getAll() throws SQLException {
		List<Person> pessoas = new ArrayList<Person>();
		
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select * from person");
		
		while (rs.next()) {
			// read the result set
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			pessoas.add(p);
		}
		
		return pessoas;
	}
	
	
	public Person getById(int id) throws SQLException {
		
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select * from person where person.id = " + id);
		
		if (rs.next()) {
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			return p;
		}
		
		stat.close();
		return null;
		
	}
	
	
	public void update(Person p, int id) throws SQLException {
		
		Statement stat = con.createStatement();
		/*
		 *  UPDATE table
			SET column_1 = new_value_1,
			    column_2 = new_value_2
			WHERE
			    search_condition
		 */
		stat.executeUpdate("update person set name = '" + p.getName() + "' " + 
								", id = " + p.getId() + " where person.id = " + id);
		
		stat.close();
	}
}
