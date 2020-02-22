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
	        ResultSet rs = st.executeQuery();
	        connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> record() {
		List result = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bnsp?autoreconnect=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false","root", "root");
			String sql = "SELECT * FROM siswa";
	        PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
	        ResultSet rs = st.executeQuery();
	        while (rs.next()) {
	        	String nim = rs.getString("nim");
	        	String nama = rs.getString("nama");
	        	String prodi = rs.getString("prog_studi");
	        	String alamat = rs.getString("alamat");
	        	result.add(nim);
	        	result.add(nama);
	        	result.add(prodi);
	        	result.add(alamat);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (ArrayList<String>) result;
	}

}
