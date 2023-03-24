package br.com.projetoAlura.escola.dominio.aluno;

public class Telefone {
	//VALUE OBJECT
	private String ddd;
	private String numero;
	
	public Telefone(String ddd, String numero) {
		//validacao
		if(numero == null || numero == null) {
			throw new NullPointerException("DDD e numero são obrigatórios");
		}
		
		if(!ddd.matches("\\d{2}")) {
			throw new IllegalArgumentException("DDD inválido");
		}
		
		if(!numero.matches("\\d{8}|\\d{9}")) {
			throw new IllegalArgumentException("Numero inválido");
		}
			
		this.ddd = ddd;
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

}
