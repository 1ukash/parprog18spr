package ru.spbstu.telematics.parprog.l1;

public class Foo {

	private String name;
	private int id;
	
	public int globalNumber;
	
	public Foo() {
		super();
	}
	
	public Foo(String name, int id) {
		super();
		this.name = name;
		this.id = id;
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
}
