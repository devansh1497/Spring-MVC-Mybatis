package com.mybatistutorial.springmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mybatistutorial.springmybatis.dao.EmployeeMapper;
import com.mybatistutorial.springmybatis.model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("list-employees");
		mav.addObject("listemployees",employeeMapper.getAllEmployees());
		return mav;
	}
	
	@RequestMapping("/showFormForAddEmployee")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("add-employee");
		mav.addObject("employee", new Employee());
		return mav;
	}
	
	@RequestMapping("/saveProcess")
	public String saveProcess(@ModelAttribute("employee") Employee employee) {
		if(employee.getId() == null) {
			employeeMapper.saveEmployee(employee);
		}else {
			employeeMapper.updateEmployee(employee);
		}
		return "redirect:/";
		
	}
	
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") Integer id) {
		employeeMapper.deleteEmployee(id);
		return "redirect:/";
	}
	
	@RequestMapping("/updateEmployee")
	public ModelAndView updateEmployee(@RequestParam("employeeId") Integer id) {
		ModelAndView mav = new ModelAndView("add-employee");
		Employee employee = employeeMapper.findById(id);
		mav.addObject("employee", employee);
		return mav;
	}
	
	
	
}
