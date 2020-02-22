package siswa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class FormInput extends JFrame {

	private static final long serialVersionUID = -8346196873079638099L;
	
	JPanel mainPanel;
	
	public FormInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Form Input Data Mahasiswa");
		setSize(600, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //********* Main Panel **********
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(750, 950));
        mainPanel.setBackground(Color.white);
        
        //************ Panel NIM ****************
        JPanel panelNim = new JPanel(new BorderLayout());
        panelNim.setPreferredSize(new Dimension(740, 25));
        panelNim.setBackground(Color.white);
        
        JLabel labelNim = new JLabel("NIM                    :");
        JTextField textNim = new JTextField(30);
        panelNim.add(labelNim, BorderLayout.WEST);
        panelNim.add(textNim);
        
        //************ Panel Nama ****************
        JPanel panelNama = new JPanel(new BorderLayout());
        panelNama.setPreferredSize(new Dimension(740, 25));
        panelNama.setBackground(Color.white);
        
        JLabel labelNama = new JLabel("Nama                 :");
        JTextField textNama = new JTextField(25);
        panelNama.add(labelNama, BorderLayout.WEST);
        panelNama.add(textNama);
        
        //************ Panel Prodi ****************
        JPanel panelProdi = new JPanel(new BorderLayout());
        panelProdi.setPreferredSize(new Dimension(740, 25));
        panelProdi.setBackground(Color.white);
        
        JLabel labelProdi = new JLabel("Program Studi    :");
        JTextField textProdi = new JTextField(25);
        panelProdi.add(labelProdi, BorderLayout.WEST);
        panelProdi.add(textProdi);
        
        //************ Panel Alamat ****************
        JPanel panelAlamat = new JPanel(new BorderLayout());
        panelAlamat.setPreferredSize(new Dimension(740, 25));
        panelAlamat.setBackground(Color.white);
        
        JLabel labelAlamat = new JLabel("Alamat               :");
        JTextField textAlamat = new JTextField(25);
        panelAlamat.add(labelAlamat, BorderLayout.WEST);
        panelAlamat.add(textAlamat);
        
        //************ Panel Buttons ****************
        JPanel panelButton = new JPanel(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(740, 30));
        panelButton.setBackground(Color.white);
        
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        
        panelButton.add(btnAdd);
        panelButton.add(btnUpdate);
        panelButton.add(btnDelete);
        
        //************ Panel JTable ****************
        JPanel panelTab = new JPanel(new BorderLayout());
        panelTab.setPreferredSize(new Dimension(740, 100));
        
        panelTab.add(mytab(), BorderLayout.CENTER);
        
        mainPanel.add(panelNim);
        mainPanel.add(panelNama);
        mainPanel.add(panelProdi);
        mainPanel.add(panelAlamat);
        mainPanel.add(panelButton);
        mainPanel.add(panelTab);
        
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
        
        btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nim = textNim.getText();
				String nama = textNama.getText();
				String prodi = textProdi.getText();
				String alamat = textAlamat.getText();
				Koneksi koneksi = new Koneksi();
				koneksi.insert(nim, nama, prodi, alamat);
			}
		});
	}
	
	
	
	public JScrollPane mytab() {
		DefaultTableModel dfm = new DefaultTableModel();
        dfm.addColumn("NIM");
        dfm.addColumn("Nama");
        dfm.addColumn("Alamat");
        dfm.addColumn("Prodi");
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bnsp?autoreconnect=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false","root", "root");
			String sql = "SELECT * FROM siswa";
	        PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
	        ResultSet rs = st.executeQuery();
	        while (rs.next()) {
	        	String nim = rs.getString("nim");
	        	String nama = rs.getString("nama");
	        	String prodi = rs.getString("prog_studi");
	        	String alamat = rs.getString("alamat");
	        	dfm.addRow(new Object[] {nim, nama, prodi, alamat});
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        JTable table = new JTable(dfm);
        table.setBounds(100, 100, 100, 80);
        JScrollPane scrollPane = new JScrollPane(table);
		return scrollPane;
	}
	

}
