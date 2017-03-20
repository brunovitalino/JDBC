package view;

import java.sql.*;
import java.util.Scanner;
import control.CCliente;
import control.COperacoesSQL;

public class Main
{
	public static void main(String[] args)
	{
		CCliente cliente = new CCliente();
		Scanner entrada = new Scanner(System.in);
		COperacoesSQL db = new COperacoesSQL();
		
		System.out.print("Digite o nome do cliente: ");
		cliente.setNome(entrada.nextLine());
		db.inserir(cliente);
	}
}
