package control;

import java.sql.Connection;
import java.sql.SQLException;
import model.*;

public class COperacoesSQL {
	
	public void inserir(String nome) {
		Connection conexao = null;			//Guarda a conexao com o banco de dados
		MOperacoesSQL operacoes = null;		//Contem as operacoes SQL
		boolean insercaoRealizada = false;	//Guarda resultado da insercao
		
		conexao = new ConnectionFactory().getConnection();
		operacoes = new MOperacoesSQL(conexao);
		insercaoRealizada = operacoes.inserir(nome);
		if (insercaoRealizada)
			System.out.println("Inserido com sucesso!");
		else
			System.out.println("Falha na inserção!");
		
		try {
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Não há conexões.");
			e.printStackTrace();
		}
	}
}
