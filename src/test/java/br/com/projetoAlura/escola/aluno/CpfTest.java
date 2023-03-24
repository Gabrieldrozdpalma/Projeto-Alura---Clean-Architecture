package br.com.projetoAlura.escola.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.projetoAlura.escola.dominio.aluno.Cpf;

class CpfTest {

	@Test
	void naoDeveriaCriarCPFComNumerosInvalidos() {
		assertThrows(IllegalArgumentException.class,
				() -> new Cpf(null));
		assertThrows(IllegalArgumentException.class,
				() -> new Cpf(""));
		assertThrows(IllegalArgumentException.class,
				() -> new Cpf("123456789000"));
	}

}
