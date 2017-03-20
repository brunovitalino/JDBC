package control;

import java.sql.*;

public class ConnectionFactory
{
	public Connection getConnection()
	{
		try
		{
			System.out.println("Conectando-se ao database...");
			try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "");
			System.out.println("Database conectado!");
			try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
			return conexao;
		}
		catch (SQLException e)
		{
			System.out.println("FALHA. Database desconectado!");
			throw new RuntimeException(e);
		}
	}
}
