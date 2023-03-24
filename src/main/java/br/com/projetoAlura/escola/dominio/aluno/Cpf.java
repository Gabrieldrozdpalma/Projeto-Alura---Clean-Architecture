package br.com.projetoAlura.escola.dominio.aluno;

public class Cpf {
	
	private String numero;

	public Cpf(String numero) {
		//validaçao
		if(numero == null ||
				!numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new IllegalArgumentException("CPF Inválido");
		}
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	

}
