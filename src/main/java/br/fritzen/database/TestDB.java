package br.fritzen.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TestDB {

	public static void main(String[] args) throws IOException {
		
		Connection con = null;
		try {
			
			con = Database.getInstance().getConnection();
			
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
//
//			String sql = FileUtils.loadTextFile("src/main/java/res/descricao.sql");
//			System.out.println(sql);
//			statement.executeUpdate(sql);
			
//			statement.executeUpdate("drop table if exists person");
//			statement.executeUpdate("create table person (id integer, name string)");
//			statement.executeUpdate("insert into person values(1, 'leo')");
//			statement.executeUpdate("insert into person values(2, 'yui')");
			
//			Person p = new Person();
//			p.setId(7);
//			p.setName("Vinícius");
//			
//			//data access object
//			PersonDao dao = new PersonDao();
//			dao.insert(p);
			
			ResultSet rs = statement.executeQuery("select * from person");
			while (rs.next()) {
				// read the result set
				System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
			}
			JOptionPane.showMessageDialog(null, "ALL FINE!!!");
		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e);
			}
		}
	}

}