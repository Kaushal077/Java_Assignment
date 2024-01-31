package bca.drive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import bca.jdbc.student;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbc_concept";
		
		String db= "root";
		
		String psd ="kaushal@123";
		
		Connection con = DriverManager.getConnection(url,db,psd);
			
		Scanner sc = new Scanner(System.in);
		
		student stud = new student();
		
		boolean exitflag = true;
		
		while (exitflag)
		{
		System.out.println("Which operation do you want to perform.");
		System.out.println("1. Insert Operation");
		System.out.println("2. Remove Operation");
		System.out.println("3. Update Operation");
		System.out.println("4. Display Operation");
		System.out.println("5. Exit");
		System.out.print("Enter the choice :");
		
		int choice=sc.nextInt();
		
		switch(choice)
		{
		case 1: 
			stud.insertStudent(con,sc);
			break;
		
		case 2:
			stud.removeStudent(con, sc);
			break;
			
		case 3 :
			stud.updateStudent(con, sc);
			break;
			
		case 4 :
			stud.displayStudents(con, sc);
			break;
			
		case 5 :
			exitflag=false;
			break;
			
		default:
			System.out.println("Invalid Choice");
			break;
		}	

	}

}
}


