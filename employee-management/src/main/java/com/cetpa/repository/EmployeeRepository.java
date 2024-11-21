package com.cetpa.repository;

import java.util.List;

import com.cetpa.entity.Employee;

public interface EmployeeRepository 
{
	void saveRecord(Employee employee);
	List<Employee> getEmployeeList();
	Employee getRecord(int eid);
	void deleteRecord(Employee employee);
	void updateRecord(Employee employeeo, Employee employeen);
}
