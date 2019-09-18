package Views;

import java.awt.*;
import javax.swing.*;
import Components.JMultiDataBox;

public class AddToCorralView extends JPanel{

	private JMultiDataBox TxtBreedingId;
	private JMultiDataBox TxtBreedingWeight;
	private JMultiDataBox TxtBreedingFat;
	private JMultiDataBox TxtBreedingMuscleColor;
	private JMultiDataBox TxtBreedingEntryDate;
	private JButton BtnGuardar, BtnLimpiar;
	
	public AddToCorralView() {
		super(new BorderLayout());
		InitializeComponents();
	}

	private void InitializeComponents() {
		TxtBreedingId = new JMultiDataBox("");
		TxtBreedingWeight = new JMultiDataBox("");
		TxtBreedingFat = new JMultiDataBox("");
		TxtBreedingMuscleColor = new JMultiDataBox("");
		TxtBreedingEntryDate = new JMultiDataBox("");
		BtnGuardar = new JButton("Aceptar");
		BtnLimpiar = new JButton("Limpiar");
		createNortPane();
		createCenterPane();
		createSouthPane();
	}
	
	private void createNortPane() {
		JLabel lblTitle = new JLabel("Alta de Cuentas");
		lblTitle.setFont(new Font("Tahoma", 0, 24));
		add(lblTitle,BorderLayout.NORTH);
	}
	
	private void createCenterPane(){
		JPanel center = new JPanel(new GridLayout(0,2,20,60));
		
		JLabel id = new JLabel("ID Cria:");
		JLabel peso = new JLabel("Peso:");
		JLabel grasa = new JLabel("Grasa:");
		JLabel cMusculo = new JLabel("Color de musculo:");
		JLabel fIngreso = new JLabel("Fecha Ingreso:");
		
		id.setHorizontalAlignment(SwingConstants.RIGHT);
		peso.setHorizontalAlignment(SwingConstants.RIGHT);
		grasa.setHorizontalAlignment(SwingConstants.RIGHT);
		cMusculo.setHorizontalAlignment(SwingConstants.RIGHT);
		fIngreso.setHorizontalAlignment(SwingConstants.RIGHT);
		
		center.add(id);
		center.add(TxtBreedingId);
		center.add(peso);
		center.add(TxtBreedingWeight);
		center.add(grasa);
		center.add(TxtBreedingFat);
		center.add(cMusculo);
		center.add(TxtBreedingMuscleColor);
		center.add(fIngreso);
		center.add(TxtBreedingEntryDate);
		
		center.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(center,BorderLayout.CENTER);
	}
	
	private void createSouthPane(){
		JPanel south = new JPanel();
		south.add(BtnGuardar);
		south.add(BtnLimpiar);
		add(south,BorderLayout.SOUTH);
	}
	
}
