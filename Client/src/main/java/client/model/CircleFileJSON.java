package client.model;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CircleFileJSON extends AbstractCircleFile {

	// getters

	// setters

	// methods
	private int readXFromFile(Scanner scanner) {
		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at x! #1");
			return -1;
		}
		scanner.next();

		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at x! #2");
			return -1;
		}
		String str = scanner.next();

		try {
			int hasComa = str.charAt(str.length() - 1) == ',' ? 1 : 0;
			int x = Integer.parseInt(str.substring(1, str.length() - 1 - hasComa));
			return x;
		} catch (NumberFormatException e) {
			System.err.println("Wrong file format at x! #3 " + e.getMessage());
			return -1;
		}
	}

	private int readYFromFile(Scanner scanner) {
		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at y! #1");
			return -1;
		}
		scanner.next();

		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at y! #2");
			return -1;
		}
		String str = scanner.next();

		try {
			int hasComa = str.charAt(str.length() - 1) == ',' ? 1 : 0;
			int y = Integer.parseInt(str.substring(1, str.length() - 1 - hasComa));
			return y;
		} catch (NumberFormatException e) {
			System.err.println("Wrong file format at y! #3 " + e.getMessage());
			return -1;
		}
	}

	private int readRadiusFromFile(Scanner scanner) {
		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at radius! #1");
			return -1;
		}
		scanner.next();

		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at radius! #2");
			return -1;
		}
		String str = scanner.next();

		try {
			int hasComa = str.charAt(str.length() - 1) == ',' ? 1 : 0;
			int r = Integer.parseInt(str.substring(1, str.length() - 1 - hasComa));
			return r;
		} catch (NumberFormatException e) {
			System.err.println("Wrong file format at radius! #3 " + e.getMessage());
			return -1;
		}
	}

	private Color readColorFromFile(Scanner scanner) {
		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at color! #1");
			return null;
		}
		scanner.next();

		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at color! #2");
			return null;
		}
		String str = scanner.next();

		int hasComa = str.charAt(str.length() - 1) == ',' ? 1 : 0;
		Color c = Colors.stringToColor(str.substring(1, str.length() - 1 - hasComa));

		if (c == null) {
			System.err.println("Wrong file format at color! #3");
		}
		return c;
	}

	private int readThicknessFromFile(Scanner scanner) {
		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at thickness! #1");
			return -1;
		}
		scanner.next();

		if (!scanner.hasNext()) {
			System.err.println("Wrong file format at thickness! #2");
			return -1;
		}
		String str = scanner.next();

		try {
			int hasComa = str.charAt(str.length() - 1) == ',' ? 1 : 0;
			int t = Integer.parseInt(str.substring(1, str.length() - 1 - hasComa));
			return t;
		} catch (NumberFormatException e) {
			System.err.println("Wrong file format at thickness! #3 " + e.getMessage());
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
			writer.write("{\n");

			writer.write("\t\"x\": \"" + this.getX() + "\",\n");
			writer.write("\t\"y\": \"" + this.getY() + "\",\n");
			writer.write("\t\"radius\": \"" + this.getRadius() + "\",\n");
			writer.write("\t\"color\": \"" + Colors.colorToString(this.getColor()) + "\",\n");
			writer.write("\t\"thickness\": \"" + this.getThickness() + "\"\n");

			writer.write("}\n");
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

			if (!scanner.hasNext(Pattern.compile("\\{\\n*"))) {
				System.err.println("Wrong file format!");
				return false;
			}
			scanner.next(Pattern.compile("\\{\\n*"));

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

			if (!scanner.hasNext("\\}\n*")) {
				System.err.println("Wrong file format!");
				return false;
			}
			scanner.next("\\}\n*");

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
	public static CircleFileJSON newInstance(File file, Circle circle) {
		if (file == null || circle == null) {
			return null;
		}
		return new CircleFileJSON(file, circle);
	}

	public static CircleFileJSON newInstance(File file, int x, int y, int radius, Color color, int thickness) {
		if (file == null) {
			return null;
		}
		return new CircleFileJSON(file, Circle.newInstance(x, y, radius, color, thickness));
	}

	public static CircleFileJSON newInstance(File file) {
		if (file == null) {
			return null;
		}
		return new CircleFileJSON(file, Circle.newInstance(0, 0, 0, Color.BLACK, 2));
	}

	// constructors
	private CircleFileJSON(File file, Circle circle) {
		super(file, circle);
	}
}
