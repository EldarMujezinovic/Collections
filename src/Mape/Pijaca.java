package Mape;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pijaca {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Map<String, Integer> cijene = new HashMap<>();
		cijene.put("Riba", 10); cijene.put("Pasteta", 90); cijene.put("Mrkva", 30);
		cijene.put("Losos", 40); cijene.put("Kivi", 50); cijene.put("Analgin", null); 
		
		System.out.println("Unesite naziv da biste dobili cijenu proizvoda: ");
		String naziv = input.nextLine();
		Integer cijena = cijene.get(naziv);
		
		if(cijena == null){
			System.out.println("Ne postoji cijena za taj proizvod..");
		}else{
		System.out.println("Cijena za: " + naziv + " je: " + cijena);
		}
		
		System.out.println(cijene);
	}

}
