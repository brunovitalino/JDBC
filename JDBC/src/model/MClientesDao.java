package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			System.out.println("Database desconectado.\n");
		} catch (SQLException e) {
			System.out.println("Não há conexão à ser fechada.\n");
		}
	}
	
	public boolean inserir(String nome) {
		String comandoSQL;
		PreparedStatement pst = null;
		
		comandoSQL =	"insert into Clientes(nome)" +
						"values (?);";
		try {
			pst = conexao.prepareStatement(comandoSQL);
			pst.setString(1, nome);
			pst.execute();
			pst.close();
			return true;
		}
		catch (SQLException e) {
			return false;
		}
	}
	
	public ResultSet listar() {
		String comandoSql = "select * from Clientes";
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conexao.createStatement();
			rs = st.executeQuery(comandoSql);
			return rs;
		} catch (SQLException e) {
			return null;
		}
		finally
		{
			/*try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível liberar os recursos.\n");
			}*/
		}
	}
}
