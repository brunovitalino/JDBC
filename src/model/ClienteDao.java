package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao
{
	private Connection conexao;
	
	public ClienteDao()
	{
		this.conexao = new ConnectionFactory().getConnectionSqlServer();
	}
	
	//Nossa camada de controle usara para fechar a conexao
	public void close()
	{
		try
		{
			this.conexao.close();
			System.out.println("Database desconectado.\n");
		}
		catch (SQLException e)
		{
			System.out.println("Não há conexão à ser fechada.\n");
		}
	}	
	//PESQUISAR
	public List<Cliente> pesquisar(String nome)
	{
		String comandoSQL = "";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Cliente cliente = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		comandoSQL =	"SELECT * FROM cliente " +
						"WHERE nome like ?";		
		try
		{
			pst = conexao.prepareStatement(comandoSQL);
			pst.setString(1, "%"+nome+"%");
			rs = pst.executeQuery();
			while (rs.next())
			{
				cliente = new Cliente();
				cliente.setId(rs.getShort("id"));
				cliente.setNome(rs.getString("nome"));
				clientes.add(cliente);
			}
			pst.close();
			rs.close();
			return clientes;
		} catch (SQLException e)
		{
			return null;
		}
	}
	
	//CADASTRAR
	public boolean inserir(String nome)
	{
		String comandoSQL;
		PreparedStatement pst = null;
		
		comandoSQL =	"INSERT INTO cliente(nome) " +
						"VALUES (?);";
		try
		{
			pst = conexao.prepareStatement(comandoSQL);
			pst.setString(1, nome);
			boolean resposta = true;
			pst.execute();
			pst.close();
			return resposta;
		}
		catch (SQLException e)
		{
			return false;
		}
	}
	//ALTERAR
	public boolean alterar(String nomeVelho, String nomeNovo)
	{
		String comandoSQL = "";
		PreparedStatement pst = null;
		Statement st = null;
		
		comandoSQL =	"update cliente set nome=? where nome=?";
		try
		{			
			pst = conexao.prepareStatement(comandoSQL);
			pst.setString(1, nomeNovo);
			pst.setString(2, nomeVelho);
			boolean resposta = true;
			pst.execute();
			pst.close();
			return resposta;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		/*finally
		{
			try {
				pst.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível liberar os recursos.\n");
			}
		}*/
		
	}
	//REMOVER
	public void remover()
	{
		
	}
	//LISTAR
	public List<Cliente> listar()
	{
		String comandoSql = "";
		Statement st = null;
		ResultSet rs = null;
		Cliente cliente = null;
		List<Cliente> clientes = new ArrayList<Cliente>();

		comandoSql = "SELECT * FROM cliente";
		
		try
		{
			st = conexao.createStatement();
			rs = st.executeQuery(comandoSql);
			while (rs.next())
			{
				cliente = new Cliente();
				cliente.setId(rs.getShort("id"));
				cliente.setNome(rs.getString("nome"));
				clientes.add(cliente);
			}
			st.close();
			rs.close();
			return clientes;
		}
		catch (SQLException e)
		{
			return null;
		}
		/*finally
		{
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível liberar os recursos.\n");
			}
		}*/
	}
	
}
