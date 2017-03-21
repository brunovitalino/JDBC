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
					System.out.println("ENCERRANDO PROGRAMA...");
					break;
				case 1:
					System.out.println("PESQUISANDO CLIENTE");
					System.out.println("Nome: ");
					//clientes.pesquisar(entrada.nextLine());
					break;
				case 2:
					System.out.println("ADICIONANDO NOVO CLIENTE");
					System.out.println("Nome: ");
					clientes.inserir(entrada.nextLine());				
					break;
				case 3:
					System.out.println("ALTERANDO CLIENTE");
					System.out.println("Nome: ");
					clientes.inserir(entrada.nextLine());				
					break;
				case 4:
					System.out.println("REMOVENDO CLIENTE");
					System.out.println("Nome: ");
					clientes.inserir(entrada.nextLine());				
					break;
				case 5:
					System.out.println("LISTANDO CLIENTES");
					clientes.listar();
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
