package client.model;

import java.awt.Color;
import java.io.File;

public class CircleFileXMLFactory extends AbstractCircleFileFactory {
	@Override
	public CircleFileXML createCircleFile(File file) {
		return CircleFileXML.newInstance(file);
	}

	@Override
	public CircleFileXML createCircleFile(File file, Circle circle) {
		return CircleFileXML.newInstance(file, circle);
	}

	@Override
	public CircleFileXML createCircleFile(File file, int x, int y, int radius, Color color, int thickness) {
		return CircleFileXML.newInstance(file, x, y, radius, color, thickness);
	}
}
