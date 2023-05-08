package br.com.alura.rh.model;

import java.math.BigDecimal;

public class Terceirizado{

    private DadosPessoais dadosPessoais;
    private String empresa;
    
    public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario, String empresa) {
        this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
		return dadosPessoais.getNome();
	}

	public void setNome(String nome) {
		dadosPessoais.setNome(nome);
	}

	public String getCpf() {
		return dadosPessoais.getCpf();
	}

	public void setCpf(String cpf) {
		dadosPessoais.setCpf(cpf);
	}

	public Cargo getCargo() {
		return dadosPessoais.getCargo();
	}

	public void setCargo(Cargo cargo) {
		dadosPessoais.setCargo(cargo);
	}

	public BigDecimal getSalario() {
		return dadosPessoais.getSalario();
	}

	public void setSalario(BigDecimal salario) {
		dadosPessoais.setSalario(salario);
	}
}
