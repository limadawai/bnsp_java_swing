package siswa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void insert(String nim, String nama, String prodi, String alamat) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bnsp?autoreconnect=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false","root", "root");
			String sql = "INSERT INTO siswa(nim, nama, prog_studi, alamat) VALUES(?, ?, ?, ?)";
	        PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
	        st.setString(1, nim);
	        st.setString(2, nama);
	        st.setString(3, prodi);
	        st.setString(4, alamat);
	        st.execute();
	        connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void update(String nama, String prodi, String alamat, String nim) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bnsp?autoreconnect=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false","root", "root");
			String sql = "UPDATE siswa set nama = ?, prog_studi = ?, alamat = ? WHERE nim = ?";
	        PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
	        st.setString(1, nama);
	        st.setString(2, prodi);
	        st.setString(3, alamat);
	        st.setString(4, nim);
	        st.execute();
	        connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bnsp?autoreconnect=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false","root", "root");
			String sql = "DELETE FROM siswa WHERE nim = ?";
	        PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
	        st.setString(1, id);
	        st.executeUpdate();
	        connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
