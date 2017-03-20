package control;

import java.sql.*;

public class ConnectionFactory
{
	
	public Connection getConnection()
	{
		try
		{
			System.out.println("Conectando database...");
			try { Thread.sleep(1000); } catch (Exception es) { es.printStackTrace(); }
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "");
			System.out.println("Database conectado!");
			try { Thread.sleep(1000); } catch (Exception es) { es.printStackTrace(); }
			return conexao;
		}
		catch (SQLException e)
		{
			System.out.println("FALHA. Database desconectado!");
			try { Thread.sleep(1000); } catch (Exception es) { es.printStackTrace(); }
			throw new RuntimeException(e);
		}
	}
	
}
