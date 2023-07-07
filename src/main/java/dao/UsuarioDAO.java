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
	
	public boolean cadastrar(Usuario usuario) {
		try {
			String sql = "INSERT INTO usuario (login, senha) VALUES (?, ?)";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.execute();	
			
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
		return false;
	}
	
	public Usuario consultaUsuario(String id) throws Exception {
		String sql = "SELECT * FROM usuario WHERE id = " + id;;
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			return new Usuario(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha"));
		}
		
		return null;
	}
	
	public List<Usuario> listar() throws Exception {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = "SELECT * FROM usuario ORDER BY id";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			Usuario usuario = new Usuario(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha"));
			usuarios.add(usuario);
		}
		
		return usuarios;
	}
	
	public boolean deletar(String id) {
		String sql = "DELETE FROM usuario WHERE id = " + id;
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.execute();
			conn.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return false;
	}
	
	public boolean update(Usuario usuario) {
		try {
			String sql = "UPDATE usuario SET login = ?, senha = ? WHERE id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setInt(3, usuario.getId());
			preparedStatement.executeUpdate();	
			
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
		return false;
	}
}
