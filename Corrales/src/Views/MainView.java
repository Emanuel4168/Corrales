package Views;

import javax.swing.*;

public class MainView extends JFrame{

	
	private MainView() {
		super("Cuentas Contables");
		setSize(600,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainView();
	}

}
