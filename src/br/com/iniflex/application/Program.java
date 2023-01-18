package br.com.iniflex.application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.iniflex.entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		DecimalFormat formatter = new DecimalFormat("#,##0.00");

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

		// 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista
		// de funcionários com novo valor.
		for (Funcionario funcionario : funcionarios) {
			funcionario.setSalario(funcionario.getSalario().multiply(new BigDecimal("1.1")));
		}
		System.out.println();
		// 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função”
		// e o valor a “lista de funcionários”.

		Map<String, List<Funcionario>> map = new HashMap<>() {
			{

				put("Operador", funcionarios.stream().filter(x -> x.getFuncao().equals("Operador"))
						.collect(Collectors.toList()));
				put("Coordenador", funcionarios.stream().filter(x -> x.getFuncao().equals("Coordenador"))
						.collect(Collectors.toList()));
				put("Diretor", funcionarios.stream().filter(x -> x.getFuncao().equals("Diretor"))
						.collect(Collectors.toList()));
				put("Recepcionista", funcionarios.stream().filter(x -> x.getFuncao().equals("Recepcionista"))
						.collect(Collectors.toList()));
				put("Contador", funcionarios.stream().filter(x -> x.getFuncao().equals("Contador"))
						.collect(Collectors.toList()));
				put("Gerente", funcionarios.stream().filter(x -> x.getFuncao().equals("Gerente"))
						.collect(Collectors.toList()));
				put("Eletricista", funcionarios.stream().filter(x -> x.getFuncao().equals("Eletricista"))
						.collect(Collectors.toList()));

			}
		};

		// 3.6 – Imprimir os funcionários, agrupados por função.
		map.forEach((key, value) -> System.out.println("Função: " + key + ", Lista de Funcionários: " + value));
		System.out.println();
		// 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.

		funcionarios.stream()
				.filter(x -> x.getDataNascimento().getMonthValue() == 10 || x.getDataNascimento().getMonthValue() == 12)
				.forEach(x -> System.out.println(x));
		System.out.println();

		// 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e
		// idade.
		//método min, pois retorna o menor ano
		Funcionario maiorIdade = funcionarios.stream()
				.min((e1, e2) -> e1.getDataNascimento().compareTo(e2.getDataNascimento())).orElse(null);

		LocalDate hoje = LocalDate.now();
		
		//Método between de Period, Retorna a diferença, em anos, entre dois LocalDates
		Period idade = Period.between(maiorIdade.getDataNascimento(), hoje);
		System.out.println(
				"Funcionário com maior idade: " + maiorIdade.getNome() + ", idade: " + idade.getYears() + " anos");
		System.out.println();
		//3.10 – Imprimir a lista de funcionários por ordem alfabética.
		funcionarios.stream()
		
	    .sorted((e1, e2) -> e1.getNome().compareTo(e2.getNome()))
	    .forEach(e -> System.out.println(e));
		System.out.println();
		
		//3.11 – Imprimir o total dos salários dos funcionários.
		BigDecimal totalSalario = funcionarios.stream()
	    .map(Funcionario::getSalario)
	    .reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("Soma dos salários: R$ " + formatter.format(totalSalario));
		System.out.println();
		
		//3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
		BigDecimal salarioMinimo = new BigDecimal("1212.00");
		
		for (Funcionario funcionario : funcionarios) {
		    BigDecimal salarioFuncionario = funcionario.getSalario();
		    BigDecimal salariosMinimo = salarioFuncionario.divide(salarioMinimo,2, RoundingMode.HALF_UP);
		    System.out.println(funcionario.getNome() + " ganha " + salariosMinimo + " salários mínimos");
		}


		
	}

}
