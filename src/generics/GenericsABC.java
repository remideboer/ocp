package generics;

import java.util.*;

public class GenericsABC {
	public static void main(String[] args) {
		List<?> list1 = new ArrayList<A>();
		List<? extends A> list2 = new ArrayList<A>();
		List<? super B> list3 = new ArrayList<B>();
//		List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
		List<? super B> list5 = new ArrayList<A>();
//		List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE
		
		List<String> ss = new ArrayList<>();
		ss.add("hello");
		String s = method1(ss);
		
		list3.add(new B()); // als List<? extends B> dan kun je niet toevoegen
		B b = (B) method1(list3); // cast nodig omdat List<? super B> niet aangeeft wat voor type er daadwerkelijk inzit
	}

	static <T> T method1(List<? extends T> list) {
		return list.get(0);
	}
	
	<B extends A> B method3(List<B> list) {
		return new B(); // DOES NOT COMPILE evil, want formele parameter B heeft dezelfde naam als klasse B
	}
}

class A {
}

class B extends A {
}

class C extends B {
}