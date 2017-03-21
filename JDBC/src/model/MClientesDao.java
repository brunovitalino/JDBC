package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MClientesDao
{
	private Connection conexao;
	private PreparedStatement stmt;
	
	public MClientesDao() {
		this.conexao = new MConnectionFactory().getConnection();
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
	
	public List<MCliente> listar() {
		String comandoSql = "";
		Statement st = null;
		ResultSet rs = null;
		MCliente cliente = null;
		List<MCliente> clientes = new ArrayList<MCliente>();

		System.out.println("PESQUISANDO NO BANCO");
		comandoSql = "select * from Clientes";
		
		try {
			st = conexao.createStatement();
			rs = st.executeQuery(comandoSql);
			while (rs.next()) {
				cliente = new MCliente();
				cliente.setId(rs.getShort("id"));
				cliente.setNome(rs.getString("nome"));
				clientes.add(cliente);
			}
			st.close();
			rs.close();
			return clientes;
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
