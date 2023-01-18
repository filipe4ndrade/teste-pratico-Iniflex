package br.com.iniflex.application;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.iniflex.entities.Funcionario;

public class Program {

	public static void main(String[] args) {
	
		
		double number = 1234567.89;
		NumberFormat formatterNum = NumberFormat.getInstance(new Locale("pt", "BR"));
		formatterNum .setMaximumFractionDigits(2);

		// 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela
		// acima.

		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios.add(new Funcionario("Maria", "18/10/2000", new BigDecimal("2009.44"), "Operador"));
		funcionarios.add(new Funcionario("João", "12/05/1990", new BigDecimal("2284.38"), "Operador"));
		funcionarios.add(new Funcionario("Caio", "02/05/1961", new BigDecimal("9836.14"), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", "14/10/1988", new BigDecimal("19119.88"), "Diretor"));
		funcionarios.add(new Funcionario("Alice", "05/01/1995", new BigDecimal("2234.68"), "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", "19/11/1999", new BigDecimal("1582.72"), "Operador"));
		funcionarios.add(new Funcionario("Arthur", "31/03/1993", new BigDecimal("4071.84"), "Contador"));
		funcionarios.add(new Funcionario("Laura", "08/07/1994", new BigDecimal("3017.45"), "Gerente"));
		funcionarios.add(new Funcionario("Heloisa", "24/05/2003", new BigDecimal("1606.85"), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", "02/09/1996", new BigDecimal("2799.93"), "Gerente"));

		// 3.2 – Remover o funcionário “João” da lista.
		funcionarios.removeIf(x -> x.getNome() == "João");

		// 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
		// • informação de data deve ser exibido no formato dd/mm/aaaa;
		// • informação de valor numérico deve ser exibida no formatado com separador de
		// milhar como ponto e decimal como vírgula.

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
		System.out.println();
		// 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista
		// de funcionários com novo valor.
		for (Funcionario funcionario : funcionarios) {
			funcionario.setSalario(funcionario.getSalario().multiply(new BigDecimal("1.1")));
		}
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}

	}

}
