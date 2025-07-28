package client.model;

public interface ObservableIF {
	void notifyAll(Object obj);

	void addObserver(ObserverIF observer);

	void removeObserver(ObserverIF observer);
}
