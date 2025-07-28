package client.presentation.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import client.model.InformationModel;
import client.model.Language;
import client.model.ObserverIF;

public class InformationGUI extends AbstractGUI implements ObserverIF {
	private JTextArea textArea;

	private JButton buttonBack;
	private JButton buttonPrevious;
	private JButton buttonNext;

	private ImagePanelGUI imagePanel;

	// getters
	private JTextArea getTextArea() {
		return this.textArea;
	}

	public JButton getBackButton() {
		return this.buttonBack;
	}

	public JButton getPreviousButton() {
		return this.buttonPrevious;
	}

	public JButton getNextButton() {
		return this.buttonNext;
	}

	private ImagePanelGUI getImagePanel() {
		return this.imagePanel;
	}

	// setters
	private void setTextArea(JTextArea area) {
		this.textArea = area;
	}

	private void setBackButton(JButton button) {
		this.buttonBack = button;
	}

	private void setPreviousButton(JButton button) {
		this.buttonPrevious = button;
	}

	private void setNextButton(JButton button) {
		this.buttonNext = button;
	}

	private void setImagePanel(ImagePanelGUI imagePanel) {
		this.imagePanel = imagePanel;
	}

	// methods
	public String getText() {
		return this.getTextArea().getText();
	}

	private void setText(String text) {
		this.getTextArea().setText(text);
	}

	public String getImageName() {
		return this.getImagePanel().getImageName();
	}

	private void setImageName(String imageName) {
		this.getImagePanel().setImageName(imageName);
	}

	// ObserverIF overrides
	@Override
	public void update(Object obj) {
		InformationModel model = (InformationModel) obj;

		this.setText(model.getCurrentTextContent());
		this.setImageName(model.getCurrentImageName());
	}

	// newInstance methods
	public static InformationGUI newInstance(Language language, String title) {
		if (language == null || title == null) {
			return null;
		}
		return new InformationGUI(language, title);
	}

	// constructors
	private InformationGUI(Language language, String title) {
		// set frame
		super(language.translated(title));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(800, 600);

		Dimension dimButton = new Dimension(125, 50);

		// button back
		this.setBackButton(new JButton(language.translated("Back") + "!"));
		this.getBackButton().setPreferredSize(dimButton);
		// panel button back
		JPanel panelBack = new JPanel();
		panelBack.add(this.getBackButton());

		// button prev
		this.setPreviousButton(new JButton(language.translated("Previous") + "!"));
		this.getPreviousButton().setPreferredSize(dimButton);
		// panel button prev
		JPanel panelPrev = new JPanel();
		panelPrev.add(this.getPreviousButton());

		// text area
		this.setTextArea(new JTextArea());
		this.getTextArea().setWrapStyleWord(true);
		this.getTextArea().setLineWrap(true);
		this.getTextArea().setEditable(false);
		this.getTextArea().setPreferredSize(new Dimension(200, 200));
		// panel text area
		JPanel panelText = new JPanel();
		panelText.add(this.getTextArea());

		// button next
		this.setNextButton(new JButton(language.translated("Next") + "!"));
		this.getNextButton().setPreferredSize(dimButton);
		// panel button next
		JPanel panelNext = new JPanel();
		panelNext.add(this.getNextButton());

		// control panel
		JPanel controlPanel = new JPanel();
		controlPanel.add(panelBack);
		controlPanel.add(panelPrev);
		controlPanel.add(this.getTextArea());
		controlPanel.add(panelNext);
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

		// image panel
		this.setImagePanel(new ImagePanelGUI(null));
		this.getImagePanel().setPreferredSize(new Dimension(500, 500));
		this.getImagePanel().setBackground(Color.WHITE);

		// main panel
		JPanel mainPanel = new JPanel();
		mainPanel.add(controlPanel);
		mainPanel.add(this.getImagePanel());

		this.setContentPane(mainPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
