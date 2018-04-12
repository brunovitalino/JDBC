package control;

import java.util.Iterator;
import java.util.List;

import model.Cliente;
import model.ClienteDao;

public class ClienteController
{

	//PESQUISAR
	public void pesquisar(String nome)
	{
		ClienteDao dao = new ClienteDao();
		List<Cliente> clientes = dao.pesquisar(nome);
		Cliente cliente = new Cliente();
		
		Iterator<Cliente> itClientes = clientes.iterator();
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
		ClienteDao dao = null;		//Contem as operacoes SQL
		boolean insercaoRealizada = false;	//Guarda resultado da insercao
		
		dao = new ClienteDao();
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
		ClienteDao dao = new ClienteDao();
		Cliente cliente = new Cliente();
		boolean nomeExistente = false, alteracaoRealizada = false;
		
		Iterator<Cliente> itClientes;
		
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
		ClienteDao dao = new ClienteDao();	//Contem as operacoes SQL
		List<Cliente> clientes = dao.listar();
		Cliente cliente = new Cliente();
		
		if (clientes==null)
			System.out.println("Dados nulos.\n");
		else
			if (clientes.isEmpty())
				System.out.println("Não há dados à serem exibidos.\n");
			else
			{
				Iterator<Cliente> itClientes = clientes.iterator();
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
