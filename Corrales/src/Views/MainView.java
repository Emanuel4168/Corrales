package Views;

import java.util.List;

import javax.swing.*;

import Utils.IObserver;
import Utils.ObserverParam;

public class MainView extends JFrame implements IObserver{

	private JTabbedPane mainMenu;
	private InsertView insertView;
	
	private MainView() {
		super("Corrales");
		setSize(600,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainMenu = new JTabbedPane();
		insertView = new InsertView();
		insertView.AddObserver(this);
		mainMenu.addTab("Alta de Crias",insertView);
		add(mainMenu);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainView();
	}

	@Override
	public void Update(List<ObserverParam> params) {
		int width = (int)params.get(0).content;
		int heigth = (int)params.get(1).content;
		
		this.setSize(width,heigth);
	}


}
