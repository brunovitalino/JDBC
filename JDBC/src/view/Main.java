package view;

import java.sql.*;
import java.util.Scanner;
import control.CClientes;

public class Main
{
	
	public static void main(String[] args)
	{
		String nome = "";
		Scanner entrada = new Scanner(System.in);
		CClientes clientes = new CClientes();
		int op = 0;
		

		do
		{
			System.out.print("Selecione uma opcao (1-pesquisar 2-cadastrar 3-alterar 4-remover 5-listar 0-sair): ");
			op = entrada.nextInt();
			entrada.nextLine();
			System.out.println();
			
			switch(op)
			{
				case 0:
					System.out.println("ENCERRANDO PROGRAMA...\n");
					break;
				case 1:
					System.out.println("PESQUISANDO CLIENTE\n");
					System.out.print("Nome: ");
					clientes.pesquisar(entrada.nextLine());
					break;
				case 2:
					System.out.println("CADASTRANDO NOVO CLIENTE\n");
					System.out.print("Nome: ");
					clientes.inserir(entrada.nextLine());				
					break;
				case 3:
					System.out.println("ALTERANDO CLIENTE\n");
					System.out.print("Digite o nome do cliente a ser alterado: ");
					nome = entrada.nextLine();
					System.out.print("Digite o novo nome: ");
					String nomeNovo = entrada.nextLine();
					clientes.alterar2(nome, nomeNovo);
					break;
				case 4:
					System.out.println("REMOVENDO CLIENTE\n");
					System.out.print("Nome: ");
					//clientes.remover(entrada.nextLine());				
					break;
				case 5:
					System.out.println("LISTANDO CLIENTES\n");
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
