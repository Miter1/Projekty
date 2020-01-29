package faktura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Faktura {
	private String nazwa;
	private int numer;
	static private HashMap<String, List<List<Object>>> mapa = new HashMap<>();
	private List<List<Object>> listaList = new ArrayList<>();
	
	public List<List<Object>> getListaList() {
		return listaList;
	}

	public void setListaList(List<List<Object>> listaList) {
		this.listaList = listaList;
	}

	public HashMap<String, List<List<Object>>> getMapa() {
		mapa.put(nazwa, listaList);
		return mapa;
	}

	public Faktura(String nazwa) {
		this.nazwa = nazwa;
		numer = mapa.size();
	}
	
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}


	public int getNumer() {
		return numer;
	}

	public void setNumer(int numer) {
		this.numer = numer;
	}

	void dodajPozycje(String nazwab, int ilosc, double cenaNetto, double stawkaVat) {
		List <Object> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(nazwab,ilosc,cenaNetto,stawkaVat));
		listaList.add(lista);
		mapa.replace(nazwa, listaList);
	}
	
	
	int IloscPozycji() {
		int licznik = 0;
		for(List<Object> lista : listaList) {
			licznik++;
		}
		
		
		return licznik;
		
	}
	double wartoscPozycji(int numerPozycji) {
		
		List<Object> lista = listaList.get(numerPozycji);
		int il = (int) lista.get(1);
		double cena = (double) lista.get(2);
		double vat = (double) lista.get(3);
		double wynik = il*cena + il*cena*(vat/100);
		return wynik;
		//albo listy.get, bez robienia obiektów
	}
	double doZaplaty() {
		double sumaCalosc=0;
		for(int i = 0; i<listaList.size(); i++) {
			sumaCalosc += wartoscPozycji(i);
		}
		
		return sumaCalosc;
	}
	void wydrukuj() {
		System.out.println("numer faktury: " + nazwa);
		for(int i=0 ; i<listaList.size(); i++) {
			System.out.println("Numer pozycji: " + (i+1));
			List<Object> listaTemp = listaList.get(i);
			System.out.println("Nazwa: " + listaTemp.get(0));
			System.out.println("Cena netto: " + listaTemp.get(2));
			System.out.println("Stawka VAT: " + listaTemp.get(3) + "%");
			System.out.println("Wartość netto: " + (int) listaTemp.get(1) * (double) listaTemp.get(2));
			System.out.println("Wartość brutto: " + wartoscPozycji(i));
			System.out.println("____________________________________________________");
		}
		System.out.println("W sumie do zapłaty: " + doZaplaty());
	}
	
}