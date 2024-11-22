package com.ejercicio.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
	
	@PostMapping("/parImpar")
	public String parImpar(@RequestParam int numero) {
		String Resultado = "";
		if(numero % 2  == 0) {
			Resultado = "El número es par";
		}
		else {
			Resultado = "El número es impar";
		}
		return Resultado;
		
	}
}
