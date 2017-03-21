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
	
	public void inserir(String nome)
	{
		MClientesDao dao = null;		//Contem as operacoes SQL
		boolean insercaoRealizada = false;	//Guarda resultado da insercao
		
		dao = new MClientesDao();
		insercaoRealizada = dao.inserir(nome);
		if (insercaoRealizada)
			System.out.println("Cliente cadastrado com sucesso!");
		else
			System.out.println("Falha na inserção!");
		try { Thread.sleep(1000); } catch (Exception es) { es.printStackTrace(); }
		dao.close();
	}
	
	public void listar()
	{
		MClientesDao dao = new MClientesDao();	//Contem as operacoes SQL
		List<MCliente> clientes = dao.listar();
		MCliente cliente = new MCliente();
		
		if (clientes==null)
			System.out.println("Dados nulos.");
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
