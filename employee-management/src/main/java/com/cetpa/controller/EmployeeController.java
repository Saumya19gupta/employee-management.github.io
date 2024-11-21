package com.cetpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cetpa.entity.Employee;
import com.cetpa.repository.EmployeeRepository;
import com.cetpa.service.EmployeeService;

@SuppressWarnings("unused")
@Controller
@RequestMapping("employee-management")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("")
	public String getHomeView()
	{
		return "home";
	}
	@RequestMapping("insert-employee")
	public ModelAndView getAddEmployeeView()
	{
		ModelAndView mv=new ModelAndView("add");
		return mv;
	}
	@RequestMapping("save-record")
	public String saveEmployeeRecord(Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "save-success";
	}
	@RequestMapping("employee-list")
	public ModelAndView getEmployeeList()
	{
		List<Employee> employeeList=employeeService.getList();
		ModelAndView mv=new ModelAndView("list");
		mv.addObject("elist",employeeList);
		return mv;
	}
	@RequestMapping("search-employee")
	public String getSearchEmployeeView()
	{
		return "search";
	}
	@RequestMapping("search-record")
	public String getEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getEmployee(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Employee not found");
			model.addAttribute("eid",eid);
			return "search";
		}
		model.addAttribute("emp",employee);
		return "show-record";
	}
	@RequestMapping("delete-employee")
	public String getDeleteEmployeeView()
	{
		return "delete";
	}
	@RequestMapping("confirm-delete")
	public String getEmployeeRecordForDelete(int eid,Model model)
	{
		Employee employee=employeeService.getEmployee(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Employee doet not ecit");
			model.addAttribute("eid",eid);
			return "delete";
		}
		model.addAttribute("emp",employee);
		return "confirm";
	}
	@RequestMapping("delete-record")
	public String deleteEmployeeRecord(int eid)
	{
		employeeService.deleteEmployee(eid);
		return "delete-success";
	}
	@RequestMapping("edit-employee")
	public String getEditEmployeeView()
	{
		return "edit";
	}
	@RequestMapping("show-record")
	public String getEmployeeRecordForUpdate(int eid,Model model)
	{
		Employee employee=employeeService.getEmployee(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Employee doet not ecit");
			model.addAttribute("eid",eid);
			return "edit";
		}
		model.addAttribute("emp",employee);
		return "update-show";
	}
	@RequestMapping("update-record")
	public String updateEmployeeRecord(Employee employee)
	{
		employeeService.updateEmployee(employee);
		return "update-success";
	}
}
