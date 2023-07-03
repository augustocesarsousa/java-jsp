package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static final String banco = "jdbc:postgresql://localhost:5432/postgres?autoReconnect=true";
	private static final String user = "postgres";
	private static final String password = "postgres123";
	private static Connection conn = null;
	
	static {
		conectar();
	}

	public SingleConnection() {
		conectar();
	}	
	
	private static void conectar() {
		try {
			if(conn == null) {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(banco, user, password);
			}
		} catch(Exception e) {
			throw new RuntimeException("Erro ao conectar ao banco");
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}

}
