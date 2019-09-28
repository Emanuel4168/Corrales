package Utils;

public interface IObservable {
	
	public boolean AddObserver(IObserver observer);
	public boolean RemoveObserver(IObserver observer);
	
	//public void UpdateObservers();

}
