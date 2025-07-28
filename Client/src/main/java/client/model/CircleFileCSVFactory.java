package client.model;

import java.awt.Color;
import java.io.File;

public class CircleFileCSVFactory extends AbstractCircleFileFactory {
	@Override
	public CircleFileCSV createCircleFile(File file) {
		return CircleFileCSV.newInstance(file);
	}

	@Override
	public CircleFileCSV createCircleFile(File file, Circle circle) {
		return CircleFileCSV.newInstance(file, circle);
	}

	@Override
	public CircleFileCSV createCircleFile(File file, int x, int y, int radius, Color color, int thickness) {
		return CircleFileCSV.newInstance(file, x, y, radius, color, thickness);
	}
}
