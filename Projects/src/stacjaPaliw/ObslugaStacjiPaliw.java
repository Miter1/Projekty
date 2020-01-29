package stacjaPaliw;

import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Scanner;



public class ObslugaStacjiPaliw {
	
	static int wKoncuZadziala (Scanner sc) {
		int odp = 0;
		boolean bool = true;
		do {
			if(sc.hasNextInt()) {
				odp = sc.nextInt();
				if(odp>7 || odp<0) {
					System.out.println("PODANO LICZBĘ Z NIEWŁAŚCIWEGO ZAKRESU. SPRÓBUJ PONOWNIE:");
				}
				else {
					bool = false;
				}
			}
			else {
				System.out.println("PODANO NIEWŁAŚCIWE DANE. PODAJ CYFRĘ:");
				sc.next();
			}
		}while(bool);
		return odp;
	}
	
	static void sprawdzacz(Scanner sc, int war, String paliwo, StacjaPaliw stacjaPaliw, int numer, BigDecimal bigDecimal) {
		if(numer == 3) {
			if(sc.hasNextInt()) {
				war = sc.nextInt();
				stacjaPaliw.dostawa(paliwo, war);
			}	
			else {
				System.out.println("Nie podano właściwej wartości.");
				sc.next();
				return;
			}
		}
		if(numer == 4 || numer == 5) {
			if (sc.hasNextBigDecimal()) {
				bigDecimal = sc.nextBigDecimal();
				if(numer == 4) {
					stacjaPaliw.ustawCene(paliwo, bigDecimal);
				}
				else {
					System.out.println("Tankowanie zakończone. należy się " + stacjaPaliw.tankuj(paliwo, bigDecimal) + " złotych.");
				}
			}
			else {
				System.out.println("Nie podano właściwej wartości.");
				sc.next();
				return;
			}
		}
		
		
	}
	
	static void decyzje(int odp, StacjaPaliw stacjaPaliw, Scanner sc) {
		
		Scanner scStr = new Scanner(System.in);
		String paliwo = null;
		int wartosc = 0;
		BigDecimal cena = null;
		BigDecimal ilePaliwa = null;
		
		while (true) {
			
		
			switch (odp) {
			case 1:
				System.out.println(stacjaPaliw.getIleMoznaZatankowac());
				break;
			case 2:
				System.out.println(stacjaPaliw.getMapa());
				break;
			case 3:
				System.out.print("Podaj nazwę paliwa:");
				paliwo = scStr.nextLine();
				System.out.print("Podaj wartość, jaką chcesz dodać:");
				sprawdzacz(sc, wartosc, paliwo, stacjaPaliw, 3, null);
				break;
			case 4:
				System.out.print("Podaj nazwę paliwa:");
				paliwo = scStr.nextLine();
				System.out.print("Podaj cenę, na jaką chcesz zmienić:");
				sprawdzacz(sc, 0, paliwo, stacjaPaliw, 4, cena);
				break;
			case 5:
				System.out.print("Podaj nazwę paliwa:");
				paliwo = scStr.nextLine();
				System.out.print("Podaj wartość, jaką chcesz zatankować:");
				sprawdzacz(sc, 0, paliwo, stacjaPaliw, 5, ilePaliwa);
//				System.out.println("Tankowanie zakończone. należy się " + stacjaPaliw.tankuj(paliwo, ilePaliwa) + " złotych.");
				break;
			case 6:
				menu();
				break;
			
			case 7:
				System.out.println("KONIEC PROGRAMU. DO WIDZENIA.");
				System.exit(0);
			default:
			
				break;
			}
			
			odp = wKoncuZadziala(sc);
			
		}
	}
	
	static void menu() {
		System.out.println("____________________________________________________________________");
		System.out.println("1: WARTOŚCI PALIW MOŻLIWE DO ZATANKOWANIA");
		System.out.println("2: AKUTALNE CENY PALIW");
		System.out.println("3: DOSTAWA PALIWA");
		System.out.println("4: USTAWIANIE CENY PALIWA");
		System.out.println("5: TANKOWANIE PALIWA");
		System.out.println("6: POKAŻ MENU");
		System.out.println("7: WYJŚCIE Z PROGRAMU");
		System.out.println("____________________________________________________________________");
	}
	
	public static void main(String[] args) {
		StacjaPaliw stacjaPaliw = new StacjaPaliw();
		

		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("WITAJ NA STACJI PALIW. WCIŚNIJ WYBRANY NUMER I NACIŚNIJ ENTER:");
		menu();
		int odp = wKoncuZadziala(sc);
		decyzje(odp, stacjaPaliw, sc);
	}		
}	
