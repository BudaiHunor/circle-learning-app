package client.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class DrawCircleModel extends AbstractModel {
	private String xPosition;
	private String yPosition;
	private String radius;
	private String diameter;
	private String perimeter;
	private String area;

	private String color;
	private String thickness;

	private Circle circle;

	// getters
	public String getXPosition() {
		return this.xPosition;
	}

	public String getYPosition() {
		return this.yPosition;
	}

	public String getRadius() {
		return this.radius;
	}

	public String getDiameter() {
		return this.diameter;
	}

	public String getPerimeter() {
		return this.perimeter;
	}

	public String getArea() {
		return this.area;
	}

	public String getColor() {
		return this.color;
	}

	public String getThickness() {
		return this.thickness;
	}

	private Circle getCircle() {
		return this.circle;
	}

	public int getCircleX() {
		return this.getCircle().getX();
	}

	public int getCircleY() {
		return this.getCircle().getY();
	}

	public int getCircleRadius() {
		return this.getCircle().getRadius();
	}

	public Color getCircleColor() {
		return this.getCircle().getColor();
	}

	public int getCircleThickness() {
		return this.getCircle().getThickness();
	}

	// setters
	public void setXPosition(String xPosition) {
		this.xPosition = xPosition;
		this.notifyAll(this);
	}

	public void setYPosition(String yPosition) {
		this.yPosition = yPosition;
		this.notifyAll(this);
	}

	public void setRadius(String radius) {
		this.radius = radius;
		this.notifyAll(this);
	}

	public void setDiameter(String diamneter) {
		this.diameter = diamneter;
		this.notifyAll(this);
	}

	public void setPerimeter(String perimeter) {
		this.perimeter = perimeter;
		this.notifyAll(this);
	}

	public void setArea(String area) {
		this.area = area;
		this.notifyAll(this);
	}

	public void setColor(String color) {
		this.color = color;
		this.notifyAll(this);
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
		this.notifyAll(this);
	}

	private void setCircle(Circle circle) {
		this.circle = circle;
		this.notifyAll(this);
	}

	public void setCircleX(int circleX) {
		this.getCircle().setX(circleX);
		this.notifyAll(this);
	}

	public void setCircleY(int circleY) {
		this.getCircle().setY(circleY);
		this.notifyAll(this);
	}

	public void setCircleRadius(int circleRadius) {
		this.getCircle().setRadius(circleRadius);
		this.notifyAll(this);
	}

	public void setCircleColor(Color circleColor) {
		this.getCircle().setColor(circleColor);
		this.notifyAll(this);
	}

	public void setCircleThickness(int circleThickness) {
		this.getCircle().setThickness(circleThickness);
		this.notifyAll(this);
	}

	// methods
	public int diameter() {
		return this.getCircle().diameter();
	}

	public double perimeter() {
		return this.getCircle().perimeter();
	}

	public double area() {
		return this.getCircle().area();
	}

	// newInstance methods
	public static DrawCircleModel newInstance(List<ObserverIF> observers) {
		if (observers == null) {
			return null;
		}
		return new DrawCircleModel(observers);
	}

	public static DrawCircleModel newInstance() {
		return new DrawCircleModel(new ArrayList<ObserverIF>());
	}

	// constructors
	private DrawCircleModel(List<ObserverIF> observers) {
		super(observers);

		this.setXPosition("");
		this.setYPosition("");
		this.setRadius("");
		this.setDiameter("");
		this.setPerimeter("");
		this.setArea("");

		this.setColor("");
		this.setThickness("");

		this.setCircle(Circle.newInstance(0, 0, 0, Color.BLACK, 2));
	}
}
