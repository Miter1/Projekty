package faktura;

public class ObslugaFaktury {

	public static void main(String[] args) {
		Faktura faktura1 = new Faktura("1234/2019");
//		Faktura faktura2 = new Faktura("111/2019");
//		Faktura faktura3 = new Faktura("15/2019");
		
		faktura1.dodajPozycje("Pralka automatyczna", 2, 1200, 23);
		faktura1.dodajPozycje("Ananas", 200, 3.4, 15);
		faktura1.dodajPozycje("Dom na piasku", 1, 300, 5);
//		System.out.println(faktura1.getMapa());
//		System.out.println(faktura1.wartoscPozycji(1));
//		System.out.println(faktura1.doZaplaty());
//		System.out.println("________________________________");
		faktura1.wydrukuj();
	}

}
