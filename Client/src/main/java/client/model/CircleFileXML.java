package client.model;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CircleFileXML extends AbstractCircleFile {

	// getters

	// setters

	// methods
	private int readXFromFile(Scanner scanner) {
		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at x! #1");
			return -1;
		}
		String str = scanner.next();
		try {
			int x = Integer.parseInt(str.substring(3, str.length() - 4));
			return x;
		} catch (NumberFormatException e) {
			System.err.println("Wrong file format at x! #2 " + e.getMessage());
			return -1;
		}
	}

	private int readYFromFile(Scanner scanner) {
		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at y! #1");
			return -1;
		}
		String str = scanner.next();
		try {
			int y = Integer.parseInt(str.substring(3, str.length() - 4));
			return y;
		} catch (NumberFormatException e) {
			System.err.println("Wrong file format at y! #2 " + e.getMessage());
			return -1;
		}
	}

	private int readRadiusFromFile(Scanner scanner) {
		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at radius! #1");
			return -1;
		}
		String str = scanner.next();
		try {
			int r = Integer.parseInt(str.substring(8, str.length() - 9));
			return r;
		} catch (NumberFormatException e) {
			System.err.println("Wrong file format at radius! #2 " + e.getMessage());
			return -1;
		}
	}

	private Color readColorFromFile(Scanner scanner) {
		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at color! #1");
			return null;
		}
		String str = scanner.next();
		Color c = Colors.stringToColor(str.substring(7, str.length() - 8));
		if (c == null) {
			System.err.println("Wrong file format at color! #2");
		}
		return c;
	}

	private int readThicknessFromFile(Scanner scanner) {
		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at thickness! #1");
			return -1;
		}
		String str = scanner.next();
		try {
			int t = Integer.parseInt(str.substring(11, str.length() - 12));
			return t;
		} catch (NumberFormatException e) {
			System.err.println("Wrong file format at thickness! #2 " + e.getMessage());
			return -1;
		}
	}

	// AbstractCircleFile overrides
	@Override
	public boolean save() {
		FileWriter writer = null;
		try {
			// write file
			writer = new FileWriter(this.getFile());
			writer.write("<circle>\n");

			writer.write("\t<x>" + this.getX() + "</x>\n");
			writer.write("\t<y>" + this.getY() + "</y>\n");
			writer.write("\t<radius>" + this.getRadius() + "</radius>\n");
			writer.write("\t<color>" + Colors.colorToString(this.getColor()) + "</color>\n");
			writer.write("\t<thickness>" + this.getThickness() + "</thickness>\n");

			writer.write("</circle>\n");
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

			if (!scanner.hasNext(Pattern.compile("<circle>\\n*"))) {
				System.err.println("Wrong file format!");
				return false;
			}
			scanner.next(Pattern.compile("<circle>\\n*"));

			int x = this.readXFromFile(scanner);
			if (x == -1) {
				System.out.println("X");
				return false;
			}

			int y = this.readYFromFile(scanner);
			if (y == -1) {
				System.out.println("Y");
				return false;
			}

			int radius = this.readRadiusFromFile(scanner);
			if (radius == -1) {
				System.out.println("R");
				return false;
			}

			Color color = this.readColorFromFile(scanner);
			if (color == null) {
				System.out.println("C");
				return false;
			}

			int thickness = this.readThicknessFromFile(scanner);
			if (thickness == -1) {
				System.out.println("T");
				return false;
			}

			if (!scanner.hasNext("</circle>\n*")) {
				System.err.println("Wrong file format!");
				return false;
			}
			scanner.next("</circle>\n*");

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
	public static CircleFileXML newInstance(File file, Circle circle) {
		if (file == null || circle == null) {
			return null;
		}
		return new CircleFileXML(file, circle);
	}

	public static CircleFileXML newInstance(File file, int x, int y, int radius, Color color, int thickness) {
		if (file == null) {
			return null;
		}
		return new CircleFileXML(file, Circle.newInstance(x, y, radius, color, thickness));
	}

	public static CircleFileXML newInstance(File file) {
		if (file == null) {
			return null;
		}
		return new CircleFileXML(file, Circle.newInstance(0, 0, 0, Color.BLACK, 2));
	}

	// constructors
	private CircleFileXML(File file, Circle circle) {
		super(file, circle);
	}
}
