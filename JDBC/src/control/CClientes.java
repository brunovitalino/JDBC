package control;

import java.sql.Connection;
import java.sql.ResultSet;
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
	
	public void listar() {
		MClienteDao dao = new MClienteDao();	//Contem as operacoes SQL
		ResultSet rs = null;
		
		rs = dao.listar();
		
		if (rs==null)
			System.out.println("Dados nulos.");
		else
			try {
				while (rs.next()) {
					System.out.println("ID:   " + rs.getString("id") + "\n" +
									   "Nome: " + rs.getString("nome") + "\n");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		dao.close();
	}
	
}
