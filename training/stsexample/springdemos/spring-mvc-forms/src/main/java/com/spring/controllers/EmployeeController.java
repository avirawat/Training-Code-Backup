package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.model.Employee;

@Controller
public class EmployeeController {
	
	@RequestMapping("/showform")
	public String showEmpForm() {
		return "empform";
	}
	
//	@RequestMapping("/addEmployee")
//	public String addEmployee(@RequestParam("empName")String ename,
//							@RequestParam("empId")int empId,
//							@RequestParam("city")String city,
//							@RequestParam("salary")double salary,Model model ) {
//		Employee employee=new Employee();
//		employee.setEmpName(ename);
//		employee.setEmpId(empId);
//		employee.setCity(city);
//		employee.setSalary(salary);
//		employee.setSalary(salary);
//		model.addAttribute("employee",employee);
//		return "empfinal";
//	}
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee employee,BindingResult result) {
		if(result.hasErrors()) {
			return "empform";
		}
		System.out.println("employee");
		return "empfinal";
	}
	
}
