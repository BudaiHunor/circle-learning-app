package client.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InformationModel extends AbstractModel {
	private final String[] imageNames;
	private final String[] textNames;

	private int index;

	// getters
	private int getIndex() {
		return this.index;
	}

	// setters
	private void setIndex(int index) {
		this.index = index;
		this.notifyAll(this);
	}

	// methods
	public void incIndex() {
		this.setIndex((this.getIndex() + 1) % this.imageNames.length);
	}

	public void decIndex() {
		this.setIndex((this.getIndex() - 1 + this.imageNames.length) % this.imageNames.length);
	}

	public String getImageName(int index) {
		return this.imageNames[index % this.imageNames.length];
	}

	public String getCurrentImageName() {
		return this.getImageName(this.getIndex());
	}

	public String getTextName(int index) {
		return this.textNames[index % this.textNames.length];
	}

	public String getCurrentTextName() {
		return this.getTextName(this.getIndex());
	}

	public String getTextContent(int index) {
		Path path = Paths.get(this.getTextName(index));
		try {
			// Returns only the first line
			return Files.readAllLines(path).get(0);
		} catch (IOException e) {
			return "Text failed to load!";
		}
	}

	public String getCurrentTextContent() {
		return this.getTextContent(this.getIndex());
	}

	// newInstance methods
	public static InformationModel newInstance(List<ObserverIF> observers, String[] imageNames, String[] textNames) {
		if (observers == null || textNames == null || imageNames == null) {
			return null;
		}
		return new InformationModel(observers, imageNames, textNames);
	}

	public static InformationModel newInstance(String[] imageNames, String[] textNames) {
		if (textNames == null || imageNames == null) {
			return null;
		}
		return new InformationModel(new ArrayList<ObserverIF>(), imageNames, textNames);
	}

	// constructors
	private InformationModel(List<ObserverIF> observers, String[] imageNames, String[] textNames) {
		super(observers);

		this.imageNames = imageNames;
		this.textNames = textNames;

		this.setIndex(0);
	}
}
