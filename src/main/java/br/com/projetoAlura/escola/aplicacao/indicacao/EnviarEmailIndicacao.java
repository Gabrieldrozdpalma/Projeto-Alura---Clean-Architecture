package br.com.projetoAlura.escola.aplicacao.indicacao;

import br.com.projetoAlura.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
	
	void enviarPara(Aluno indicado);

}
