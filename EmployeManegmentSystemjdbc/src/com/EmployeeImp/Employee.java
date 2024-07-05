package com.EmployeeImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.Connection.ConnectionEstablish;
import com.EmployeeUnimp.EmployeeUnImp;

public class Employee implements EmployeeUnImp {
	@Override
	public void register() {
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Id:");
		int id = sc.nextInt();
		
		System.out.println("Enter your Name:");
		String n = sc.next();
		
		System.out.println("Enter your salary:");
		double s = sc.nextDouble();
		
		System.out.println("Enter your Experience:");
		double e = sc.nextDouble();
		
		try {
			Connection con = ConnectionEstablish.createConnection();
			PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,n);
			ps.setDouble(3,s);
			ps.setDouble(4,e);
			int row = ps.executeUpdate();
			System.out.println(row + "affected");
			ps.close();
			con.close();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void update() {
		try {
			Connection con = ConnectionEstablish.createConnection();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your id to update salary");
			int id = sc.nextInt();
			
			System.out.println("Enter your id to update salary of" + id + "Employee");
			double s=sc.nextDouble();
			PreparedStatement ps = con.prepareStatement("update Employee set experience = ? where id=?");
			
			ps.setDouble(1,s);
			ps.setInt(2,id);
		}catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fetch() {
		// TODO Auto-generated method stub
		//select
		try {
			Connection con= ConnectionEstablish.createConnection();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id for fetching into of employee");
			int id=sc.nextInt();
			
			PreparedStatement ps = con.prepareStatement("select* from Employee where id=?;");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));
				System.out.println(rs.getDouble(4));
				
			}
			ps.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void terminated() {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectionEstablish.createConnection();
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id which you want to terminate the employee");
			int id=sc.nextInt();
			
			PreparedStatement ps=con.prepareStatement("delete from Employee where id=?");
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			if(row==0) {
				System.out.println("row+employee is not terminated");
			}else {
				System.out.println("row+employee is terminated");
				
			}
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void alldeatils() {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectionEstablish.createConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Employee");
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));
				System.out.println(rs.getDouble(4));
			}
			con.close();
			rs.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		
	}

	
