package client.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.model.Account;
import client.model.AccountValidators;
import client.model.Language;
import client.model.UserType;
import client.presentation.view.SignUpGUI;
import client.repository.AccountFactory;

public class SignUpController extends AbstractController {
	private SignUpGUI view;

	// getters
	private SignUpGUI getView() {
		return this.view;
	}

	// setters
	private void setView(SignUpGUI view) {
		this.view = view;
	}

	// methods
	public void goToMain() {
		this.getView().close();
		MainController.newInstance(this.getLanguage());
	}

	public void signUp() {
		// valid username format
		String username = this.getView().getUsernameString();
		if (!AccountValidators.validUsername(username)) {
			this.getView().showMessage("Invalid Username Format!", true);
			return;
		}
		// valid password format
		String password = this.getView().getPasswordString();
		if (!AccountValidators.validPassword(password)) {
			this.getView().showMessage("Invalid Password Format!", true);
			return;
		}
		// repeated password
		String repeatedPassword = this.getView().getPasswordAgainString();
		if (!password.equals(repeatedPassword)) {
			this.getView().showMessage("Wrong Second Password!", true);
			return;
		}
		// valid email format
		String email = this.getView().getEmailString();
		if (!AccountValidators.validEmail(email)) {
			this.getView().showMessage("Invalid Email Format!", true);
			return;
		}
		// sign up/create the account
		if (!AccountFactory.createAccount(username, password, email, UserType.USER)) {
			this.getView().showMessage("Account failed to create!", true);
			return;
		}
		// log in/read the account
		Account account = AccountFactory.readAccountByUsername(username, password);
		if (account == null) {
			account = AccountFactory.readAccountByEmail(email, password);
		}
		if (account == null) {
			this.getView().showMessage("WHAT THE HELL IS THIS?!", true);
			return;
		}

		this.getView().close();
		UserMainController.newInstance(account, this.getLanguage());
	}

	public void goToLogIn() {
		this.getView().close();
		LogInController.newInstance(this.getLanguage());
	}

	// newInstance methods
	public static SignUpController newInstance(Language language) {
		if (language == null) {
			return null;
		}
		return new SignUpController(language);
	}

	// constructors
	private SignUpController(Language language) {
		super(null, language);

		// set view
		this.setView(SignUpGUI.newInstance(language));

		// back button
		this.getView().getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpController.this.goToMain();
			}
		});

		// sign up button
		this.getView().getSignUpButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpController.this.signUp();
			}
		});

		// log in button
		this.getView().getLogInButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpController.this.goToLogIn();
			}
		});
	}
}
