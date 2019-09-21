package ViewModels;

public class BuilderFactory {
	
	public final static int CRIA_BUILDER = 0;
	public final static int CORRAL_BUILDER = 1;
	
	public static IBuilder getBuilder(int type) {
		switch(type) {
		case CRIA_BUILDER:
			break;
		case CORRAL_BUILDER:
			break;
		}
		return null;
	}

}
