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

public class SignUpGUI extends AbstractGUI {
	private JTextField fieldUsername;
	private JPasswordField fieldPassword;
	private JPasswordField fieldPasswordAgain;
	private JTextField fieldEmail;

	private JButton buttonBack;
	private JButton buttonSignUp;
	private JButton buttonLogIn;

	// getters
	private JTextField getUsernameField() {
		return this.fieldUsername;
	}

	private JPasswordField getPasswordField() {
		return this.fieldPassword;
	}

	private JPasswordField getPasswordAgainField() {
		return this.fieldPasswordAgain;
	}

	private JTextField getEmailField() {
		return this.fieldEmail;
	}

	public JButton getBackButton() {
		return this.buttonBack;
	}

	public JButton getSignUpButton() {
		return this.buttonSignUp;
	}

	public JButton getLogInButton() {
		return this.buttonLogIn;
	}

	// setters
	private void setUsernameField(JTextField field) {
		this.fieldUsername = field;
	}

	private void setPasswordField(JPasswordField field) {
		this.fieldPassword = field;
	}

	private void setPasswordAgainField(JPasswordField field) {
		this.fieldPasswordAgain = field;
	}

	private void setEmailField(JTextField field) {
		this.fieldEmail = field;
	}

	private void setBackButton(JButton button) {
		this.buttonBack = button;
	}

	private void setSignUpButton(JButton button) {
		this.buttonSignUp = button;
	}

	private void setLogInButton(JButton button) {
		this.buttonLogIn = button;
	}

	// methods
	public String getUsernameString() {
		return this.getUsernameField().getText();
	}

	private void setUsernameString(String username) {
		this.getUsernameField().setText(username);
	}

	public String getPasswordString() {
		return new String(this.getPasswordField().getPassword());
	}

	private void setPasswordString(String password) {
		this.getPasswordField().setText(password);
	}

	public String getPasswordAgainString() {
		return new String(this.getPasswordAgainField().getPassword());
	}

	private void setPasswordAgainString(String passwordAgain) {
		this.getPasswordAgainField().setText(passwordAgain);
	}

	public String getEmailString() {
		return this.getEmailField().getText();
	}

	private void setEmailString(String email) {
		this.getEmailField().setText(email);
	}

	// newInstance methods
	public static SignUpGUI newInstance(Language language) {
		if (language == null) {
			return null;
		}
		return new SignUpGUI(language);
	}

	// constructors
	private SignUpGUI(Language language) {
		// set frame
		super(language.translated("Sign Up"));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(600, 500);

		Dimension dimButton = new Dimension(125, 50);
		Dimension dimField = new Dimension(200, 30);
		Dimension dimLabel = new Dimension(120, 30);
		int side = SwingConstants.RIGHT;

		// back button
		this.setBackButton(new JButton(language.translated("Back") + "!"));
		this.getBackButton().setPreferredSize(dimButton);

		// sign up label
		JLabel labelSignUp = new JLabel(language.translated("Please Sign Up"), SwingConstants.CENTER);
		labelSignUp.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		// panel sign up label
		JPanel panelTitle = new JPanel();
		panelTitle.add(labelSignUp);
		panelTitle.setPreferredSize(new Dimension(300, 50));

		// empty label for balance
		JLabel labelEmpty = new JLabel();
		labelEmpty.setPreferredSize(dimButton);

		// header panel
		JPanel panelHeader = new JPanel();
		panelHeader.add(this.getBackButton());
		panelHeader.add(panelTitle);
		panelHeader.add(labelEmpty);

		// username label
		JLabel labelUsername = new JLabel(language.translated("Username"), side);
		labelUsername.setPreferredSize(dimLabel);
		// username text field
		this.setUsernameField(new JTextField());
		this.getUsernameField().setPreferredSize(dimField);
		// username panel
		JPanel panelUsername = new JPanel();
		panelUsername.add(labelUsername);
		panelUsername.add(this.getUsernameField());

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

		// password again label
		JLabel labelPasswordAgain = new JLabel(language.translated("Repeat Password"), side);
		labelPasswordAgain.setPreferredSize(dimLabel);
		// password again text field
		this.setPasswordAgainField(new JPasswordField());
		this.getPasswordAgainField().setPreferredSize(dimField);
		// password again panel
		JPanel panelPasswordAgain = new JPanel();
		panelPasswordAgain.add(labelPasswordAgain);
		panelPasswordAgain.add(this.getPasswordAgainField());

		// email label
		JLabel labelEmail = new JLabel(language.translated("Email"), side);
		labelEmail.setPreferredSize(dimLabel);
		// email text field
		this.setEmailField(new JTextField());
		this.getEmailField().setPreferredSize(dimField);
		// email panel
		JPanel panelEmail = new JPanel();
		panelEmail.add(labelEmail);
		panelEmail.add(this.getEmailField());

		// sign up button
		this.setSignUpButton(new JButton(language.translated("Sign Up") + "!"));
		this.getSignUpButton().setPreferredSize(dimButton);
		// panel sign up button
		JPanel panelSignUp = new JPanel();
		panelSignUp.add(this.getSignUpButton());

		// log in button
		this.setLogInButton(new JButton(language.translated("Log In") + "!"));
		this.getLogInButton().setPreferredSize(dimButton);
		// panel log in button
		JPanel panelLogIn = new JPanel();
		panelLogIn.add(this.getLogInButton());

		// main panel
		JPanel mainPanel = new JPanel();
		mainPanel.add(panelHeader);
		mainPanel.add(panelUsername);
		mainPanel.add(panelPassword);
		mainPanel.add(panelPasswordAgain);
		mainPanel.add(panelEmail);
		mainPanel.add(panelSignUp);
		mainPanel.add(panelLogIn);
		mainPanel.setLayout(new GridLayout(0, 1));

		this.setContentPane(mainPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
