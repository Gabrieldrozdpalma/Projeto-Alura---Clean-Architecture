package br.com.projetoAlura.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.projetoAlura.escola.dominio.aluno.Aluno;
import br.com.projetoAlura.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.projetoAlura.escola.dominio.aluno.Cpf;
import br.com.projetoAlura.escola.dominio.aluno.Email;
import br.com.projetoAlura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.projetoAlura.escola.dominio.aluno.Telefone;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {
	
	private final Connection connection;
	
	public RepositorioDeAlunosComJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void matricular(Aluno aluno) {
		String sql = "INSERT INTO ALUNO VALUES (?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();
			
			sql = "INSERT INTO TELEFONE VALUES(?,?)";
			ps=connection.prepareStatement(sql);
			for(Telefone telefone: aluno.getTelefones()) {
				ps.setString(1, telefone.getDdd());
				ps.setString(2, telefone.getNumero());
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}

	@Override
	public Aluno buscarPorCpf(Cpf cpf) {
		String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
		try {
		PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumero());
			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			if(!encontrou) {
				throw new AlunoNaoEncontrado(cpf);
			}
			String nome = rs.getString("nome");
			Email email = new Email(rs.getString("email"));
			Aluno encontrado = new Aluno(cpf,nome,email);
			
			Long id = rs.getLong("id");
			sql = "SELECT ddd, numero FROM TELEOFNE WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				String numero = rs.getString("numero");
				String ddd = rs.getString("ddd");
				encontrado.adicionarTelefone(ddd, numero);
			}
			return encontrado;
		} catch (SQLException e) {
		}
		return null;
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		// TODO Auto-generated method stub
		return null;
	}

}
