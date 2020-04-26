package com.cg.demo1.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("Spring1.xml");
	Employee emp=(Employee) context.getBean("emp",Employee.class);
	System.out.println("Employee Details");
	System.out.println("-------------------------");
	System.out.println("Employee {empAge="+emp.getAge()+", empId="+emp.getEmployeeId()+", empName="+emp.getEmployeeName()+", empSalary="+emp.getSalary()+"}");
	System.out.println("sbu details=SBU {sbuCode="+emp.getBusinessUnit().getSbuName()+", sbuHead="+emp.getBusinessUnit().getSbuHead()+", sbuName="+emp.getBusinessUnit().getSbuName()+"}");
	
	
}
}
