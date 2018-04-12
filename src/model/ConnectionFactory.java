package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory
{	
	
	public Connection getConnectionSqlServer()
	{
		try
		{
			System.out.print("Acesando database SQL Server... ");
			try { Thread.sleep(1000); } catch (Exception es) { es.printStackTrace(); }
			Connection conexao = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=jdbc", "sa", "s3nh4nvst!");
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
	
	public Connection getConnectionMySql()
	{
		try
		{
			System.out.print("Acesando database MySQL... ");
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
