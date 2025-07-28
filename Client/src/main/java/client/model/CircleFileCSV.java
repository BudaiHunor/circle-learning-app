package client.model;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CircleFileCSV extends AbstractCircleFile {

	// getters

	// setters

	// methods

	// AbstractCircleFile overrides
	@Override
	public boolean save() {
		FileWriter writer = null;
		try {
			// write file
			writer = new FileWriter(this.getFile());

			writer.write("x;y;radius;color;thickness\n");

			writer.write(this.getX() + ";");
			writer.write(this.getY() + ";");
			writer.write(this.getRadius() + ";");
			writer.write(Colors.colorToString(this.getColor()) + ";");
			writer.write(this.getThickness() + "\n");

			writer.close();
		} catch (IOException e) {
			System.err.println("IO Exception! " + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean load() {
		Scanner scanner = null;
		try {
			// scan file
			scanner = new Scanner(this.getFile());

			if (!scanner.hasNext()) {
				System.err.println("Wrong file format!");
				return false;
			}
			String[] headers = scanner.next().split(";");
			if (headers.length != 5) {
				System.err.println("Wrong file format!");
				return false;
			}

			if (!scanner.hasNext()) {
				System.err.println("Wrong file format!");
				return false;
			}

			String[] strings = scanner.next().split(";");
			if (strings.length != 5) {
				System.err.println("Wrong file format!");
				return false;
			}

			int x;
			try {
				x = Integer.parseInt(strings[0]);
			} catch (NumberFormatException e) {
				System.err.println("Wrong file format at x! " + e.getMessage());
				return false;
			}

			int y;
			try {
				y = Integer.parseInt(strings[1]);
			} catch (NumberFormatException e) {
				System.err.println("Wrong file format at y! " + e.getMessage());
				return false;
			}

			int radius;
			try {
				radius = Integer.parseInt(strings[2]);
			} catch (NumberFormatException e) {
				System.err.println("Wrong file format at radius! " + e.getMessage());
				return false;
			}

			Color color = Colors.stringToColor(strings[3]);
			if (color == null) {
				System.err.println("Wrong file format at color!");
				return false;
			}

			int thickness;
			try {
				thickness = Integer.parseInt(strings[4]);
			} catch (NumberFormatException e) {
				System.err.println("Wrong file format at thickness! " + e.getMessage());
				return false;
			}

			// set values
			this.setX(x);
			this.setY(y);
			this.setRadius(radius);
			this.setColor(color);
			this.setThickness(thickness);

			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found! " + e.getMessage());
			return false;
		}
		return true;
	}

	// newInstance methods
	public static CircleFileCSV newInstance(File file, Circle circle) {
		if (file == null || circle == null) {
			return null;
		}
		return new CircleFileCSV(file, circle);
	}

	public static CircleFileCSV newInstance(File file, int x, int y, int radius, Color color, int thickness) {
		if (file == null) {
			return null;
		}
		return new CircleFileCSV(file, Circle.newInstance(x, y, radius, color, thickness));
	}

	public static CircleFileCSV newInstance(File file) {
		if (file == null) {
			return null;
		}
		return new CircleFileCSV(file, Circle.newInstance(0, 0, 0, Color.BLACK, 2));
	}

	// constructors
	private CircleFileCSV(File file, Circle circle) {
		super(file, circle);
	}
}
