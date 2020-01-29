package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CantorController{
	
	
	@Autowired
	private CantorService cantorService;
	
	@GetMapping("/cantor")
	public String cantorGet() {
		return "Cantor.jsp";
	}
	
	@PostMapping("/cantor")
	public String cantorPost(String waluta1, String waluta2, BigDecimal liczba, Model model) {
		BigDecimal wynik = cantorService.przelicz(liczba, waluta1, waluta2);
		model.addAttribute("wynik", wynik);
		return ("kalkulator.jsp");
	}
}
