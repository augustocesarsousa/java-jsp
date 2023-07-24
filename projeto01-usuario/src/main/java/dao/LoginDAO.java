package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;

public class LoginDAO {
	
	private Connection conn;
	
	public LoginDAO() {
		conn = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(String login, String senha) {
		String sql = "SELECT id FROM usuario WHERE login = ? AND senha  = ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, senha);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}

}
