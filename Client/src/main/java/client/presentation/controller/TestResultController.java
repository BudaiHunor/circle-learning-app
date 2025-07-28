package client.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.model.Account;
import client.model.Language;
import client.presentation.view.TestResultGUI;

public class TestResultController extends AbstractController {
	private TestResultGUI view;

	// getters
	private TestResultGUI getView() {
		return this.view;
	}

	// setters
	private void setView(TestResultGUI view) {
		this.view = view;
	}

	// methods
	public void goToTest() {
		this.getView().close();
		TestPageController.newInstance(this.getAccount(), this.getLanguage());
	}

	public void goToMain() {
		this.getView().close();
		switch (this.getAccount().getType()) {
		case ADMIN:
			AdminMainController.newInstance(this.getAccount(), this.getLanguage());
			return;
		case USER:
			UserMainController.newInstance(this.getAccount(), this.getLanguage());
			return;
		}
	}

	// newInstance methods
	public static TestResultController newInstance(Account account, Language language, double score) {
		if (account == null || language == null || !(0.0 <= score && score <= 10.0)) {
			return null;
		}
		return new TestResultController(account, language, score);
	}

	// constructors
	private TestResultController(Account account, Language language, double score) {
		super(account, language);

		// set view
		this.setView(TestResultGUI.newInstance(language, score));

		// button again
		this.getView().getAgainButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TestResultController.this.goToTest();
			}
		});

		// button continue
		this.getView().getContinueButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TestResultController.this.goToMain();
			}
		});
	}
}
