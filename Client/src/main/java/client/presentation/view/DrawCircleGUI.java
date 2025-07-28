package client.presentation.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import client.model.Colors;
import client.model.DrawCircleModel;
import client.model.Language;
import client.model.ObserverIF;

public class DrawCircleGUI extends AbstractGUI implements ObserverIF {
	private JTextField fieldX;
	private JTextField fieldY;
	private JTextField fieldRadius;
	private JTextField fieldDiameter;
	private JTextField fieldPerimeter;
	private JTextField fieldArea;

	private JComboBox<String> selectColor;
	private JTextField fieldThickness;

	private JButton buttonBack;
	private JButton buttonApply;
	private JButton buttonSave;
	private JButton buttonLoad;

	private DrawingPanelGUI drawingPanel;

	// getters
	private JTextField getXField() {
		return this.fieldX;
	}

	private JTextField getYField() {
		return this.fieldY;
	}

	private JTextField getRadiusField() {
		return this.fieldRadius;
	}

	private JTextField getDiameterField() {
		return this.fieldDiameter;
	}

	private JTextField getPerimeterField() {
		return this.fieldPerimeter;
	}

	private JTextField getAreaField() {
		return this.fieldArea;
	}

	private JComboBox<String> getColorSelect() {
		return this.selectColor;
	}

	private JTextField getThicknessField() {
		return this.fieldThickness;
	}

	public JButton getBackButton() {
		return this.buttonBack;
	}

	public JButton getApplyButton() {
		return this.buttonApply;
	}

	public JButton getSaveButton() {
		return this.buttonSave;
	}

	public JButton getLoadButton() {
		return this.buttonLoad;
	}

	public DrawingPanelGUI getDrawingPanel() {
		return this.drawingPanel;
	}

	// setters
	private void setXField(JTextField field) {
		this.fieldX = field;
	}

	private void setYField(JTextField field) {
		this.fieldY = field;
	}

	private void setRadiusField(JTextField field) {
		this.fieldRadius = field;
	}

	private void setDiameterField(JTextField field) {
		this.fieldDiameter = field;
	}

	private void setPerimeterField(JTextField field) {
		this.fieldPerimeter = field;
	}

	private void setAreaField(JTextField field) {
		this.fieldArea = field;
	}

	private void setColorSelect(JComboBox<String> select) {
		this.selectColor = select;
	}

	private void setThicknessField(JTextField field) {
		this.fieldThickness = field;
	}

	private void setBackButton(JButton button) {
		this.buttonBack = button;
	}

	private void setApplyButton(JButton button) {
		this.buttonApply = button;
	}

	private void setSaveButton(JButton button) {
		this.buttonSave = button;
	}

	private void setLoadButton(JButton button) {
		this.buttonLoad = button;
	}

	private void setDrawingPanel(DrawingPanelGUI panel) {
		this.drawingPanel = panel;
	}

	// methods
	public String getXString() {
		return this.getXField().getText();
	}

	private void setXString(String x) {
		this.getXField().setText(x);
	}

	public String getYString() {
		return this.getYField().getText();
	}

	private void setYString(String y) {
		this.getYField().setText(y);
	}

	public String getRadiusString() {
		return this.getRadiusField().getText();
	}

	private void setRadiusString(String radius) {
		this.getRadiusField().setText(radius);
	}

	public String getDiameterString() {
		return this.getDiameterField().getText();
	}

	private void setDiameterString(String diameter) {
		this.getDiameterField().setText(diameter);
	}

	public String getPerimeterString() {
		return this.getPerimeterField().getText();
	}

	private void setPerimeterString(String perimeter) {
		this.getPerimeterField().setText(perimeter);
	}

	public String getAreaString() {
		return this.getAreaField().getText();
	}

	private void setAreaString(String area) {
		this.getAreaField().setText(area);
	}

	public String getSelectColor() {
		return this.getColorSelect().getSelectedItem().toString();
	}

	private void setSelectColor(String color) {
		this.getColorSelect().setSelectedItem(color);
	}

	public String getThicknessString() {
		return this.getThicknessField().getText();
	}

	private void setThicknessString(String thickness) {
		this.getThicknessField().setText(thickness);
	}

	public int getCircleX() {
		return this.getDrawingPanel().getCircleX();
	}

	private void setCircleX(int x) {
		this.getDrawingPanel().setCircleX(x);
		this.updatePanel();
	}

	public int getCircleY() {
		return this.getDrawingPanel().getCircleY();
	}

	private void setCircleY(int y) {
		this.getDrawingPanel().setCircleY(y);
		this.updatePanel();
	}

	public int getCircleRadius() {
		return this.getDrawingPanel().getCircleRadius();
	}

	private void setCircleRadius(int radius) {
		this.getDrawingPanel().setCircleRadius(radius);
		this.updatePanel();
	}

	public Color getCircleColor() {
		return this.getDrawingPanel().getCircleColor();
	}

	private void setCircleColor(Color color) {
		this.getDrawingPanel().setCircleColor(color);
		this.updatePanel();
	}

	public int getCircleThickness() {
		return this.getDrawingPanel().getCircleThickness();
	}

	private void setCircleThickness(int thickness) {
		this.getDrawingPanel().setCircleThickness(thickness);
		this.updatePanel();
	}

	public void updatePanel() {
		this.getDrawingPanel().repaint();
	}

	// ObserverIF overrides
	@Override
	public void update(Object obj) {
		DrawCircleModel model = (DrawCircleModel) obj;

		this.setXString(model.getXPosition());
		this.setYString(model.getYPosition());
		this.setRadiusString(model.getRadius());
		this.setDiameterString(model.getDiameter());
		this.setPerimeterString(model.getPerimeter());
		this.setAreaString(model.getArea());

		this.setSelectColor(model.getColor());
		this.setThicknessString(model.getThickness());

		this.setCircleX(model.getCircleX());
		this.setCircleY(model.getCircleY());
		this.setCircleRadius(model.getCircleRadius());
		this.setCircleColor(model.getCircleColor());
		this.setCircleThickness(model.getCircleThickness());
	}

	// newInstance methods
	public static DrawCircleGUI newInstance(Language language) {
		return new DrawCircleGUI(language);
	}

	// constructors
	private DrawCircleGUI(Language language) {
		// set frame
		super("Draw Cirlce");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(900, 650);

		Dimension dimButton = new Dimension(110, 45);
		Dimension dimField = new Dimension(150, 30);
		Dimension dimLabel = new Dimension(70, 30);
		int side = SwingConstants.RIGHT;

		// button back
		this.setBackButton(new JButton(language.translated("Back") + "!"));
		this.getBackButton().setPreferredSize(dimButton);
		// panel button back
		JPanel panelBack = new JPanel();
		panelBack.add(this.getBackButton());

		// X label
		JLabel labelX = new JLabel("X " + language.translated("Position"), side);
		labelX.setPreferredSize(dimLabel);
		// X text field
		this.setXField(new JTextField());
		this.getXField().setPreferredSize(dimField);
		// X panel
		JPanel panelX = new JPanel();
		panelX.add(labelX);
		panelX.add(this.getXField());

		// Y label
		JLabel labelY = new JLabel("Y " + language.translated("Position"), side);
		labelY.setPreferredSize(dimLabel);
		// Y text field
		this.setYField(new JTextField());
		this.getYField().setPreferredSize(dimField);
		// Y panel
		JPanel panelY = new JPanel();
		panelY.add(labelY);
		panelY.add(this.getYField());

		// radius label
		JLabel labelRadius = new JLabel(language.translated("Radius"), side);
		labelRadius.setPreferredSize(dimLabel);
		// radius text field
		this.setRadiusField(new JTextField());
		this.getRadiusField().setPreferredSize(dimField);
		// radius panel
		JPanel panelRadius = new JPanel();
		panelRadius.add(labelRadius);
		panelRadius.add(this.getRadiusField());

		// diameter label
		JLabel labelDiameter = new JLabel(language.translated("Diameter"), side);
		labelDiameter.setPreferredSize(dimLabel);
		// diameter text field
		this.setDiameterField(new JTextField());
		this.getDiameterField().setPreferredSize(dimField);
		this.getDiameterField().setEditable(false);
		// diameter panel
		JPanel panelDiameter = new JPanel();
		panelDiameter.add(labelDiameter);
		panelDiameter.add(this.getDiameterField());

		// perimeter label
		JLabel labelPerimeter = new JLabel(language.translated("Perimeter"), side);
		labelPerimeter.setPreferredSize(dimLabel);
		// perimeter text field
		this.setPerimeterField(new JTextField());
		this.getPerimeterField().setPreferredSize(dimField);
		this.getPerimeterField().setEditable(false);
		// perimeter panel
		JPanel panelPerimeter = new JPanel();
		panelPerimeter.add(labelPerimeter);
		panelPerimeter.add(this.getPerimeterField());

		// area label
		JLabel labelArea = new JLabel(language.translated("Area"), side);
		labelArea.setPreferredSize(dimLabel);
		// area text field
		this.setAreaField(new JTextField());
		this.getAreaField().setPreferredSize(dimField);
		this.getAreaField().setEditable(false);
		// area panel
		JPanel panelArea = new JPanel();
		panelArea.add(labelArea);
		panelArea.add(this.getAreaField());

		// color label
		JLabel labelColor = new JLabel(language.translated("Color"), side);
		labelColor.setPreferredSize(dimLabel);
		// color select box
		this.setColorSelect(new JComboBox<String>(Colors.COLOR_NAMES));
		this.getColorSelect().setPreferredSize(dimField);
		// color panel
		JPanel panelColor = new JPanel();
		panelColor.add(labelColor);
		panelColor.add(this.getColorSelect());

		// thinkness label
		JLabel labelThickness = new JLabel(language.translated("Thickness"), side);
		labelThickness.setPreferredSize(dimLabel);
		// thickness field
		this.setThicknessField(new JTextField());
		this.getThicknessField().setPreferredSize(dimField);
		// thickness panel
		JPanel panelThickness = new JPanel();
		panelThickness.add(labelThickness);
		panelThickness.add(this.getThicknessField());

		// button apply
		this.setApplyButton(new JButton(language.translated("Apply") + "!"));
		this.getApplyButton().setPreferredSize(dimButton);
		// panel apply button
		JPanel panelApply = new JPanel();
		panelApply.add(this.getApplyButton());

		// button save
		this.setSaveButton(new JButton(language.translated("Save") + "!"));
		this.getSaveButton().setPreferredSize(dimButton);
		// button load
		this.setLoadButton(new JButton(language.translated("Load") + "!"));
		this.getLoadButton().setPreferredSize(dimButton);
		// panel save & load
		JPanel panelSaveLoad = new JPanel();
		panelSaveLoad.add(this.getSaveButton());
		panelSaveLoad.add(this.getLoadButton());

		// control panel
		JPanel controlPanel = new JPanel();
		controlPanel.add(panelBack);
		controlPanel.add(panelX);
		controlPanel.add(panelY);
		controlPanel.add(panelRadius);
		controlPanel.add(panelDiameter);
		controlPanel.add(panelPerimeter);
		controlPanel.add(panelArea);
		controlPanel.add(panelColor);
		controlPanel.add(panelThickness);
		controlPanel.add(panelApply);
		controlPanel.add(panelSaveLoad);
		controlPanel.setLayout(new GridLayout(0, 1));

		// draw panel
		this.setDrawingPanel(new DrawingPanelGUI());
		this.getDrawingPanel().setBackground(Color.WHITE);
		this.getDrawingPanel().setPreferredSize(new Dimension(600, 600));

		// main panel
		JPanel mainPanel = new JPanel();
		mainPanel.add(controlPanel);
		mainPanel.add(this.getDrawingPanel());

		this.setContentPane(mainPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
