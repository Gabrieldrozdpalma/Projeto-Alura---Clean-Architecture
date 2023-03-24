package br.com.projetoAlura.escola.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.projetoAlura.escola.dominio.aluno.Telefone;

class TelefoneTest {
	
	@Test
	void naoDeveriaCriarTelefoneComDddDiferenteDe2Numeros() {
		assertThrows(NullPointerException.class,
				() -> new Telefone(null,"123456789"));
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("","123456789"));
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("1","123456789"));
	}
	
	@Test
	void naoDeveriaCriarTelefoneComQuantidadeDeDigitosDiferenteDe8ou9() {
		assertThrows(NullPointerException.class,
				() -> new Telefone( "11", null));
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone( "11", ""));
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone( "11", "12345"));
	}
	
	@Test
	void deveriaPermitirCriarTelefoneComDDDeNumeroValidos() {
		String ddd = "11";
		String numero = "123456789";
		Telefone telefone = new Telefone(ddd, numero);
		assertEquals(ddd, telefone.getDdd());
		assertEquals(numero, telefone.getNumero());
		
	}
}
