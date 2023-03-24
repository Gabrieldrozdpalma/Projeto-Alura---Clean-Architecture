package br.com.projetoAlura.escola.infra.indicacao;

import br.com.projetoAlura.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.projetoAlura.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao{

	@Override
	public void enviarPara(Aluno indicado) {
		//logica de envio de email com a lib Java Mail
		
	}

}
