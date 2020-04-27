package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Employee;
import entity.Jobs;

public class MysqlConnection {

	public static Connection conn;
	
	public static void startConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			// handle the error
			System.out.println("Driver definition failed");
		}

		try {
			 conn = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=IST", "root",
					"h$5E2*jk/Jn47v");
			System.out.println("SQL connection succeed");

		} catch (SQLException ex) {/* handle any errors */
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public static ArrayList<Employee> getAllEmployeeData() {
		Statement stmt;
		ArrayList<Employee> result=new ArrayList<Employee>();
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM myfuelemployee");
			while(rs.next()) {
				if(!rs.isLast()) {
					System.out.println(rs.getString(1));
					result.add(new Employee(rs.getString(1),rs.getString(2),rs.getString(3),
							rs.getString(4),Jobs.valueOf(rs.getString(5))));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void updateEmployeeJob(Employee emp) {
		try {
			PreparedStatement ps = conn.prepareStatement("Update myfuelemployee SET job=?"+
		         "WHERE employeeID =?");
			ps.setString(1, emp.getWorkerJob().toString());
			ps.setString(2, emp.getWorkerID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
