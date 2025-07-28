package client.model;

import java.awt.Color;

public class Circle extends Shape2D {
	private int x, y;
	private int radius;
	private Color color;
	private int thickness;

	// getters
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getRadius() {
		return this.radius;
	}

	public Color getColor() {
		return this.color;
	}

	public int getThickness() {
		return this.thickness;
	}

	// setters
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	// methods
	public int diameter() {
		return 2 * this.getRadius();
	}

	@Override
	public double perimeter() {
		return Math.PI * this.diameter();
	}

	@Override
	public double area() {
		return Math.PI * this.getRadius() * this.getRadius();
	}

	// newInstance methods
	public static Circle newInstance(int x, int y, int radius, Color color, int thickness) {
		if (radius < 0) {
			radius = 10;
		}
		if (thickness < 0) {
			thickness = 2;
		}
		if (color == null) {
			color = Color.BLACK;
		}
		return new Circle(x, y, radius, color, thickness);
	}

	public static Circle newInstance(Circle c) {
		if (c == null) {
			return null;
		}
		return Circle.newInstance(c.getX(), c.getY(), c.getRadius(), c.getColor(), c.getThickness());
	}

	// constructors
	private Circle(int x, int y, int radius, Color color, int thickness) {
		this.setX(x);
		this.setY(y);
		this.setRadius(radius);
		this.setColor(color);
		this.setThickness(thickness);
	}
}
