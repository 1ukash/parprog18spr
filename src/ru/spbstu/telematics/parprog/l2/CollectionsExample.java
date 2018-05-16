package ru.spbstu.telematics.parprog.l2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsExample {
	
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		
		l.add("first");
		l.add("second");
		l.add("third");
		l.add("first");
		
		for (String s: l) {
			System.out.println(s);
		}
		
		Set<String> s = new HashSet<>();
		s.add("1");
		s.add("2");
		s.add("2");
		
		for(String s2: s) {
			System.out.println(s2);
		}
		
	}

}
