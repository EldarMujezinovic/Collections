package BILD_IT_Zadaca;
/*
 * Napisati program koji pita korisnika da proslijedi ime filea. Nakon što je korisnik proslijedio ime filea, program treba da: 

	ispiše broj unikatnih riječi u fileu
	ukupan broj riječi u fileu
	broj samoglasnika u fileu
	broj suglasnik u fileu

 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Zadatak5 {

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
		printVowels(path);
		numberOfWords(path);

	}

	public static void uniqueWords(Path path) throws IOException {
		Set<String> set = new HashSet<>();
		BufferedReader br = Files.newBufferedReader(path);
		String line;
		while ((line = br.readLine()) != null) {
			set.add(line);
		}

		System.out.println(set);

	}
	
	public static void numberOfWords(Path path) throws IOException{
		ArrayList<String> list = new ArrayList<>();
		int counter = 0;
		BufferedReader br = Files.newBufferedReader(path);
		String line;
		while ((line = br.readLine()) != null) {
			list.add(line);
			if(!line.isEmpty())
			counter++;
			
		}
		
		System.out.println("Number of words: " + counter);
	}
	
	public static void printVowels(Path path) throws IOException{
	ArrayList<String> list = new ArrayList<>();
	BufferedReader br = Files.newBufferedReader(path);
	String line;
	int vowels = 0;
	int consonants = 0;
	while((line = br.readLine()) != null){
		list.add(line);
		for(int i = 0; i < line.length(); i++){
			if
			(line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u' ||
			line.charAt(i) == 'A' || line.charAt(i) == 'E' || line.charAt(i) == 'I' || line.charAt(i) == 'O' || line.charAt(i) == 'U')
			{
				vowels++;
			}
			else if(Character.isAlphabetic(line.charAt(i)))
			{
				consonants++;
			}
		}
	}
	
	System.out.println("Number of vowels: " + vowels);
	System.out.println("Number of consonants: " + consonants);

	}

}
