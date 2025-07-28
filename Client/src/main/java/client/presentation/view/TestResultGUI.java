package client.presentation.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import client.model.Language;

public class TestResultGUI extends AbstractGUI {
	private JButton buttonAgain;
	private JButton buttonContinue;

	// getters
	public JButton getAgainButton() {
		return this.buttonAgain;
	}

	public JButton getContinueButton() {
		return this.buttonContinue;
	}

	// setters
	private void setAgainButton(JButton button) {
		this.buttonAgain = button;
	}

	private void setContinueButton(JButton button) {
		this.buttonContinue = button;
	}

	// methods

	// newInstance methods
	public static TestResultGUI newInstance(Language language, double score) {
		if (language == null) {
			return null;
		}
		return new TestResultGUI(language, score);
	}

	// constructors
	private TestResultGUI(Language language, double score) {
		// set frame
		super(language.translated("Test Result!"));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(500, 500);

		Dimension dimButton = new Dimension(125, 50);

		// label congrats
		JLabel labelCongrat = new JLabel(language.translated("Congratulations") + "!", SwingConstants.CENTER);
		labelCongrat.setFont(new Font("Arial", Font.ROMAN_BASELINE, 35));
		// panel congrats
		JPanel panelCongrat = new JPanel();
		panelCongrat.add(labelCongrat);

		// label score
		JLabel labelScore = new JLabel(
				language.translated("You scored") + " " + score + " " + language.translated("points") + "!",
				SwingConstants.CENTER);
		labelScore.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
		// panel score
		JPanel panelScore = new JPanel();
		panelScore.add(labelScore);

		// button again
		this.setAgainButton(new JButton(language.translated("Again") + "!"));
		this.getAgainButton().setPreferredSize(dimButton);
		// panel again
		JPanel panelAgain = new JPanel();
		panelAgain.add(this.getAgainButton());

		// button continue
		this.setContinueButton(new JButton(language.translated("Continue") + "!"));
		this.getContinueButton().setPreferredSize(dimButton);
		// panel continue
		JPanel panelContinue = new JPanel();
		panelContinue.add(this.getContinueButton());

		// main panel
		JPanel mainPanel = new JPanel();
		mainPanel.add(panelCongrat);
		mainPanel.add(panelScore);
		mainPanel.add(panelAgain);
		mainPanel.add(panelContinue);
		mainPanel.setLayout(new GridLayout(0, 1));

		this.setContentPane(mainPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
