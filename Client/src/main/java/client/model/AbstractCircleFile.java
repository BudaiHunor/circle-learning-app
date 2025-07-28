package client.model;

import java.awt.Color;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractCircleFile {
	private File file;
	private Circle circle;

	// getters
	public File getFile() {
		return this.file;
	}

	private Circle getCircle() {
		return this.circle;
	}

	public int getX() {
		return this.getCircle().getX();
	}

	public int getY() {
		return this.getCircle().getY();
	}

	public int getRadius() {
		return this.getCircle().getRadius();
	}

	public Color getColor() {
		return this.getCircle().getColor();
	}

	public int getThickness() {
		return this.getCircle().getThickness();
	}

	// setters
	private void setFile(File file) {
		this.file = file;
	}

	private void setCircle(Circle circle) {
		this.circle = circle;
	}

	void setX(int x) {
		this.getCircle().setX(x);
	}

	void setY(int y) {
		this.getCircle().setY(y);
	}

	void setRadius(int radius) {
		this.getCircle().setRadius(radius);
	}

	void setColor(Color color) {
		this.getCircle().setColor(color);
	}

	void setThickness(int thickness) {
		this.getCircle().setThickness(thickness);
	}

	// methods
	abstract public boolean save();

	abstract public boolean load();

	// newInstance methods
	public static <T extends AbstractCircleFile> T newInstance(File file, Circle circle, Class<T> cls) {
		if (file == null || circle == null) {
			return null;
		}
		try {
			Constructor<T> constructor = cls.getDeclaredConstructor(File.class, Circle.class);
			constructor.setAccessible(true);
			return constructor.newInstance(file, circle);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InaccessibleObjectException e) {
			System.err.println("AbstractCircleFile construction exploded! " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public static <T extends AbstractCircleFile> T newInstance(File file, int x, int y, int radius, Color color,
			int thickness, Class<T> cls) {
		Circle circle = Circle.newInstance(x, y, radius, color, thickness);
		return AbstractCircleFile.newInstance(file, circle, cls);
	}

	public static <T extends AbstractCircleFile> T newInstance(File file, Class<T> cls) {
		Circle circle = Circle.newInstance(0, 0, 0, Color.BLACK, 2);
		return AbstractCircleFile.newInstance(file, circle, cls);
	}

	// constructors
	protected AbstractCircleFile(File file, Circle circle) {
		this.setFile(file);
		this.setCircle(circle);
	}
}
