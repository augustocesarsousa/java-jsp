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
			String sql = "INSERT INTO usuario (login, senha) VALUES (?, ?)";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
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
			String sql = "SELECT * FROM usuario WHERE id = " + id;;
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return new Usuario(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public Usuario consultaUsuarioPorLogin(String login) {		
		try {
			String sql = "SELECT * FROM usuario WHERE login = '" + login + "'";	
			
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return new Usuario(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha")); 
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
				Usuario usuario = new Usuario(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	public void deletar(String id) {
		String sql = "DELETE FROM usuario WHERE id = " + id;
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
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
			String sql = "UPDATE usuario SET login = ?, senha = ? WHERE id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setInt(3, usuario.getId());
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
