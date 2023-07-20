package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import connection.SingleConnection;

public class UsuarioDAO {
	
	private Connection conn;

	public UsuarioDAO() {
		conn = SingleConnection.getConnection();
	}
	
	public void cadastrar(Usuario usuario) {
		try {
			String sql = "INSERT INTO usuario (login, senha, nome, sobrenome, email, telefone, logradouro, numero, bairro, cidade, estado, cep, fotobase64, fotominiaturabase64, curriculobase64) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setString(3, usuario.getNome());
			preparedStatement.setString(4, usuario.getSobrenome());
			preparedStatement.setString(5, usuario.getEmail());
			preparedStatement.setString(6, usuario.getTelefone());
			preparedStatement.setString(7, usuario.getLogradouro());
			preparedStatement.setInt(8, usuario.getNumero());
			preparedStatement.setString(9, usuario.getBairro());
			preparedStatement.setString(10, usuario.getCidade());
			preparedStatement.setString(11, usuario.getEstado());
			preparedStatement.setString(12, usuario.getCep());
			preparedStatement.setString(13, usuario.getFotoBase64());
			preparedStatement.setString(14, usuario.getFotoMiniaturaBase64());
			preparedStatement.setString(15, usuario.getCurriculoBase64());
			preparedStatement.setBoolean(16, usuario.getTemCurriculo());
			preparedStatement.execute();	
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public Usuario consultaUsuarioPorId(String id) {
		try {
			String sql = "SELECT * FROM usuario WHERE id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(id));
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getLong("id"));
				usuario.setLogin(resultSet.getString("login"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setSobrenome(resultSet.getString("sobrenome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setLogradouro(resultSet.getString("logradouro"));
				usuario.setNumero(resultSet.getInt("numero"));
				usuario.setBairro(resultSet.getString("bairro"));
				usuario.setCidade(resultSet.getString("cidade"));
				usuario.setEstado(resultSet.getString("estado"));
				usuario.setCep(resultSet.getString("cep"));
				return usuario;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public Usuario consultaUsuarioPorLogin(String login) {		
		try {
			String sql = "SELECT id FROM usuario WHERE login = ?";	
			
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getLong("id"));
				return usuario; 
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = "SELECT * FROM usuario ORDER BY id";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getLong("id"));
				usuario.setLogin(resultSet.getString("login"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setSobrenome(resultSet.getString("sobrenome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setLogradouro(resultSet.getString("logradouro"));
				usuario.setNumero(resultSet.getInt("numero"));
				usuario.setBairro(resultSet.getString("bairro"));
				usuario.setCidade(resultSet.getString("cidade"));
				usuario.setEstado(resultSet.getString("estado"));
				usuario.setCep(resultSet.getString("cep"));
				usuario.setFotoMiniaturaBase64(resultSet.getString("fotominiaturabase64"));
				usuario.setTemCurriculo(resultSet.getBoolean("temcurriculo"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	public void deletar(String id) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(id));
			preparedStatement.execute();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void update(Usuario usuario) {
		try {
			String sql = "UPDATE usuario SET login = ?, senha = ?, nome = ?, sobrenome = ?, email = ?, telefone = ?, "
					+ "logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, fotobase64 = ?, "
					+ "fotominiaturabase64 = ?, curriculobase64 = ?, temcurriculo = ? WHERE id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setString(3, usuario.getNome());
			preparedStatement.setString(4, usuario.getSobrenome());
			preparedStatement.setString(5, usuario.getEmail());
			preparedStatement.setString(6, usuario.getTelefone());
			preparedStatement.setString(7, usuario.getLogradouro());
			preparedStatement.setInt(8, usuario.getNumero());
			preparedStatement.setString(9, usuario.getBairro());
			preparedStatement.setString(10, usuario.getCidade());
			preparedStatement.setString(11, usuario.getEstado());
			preparedStatement.setString(12, usuario.getCep());
			preparedStatement.setString(13, usuario.getFotoBase64());
			preparedStatement.setString(14, usuario.getFotoMiniaturaBase64());
			preparedStatement.setString(15, usuario.getCurriculoBase64());
			preparedStatement.setBoolean(16, usuario.getTemCurriculo());
			preparedStatement.setLong(17, usuario.getId());
			preparedStatement.executeUpdate();	
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
	}
	
	public String consultaFoto(Long id) {	
		String foto = null;
		try {
			String sql = "SELECT fotobase64 FROM usuario WHERE id = ?";	
			
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				foto = resultSet.getString("fotobase64"); 
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foto;		
	}
	
	public String consultaCurriculo(Long id) {	
		String curriculo = null;
		try {
			String sql = "SELECT curriculobase64 FROM usuario WHERE id = ?";	
			
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				curriculo = resultSet.getString("curriculobase64"); 
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curriculo;		
	}
}
