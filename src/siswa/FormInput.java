package siswa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
        mainPanel.setPreferredSize(new Dimension(400, 750));
        mainPanel.setBackground(Color.white);
        
        //************ Panel NIM ****************
        JPanel panelNim = new JPanel(new BorderLayout());
        panelNim.setPreferredSize(new Dimension(390, 25));
        panelNim.setBackground(Color.white);
        
        JLabel labelNim = new JLabel("NIM               :");
        JTextField textNim = new JTextField(30);
        panelNim.add(labelNim, BorderLayout.WEST);
        panelNim.add(textNim);
        
        //************ Panel Nama ****************
        JPanel panelNama = new JPanel(new BorderLayout());
        panelNama.setPreferredSize(new Dimension(390, 25));
        panelNama.setBackground(Color.white);
        
        JLabel labelNama = new JLabel("Nama            :");
        JTextField textNama = new JTextField(25);
        panelNama.add(labelNama, BorderLayout.WEST);
        panelNama.add(textNama);
        
        //************ Panel Prodi ****************
        JPanel panelProdi = new JPanel(new BorderLayout());
        panelProdi.setPreferredSize(new Dimension(390, 25));
        panelProdi.setBackground(Color.white);
        
        JLabel labelProdi = new JLabel("Program Studi   :");
        JTextField textProdi = new JTextField(25);
        panelProdi.add(labelProdi, BorderLayout.WEST);
        panelProdi.add(textProdi);
        
        //************ Panel Alamat ****************
        JPanel panelAlamat = new JPanel(new BorderLayout());
        panelAlamat.setPreferredSize(new Dimension(390, 25));
        panelAlamat.setBackground(Color.white);
        
        JLabel labelAlamat = new JLabel("Alamat        :");
        JTextField textAlamat = new JTextField(25);
        panelAlamat.add(labelAlamat, BorderLayout.WEST);
        panelAlamat.add(textAlamat);
        
        //************ Panel Buttons ****************
        JPanel panelButton = new JPanel(new BorderLayout());
        panelButton.setPreferredSize(new Dimension(390, 25));
        panelButton.setBackground(Color.white);
        
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        
        panelButton.add(btnAdd);
        panelButton.add(btnUpdate);
        panelButton.add(btnDelete);
        
        //************ Panel JTable ****************
        JPanel panelTab = new JPanel(null);
        String[] column = {"NIM","Nama","Alamat","Prodi"};
        DefaultTableModel dfm = new DefaultTableModel(null, column);
        JTable table = new JTable(dfm);
        JScrollPane scrollPane = new JScrollPane(table);
        panelTab.add(scrollPane);
        
        mainPanel.add(panelNim);
        mainPanel.add(panelNama);
        mainPanel.add(panelProdi);
        mainPanel.add(panelAlamat);
        mainPanel.add(panelButton);
        mainPanel.add(panelTab);
        
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
	}

}
