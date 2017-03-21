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
		int op = 0;
		
		do
		{
			System.out.print("Selecione uma opcao valida (1-listar 2-cadastrar 0-sair): ");
			op = entrada.nextInt();
			
			switch(op)
			{
				case 0:
					System.out.println("Encerrando programa...");
					break;
				case 1:
					db.listar();
					break;
				case 2:
					System.out.println("Digite o nome do cliente: ");
					cliente.setNome(entrada.nextLine());
					db.inserir(cliente);				
					break;
				default:
					System.out.println("Opcao invalida.\n");
					break;
			}			
		}
		while(op!=0);
		
		System.out.println("Programa encerrado.");		
	}
}
