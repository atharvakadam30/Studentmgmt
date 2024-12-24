package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pojo.Student;

public class StudentDao {
	private static final String url = "jdbc:mysql://localhost:3306/studentmgmt";
	private static final String username = "root";
	private static final String password = "root";
	public static Connection con;
	public static PreparedStatement pstmt;

	public static Connection getDbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void addstudent(Student s) {
		String sql = "insert into student values(?,?,?,?)";

		try {
			con.commit();
			pstmt = getDbConnection().prepareStatement(sql);
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setInt(3, s.getAge());
			pstmt.setString(4, s.getCourse());
			pstmt.executeUpdate();
			System.err.println("Data inserted successfully");
		} catch (SQLException e) {
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}

	public void deleteStudent(Student s) {
		String sql = "delete from  student where id=?";

		try {
			pstmt = getDbConnection().prepareStatement(sql);
			pstmt.setInt(1, s.getId());
			pstmt.executeUpdate();
			System.err.println("Data deleted successfully");
		} catch (Exception e) {

		}

	}

	public void Updatestudent(Student s) {
		String sql = "update student set name=?, age=?, course=? where id=?";

		try {
			pstmt = getDbConnection().prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getAge());
			pstmt.setString(3, s.getCourse());
			pstmt.setInt(4, s.getId());
			int i = pstmt.executeUpdate();
			if (i > 0)
				System.err.println("Data updated successfully");

			else

				System.err.println("Data not updated");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
