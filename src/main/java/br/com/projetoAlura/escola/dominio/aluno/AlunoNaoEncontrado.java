package br.com.projetoAlura.escola.dominio.aluno;

public class AlunoNaoEncontrado extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public AlunoNaoEncontrado(Cpf cpf) {
		super("Aluno não encontrado com CPF: " + cpf.getNumero());
	}

}
