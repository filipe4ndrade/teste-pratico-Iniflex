package br.com.iniflex.entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Funcionario extends Pessoa {
	DecimalFormat formatter = new DecimalFormat("#,##0.00");

	private BigDecimal salario;
	private String funcao;

	public Funcionario() {

	}

	public Funcionario(String nome, String dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale("pt", "BR")));
		return "Nome= " + getNome() + ", DatadeNascimento= " + getDataNascimento() + ", Salario= R$ "
				+ formatter.format(salario) + ", Função= " + funcao;
	}

}
