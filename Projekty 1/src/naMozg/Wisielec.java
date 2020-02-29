package naMozg;

import java.util.Scanner;

public class Wisielec {
	//Można jeszcze dodać animacje ruchu po błędnym odgadnięciu
	public static void main(String[] args) {
		boolean slowoNieodgadniete = true;
		System.out.println("Gracz 1 podaje słowo dla gracza 2 do odgadnięcia:");
		Scanner sc = new Scanner(System.in);
		String slowo = sc.nextLine();
		StringBuilder slowoOdgadywane = new StringBuilder("");
		for(int i = 1; i<20; i++) {
			System.out.println();
		}
		for(int i=0; i<slowo.length(); i++) {
			if(slowo.charAt(i)!=' ') {
				System.out.print("_ ");
				slowoOdgadywane.append("_");
			}
			else {
				System.out.print(" ");
				slowoOdgadywane.append(" ");
			}
			
		}
		
		
		while(slowoNieodgadniete) {
			
		
			System.out.println("Gracz 2 podaje literę:");
			
			char litera = sc.next().charAt(0);
			for(int i=0; i<slowo.length(); i++) {
				
				if(slowo.charAt(i)==Character.toLowerCase(litera)) {
					slowoOdgadywane.setCharAt(i, litera);
				}
				
				
			}
			for(int i = 0; i<slowo.length(); i++) {
				if(slowo.charAt(i)!=' ') {
					System.out.print(slowoOdgadywane.charAt(i) + " ");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
			System.out.println(slowoOdgadywane);
			slowoNieodgadniete = sprawdzacz(slowoOdgadywane);
		}	
		System.out.println("Dziękuję za zagranie w moją grę!");
	}
	static boolean sprawdzacz(StringBuilder slowo) {
		for (int i = 0; i<slowo.length(); i++) {
			if(slowo.charAt(i)=='_') {
				return true;
			}
		}
		return false;
	}

}
