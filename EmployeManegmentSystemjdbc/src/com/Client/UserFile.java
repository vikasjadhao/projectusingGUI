package com.Client;

import java.util.Scanner;

import com.EmployeeImp.Employee;

public class UserFile {
	public static void main(String args[]) {
		
		
		Employee emp=new Employee();
		
		boolean flag=true;
		while(flag) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your choice");
			System.out.println("1] Registration");
			System.out.println("2] Update Salary");
			System.out.println("3] Fetch Record");
			System.out.println("4] Registration of Employee");
			System.out.println("5] alldeatals");
			System.out.println("6] Exist");
		
			int choice=sc.nextInt();
			switch(choice) {
			case 1:emp.register();
					
			break;
			
			case 2:emp.update();
					
			break;
			
			case 3:emp.fetch();
					
			break;
			
			case 4:emp.terminated();
					
			break;
			
			case 5:emp.alldeatils();
			break;
			
			default:System.out.println("Exit");
					flag = false;
			break;		
				
			
			}
		}
	}

}
