package siswa;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                login.windowlogin();
            }
        });
		
	}

}
