package client.model;

import java.awt.Color;
import java.io.File;

abstract public class AbstractCircleFileFactory {
	abstract public AbstractCircleFile createCircleFile(File file);

	abstract public AbstractCircleFile createCircleFile(File file, Circle circle);

	abstract public AbstractCircleFile createCircleFile(File file, int x, int y, int radius, Color color,
			int thickness);
}
