package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class BDConnection {
	
	private static Connection conexion;
	
	public void startConnection() {
		Properties properties = new Properties();
		conexion = null;
		
		try {
			File file = new File("login.properties");
			FileInputStream fis = new FileInputStream(file);
			properties.load(fis);
			String driver = String.valueOf(properties.get("DRIVER"));
			String url = String.valueOf(properties.get("URL"));
			String user = String.valueOf(properties.get("USER"));
			String pass = String.valueOf(properties.get("PASS"));
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, pass);
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		} 
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void endConnection() {
		try {
			conexion.close();
		}
		catch (SQLException e) {
			
		}
	}
	
	public Connection getConnection() {
		return conexion;
	}
}