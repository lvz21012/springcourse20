package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//crear un objeto student
		Student theStudent = new Student();
		
		//agregar objeto student al modelo
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log de input data
		System.out.println("theStudent: "+ theStudent.getFirstName()
				+ " "+ theStudent.getLastName());
		return "student-confirmation";
	}
}
