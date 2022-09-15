package com.spring.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {
	
	@RequestMapping("/greet")
	public String greetMessage(Model map) {
		map.addAttribute("message","Have a great Day");
		return "success";
	}
	@RequestMapping("/sayHello")
	public String helloMessage(ModelMap map) {
		//creating model
		map.addAttribute("message", "Hello !!! How are you");
		//return view
		return "success";
	}
	@RequestMapping("/sayWelcome")
	public ModelAndView welcomeMessage() {
		//(view,model,value)
		ModelAndView model=new ModelAndView("success","message","Welcometo spring MVC");
		return model;
	}
	
	@RequestMapping("/welcomeView")
	public ModelAndView welcomeMessage(ModelAndView model) {
		model.addObject("message","using Model and View");
		model.setViewName("success");
		return model;
	}
	
	@RequestMapping(value= {"check","trial","demo"})
	public String checkMessage(Model map) {
		map.addAttribute("message","hello! how are you");
		// return to the view 
		return "success";
	}
}
