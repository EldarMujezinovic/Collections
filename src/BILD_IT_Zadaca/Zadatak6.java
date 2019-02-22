package BILD_IT_Zadaca;

import java.io.BufferedReader;
import java.io.IOException;
/*
 * Napisati program koji pita korisnika da proslijed ime filea. Nakon što je korisnik proslijedio ime filea, program pita korisnika da unese neku riječ. Nakon unešene riječi, program treba da: 

	ispiše koliko puta se data riječ pojavljuje u fileu
	poziciju u tekstu na kojoj se riječ pojavljuje (broj reda, poziciju riječi u datom redu)

 */
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak6 {

	private static Scanner input;

	public static void main(String[] args) throws IOException {

		input = new Scanner(System.in);
		System.out.println("Enter the name of the file: ");
		String fileName = input.nextLine();
		Path path = Paths.get(fileName);
		if (!Files.exists(path)) {
			System.out.println(fileName + " does not exist..");
			System.exit(1);
		}

		System.out.println("Input word: ");
		String word = input.next();
		wordCounter(word, path);
		wordPosition(word, path);
	}

	public static void wordCounter(String word, Path path) throws IOException {
		ArrayList<String> list = new ArrayList<>();
		BufferedReader br = Files.newBufferedReader(path);
		String line;
		int counter = 0;
		while ((line = br.readLine()) != null) {
			list.add(line);
			if (word.equals(line)) {
				counter++;
			}
		}
		if (!list.contains(word)) {
			System.out.println("Word doesn't exist..");
		} else {
			System.out.println("Word: " + word + " shows up: " + counter + " times.");
		}

	}

	public static void wordPosition(String word, Path path) throws IOException {
		ArrayList<String> list = new ArrayList<>();
		BufferedReader br = Files.newBufferedReader(path);
		String line;
		int wordRow = 0;
		while ((line = br.readLine()) != null) {
			list.add(line);
		}
		for (int i = 0; i < list.size(); i++) {
			if (word.equals(list.get(i))) {
				wordRow = i;
			}
		}
		if (!list.contains(word)) {
			System.out.println("Word doesn't exist in file..");
		} else {
			System.out.println("Row of word is: " + wordRow);
		}
	}

}
