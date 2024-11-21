package com.cetpa.service;

import java.util.List;

import com.cetpa.entity.Employee;

public interface EmployeeService 
{
	void saveEmployee(Employee employee);
	List<Employee> getList();
	Employee getEmployee(int eid);
	void deleteEmployee(int eid);
	void updateEmployee(Employee employee);
}