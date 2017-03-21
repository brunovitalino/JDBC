package view;

import java.sql.*;
import java.util.Scanner;
import control.CClientes;

public class Main
{
	
	public static void main(String[] args)
	{
		Scanner entrada = new Scanner(System.in);
		CClientes clientes = new CClientes();
		int op = 0;
		
		do
		{
			System.out.print("Selecione uma opcao (1-listar 2-cadastrar 0-sair): ");
			op = entrada.nextInt();
			
			switch(op)
			{
				case 0:
					System.out.println("Encerrando programa...");
					break;
				case 1:
					clientes.listar();
					break;
				case 2:
					System.out.println("Digite o nome do cliente: ");
					clientes.inserir(entrada.nextLine());				
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
