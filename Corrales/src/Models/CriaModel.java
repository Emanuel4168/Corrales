package Models;

import java.sql.Statement;

import Utils.SQLConnectionHelper;
import ViewModels.Cria;

public class CriaModel {

	private Statement connHelper;
	
	public CriaModel() {
		connHelper = SQLConnectionHelper.getConexion();
	}
	
	public boolean doInsert(Cria cria) {
		String statement = "insert into Crias values (CriaID ="+cria.getIdCria()+",FechaEntrada ="+cria.getEntryDate()+",Grasa ="+cria.getFat()+",Peso ="+cria.getWeigth()+",ColorMusculo ="+cria.getMusculeColor()+",ClasificacionID ="+cria.GetClasificationPerAtributes()+",CorralID = "+cria.getIdCorral()+")";
		return false;
	}
	
}
