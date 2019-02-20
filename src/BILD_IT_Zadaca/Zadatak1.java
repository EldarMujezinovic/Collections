package BILD_IT_Zadaca;
/*
 * Napisati program koji čita riječi iz tekstualnog filea te ispisuje iste te riječi u rastućem abecednom redu. Program treba da pita korisnika da unese ime filea, te: 


	da li korisnik želi da ispiše sve riječi, uključujući duplikate.
	da li korisnik želi da ispiše samo unikatne riječi, ne uključujući duplikate. 

 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Zadatak1 {

	private static Scanner input;

	public static void main(String[] args) throws IOException {
		input = new Scanner(System.in);
		boolean valid = true;
		System.out.println("Enter the name of the file: ");
		String fileName = input.nextLine();
		Path path = Paths.get(fileName); // name of the file that you have
											// created on your pc..
		if (!Files.exists(path)) {
			System.out.println(fileName + " does not exist..");
			System.exit(1);

		}

		System.out.println(
				"If you want to see all words from file, enter \"1\", if you want without duplicates, enter \"2\": ");
		int num = 0;
		try {
			num = input.nextInt();

			while (num != 1 && num != 2) {
				System.out.println("Wrong input, try again!");
				num = input.nextInt();
			}

		} catch (InputMismatchException e) {
			System.out.println("Wrong input, you need to enter an Integer..");

		}

		switch (num) {
		case 1:
			writeAll(path);
			break;
		case 2:
			writeWithoutDuplicates(path);
			break;

		}

	}

	public static void writeAll(Path path) throws IOException {
		ArrayList<String> array = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(path)) {
			String line;
			while ((line = br.readLine()) != null) {
				array.add(line);
			}
		} catch (IOException e) {
			System.out.println("File not found!");
		}
		Collections.sort(array);
		System.out.println(array);

	}

	public static void writeWithoutDuplicates(Path path) throws IOException {
		Set<String> set = new TreeSet<>();

		try (BufferedReader br = Files.newBufferedReader(path)) {
			String line;
			while ((line = br.readLine()) != null) {
				set.add(line);
			}

		} catch (IOException e) {
			System.out.println("File not found!");
		}
		System.out.println(set);
	}

}
