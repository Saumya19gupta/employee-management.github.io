package com.cetpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entity.Employee;
import com.cetpa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveEmployee(Employee employee) 
	{
		
		employeeRepository.saveRecord(employee);
	}
	public List<Employee> getList() 
	{
		List<Employee> elist=employeeRepository.getEmployeeList();
		return elist;
	}
	public Employee getEmployee(int eid) 
	{
		Employee employee=employeeRepository.getRecord(eid);
		return employee;
	}
	public void deleteEmployee(int eid) 
	{
		Employee employee=employeeRepository.getRecord(eid);
		employeeRepository.deleteRecord(employee);
	}
	public void updateEmployee(Employee employeen) 
	{
		Employee employeeo=employeeRepository.getRecord(employeen.getEid());
		employeeRepository.updateRecord(employeeo,employeen);
	} 
}
