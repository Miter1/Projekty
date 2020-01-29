package stacjaPaliw;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class StacjaPaliw {
	
	private Map <String, BigDecimal> mapa = new HashMap<>(); 
	private Map <String, Integer> ileMoznaZatankowac = new HashMap<>();


	public StacjaPaliw() {
		mapa.put("PB95", BigDecimal.valueOf(4.96));
		mapa.put("PB98", BigDecimal.valueOf(5.29));
		mapa.put("ON", BigDecimal.valueOf(5.05));
		mapa.put("LPG", BigDecimal.valueOf(2.29));
		ileMoznaZatankowac.put("PB95", 0);
		ileMoznaZatankowac.put("PB98", 0);
		ileMoznaZatankowac.put("ON", 0);
		ileMoznaZatankowac.put("LPG", 0);
	}
	

	public Map<String, Integer> getIleMoznaZatankowac() {
		return ileMoznaZatankowac;
	}


	public void setIleMoznaZatankowac(Map<String, Integer> ileMoznaZatankowac) {
		this.ileMoznaZatankowac = ileMoznaZatankowac;
	}


	public Map<String, BigDecimal> getMapa() {
		return mapa;
	}

	public void setMapa(Map<String, BigDecimal> mapa) {
		this.mapa = mapa;
	}

	Map<String, Integer> dostawa (String nazwa, Integer wartosc) {
//		Map<String, Integer> mapaDwa = ileMoznaZatankowac;
		String nazwaBezPomylek = nazwa.trim().toUpperCase();
		if(ileMoznaZatankowac.containsKey(nazwaBezPomylek)) {
			for(Map.Entry<String, Integer> entry : ileMoznaZatankowac.entrySet()) {
				if(nazwaBezPomylek.equals(entry.getKey())) {
					int suma = entry.getValue() + wartosc;
					ileMoznaZatankowac.replace(nazwaBezPomylek, entry.getValue(), suma);
					// lub mapaDwa.put(klucz, element)
				}
			}
			System.out.println("Tankowanie zakończone.");
		}
		else {
			System.out.println("Podano niewłaściwą nazwę paliwa. Proces zakończony niepowodzeniem.");
		}
		return ileMoznaZatankowac;
	}
	Map<String, BigDecimal> ustawCene (String nazwa, BigDecimal cena) {
		String nazwaBezBledow = nazwa.trim().toUpperCase();
//		Map <String, BigDecimal> mapaDwa = mapa;
		if(mapa.containsKey(nazwaBezBledow)) {
			for(Map.Entry<String, BigDecimal> entry : mapa.entrySet()) {
				if(entry.getKey().equals(nazwaBezBledow)) {
					mapa.replace(nazwaBezBledow, cena);
				}
			}
			System.out.println("Zmiana ceny zakończona sukcesem.");
		}
		else {
			System.out.println("Podano niewłaściwą nazwę paliwa. Proces zakończony niepowodzeniem.");
		}
		return mapa;
	}
	BigDecimal tankuj (String nazwa, BigDecimal iloscPaliwa) {
//		Map<String, Integer> mapaJeden = ileMoznaZatankowac;
//		Map<String, BigDecimal> mapaDwa = mapa;
		BigDecimal doZaplaty = BigDecimal.ZERO;
		BigDecimal zmianaPaliwaB = BigDecimal.ZERO;
		int zmianaPaliwa;
		String nazwaBezPomylek = nazwa.trim().toUpperCase();
		
		for(Map.Entry<String, Integer> entry :ileMoznaZatankowac.entrySet()) {
			if(nazwaBezPomylek.equals(entry.getKey())) {
				BigDecimal mozliwePaliwo = BigDecimal.valueOf(entry.getValue());
				zmianaPaliwaB = mozliwePaliwo.subtract(iloscPaliwa);
				if(zmianaPaliwaB.compareTo(BigDecimal.ZERO) <0){
					System.out.println("Nie");
					return doZaplaty;
				}
				zmianaPaliwa = zmianaPaliwaB.intValue();
				ileMoznaZatankowac.replace(nazwaBezPomylek, zmianaPaliwa);
			}
		}
		for(Map.Entry<String, BigDecimal> entry: mapa.entrySet()) {
			
			if(nazwaBezPomylek.equals(entry.getKey())) {
				doZaplaty = entry.getValue().multiply(iloscPaliwa);
			}
		}
		return doZaplaty;
	}
}	
