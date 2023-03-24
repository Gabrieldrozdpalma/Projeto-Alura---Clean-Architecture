package br.com.projetoAlura.escola.dominio.aluno;

public interface CifradorDeSenha {
	
	String cifrarSenha(String senha);
	
	boolean validarSenhaCifrada(String senhaCifrada, String senha);

}
