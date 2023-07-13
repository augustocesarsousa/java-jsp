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
			String sql = "INSERT INTO usuario (login, senha, nome, sobrenome, email, telefone, logradouro, numero, bairro, cidade, estado, cep, fotobase64, fotocontenttype) "
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
			preparedStatement.setString(14, usuario.getFotoContentType());
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
				return new Usuario(
						resultSet.getLong("id"), 
						resultSet.getString("login"), 
						resultSet.getString("senha"),
						resultSet.getString("nome"),
						resultSet.getString("sobrenome"),
						resultSet.getString("email"),
						resultSet.getString("telefone"),
						resultSet.getString("logradouro"),
						resultSet.getInt("numero"),
						resultSet.getString("bairro"),
						resultSet.getString("cidade"),
						resultSet.getString("estado"),
						resultSet.getString("cep"),
						resultSet.getString("fotobase64"),
						resultSet.getString("fotocontenttype"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public Usuario consultaUsuarioPorLogin(String login) {		
		try {
			String sql = "SELECT * FROM usuario WHERE login = ?";	
			
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return new Usuario(
						resultSet.getLong("id"), 
						resultSet.getString("login"), 
						resultSet.getString("senha"),
						resultSet.getString("nome"),
						resultSet.getString("sobrenome"),
						resultSet.getString("email"),
						resultSet.getString("telefone"),
						resultSet.getString("logradouro"),
						resultSet.getInt("numero"),
						resultSet.getString("bairro"),
						resultSet.getString("cidade"),
						resultSet.getString("estado"),
						resultSet.getString("cep"),
						resultSet.getString("fotobase64"),
						resultSet.getString("fotocontenttype")); 
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
				Usuario usuario = new Usuario(
						resultSet.getLong("id"), 
						resultSet.getString("login"), 
						resultSet.getString("senha"),
						resultSet.getString("nome"),
						resultSet.getString("sobrenome"),
						resultSet.getString("email"),
						resultSet.getString("telefone"),
						resultSet.getString("logradouro"),
						resultSet.getInt("numero"),
						resultSet.getString("bairro"),
						resultSet.getString("cidade"),
						resultSet.getString("estado"),
						resultSet.getString("cep"),
						resultSet.getString("fotobase64"),
						resultSet.getString("fotocontenttype"));
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
					+ "logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, fotobase64 = ?, fotocontenttype = ? WHERE id = ?";
			
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
			preparedStatement.setString(14, usuario.getFotoContentType());
			preparedStatement.setLong(15, usuario.getId());
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
}
