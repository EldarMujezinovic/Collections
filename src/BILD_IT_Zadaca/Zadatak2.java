package BILD_IT_Zadaca;
/*
 * Napisati program koji pita korisnika da unese neodređeni broj cijelih brojeva (0 prekida unos). Nakon što je korisnik unio brojeve, pitati korisnika da li želi: 

	da sortira brojeve? (sort)
	da promiješa brojeve? (shuffle)
	da sortira brojeve u silazećem redosljedu? (reverse sort)

Nakon svake izabrane opcije, ispisati brojeve na konzoli. Ne pohranjivati duplikate brojeva. 

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Zadatak2 {

	private static Scanner input;

	static ArrayList<Integer> numbers = new ArrayList<>();

	public static void main(String[] args) {
		

		input = new Scanner(System.in);
		System.out.println("Enter some Integers, zero stops input: ");
		Integer numInput = -1;

		while (numInput != 0) {
			numInput = input.nextInt();
			if (numInput != 0)
				numbers.add(numInput);

		}
		menu();

	}

	public static void menu() {
		System.out
				.println("Choose operation: \n1. Shuffle Numbers\n2. Sort Numbers\n3. Sort in reverse order\n4. Exit");
		int choice = input.nextInt();
		boolean valid = true;
		while (valid) {
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
				System.out.println("Wrong input!");
				System.out.println("Try again..");
				choice = input.nextInt();
			}
			valid = false;
		}
		switch (choice) {

		case 1:
			shuffleNumbers(numbers);
			menu();
			break;
		case 2:
			sortNumbers(numbers);
			menu();
			break;
		case 3:
			reverseOrder(numbers);
			menu();
			break;
		case 4:
			System.out.println("Goodbye!");
			System.exit(1);
			break;

		}
	}

	// random shuffle
	public static void shuffleNumbers(ArrayList<Integer> array) {
		Collections.shuffle(array);
		System.out.println(array);
	}

	// from min to max
	public static void sortNumbers(ArrayList<Integer> array) {
		SortedSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < array.size(); i++) {
			set.add(array.get(i));
		}

		System.out.println(set);
	}

	// from max to min
	public static void reverseOrder(ArrayList<Integer> array) {
		Collections.sort(array, Collections.reverseOrder());
		System.out.println(array);
	}

}
