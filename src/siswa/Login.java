package siswa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	JPanel panel;

	public void windowlogin () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Window Login");
		setSize(400, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //********* JPanel **********
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 450));
        panel.setBackground(Color.white);
        
        //********* Component Username **********
        JPanel userPanel = new JPanel();
        userPanel.setPreferredSize(new Dimension(390, 30));
        userPanel.setBackground(Color.white);
        
        JLabel label_username = new JLabel("Username : ");
        JTextField text_username = new JTextField(20);    
        userPanel.add(label_username);
        userPanel.add(text_username);
        
      //********* Component Password **********
        JPanel passPanel = new JPanel();
        passPanel.setPreferredSize(new Dimension(390, 30));
        passPanel.setBackground(Color.white);
        
        JLabel label_password = new JLabel("Password : ");
        JPasswordField text_password = new JPasswordField(20);
        passPanel.add(label_password);
        passPanel.add(text_password);
        
      //********* Component Button **********
        JPanel btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(390, 50));
        btnPanel.setBackground(Color.white);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setPreferredSize(new Dimension(380, 40));
        btnPanel.add(btnLogin);
        
        panel.add(userPanel, BorderLayout.LINE_START);
        panel.add(passPanel, BorderLayout.AFTER_LAST_LINE);
        panel.add(btnPanel, BorderLayout.SOUTH);
        
      //********* Add JPanel ke dalam Frame **********
        add(panel, BorderLayout.CENTER); // Panggil JPanel ke Frame utama
        setVisible(true);
	}

}
