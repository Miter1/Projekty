package graTekstowa;

import java.util.Scanner;
public class ObslugaGry {
	
	public static void main(String[] args) {
		Lodka lodka = new Lodka();
		System.out.println("WITAMY W GRZE. WYBIERZ ODPOWIEDNI NUMER I WCIŚNIJ ENTER.");
		menu();
		Scanner sc = new Scanner(System.in);
		int odp = wKoncuZadziala(sc, 1, 6);
		opcje(odp, sc, lodka);
	}
	
	static void menu() {
		System.out.println("___________________________________");
		System.out.println("1: AKTUALNE POŁOŻENIE OBIEKTÓW I ŁÓDKI");
		System.out.println("2: WEŹ OBIEKT DO ŁÓDKI");
		System.out.println("3: WYRZUĆ OBIEKT Z ŁÓDKI");
		System.out.println("4: PŁYŃ NA DRUGĄ STRONĘ");
		System.out.println("5: POKAŻ MENU");
		System.out.println("6: WYJDŹ Z GRY");
		System.out.println("__________________________________");
		System.out.println();
		
	}
	
	static void opcje(int odp, Scanner sc, Lodka lodka) {
		Scanner scStr = new Scanner(System.in);
		String obiekt = null;
		while (true) {
			
			switch(odp) {
			case 1:
				polozenieObiektow();
				lodka.polozenieLodki();
				break;
			case 2:
				if(lodka.getCzyJestPusta()==false) {
					System.out.println("Jest już inny obiekt w łódce!");
					break;
				}
				System.out.println("Podaj obiekt, które chcesz wziąć do łódki:");
				obiekt = scStr.nextLine().trim().toLowerCase();
				for(Obiekty o: Obiekty.values()) {
					if(o.nazwaObiektu.equals(obiekt) && o.polozenieObiektu==lodka.getPolozenieLodki()) {
						o.polozenieObiektu = 0;
						lodka.setCzyJestPusta(false);
					}
				}
				if(lodka.getCzyJestPusta()==true)
					System.out.println("Takiego obiektu nie ma w tej grze!");
				else
					System.out.println("Obiekt został wrzucony na łódkę.");
				break;
			case 3:
				if(lodka.getCzyJestPusta()==true) {
					System.out.println("Łódka jest pusta, nie można nic z niej wyrzucić!"); 
					break;
				}
				else {
					for(Obiekty o: Obiekty.values()) {
						if(o.polozenieObiektu==0 && lodka.getPolozenieLodki()==1) {
							o.polozenieObiektu=1; 
							lodka.setCzyJestPusta(true);
						}
						if(o.polozenieObiektu==0 && lodka.getPolozenieLodki()==-1){
							o.polozenieObiektu=-1;
							lodka.setCzyJestPusta(true);
						}
						
					}
					System.out.println("Obiekt został wyrzucony z łódki.");
				}
				sprawdzacz(lodka);
				break;
			case 4:
				lodka.plyniecieLodki();
				sprawdzacz(lodka);
				break;
			case 5:
				menu();
				break;
			case 6:
				System.out.println("DZIĘKUJĘ ZA GRĘ.");
				System.exit(0);
			}
//			System.out.println(Obiekty.WILK.polozenieObiektu);
//			System.out.println(Obiekty.KOZA.polozenieObiektu);
//			System.out.println(Obiekty.KAPUSTA.polozenieObiektu);
//			System.out.println(lodka.getPolozenieLodki());
			odp = wKoncuZadziala(sc, 1, 6);
			odp = sc.nextInt();
			opcje(odp, sc, lodka);
		}
	}
	
	static void polozenieObiektow() {
		for(Obiekty o: Obiekty.values()) {
			if(o.polozenieObiektu==-1) System.out.println(o.nazwaObiektu + " znajduje się na wyspie po lewo");
			else if(o.polozenieObiektu==1) System.out.println(o.nazwaObiektu + " znajduje się na wyspie po prawo.");
			else System.out.println(o.nazwaObiektu + " znajduje się w łódce.");
		}
	}
	
	static void sprawdzacz(Lodka lodka) {
		int bool = sprawdzanieWarunkow(lodka);
		if(bool == -1) {
			System.out.println("KONIEC GRY. CZY CHCESZ ZAGRAĆ JESZCZE RAZ? (0-nie, 1-tak)");
			menuPoKoncuGry(lodka);
		}
		if(bool == 1) {
			System.out.println("GRATULACJE, WYGRAŁEŚ/WYGRAŁAŚ!. CZY CHCESZ ZAGRAĆ JESZCZE RAZ? (0-nie, 1-tak)");
			menuPoKoncuGry(lodka);
		}
	}
	
	static void resetElementow(Lodka lodka) {
		Obiekty.KOZA.polozenieObiektu=-1;
		Obiekty.WILK.polozenieObiektu=-1;
		Obiekty.KAPUSTA.polozenieObiektu=-1;
		lodka.setPolozenieLodki(-1);
		lodka.setCzyJestPusta(true);
	}
	
	static int sprawdzanieWarunkow(Lodka lodka){
		if(Obiekty.KOZA.polozenieObiektu==Obiekty.WILK.polozenieObiektu && lodka.getPolozenieLodki()!=Obiekty.WILK.polozenieObiektu
				|| Obiekty.KOZA.polozenieObiektu==Obiekty.KAPUSTA.polozenieObiektu && lodka.getPolozenieLodki()!=Obiekty.KOZA.polozenieObiektu) {
			return -1;
		}
		if(Obiekty.KOZA.polozenieObiektu==1 && Obiekty.WILK.polozenieObiektu==1 && Obiekty.KAPUSTA.polozenieObiektu==1)
			return 1;
		
		return 0;
	}
	
	static void menuPoKoncuGry(Lodka lodka) {
		
		Scanner sc = new Scanner(System.in);
		int odp = wKoncuZadziala(sc, 0, 1);
		if(odp == 0) System.exit(0);
		else {
			menu();
			resetElementow(lodka);
		}
	}
	static int wKoncuZadziala (Scanner sc, int dolnaGranica, int gornaGranica) {
		int odp = 0;
		boolean bool = true;
		do {
			if(sc.hasNextInt()) {
				odp = sc.nextInt();
				if(odp>gornaGranica || odp<dolnaGranica) {
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
}
