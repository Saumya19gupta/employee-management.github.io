package com.cetpa.repository;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.cetpa.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository 
{
	private Session session;
	private Transaction transaction;
	

	
	public EmployeeRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	public void saveRecord(Employee employee) 
	{
		transaction.begin();
		session.persist(employee);
		transaction.commit();
	}
	public List<Employee> getEmployeeList() 
	{
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		List<Employee> employeeList=query.list();
		return employeeList;
	}
	public Employee getRecord(int eid) 
	{
		Employee employee=session.get(Employee.class,eid);
		return employee;
	}
	public void deleteRecord(Employee employee) 
	{
		transaction.begin();
//		session.delete(employee);
		transaction.commit();
	}
	public void updateRecord(Employee employeeo, Employee employeen) 
	{
		transaction.begin();
		employeeo.setFirstname(employeen.getFirstname());
		employeeo.setLastname(employeen.getLastname());
		employeeo.setPhone(employeen.getPhone());
		employeeo.setEmail(employeen.getEmail());
		employeeo.setDepartment(employeen.getDepartment());
		employeeo.setSalary(employeen.getSalary());
		transaction.commit();
	}
}
