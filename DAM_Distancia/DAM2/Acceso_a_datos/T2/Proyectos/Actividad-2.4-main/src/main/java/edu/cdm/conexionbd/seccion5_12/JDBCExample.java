package edu.cdm.conexionbd.seccion5_12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.cdm.conexionbd.properties.ConexionProperties;

public class JDBCExample {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    // Database credentials
    static final String USER = "scott";
    static final String PASS = "tiger";

    public static void main(String[] args) {
		Connection conn = null;
		try {
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			//conn = DriverManager.getConnection(DB_URL, USER, PASS);
           conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?user=root&password=abc123.",
            "root", "abc123.");

			// STEP 4: Execute a query to create statment with
			// required arguments for RS example.
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// STEP 5: Execute a query
            //Actualizamos la consulta
            //String sql = "SELECT EMPLOYEE_ID, first_name, last_name, salary, email, hire_date FROM Employees";
			String sql = "SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP ORDER BY EMPNO";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("List result set for reference....");
			printRs(rs);
			// STEP 6: Loop through result set and add 5 in sal
			// Move to BFR postion so while-loop works properly
			rs.beforeFirst();
			// STEP 7: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
                //Cambiamos int por float
				float newSalary = rs.getFloat("SAL") + 5;
				rs.updateDouble("SAL", newSalary);
				rs.updateRow();
			}
			System.out.println("List result set showing new salarys...");
			printRs(rs);
			// Insert a record into the table.
			// Move to insert row and add column data with updateXXX()
			System.out.println("Inserting a new record...");
			rs.moveToInsertRow();
			rs.updateInt("EMPNO", 300);
			rs.updateString("ENAME", "John");
			//rs.updateString("last_name", "Paul");
			rs.updateInt("SAL", 40);
			//rs.updateString("email", "ana@ana");
			rs.updateTimestamp("HIREDATE", null);
			// Commit row
			rs.insertRow();
			System.out.println("List result set showing new set...");
			printRs(rs);

			// Delete second record from the table.
			// Set position to second record first_name
			rs.absolute(2);
			System.out.println("List the record before deleting...");
			// Retrieve by column name
			int EMPLOYEE_ID = rs.getInt("EMPNO");
			int salary = rs.getInt("SAL");
			String first_name = rs.getString("ENAME");
			//String last_name = rs.getString("last_name");
			// Display values
			System.out.print("EMPNO: " + EMPLOYEE_ID);
			System.out.print(", SAL: " + salary);
			System.out.print(", ENAME: " + first_name);
			//System.out.println(", last_name: " + last_name);
			// Delete row
			rs.deleteRow();
			System.out.println("List result set after deleting one records...");
			printRs(rs);
			// STEP 8: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main

    public static void printRs(ResultSet rs) throws SQLException {
        // Ensure we start with first_name row
        rs.beforeFirst();
        int contador = 0; 
        while (rs.next()) {
            // Retrieve by column name
            int EMPLOYEE_ID = rs.getInt("EMPNO");
            int age = rs.getInt("SAL");
            String first_name = rs.getString("ENAME");
            //String last_name = rs.getString("last_name");
            // Display values
            System.out.printf("contador: %d : ",   ++contador);
            System.out.print("EMPLOYEE_ID: " + EMPLOYEE_ID);
            System.out.print(", Salary: " + age);
            System.out.print(", first_name: " + first_name);
            System.out.println(" ");
           // System.out.println(", last_name: " + last_name);
        }
        System.out.println();
    }// end printRs()
}
