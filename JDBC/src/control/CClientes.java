package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import model.MCliente;
import model.MClientesDao;

public class CClientes
{

	//PESQUISAR
	public void pesquisar(String nome)
	{
		MClientesDao dao = new MClientesDao();
		List<MCliente> clientes = dao.pesquisar(nome);
		MCliente cliente = new MCliente();
		
		Iterator<MCliente> itClientes = clientes.iterator();
		while (itClientes.hasNext())
		{
			cliente = itClientes.next();
			System.out.println("ID:   " + cliente.getId() + "\n" +
							   "Nome: " + cliente.getNome() + "\n");
		}
		dao.close();
	}
	//CADASTRAR
	public void inserir(String nome)
	{
		MClientesDao dao = null;		//Contem as operacoes SQL
		boolean insercaoRealizada = false;	//Guarda resultado da insercao
		
		dao = new MClientesDao();
		insercaoRealizada = dao.inserir(nome);
		if (insercaoRealizada)
			System.out.println("Cadastramento de cliente realizado com sucesso!\n");
		else
			System.out.println("Falha no cadastro!");
		dao.close();
	}
	//ALTERAR
	public void alterar2(String nomeVelho, String nomeNovo)
	{
		MClientesDao dao = new MClientesDao();
		MCliente cliente = new MCliente();
		boolean nomeExistente = false, alteracaoRealizada = false;
		
		Iterator<MCliente> itClientes;
		
		itClientes= dao.pesquisar(nomeNovo).iterator();
		while (itClientes.hasNext())
		{
			cliente = itClientes.next();
			if (cliente.getNome().equals(nomeNovo))
			{
				nomeExistente = true;
				break;
			}
		}
		
		if (nomeExistente)
		{
			System.out.println("Nome já existe! Falha na alteracao!\n");
		}
		else
		{
			alteracaoRealizada = dao.alterar(nomeVelho, nomeNovo);
			if (alteracaoRealizada)
			{				
				itClientes= dao.pesquisar(nomeNovo).iterator();
				while (itClientes.hasNext())
				{
					cliente = itClientes.next();
					if (cliente.getNome().equals(nomeNovo))
					{
						//nomeExistente = true; 
						System.out.println("Alteracao de cliente realizada com sucesso!\n");
						break;
					}
				}
			}
			else
			{
				System.out.println("Nao foi possivel realizar! Falha na alteracao!\n");
			}
		}
		
	}
	//REMOVER
	public void remover()
	{
		
	}
	//LISTAR
	public void listar()
	{
		MClientesDao dao = new MClientesDao();	//Contem as operacoes SQL
		List<MCliente> clientes = dao.listar();
		MCliente cliente = new MCliente();
		
		if (clientes==null)
			System.out.println("Dados nulos.\n");
		else
			if (clientes.isEmpty())
				System.out.println("Não há dados à serem exibidos.\n");
			else
			{
				Iterator<MCliente> itClientes = clientes.iterator();
				while (itClientes.hasNext())
				{
					cliente = itClientes.next();
					System.out.println("ID:   " + cliente.getId() + "\n" +
									   "Nome: " + cliente.getNome() + "\n");
				}
			}
		dao.close();
	}
	
}
