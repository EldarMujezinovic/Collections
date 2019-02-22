package BILD_IT_Zadaca;
/*
 * Napisati program koji pohranjuje 5 miliona cijelih brojeva u listu (ArrayListu, LinkedListu) te testira i ispisuje vrijeme potrebno da se prodje kroz listu i ispise svaki element na konzoli: 

	koristeći se get(index) metodom
	koristeći se foreach petljom / iteratorom. 

 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Zadatak4 {

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < 1E5; i++) {
			arrayList.add(i);
			linkedList.add(i);
		}
		
	//	doTimingWithGet("ArrayList", arrayList);
    //  doTimingWithGet("LinkedList", linkedList);
		
	//	doTimingForEach("ArrayList", arrayList);
	//	doTimingForEach("LinkedList", linkedList);
		
	//	doTimingWithIterator("ArrayList", arrayList);
	//	doTimingWithIterator("LinkedList", linkedList);


	}

	public static void doTimingWithGet(String type, List<Integer> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start) + " ms for: " + type);
	}

	public static void doTimingForEach(String type, List<Integer> list) {
		long start = System.currentTimeMillis();
		for (Integer a : list) {
			System.out.println(a);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start) + " ms for: " + type);

	}

	public static void doTimingWithIterator(String type, List<Integer> list) {
		Iterator<Integer> i = list.iterator();
		long start = System.currentTimeMillis();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start) + " ms for: " + type);

	}

}
