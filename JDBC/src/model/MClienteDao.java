package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MClienteDao {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public MClienteDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	//Nossa camada de controle usara para fechar a conexao
	public void close() {
		try {
			this.conexao.close();
			System.out.println("Database desconectado.");
		} catch (SQLException e) {
			System.out.println("Não há conexão à ser fechada.");
		}
	}
	
	public boolean inserir(String nome) {
		String comandoSQL = "insert into Clientes(nome)" +
							"values (?)";
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(comandoSQL);
			pst.setString(1, nome);
			pst.execute();
			pst.close();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
