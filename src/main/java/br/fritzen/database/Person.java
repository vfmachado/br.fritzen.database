package br.fritzen.database;

public class Person {

	private int id;
	
	private String name;
	
	
	public Person() {
	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "ID: " + id + "\tName: " + name;
	}
}
