package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Patient;

public class DAO {
	private static final String Db_url = "jdbc:mysql://localhost:3306/hospitalmanagement";
	private static final String username = "root";
	private static final String password = "root";
	public static Connection con;
	public static PreparedStatement pstmt;
	
	
	public static Connection dbconnection() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(Db_url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void insertPatientD(Patient p)
	{
		String SQL="Insert into patient values(?,?,?,?)";
		try {	
			
			pstmt=dbconnection().prepareStatement(SQL);
			pstmt.setInt(1,p.getPid());
			pstmt.setString(2,p.getName());
			pstmt.setInt(3,p.getAge());
			pstmt.setString(4,p.getGender());
			pstmt.executeUpdate();
			System.out.println("Data inserted Successfully");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
	}
	public static boolean checkId(int pid)
	{
		String SQL="select *from patient where pid=?";
		boolean status=false;
		try {
			pstmt=dbconnection().prepareStatement(SQL);
			pstmt.setInt(1, pid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				status= true;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return status;
	}
	
	
	
	public static void updatePatient(Patient p) {
		String sql="update patient set name = ?, age = ?, gender = ? WHERE pid = ?";
try {	
			
			pstmt=dbconnection().prepareStatement(sql);
			
			pstmt.setString(1,p.getName());
			 pstmt.setInt(2, p.getAge());
		       pstmt.setString(3, p.getGender());
		        pstmt.setInt(4, p.getPid());
			
			pstmt.executeUpdate();
			System.out.println("Data Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void deletePatient(int pid) {
		String sql="DELETE FROM patient WHERE pid = ?";
		try {	
					
					pstmt=dbconnection().prepareStatement(sql);
					
					pstmt.setInt(1,pid);
					
					
					pstmt.executeUpdate();
					System.out.println("Data Deleted Successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	
	public static void viewAllPatients() {
	    String sql = "SELECT * FROM patient";
	    try {	
			
			pstmt=dbconnection().prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery();
			 System.out.println("Patient ID, Name , Age , Gender");
			
			 while (rs.next()) {  
		            int pid = rs.getInt("pid");
		            String name = rs.getString("name");
		            int age = rs.getInt("age");
		            String gender = rs.getString("gender");
			
			System.out.println(pid+" " +name+" "+age+" "+gender);
			 }
		}
			 catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
