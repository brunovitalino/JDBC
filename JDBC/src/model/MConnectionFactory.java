package model;

import java.sql.*;

public class MConnectionFactory
{
	
	public Connection getConnection()
	{
		try
		{
			System.out.print("Acesando database... ");
			try { Thread.sleep(1000); } catch (Exception es) { es.printStackTrace(); }
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "");
			System.out.println("conectado!\n");
			try { Thread.sleep(1000); } catch (Exception es) { es.printStackTrace(); }
			return conexao;
		}
		catch (SQLException e)
		{
			System.out.println("FALHA. Database offline.\n");
			try { Thread.sleep(1000); } catch (Exception es) { es.printStackTrace(); }
			throw new RuntimeException(e);
		}
	}
	
}
