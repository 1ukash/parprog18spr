package ru.spbstu.telematics.parprog.l1;

import java.util.ArrayList;

public class HelloWorld {
	
	public static void main(String[] args) {
		System.out.println("Hello world!");
		
				
		System.out.println("ItIsAClassWithALongName is conforming upper case camel notation");
		System.out.println("methodWithALongName is conforming downcase camel notation");
		
		ArrayList<String> l = new ArrayList<>();
		
		Foo f = new Foo("John Smith", 10);
		Foo d = new Foo("Ivan Fomin", 11);
		
		
		f.globalNumber = 101;
		f.setId(100);
		
		for (int i = 0; i < 100; i ++) {
			f.setId(f.getId() + 1);
		}
		
		if (f.getId() > d.getId()) {
			System.out.println("f greater than d");
		} else {
			System.out.println("f lower than d");
		}
		
		if (f.getId() > 100 ) {
			System.out.println("Awesome");
		} else {
			System.out.println("Not so good");
		}
		System.out.println(f.getId() + " " + f.getName());
		
		System.out.println(f.getId() + " is a result of operation");
		
//		java.util.LinkedList<String>
	}
	
}
