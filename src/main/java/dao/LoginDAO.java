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
		String sql = "SELECT * FROM usuario WHERE login = '" + login + "' AND senha  = '" + senha + "'";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			return true;
		}
		
		return false;
	}

}
