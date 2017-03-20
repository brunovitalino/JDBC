package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MOperacoesSQL {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public MOperacoesSQL(Connection conexao) {
		this.conexao = conexao;
	}
	
	public boolean inserir(String nome) {
		String comandoSQL = "insert into Clientes(nome)" +
							"values (?)";
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(comandoSQL);
			pst.setString(1, nome);
			pst.execute();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
