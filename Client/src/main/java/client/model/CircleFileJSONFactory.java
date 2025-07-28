package client.model;

import java.awt.Color;
import java.io.File;

public class CircleFileJSONFactory extends AbstractCircleFileFactory {
	@Override
	public CircleFileJSON createCircleFile(File file) {
		return CircleFileJSON.newInstance(file);
	}

	@Override
	public CircleFileJSON createCircleFile(File file, Circle circle) {
		return CircleFileJSON.newInstance(file, circle);
	}

	@Override
	public CircleFileJSON createCircleFile(File file, int x, int y, int radius, Color color, int thickness) {
		return CircleFileJSON.newInstance(file, x, y, radius, color, thickness);
	}
}
