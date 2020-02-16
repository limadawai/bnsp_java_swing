package siswa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Koneksi {
	
	Connection connection;
	
	public boolean masuk(String username, String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bnsp?autoreconnect=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false","root", "root");
			String sql = "SELECT username, password FROM user WHERE username=? AND password=?";
	        PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
	        st.setString(1, username);
	        st.setString(2, password);
	        ResultSet rs = st.executeQuery();
	        if (rs.next()) {
	            return true;
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

}
