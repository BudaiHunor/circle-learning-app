package client.model;

import java.util.List;

abstract public class AbstractModel implements ObservableIF {
	private List<ObserverIF> observers;

	// getters
	// TODO back to private
	public List<ObserverIF> getObservers() {
		return this.observers;
	}

	// setters
	private void setObservers(List<ObserverIF> observers) {
		this.observers = observers;
	}

	// ObserverIF overrides
	@Override
	public void notifyAll(Object obj) {
		this.getObservers().forEach(observer -> observer.update(obj));
	}

	@Override
	public void addObserver(ObserverIF observer) {
		this.getObservers().add(observer);
	}

	@Override
	public void removeObserver(ObserverIF observer) {
		this.getObservers().remove(observer);
	}

	// newInstance methods
	// CAN'T HAVE ANY

	// constructors
	protected AbstractModel(List<ObserverIF> observers) {
		this.setObservers(observers);
	}
}
