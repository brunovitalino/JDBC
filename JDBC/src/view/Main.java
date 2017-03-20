package view;

import java.sql.*;
import java.util.Scanner;
import control.CCliente;
import control.CClienteDao;

public class Main
{
	public static void main(String[] args)
	{
		CCliente cliente = new CCliente();
		Scanner entrada = new Scanner(System.in);
		CClienteDao db = new CClienteDao();
		
		System.out.print("Digite o nome do cliente: ");
		cliente.setNome(entrada.nextLine());
		db.inserir(cliente);
	}
}
