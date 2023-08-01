package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import entities.Usuario;

public class UsuarioDAO {	
	private Connection conn;

	public UsuarioDAO() {
		conn = SingleConnection.getConnection();
	}

	public List<Usuario> getAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();		
		
		String sql = "SELECT id, nome, sobrenome, email, telefone FROM usuario ORDER BY id";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getLong("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setSobrenome(resultSet.getString("sobrenome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
}
