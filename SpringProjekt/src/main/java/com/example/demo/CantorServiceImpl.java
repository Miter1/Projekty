package com.example.demo;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class CantorServiceImpl implements CantorService{
	
	@Override
	public BigDecimal przelicz(BigDecimal liczba, String waluta1, String waluta2) {
		if (liczba == null) {
			return null;
		}
		BigDecimal liczba1 = jakaWaluta(waluta1);
		BigDecimal liczba2 = jakaWaluta(waluta2);
		BigDecimal kurs = liczba1.divide(liczba2);
	
		
		BigDecimal wynik = liczba.multiply(kurs);
		return wynik;
	}
	public BigDecimal jakaWaluta(String waluta) {
		switch(waluta) {
		case("EUR"): return BigDecimal.valueOf(4.28);
		case("GBP"): return BigDecimal.valueOf(5.06);
		case("USD"): return BigDecimal.valueOf(3.88);
		case("NOK"): return BigDecimal.valueOf(0.42);
		case("SEK"): return BigDecimal.valueOf(0.4);
		case("CHF"): return BigDecimal.valueOf(4.01);
		case("PLN"): return BigDecimal.ONE;
		default: return null;
		}
	}
}