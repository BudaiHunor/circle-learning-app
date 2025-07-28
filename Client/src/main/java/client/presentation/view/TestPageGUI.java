package client.presentation.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import client.model.Language;

public class TestPageGUI extends AbstractGUI {
	private JLabel labelQuestion;

	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;

	private JButton buttonDone;

	// getters
	public JLabel getQuestionLabel() {
		return this.labelQuestion;
	}

	public JCheckBox getCheckBox1() {
		return this.checkBox1;
	}

	public JCheckBox getCheckBox2() {
		return this.checkBox2;
	}

	public JCheckBox getCheckBox3() {
		return this.checkBox3;
	}

	public JButton getDoneButton() {
		return this.buttonDone;
	}

	// setters
	private void setQuestionLabel(JLabel label) {
		this.labelQuestion = label;
	}

	private void setCheckBox1(JCheckBox checkBox) {
		this.checkBox1 = checkBox;
	}

	private void setCheckBox2(JCheckBox checkBox) {
		this.checkBox2 = checkBox;
	}

	private void setCheckBox3(JCheckBox checkBox) {
		this.checkBox3 = checkBox;
	}

	private void setDoneButton(JButton button) {
		this.buttonDone = button;
	}

	// methods
	public boolean getChecked1() {
		return this.getCheckBox1().isSelected();
	}

	private void setChecked1(boolean selected) {
		this.getCheckBox1().setSelected(selected);
	}

	public boolean getChecked2() {
		return this.getCheckBox2().isSelected();
	}

	private void setChecked2(boolean selected) {
		this.getCheckBox2().setSelected(selected);
	}

	public boolean getChecked3() {
		return this.getCheckBox3().isSelected();
	}

	private void setChecked3(boolean selected) {
		this.getCheckBox1().setSelected(selected);
	}

	// newInstance methods
	public static TestPageGUI newInstance(Language language, String title) {
		if (language == null || title == null) {
			return null;
		}
		return new TestPageGUI(language, title);
	}

	// constructors
	private TestPageGUI(Language language, String title) {
		// set frame
		super(title);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(600, 500);

		Dimension dimButton = new Dimension(125, 50);
		int border = 100;

		// title label
		JLabel labelTitle = new JLabel(language.translated("Test") + "!", SwingConstants.CENTER);
		labelTitle.setFont(new Font("Arial", Font.ROMAN_BASELINE | Font.BOLD, 25));
		// panel title
		JPanel panelTitle = new JPanel();
		panelTitle.add(labelTitle);

		// panel test question
		JPanel panelTest = new JPanel();
		// panelTest.setPreferredSize(new Dimension(500, 400));
		panelTest.setLayout(new GridLayout(0, 1));
		panelTest.setBorder(new EmptyBorder(0, border, 0, border));

		// label question
		this.setQuestionLabel(new JLabel("Question?"));
		this.getQuestionLabel().setPreferredSize(new Dimension(100, 30));
		panelTest.add(this.getQuestionLabel());

		this.setCheckBox1(new JCheckBox("Answer1!"));
		panelTest.add(this.getCheckBox1());
		this.setCheckBox2(new JCheckBox("Answer2!"));
		panelTest.add(this.getCheckBox2());
		this.setCheckBox3(new JCheckBox("Answer3!"));
		panelTest.add(this.getCheckBox3());

		// empty label for space
		JLabel labelSpace = new JLabel();
		labelSpace.setPreferredSize(new Dimension(100, 30));
		panelTest.add(labelSpace);

		// button finish
		this.setDoneButton(new JButton("Done!"));
		this.getDoneButton().setPreferredSize(dimButton);
		// panel button finish
		JPanel panelFinish = new JPanel();
		panelFinish.add(this.getDoneButton());

		// main panel
		JPanel mainPanel = new JPanel();
		mainPanel.add(panelTitle);
		mainPanel.add(panelTest);
		mainPanel.add(panelFinish);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		this.setContentPane(mainPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
