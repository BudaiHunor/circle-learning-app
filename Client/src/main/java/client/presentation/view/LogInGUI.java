package client.presentation.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import client.model.Language;

public class LogInGUI extends AbstractGUI {
	private JTextField fieldIdentifier;
	private JPasswordField fieldPassword;

	private JButton buttonBack;
	private JButton buttonLogIn;
	private JButton buttonSignUp;

	// getters
	private JTextField getIdentifierField() {
		return this.fieldIdentifier;
	}

	private JPasswordField getPasswordField() {
		return this.fieldPassword;
	}

	public JButton getBackButton() {
		return this.buttonBack;
	}

	public JButton getLogInButton() {
		return this.buttonLogIn;
	}

	public JButton getSignUpButton() {
		return this.buttonSignUp;
	}

	// setters
	private void setIdentifierField(JTextField field) {
		this.fieldIdentifier = field;
	}

	private void setPasswordField(JPasswordField field) {
		this.fieldPassword = field;
	}

	private void setBackButton(JButton button) {
		this.buttonBack = button;
	}

	private void setLogInButton(JButton button) {
		this.buttonLogIn = button;
	}

	private void setSignUpButton(JButton button) {
		this.buttonSignUp = button;
	}

	// methods
	public String getIdentifierString() {
		return this.getIdentifierField().getText();
	}

	private void setIdentifierString(String identifier) {
		this.getIdentifierField().setText(identifier);
	}

	public String getPasswordString() {
		return new String(this.getPasswordField().getPassword());
	}

	private void setPasswordString(String password) {
		this.getPasswordField().setText(password);
	}

	// newInstance methods
	public static LogInGUI newInstance(Language language) {
		if (language == null) {
			return null;
		}
		return new LogInGUI(language);
	}

	// constructors
	private LogInGUI(Language language) {
		// set frame
		super(language.translated("Log In"));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(600, 500);

		Dimension dimButton = new Dimension(125, 50);
		Dimension dimField = new Dimension(200, 30);
		Dimension dimLabel = new Dimension(150, 30);
		int side = SwingConstants.RIGHT;

		// back button
		this.setBackButton(new JButton(language.translated("Back") + "!"));
		this.getBackButton().setPreferredSize(dimButton);

		// log in label
		JLabel labelLogIn = new JLabel(language.translated("Please Log In"), SwingConstants.CENTER);
		labelLogIn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		// panel log in label
		JPanel panelTitle = new JPanel();
		panelTitle.setPreferredSize(new Dimension(300, 50));
		panelTitle.add(labelLogIn);

		// empty label for balance
		JLabel labelEmpty = new JLabel();
		labelEmpty.setPreferredSize(dimButton);

		// header panel
		JPanel panelHeader = new JPanel();
		panelHeader.add(this.getBackButton());
		panelHeader.add(panelTitle);
		panelHeader.add(labelEmpty);

		// identifier label
		JLabel labelIdentifier = new JLabel(language.translated("Username") + " / " + language.translated("Email"),
				side);
		labelIdentifier.setPreferredSize(dimLabel);
		// identifier text field
		this.setIdentifierField(new JTextField());
		this.getIdentifierField().setPreferredSize(dimField);
		// identifier panel
		JPanel panelIdentifier = new JPanel();
		panelIdentifier.add(labelIdentifier);
		panelIdentifier.add(this.getIdentifierField());

		// password label
		JLabel labelPassword = new JLabel(language.translated("Password"), side);
		labelPassword.setPreferredSize(dimLabel);
		// password text field
		this.setPasswordField(new JPasswordField());
		this.getPasswordField().setPreferredSize(dimField);
		// password panel
		JPanel panelPassword = new JPanel();
		panelPassword.add(labelPassword);
		panelPassword.add(this.getPasswordField());

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

		// main panel
		JPanel mainPanel = new JPanel();
		mainPanel.add(panelHeader);
		mainPanel.add(panelIdentifier);
		mainPanel.add(panelPassword);
		mainPanel.add(panelLogIn);
		mainPanel.add(panelSignUp);
		mainPanel.setLayout(new GridLayout(0, 1));

		this.setContentPane(mainPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
