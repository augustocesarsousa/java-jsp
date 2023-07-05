package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
