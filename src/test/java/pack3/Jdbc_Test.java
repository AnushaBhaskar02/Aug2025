package pack3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_Test {
	public static void main(String[] args) {
		String url="jdbc:mysql://127.0.0.1:3306/august4th2025";
		String user="root";
		String password= "root";
		try(Connection con=DriverManager.getConnection(url, user, password))
		{
			System.out.println("Connect to DB");
			String insertsql="INSERT INTO Students(id,name,age) VALUES(?,?,?)";
			try(PreparedStatement pstmt=con.prepareStatement(insertsql))
			{
				pstmt.setInt(1, 104);
				pstmt.setString(2, "Adarsh");
				pstmt.setInt(3, 23);
				int rows= pstmt.executeUpdate();
				System.out.println("inserted: "+ rows);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			String readsql ="SELECT * FROM Students";
			try(Statement stmt=con.createStatement()){
				ResultSet rs= stmt.executeQuery(readsql);
				while(rs.next()) {
					System.out.println("id: "+rs.getInt("id"));
					System.out.println("name: "+rs.getString("name"));
					System.out.println("id: "+rs.getInt("age"));
				}
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
			String upadtesql="UPDATE Students SET age=? WHERE id=?";
			try(PreparedStatement pstmt1=con.prepareStatement(upadtesql))
			{
				pstmt1.setInt(1, 28);
				pstmt1.setInt(2, 102);
				int rows= pstmt1.executeUpdate();
				System.out.println("updated: "+ rows);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			//delete
			String deletesql="DELETE FROM Students WHERE id=?";
			try(PreparedStatement pstmt2=con.prepareStatement(deletesql))
			{
				pstmt2.setInt(1, 103);
				int rows= pstmt2.executeUpdate();
				System.out.println("deleted: "+ rows);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
}
}
