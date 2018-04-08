package br.com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection con;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pacocas","root","");
		System.out.println("Conectou!!");
		return con;
		}catch(Exception e) {
			System.out.println("Error -> "+e);
			return null;
		}
	}
	
	public static void close(Connection con) {
		
		try {
			con.close();
			
		}catch(Exception e) {
			System.out.println("Error -> " +e);
			
		}
	}

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		Conexao.con = con;
	}
}
