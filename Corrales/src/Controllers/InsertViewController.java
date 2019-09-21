package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Models.ISQLModel;
import Models.ModelFactory;
import Views.InsertView;

public class InsertViewController implements ActionListener{

	private InsertView view;
	private ISQLModel model;
	private boolean firstTime = true;
	
	public InsertViewController(InsertView view, int type) {
		this.view = view;
		model = ModelFactory.getModel(type);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() instanceof JComboBox ) {
			listenCombos(evt);
			return;
		}
		if(evt.getSource() instanceof JButton) {
			listenButtons();
			return;
		}
	}

	private void listenCombos(ActionEvent evt) {
		if(firstTime) {
			firstTime = false;
			return;
		}
		
		JComboBox box = (JComboBox) evt.getSource();
		int originalIndex = box.getSelectedIndex();
		int input = JOptionPane.showConfirmDialog(null, "La informacion se perdera");
		// 0=yes, 1=no, 2=cancel
		System.out.println(originalIndex);
		if(input > 0){
			
			return;
		}
		//createCenterPane();

	}

	private void listenButtons() {

	}


}
