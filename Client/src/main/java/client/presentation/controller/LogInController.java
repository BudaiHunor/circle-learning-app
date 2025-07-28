package client.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.model.Account;
import client.model.Language;
import client.presentation.view.LogInGUI;
import client.repository.AccountFactory;

public class LogInController extends AbstractController {
	private LogInGUI view;

	// getters
	private LogInGUI getView() {
		return this.view;
	}

	// setters
	private void setView(LogInGUI view) {
		this.view = view;
	}

	// methods
	public void goToMain() {
		this.getView().close();
		MainController.newInstance(this.getLanguage());
	}

	public void logIn() {
		String identifier = this.getView().getIdentifierString();
		String password = this.getView().getPasswordString();

		// log in/read the account
		Account account = AccountFactory.readAccountByUsername(identifier, password);
		if (account == null) {
			account = AccountFactory.readAccountByEmail(identifier, password);
		}
		if (account == null) {
			this.getView().showMessage("Wrong username / email or password!", true);
			return;
		}

		this.getView().close();
		switch (account.getType()) {
		case ADMIN:
			AdminMainController.newInstance(account, this.getLanguage());
			return;
		case USER:
			UserMainController.newInstance(account, this.getLanguage());
			return;
		}
	}

	public void goToSignUp() {
		this.getView().close();
		SignUpController.newInstance(this.getLanguage());
	}

	// newInstance methods
	public static LogInController newInstance(Language language) {
		if (language == null) {
			return null;
		}
		return new LogInController(language);
	}

	// constructors
	private LogInController(Language language) {
		super(null, language);

		// set view
		this.setView(LogInGUI.newInstance(language));

		// back button
		this.getView().getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LogInController.this.goToMain();
			}
		});

		// log in button
		this.getView().getLogInButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LogInController.this.logIn();
			}
		});

		// sign up button
		this.getView().getSignUpButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LogInController.this.goToSignUp();
			}
		});
	}
}
