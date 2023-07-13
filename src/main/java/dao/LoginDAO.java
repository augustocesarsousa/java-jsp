package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class LoginDAO {
	
	private Connection conn;
	
	public LoginDAO() {
		conn = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(String login, String senha) throws Exception {
		String sql = "SELECT * FROM usuario WHERE login = ? AND senha  = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, login);
		preparedStatement.setString(2, senha);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			return true;
		}
		
		return false;
	}

}
