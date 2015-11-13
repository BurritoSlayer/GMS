package database;
import java.sql.*;
public class DbConn {

	static private String connString =  "jdbc:mysql://localhost:3306/matams";
	static private String userName = "sa";
	static private String password = "m5w14X55";
	static private ResultSet rs;
	static private Connection conn;
	
	static void loadDriver(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e){
			System.out.println(String.format("Error: %s", e.getMessage()));
		}
	}
	
	public void update(String s) throws SQLException
	{
		loadDriver();
		conn = DriverManager.getConnection(connString, userName, password);
		try
		{
			PreparedStatement ps = conn.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
		}
		catch (SQLException ex)
		{
			System.out.println("DBConn.update: " + ex.getMessage());
		}
	}
	
	public ResultSet query(String s) throws SQLException
	{
		loadDriver();
		conn = DriverManager.getConnection(connString, userName, password);
		try
		{
			PreparedStatement ps = conn.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
			rs = ps.executeQuery();
			return rs;
		}
		catch (SQLException ex)
		{
			System.out.println("DBConn.query: " + ex.getMessage());
			return rs;
		}
	}
	
	public static PreparedStatement createPrepStatement(String iString) throws SQLException {
		PreparedStatement ps = null;
		ps = conn.prepareStatement(iString);
		return ps;
	}
	
	static void closeConn()
	{
		try {
			conn.close();
		} catch (SQLException ex) {		
			System.out.println("DBConn.closeConn: " + ex.getMessage());
		}
	}
}
