package BILD_IT_Zadaca;
/*
 * Napisati program koji pita korisnika da unose neodređeni broj cijelih brojeva (0 prekida unos). Nakon što korisnik unese cijele brojeve, program treba da pita korisnika:

	da li želi da ispiše zbir svih unesenih brojeva? 
	da li želi da ispiše prosjek svih unesenih brojeva? 
	da li želi da ispiše zbir svih: 
	parnih brojeva?
	neparnih brojeva?
	brojeva na parnim pozicijama?
	brojeva na neparnim pozicijama?
	da li želi da ispiše sve unikatne brojeve?
	da li želi da ispiše sve brojeve koji se ponavljaju više od jednom? 

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Zadatak3 {

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
		System.out.print("Choose operation: \n1. Sum of all numbers\n2. Average of all numbers\n3. Sum of all even numbers");
		System.out.print("\n4. Sum of all odd numbers\n5. Sum of all numbers on even positions\n6. Sum of all numbers on odd positions");
		System.out.print("\n7. Print unique numbers\n8. Print repeating numbers\n9. Exit!");
						
		int choice = input.nextInt();
		boolean valid = true;
		while (valid) {
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7 && choice != 8 && choice != 9) {
				System.out.println("Wrong input!");
				System.out.println("Try again..");
				choice = input.nextInt();
			}
			valid = false;
		}
		switch(choice){
		
		case 1:
			System.out.println("Sum: " + sumOfAllNumbers(numbers));
			menu();
			break;
		case 2:
			System.out.println("Average: " + averageOfAllNumbers(numbers));
			menu();
			break;
		case 3:
			System.out.println("Sum: " + sumOfAllEvenNumbers(numbers));
			menu();
			break;
		case 4:
			System.out.println("Sum: " + sumOfAllOddNumbers(numbers));
			menu();
			break;
		case 5:
			System.out.println("Sum: " + sumOfAllNumbersOnEvenPositions(numbers));
			menu();
			break;
		case 6:
			System.out.println("Sum: " + sumOfAllNumbersOnOddPositions(numbers));
			menu();
			break;
		case 7:
			printWithoutDuplicates(numbers);
			menu();
			break;
		case 8:
			printRepeatingNumbers(numbers);
			menu();
			break;
		case 9: 
			System.out.println("Goodbye!");
			System.exit(1);
			
		}
		
		
		}

	public static int sumOfAllNumbers(ArrayList<Integer> list) {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}

		return sum;
	}

	public static double averageOfAllNumbers(ArrayList<Integer> list) {
		int sum = 0;
		int numbers = 0;
		double average = 0;

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			numbers++;
		}

		average = sum / numbers;
		return average;

	}

	public static int sumOfAllEvenNumbers(ArrayList<Integer> list) {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0)
				sum += list.get(i);
		}

		return sum;
	}

	public static int sumOfAllOddNumbers(ArrayList<Integer> list) {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 != 0)
				sum += list.get(i);
		}

		return sum;
	}

	public static int sumOfAllNumbersOnEvenPositions(ArrayList<Integer> list) {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 0)
				sum += list.get(i);
		}

		return sum;
	}

	public static int sumOfAllNumbersOnOddPositions(ArrayList<Integer> list) {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			if (i % 2 != 0)
				sum += list.get(i);
		}

		return sum;
	}

	public static void printWithoutDuplicates(ArrayList<Integer> list) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			set.add(list.get(i));
		}
		System.out.println("Unique numbers are: ");
		System.out.println(set);
	}

	public static void printRepeatingNumbers(ArrayList<Integer> list) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			if (Collections.frequency(list, list.get(i)) > 1) {			
				set.add(list.get(i));
			}
		}
		System.out.println("Repeating numbers are: ");
		System.out.println(set);
	}

}
