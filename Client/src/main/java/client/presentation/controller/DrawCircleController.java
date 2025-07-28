package client.presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.JFileChooser;

import client.model.AbstractCircleFile;
import client.model.AbstractCircleFileFactory;
import client.model.Account;
import client.model.CircleFileCSVFactory;
import client.model.CircleFileJSONFactory;
import client.model.CircleFileXMLFactory;
import client.model.Colors;
import client.model.DrawCircleModel;
import client.model.Language;
import client.presentation.view.DrawCircleGUI;

public class DrawCircleController extends AbstractController {
	private DrawCircleGUI view;

	private DrawCircleModel model;

	// File Operators (Strategy Pattern)
	private AbstractCircleFile saver;
	private AbstractCircleFile loader;

	// getters
	private DrawCircleGUI getView() {
		return this.view;
	}

	private DrawCircleModel getModel() {
		return this.model;
	}

	// setters
	private void setView(DrawCircleGUI view) {
		this.view = view;
	}

	private void setModel(DrawCircleModel model) {
		this.model = model;
	}

	// methods
	private void goToMain() {
		this.getView().close();
		if (this.getAccount() == null) {
			MainController.newInstance(this.getLanguage());
			return;
		}
		switch (this.getAccount().getType()) {
		case USER:
			UserMainController.newInstance(this.getAccount(), this.getLanguage());
			return;
		case ADMIN:
			AdminMainController.newInstance(this.getAccount(), this.getLanguage());
		}
	}

	private void apply() {
		int x, y, radius, thickness;
		try {
			x = Integer.parseInt(this.getView().getXString());
		} catch (NumberFormatException e) {
			this.getView().showMessage("Invalid number format for X Position!", true);
			return;
		}
		try {
			y = Integer.parseInt(this.getView().getYString());
		} catch (NumberFormatException e) {
			this.getView().showMessage("Invalid number format for Y Position!", true);
			return;
		}
		try {
			radius = Integer.parseInt(this.getView().getRadiusString());
		} catch (NumberFormatException e) {
			this.getView().showMessage("Invalid number format for Radius!", true);
			return;
		}
		try {
			thickness = Integer.parseInt(this.getView().getThicknessString());
		} catch (NumberFormatException e) {
			this.getView().showMessage("Invalid number format for Thickness!", true);
			return;
		}
		Color color = Colors.stringToColor(this.getView().getSelectColor());

		// set the circle/panel
		this.getModel().setCircleX(x);
		this.getModel().setCircleY(y);
		this.getModel().setCircleRadius(radius);
		this.getModel().setCircleColor(color);
		this.getModel().setCircleThickness(thickness);

		// set the given date fields
		this.getModel().setXPosition(x + "");
		this.getModel().setYPosition(y + "");
		this.getModel().setRadius(radius + "");

		// set the computed data fields
		this.getModel().setDiameter(this.getModel().diameter() + "");
		this.getModel().setPerimeter(this.getModel().perimeter() + "");
		this.getModel().setArea(this.getModel().area() + "");

		// aspect data fields ARE MODIFIED AS WELL !!!
		this.getModel().setColor(Colors.colorToString(color));
		this.getModel().setThickness(thickness + "");
	}

	private void updateFields() {
		int x = this.getView().getCircleX();
		int y = this.getView().getCircleY();
		int radius = this.getView().getCircleRadius();
		Color color = this.getView().getCircleColor();
		int thickness = this.getView().getCircleThickness();

		// set the circle/panel
		this.getModel().setCircleX(x);
		this.getModel().setCircleY(y);
		this.getModel().setCircleRadius(radius);
		this.getModel().setCircleColor(color);
		this.getModel().setCircleThickness(thickness);

		// set the given data fields
		this.getModel().setXPosition(x + "");
		this.getModel().setYPosition(y + "");
		this.getModel().setRadius(radius + "");

		// set the computed data fields
		this.getModel().setDiameter(this.getModel().diameter() + "");
		this.getModel().setPerimeter(this.getModel().perimeter() + "");
		this.getModel().setArea(this.getModel().area() + "");

		// aspect data fields ARE MODIFIED AS WELL !!!
		this.getModel().setColor(Colors.colorToString(color));
		this.getModel().setThickness(thickness + "");
	}

	private AbstractCircleFile createFileSaver(File file, int x, int y, int radius, Color color, int thickness) {
		String[] strings = file.getName().split("\\.");
		String extension = strings[strings.length - 1].toUpperCase();

		AbstractCircleFileFactory factory = null;

		switch (extension) {
		case "CSV":
			factory = new CircleFileCSVFactory();
			return factory.createCircleFile(file, x, y, radius, color, thickness);
		case "JSON":
			factory = new CircleFileJSONFactory();
			return factory.createCircleFile(file, x, y, radius, color, thickness);
		case "XML":
			factory = new CircleFileXMLFactory();
			return factory.createCircleFile(file, x, y, radius, color, thickness);
		default:
			return null;
		}

//		switch (extension) {
//		case "CSV":
//			return CircleFileCSV.newInstance(file, x, y, radius, color, thickness);
//		case "JSON":
//			return CircleFileJSON.newInstance(file, x, y, radius, color, thickness);
//		case "XML":
//			return CircleFileXML.newInstance(file, x, y, radius, color, thickness);
//		default:
//			return null;
//		}
	}

	private AbstractCircleFile createFileLoader(File file) {
		String[] strings = file.getName().split("\\.");
		String extension = strings[strings.length - 1].toUpperCase();

		AbstractCircleFileFactory factory = null;

		switch (extension) {
		case "CSV":
			factory = new CircleFileCSVFactory();
			return factory.createCircleFile(file);
		case "JSON":
			factory = new CircleFileJSONFactory();
			return factory.createCircleFile(file);
		case "XML":
			factory = new CircleFileXMLFactory();
			return factory.createCircleFile(file);
		default:
			return null;
		}

//		switch (extension) {
//		case "CSV":
//			return CircleFileCSV.newInstance(file);
//		case "JSON":
//			return CircleFileJSON.newInstance(file);
//		case "XML":
//			return CircleFileXML.newInstance(file);
//		default:
//			return null;
//		}
	}

	private void save() {
		int x = this.getView().getCircleX();
		int y = this.getView().getCircleY();
		int r = this.getView().getCircleRadius();

		Color c = this.getView().getCircleColor();
		int t = this.getView().getCircleThickness();

		JFileChooser chooser = new JFileChooser();
		if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();

			this.saver = this.createFileSaver(file, x, y, r, c, t);
			if (this.saver == null) {
				this.getView().showMessage("Unsupported file extension!", true);
				return;
			}
			this.saver.save();
		}
	}

	private void load() {
		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();

			this.loader = this.createFileLoader(file);
			if (this.loader == null) {
				this.getView().showMessage("Unsupported file extension!", true);
				return;
			}
			this.loader.load();

			this.getModel().setCircleX(this.loader.getX());
			this.getModel().setCircleY(this.loader.getY());
			this.getModel().setCircleRadius(this.loader.getRadius());

			this.getModel().setCircleColor(this.loader.getColor());
			this.getModel().setCircleThickness(this.loader.getThickness());

			this.updateFields();
		}
	}

	private void mousePressed(int x, int y) {
		this.updateFields();
	}

	private void mouseDragged(int x, int y) {
		this.updateFields();
	}

	// newInstance methods
	public static DrawCircleController newInstance(Account account, Language language) {
		return new DrawCircleController(account, language);
	}

	// constructors
	private DrawCircleController(Account account, Language language) {
		super(account, language);

		// set view
		this.setView(DrawCircleGUI.newInstance(language));

		// back button
		this.getView().getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DrawCircleController.this.goToMain();
			}
		});

		// apply button
		this.getView().getApplyButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DrawCircleController.this.apply();
			}
		});

		// save button
		this.getView().getSaveButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DrawCircleController.this.save();
			}
		});

		// load button
		this.getView().getLoadButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DrawCircleController.this.load();
			}
		});

		// drawing panel press
		this.getView().getDrawingPanel().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				DrawCircleController.this.mousePressed(e.getX(), e.getY());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			};
		});

		// drawing panel drag
		this.getView().getDrawingPanel().addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				DrawCircleController.this.mouseDragged(e.getX(), e.getY());
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// set model
		this.setModel(DrawCircleModel.newInstance());
		this.getModel().addObserver(this.getView());
	}
}
