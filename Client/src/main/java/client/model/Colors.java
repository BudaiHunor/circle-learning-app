package client.model;

import java.awt.Color;
import java.util.Arrays;

public class Colors {
	public static final Color[] COLORS = new Color[] { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
			Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
			Color.YELLOW };

	public static final String[] COLOR_NAMES = new String[] { "BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY", "GREEN",
			"LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", "RED", "WHITE", "YELLOW" };

	public static final String colorToString(Color color) {
		int index = Arrays.asList(Colors.COLORS).indexOf(color);
		if (index == -1) {
			return null;
		}
		return Colors.COLOR_NAMES[index];
	}

	public static final Color stringToColor(String color) {
		int index = Arrays.asList(Colors.COLOR_NAMES).indexOf(color);
		if (index == -1) {
			return null;
		}
		return Colors.COLORS[index];
	}

	private Colors() {
	}
}
