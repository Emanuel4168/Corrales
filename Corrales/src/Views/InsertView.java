package Views;

import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import Components.JMultiDataBox;
import Utils.*;
import ViewModels.BuilderFactory;
import ViewModels.IBuilder;
import ViewModels.PropertyListItem;

public class InsertView extends JPanel implements ActionListener,IObservable{

	private static final int[] heigthValues = {500,250}; 
	
	private LinkedList<JMultiDataBox> fields; 
	private JComboBox<String> CmbInsertCombo;
	private JButton BtnGuardar, BtnLimpiar;
	private IBuilder builder;
	private boolean firstTime;
	private LinkedList<IObserver> observers;

	public InsertView() {
		super(new BorderLayout());
		observers = new LinkedList<IObserver>();
		firstTime = true;
		InitializeComponents();
	}

	private void InitializeComponents() {
		fields = new LinkedList<>();

		BtnGuardar = new JButton("Aceptar");
		BtnLimpiar = new JButton("Limpiar");
		createNortPane();
		createCenterPane();
		createSouthPane();
	}

	private void createNortPane() {
		JPanel northPanel = new JPanel();
		JLabel lblTitle = new JLabel("Insercion de:");
		lblTitle.setFont(new Font("Tahoma", 0, 24));

		CmbInsertCombo = new JComboBox<>();
		CmbInsertCombo.addActionListener(this);
		CmbInsertCombo.addItem("Cria");
		CmbInsertCombo.addItem("Corral");

		northPanel.add(lblTitle);
		northPanel.add(CmbInsertCombo);

		add(northPanel, BorderLayout.NORTH);

	}

	public void createCenterPane(){
		BorderLayout layout = (BorderLayout)getLayout();
		Component centerComponent = layout.getLayoutComponent(BorderLayout.CENTER);
		if(centerComponent != null)
			remove(centerComponent);

		
		fields = new LinkedList<>();
		JPanel center = new JPanel(new GridLayout(0,2,20,60));
		
		builder = BuilderFactory.getBuilder(CmbInsertCombo.getSelectedIndex());
		java.util.List<PropertyListItem> properties = builder.getProperties();
		
		
		for(PropertyListItem prop: properties) {
			String a = prop.getName();
			System.out.println(a);
			JLabel auxlbl = new JLabel(prop.getName());
			auxlbl.setHorizontalAlignment(SwingConstants.RIGHT);
			JMultiDataBox auxbox = new JMultiDataBox(prop.getRegEx());

			fields.add(auxbox);

			center.add(auxlbl);
			center.add(auxbox);
		}

		center.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(center,BorderLayout.CENTER);
		
	}

	private void createSouthPane(){
		JPanel south = new JPanel();
		south.add(BtnGuardar);
		south.add(BtnLimpiar);
		add(south,BorderLayout.SOUTH);
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
		int Index = box.getSelectedIndex();
		int input = JOptionPane.showConfirmDialog(null, "La informacion se perdera");
		// 0=yes, 1=no, 2=cancel
		//System.out.println(originalIndex);
		if(input > 0){
			
			return;
		}	
		createCenterPane();
		UpdateObservers(Index);


	}

	private void listenButtons() {

	}

	public boolean isFirstTime() {
		return firstTime;
	}

	public void setFirstTime(boolean firstTime) {
		this.firstTime = firstTime;
	}

	@Override
	public boolean AddObserver(IObserver observer) {
		return this.observers.add(observer);
	}

	@Override
	public boolean RemoveObserver(IObserver observer) {
		return this.observers.remove(observer);
	}
	
	private void UpdateObservers(int cmbPos) {
		LinkedList<ObserverParam> params = new LinkedList<>();
		int newHeight = heigthValues[cmbPos];
		System.out.println(newHeight);
		params.add(new ObserverParam(600));
		params.add(new ObserverParam(newHeight));
		this.observers.forEach(o -> o.Update(params));
//		for(IObserver observer : observers) {
//			observer.Update(params);
//		}
	}
	

}
