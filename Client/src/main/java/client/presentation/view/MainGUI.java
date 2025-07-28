package client.presentation.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import client.model.Language;

public class MainGUI extends AbstractGUI {
	private JButton buttonLogIn;
	private JButton buttonSignUp;
	private JButton buttonInner;
	private JButton buttonOuter;
	private JButton buttonSpecial;
	private JButton buttonDraw;
	private JButton buttonExit;

	private JComboBox<String> languageComboBox;

	private JLabel labelTitle;

	// getters
	public JButton getLogInButton() {
		return this.buttonLogIn;
	}

	public JButton getSignUpButton() {
		return this.buttonSignUp;
	}

	public JButton getInnerButton() {
		return this.buttonInner;
	}

	public JButton getOuterButton() {
		return this.buttonOuter;
	}

	public JButton getSpecialButton() {
		return this.buttonSpecial;
	}

	public JButton getDrawButton() {
		return this.buttonDraw;
	}

	public JButton getExitButton() {
		return this.buttonExit;
	}

	public JComboBox<String> getLanguageComboBox() {
		return this.languageComboBox;
	}

	public JLabel getTitleLabel() {
		return this.labelTitle;
	}

	// setters
	private void setLogInButton(JButton button) {
		this.buttonLogIn = button;
	}

	private void setSignUpButton(JButton button) {
		this.buttonSignUp = button;
	}

	private void setInnerButton(JButton button) {
		this.buttonInner = button;
	}

	private void setOuterButton(JButton button) {
		this.buttonOuter = button;
	}

	private void setSpecialButton(JButton button) {
		this.buttonSpecial = button;
	}

	private void setDrawButton(JButton button) {
		this.buttonDraw = button;
	}

	private void setExitButton(JButton button) {
		this.buttonExit = button;
	}

	private void setLanguageComboBox(JComboBox<String> comboBox) {
		this.languageComboBox = comboBox;
	}

	private void setTitleLabel(JLabel label) {
		this.labelTitle = label;
	}

	// methods
	public String getLanguageString() {
		return (String) this.getLanguageComboBox().getSelectedItem();
	}

	private void setLanguageString(String language) {
		this.getLanguageComboBox().setSelectedItem(language);
	}

	// newInstance methods
	public static MainGUI newInstance(Language language) {
		if (language == null) {
			return null;
		}
		return new MainGUI(language);
	}

	// constructors
	private MainGUI(Language language) {
		// set frame
		super(language.translated("Offline Main Page") + "!");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(850, 600);

		Dimension dimButton = new Dimension(125, 50);
		Dimension dimPanelSmall = new Dimension(150, 50);
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

		// account status label
		JLabel labelAccount = new JLabel("Offline!", SwingConstants.CENTER);
		labelAccount.setBorder(border);
		labelAccount.setPreferredSize(dimPanelSmall);

		// title label
		this.setTitleLabel(
				new JLabel(language.translated("Welcome to the Circle Learning App") + "!", SwingConstants.CENTER));
		this.getTitleLabel().setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		this.getTitleLabel().setPreferredSize(new Dimension(500, 80));
		this.getTitleLabel().setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		// language combo box
		this.setLanguageComboBox(new JComboBox<String>(Language.names()));
		this.getLanguageComboBox().setPreferredSize(new Dimension(100, 30));
		this.getLanguageComboBox().setSelectedItem(language.toString());
		// label language combo box
		JPanel panelLanguage = new JPanel();
		panelLanguage.add(this.getLanguageComboBox());
		panelLanguage.setPreferredSize(dimPanelSmall);
		panelLanguage.setLayout(new GridBagLayout());

		// panel title
		JPanel panelTitle = new JPanel();
		panelTitle.add(labelAccount);
		panelTitle.add(this.getTitleLabel());
		panelTitle.add(panelLanguage);

		// log in button
		this.setLogInButton(new JButton(language.translated("Log In") + "!"));
		this.getLogInButton().setPreferredSize(dimButton);
		// panel log in button
		JPanel panelLogIn = new JPanel();
		panelLogIn.add(this.getLogInButton());

		// sign up button
		this.setSignUpButton(new JButton(language.translated("Sign Up") + "!"));
		this.getSignUpButton().setPreferredSize(dimButton);
		// panel sign up button
		JPanel panelSignUp = new JPanel();
		panelSignUp.add(this.getSignUpButton());

		// draw button
		this.setDrawButton(new JButton(language.translated("Draw") + "!"));
		this.getDrawButton().setPreferredSize(dimButton);
		// panel draw button
		JPanel panelDraw = new JPanel();
		panelDraw.add(this.getDrawButton());

		// inner circle button
		this.setInnerButton(new JButton(language.translated("Inscribed") + "!"));
		this.getInnerButton().setPreferredSize(dimButton);
		// panel inner circle button
		JPanel panelInner = new JPanel();
		panelInner.add(this.getInnerButton());

		// outer circle button
		this.setOuterButton(new JButton(language.translated("Circumscribed") + "!"));
		this.getOuterButton().setPreferredSize(dimButton);
		// panel outer circle button
		JPanel panelOuter = new JPanel();
		panelOuter.add(this.getOuterButton());

		// special circle button
		this.setSpecialButton(new JButton(language.translated("Special") + "!"));
		this.getSpecialButton().setPreferredSize(dimButton);
		// panel special circle button
		JPanel panelSpecial = new JPanel();
		panelSpecial.add(this.getSpecialButton());

		// exit button
		this.setExitButton(new JButton(language.translated("Exit") + "!"));
		this.getExitButton().setPreferredSize(dimButton);
		// panel exit button
		JPanel panelExit = new JPanel();
		panelExit.add(this.getExitButton());

		// control panel
		JPanel controlPanel = new JPanel();
		controlPanel.add(panelLogIn);
		controlPanel.add(panelSignUp);
		controlPanel.add(panelInner);
		controlPanel.add(panelDraw);
		controlPanel.add(panelOuter);
		controlPanel.add(panelExit);
		controlPanel.add(panelSpecial);
		controlPanel.setLayout(new GridLayout(0, 2));

		// main panel
		JPanel mainPanel = new JPanel();
		mainPanel.add(panelTitle);
		mainPanel.add(controlPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		this.setContentPane(mainPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
