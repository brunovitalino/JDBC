package control;

import java.sql.Connection;
import java.sql.SQLException;
import model.MClienteDao;

public class CClienteDao {
	
	public void inserir(CCliente cliente) {
		MClienteDao dao = null;		//Contem as operacoes SQL
		boolean insercaoRealizada = false;	//Guarda resultado da insercao
		
		dao = new MClienteDao();
		insercaoRealizada = dao.inserir(cliente.getNome());
		if (insercaoRealizada)
			System.out.println("Cliente cadastrado com sucesso!");
		else
			System.out.println("Falha na inserção!");
		try { Thread.sleep(1000); } catch (Exception es) { es.printStackTrace(); }
		dao.close();
		
		
	}
	
}
