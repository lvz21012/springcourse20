package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	//metodo para mostrar el initial HTML form

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//metodo para procesar el HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//metodo para leer los datos de form
	
	//agregar los datos al modelo
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//leer el parametro request del HTML form
		String theName= request.getParameter("studentName");
		
		//convertir los datos a mayusculas
		theName = theName.toUpperCase();
		
		//Crear el mensaje
		String result = "Yo! " + theName;
		
		//agregar el mensaje al modelo
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		//convertir los datos a mayusculas
		theName = theName.toUpperCase();
		
		//Crear el mensaje
		String result = "Hey my friend from v3 " + theName;
		
		//agregar el mensaje al modelo
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
