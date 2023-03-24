package br.com.projetoAlura.escola.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.projetoAlura.escola.dominio.aluno.Email;

class EmailTest {

	@Test
	void naoDeveriaCriarEmailComEnderecoNulo() {
		assertThrows(IllegalArgumentException.class,
				() -> new Email(null));
	}
	
	@Test
	void naoDeveriaCriarEmailComEnderecoVazio() {
		assertThrows(IllegalArgumentException.class,
				() -> new Email(""));
	}
	
	@Test
	void naoDeveriaCriarEmailComEnderecoInvalido() {
		assertThrows(IllegalArgumentException.class,
				() -> new Email("emailinvalido"));
	}

}
