package com.productapp.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleOther(Exception e,Model model) {
		System.out.println(e.getMessage());
		model.addAttribute("message",e.getMessage());
		return "redirect:/";
	}
}
