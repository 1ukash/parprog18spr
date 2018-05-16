package ru.spbstu.telematics.parprog.l2;

public interface MyCollectionInterface<T> {
/*
 * size
contains
add (put для map по ключу)
remove (для map по ключу)
get (для map по ключу)
 * 
 */
	
	int size();
	boolean contains(T t);
	void add(T t);
	void remove(T t);
	
}
