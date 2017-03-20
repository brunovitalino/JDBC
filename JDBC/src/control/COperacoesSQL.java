package control;

import java.sql.Connection;
import java.sql.SQLException;
import model.*;

public class COperacoesSQL {
	
	public void inserir(CCliente cliente) {
		Connection conexao = null;			//Guarda a conexao com o banco de dados
		MOperacoesSQL db = null;		//Contem as operacoes SQL
		boolean insercaoRealizada = false;	//Guarda resultado da insercao
		
		conexao = new ConnectionFactory().getConnection();
		db = new MOperacoesSQL(conexao);
		insercaoRealizada = db.inserir(cliente.getNome());
		if (insercaoRealizada)
			System.out.println("Cliente cadastrado com sucesso!");
		else
			System.out.println("Falha na inser��o!");
		try { Thread.sleep(1000); } catch (Exception es) { es.printStackTrace(); }
		
		try {
			conexao.close();
		} catch (SQLException e) {
			System.out.println("N�o h� conex�es.");
			try { Thread.sleep(1000); } catch (Exception es) { es.printStackTrace(); }
		}
		finally
		{
			try {
				conexao.close();
				System.out.println("Conex�o ao database finalizada.");
			} catch (SQLException e) {
				System.out.println("N�o h� conex�es para serem fechadas.");
			}
		}
	}
	
}
