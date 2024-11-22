package com.ejercicio.controlador;

import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controladores {
	
	@PostMapping("/calculadora")
	public String calculadora(@RequestParam float peso, 
							  @RequestParam float altura) 
	{
		String res = "";
		float valorIMC = peso / (altura*altura);
		
		if(valorIMC < 18.5) { res = "Peso muy bajo";}
		if(valorIMC >= 18.5 && valorIMC <= 24.9) { res = "Peso normal";}
		if(valorIMC > 25 && valorIMC < 29.9) { res = "Peso alto";}
		if(valorIMC >= 29.9) { res = "Peso muy alto";}
		
		return res;
	}
	
	@PostMapping("/encuesta")
	public String encuesta(@RequestParam int satisfaccion) {
		String mensaje = "";
		//refactorizar con un switch
		if(satisfaccion == 1) {mensaje = "<h1>" + satisfaccion + ": Sentimos no haber podido complacerle</h1>";}
		if(satisfaccion == 2) {mensaje = "<h1>" + satisfaccion + ": Sentimos no haber podido complacerle adecuadamente</h1>";}
		if(satisfaccion == 3) {mensaje = "<h1>" + satisfaccion + ": Nos alegra haberle complacido</h1>";}
		if(satisfaccion == 4) {mensaje = "<h1>" + satisfaccion + ": Nos alegra haberle complacido mucho</h1>";}
		if(satisfaccion == 5) {mensaje = "<h1>" + satisfaccion + ": Nos alegra haberle complacido adecuadamente</h1>";}

		return mensaje;
	}
	@PostMapping("/factorial")
	public String factorial(@RequestParam int numero) {
		int  Resultado = 0;
		for(int i = 1; i<= numero; i++) {
			Resultado = Resultado * i;
		}
		return "<h1>" + Resultado + "</h1>";
	}
	@PostMapping("/generarContrasena")
	public String generadorContrasena(@RequestParam int longitud) {
		String contrasena = "";
		for(int i = 1; i< longitud; i++) {
			contrasena = contrasena + caracterAleatorio();
		}
		return contrasena;
	}
	
	//refactorizado para que incluya números y caracteres especiales
	private char caracterAleatorio() {
		String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		 
        Random r = new Random();
        char caracter = caracteres.charAt(r.nextInt(caracteres.length()));
		return caracter; 
	}
	
	
	@PostMapping("/parImpar")
	public String parImpar(@RequestParam int numero) {
		String Resultado = "";
		if(numero % 2  == 0) {
			Resultado = "El número es par";
		}
		else {
			Resultado = "El número es impar";
		}
		return "<h1>" + Resultado + "</h1>";
	}
	

	@PostMapping("/promedioCalificaciones")
	public String promedioCalificaciones(@RequestParam String calificaciones) {
		String aprueba = "";
		float media = 0;
		
		String[] notas = calificaciones.split(",");
		for(int i = 0; i < notas.length; i++) {
			media = media + Float.parseFloat(notas[i]);
		}
		
		media = media/notas.length;
		
		if(media >=5) {
			aprueba = "Has aprobado";
		}
		else {
			aprueba = "Has suspendido";
		}
		
		return "<h1>" + aprueba +"</h1>";
		
	}
	
	@PostMapping("/sumatoria")
	public String sumatoria(@RequestParam int numero) {
		int  Resultado = 0;
		for(int i = 1; i<= numero; i++) {
			Resultado = Resultado + i;
		}
		return "<h1>" + Resultado + "</h1>";
	}
	
	@PostMapping("/tablaMultiplicar")
	public void tablaMultiplicar(@RequestParam int numero) {
		String  texto = "";
		for(int i = 1; i<= numero; i++) {
			texto = "<p>" + numero + " x " + i + " = " + (numero*i) +"</p>";
		}
	}
}
