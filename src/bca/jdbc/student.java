package bca.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class student {

	public student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insertStudent(Connection con,Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter student id: ");
		int id = sc.nextInt();
		
		System.out.println("Enter student Name: ");
		String name = sc.next();
		
		System.out.println("Enter student Marks: ");
		double marks  = sc.nextDouble();
		
		System.out.println("Enter student Age: ");
		int age = sc.nextInt();
		
		System.out.println("Enter student Gender: ");
		String gender = sc.next();
		
		
		String query = String.format("Insert into student value(%d, '%s',  %f, %d, '%s')", id, name, marks, age, gender);
		
		int rowsAffected = ((java.sql.Statement) st).executeUpdate(query);
		System.out.println(rowsAffected + " record inserted!!");
	}
    public void displayStudents(Connection con, Scanner sc) throws SQLException {
    	 Statement st = con.createStatement();
    	    String query = "SELECT * FROM student";
    	    ResultSet rs = st.executeQuery(query);
    	    
    	    System.out.println("---------------------------------");
    	    while (rs.next()) {
    	        // Retrieve data from the result set
    	    	System.out.println(" | " + rs.getInt(1) + " | " + rs.getString(2) + " |"  + rs.getDouble(3) + " | " + rs.getInt(4) + " | " + rs.getString(5));
    	    	System.out.println("---------------------------------");
    	    }
    	    
    	    System.out.println("---------------------------------");
    	    // Close the ResultSet and Statement
    	    rs.close();
    	    st.close();
    }
    public void updateStudent(Connection con, Scanner sc) throws SQLException {

        Statement st = con.createStatement();

        System.out.println("Enter student id to update: ");
        int idToUpdate = sc.nextInt();

        // Assuming you want to update the marks for the student
        System.out.println("Enter new marks for the student: ");
        double newMarks = sc.nextDouble();

        String query = String.format("UPDATE student SET marks = %f WHERE id = %d", newMarks, idToUpdate);
        int rowsAffected = st.executeUpdate(query);

        System.out.println(rowsAffected + " record(s) updated!!");

    }
   public void removeStudent(Connection con, Scanner sc) throws SQLException {
	   Statement st = con.createStatement();

	    System.out.println("Enter student id to remove: ");
	    int idToRemove = sc.nextInt();

	    String query = String.format("DELETE FROM student WHERE id = %d", idToRemove);
	    int rowsAffected = st.executeUpdate(query);

	    System.out.println(rowsAffected + " record(s) removed!!");
    }
    
}