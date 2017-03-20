package view;

import java.sql.*;
import control.COperacoesSQL;

public class Main
{
	public static void main(String[] args)
	{
		String nome = "Mvc";
		COperacoesSQL operacoes = new COperacoesSQL();
		operacoes.inserir(nome);
	}
}
