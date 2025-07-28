package client.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.model.Account;
import client.model.Language;
import client.model.SpecialCircles;
import client.model.UserType;
import client.presentation.view.AbstractGUI;
import client.presentation.view.UserMainGUI;

public class UserMainController extends AbstractController {
	private UserMainGUI view;

	// getters
	public UserMainGUI getView() {
		return view;
	}

	// setters
	public void setView(UserMainGUI view) {
		this.view = view;
	}

	// methods
	public void changeLanguage() {
		// change language
		String string = this.getView().getLanguageString();
		Language language = Language.stringToLanguage(string);
		this.setLangauge(language);

		// frame title
		string = language.translated("Online Main Page") + "!";
		this.getView().setTitle(string);

		// main title
		string = language.translated("Welcome to the Circle Learning App") + "!";
		this.getView().getTitleLabel().setText(string);

		// draw button
		string = language.translated("Draw") + "!";
		this.getView().getDrawButton().setText(string);

		// inscribed button
		string = language.translated("Inscribed") + "!";
		this.getView().getInnerButton().setText(string);

		// circumscribed button
		string = language.translated("Circumscribed") + "!";
		this.getView().getOuterButton().setText(string);

		// special button
		string = language.translated("Special") + "!";
		this.getView().getSpecialButton().setText(string);

		// test button
		string = language.translated("Test") + "!";
		this.getView().getTestButton().setText(string);

		// log out button
		string = language.translated("Log Out") + "!";
		this.getView().getLogOutButton().setText(string);

		// exit button
		string = language.translated("Exit") + "!";
		this.getView().getExitButton().setText(string);
	}

	public void logOut() {
		this.getView().close();
		MainController.newInstance(this.getLanguage());
	}

	public void goToDrawCircle() {
		this.getView().close();
		DrawCircleController.newInstance(this.getAccount(), this.getLanguage());
	}

	public void goToInnerCircle() {
		this.getView().close();
		InformationController.newInstance(this.getAccount(), this.getLanguage(),
				this.getLanguage().translated("Inscribed Circles"), SpecialCircles.INSCRIBED_CIRCLE_IMAGES,
				SpecialCircles.INSCRIBED_CIRCLE_TEXTS);
	}

	public void goToOuterCircle() {
		this.getView().close();
		InformationController.newInstance(this.getAccount(), this.getLanguage(),
				this.getLanguage().translated("Circumscribed Circles"), SpecialCircles.CIRCUMSCRIBED_CIRCLE_IMAGES,
				SpecialCircles.CIRCUMSCRIBED_CIRCLE_TEXTS);
	}

	private void goToSpecialCircle() {
		this.getView().close();
		InformationController.newInstance(this.getAccount(), this.getLanguage(),
				this.getLanguage().translated("Special Circles"), SpecialCircles.SPECIAL_CIRCLE_IMAGES,
				SpecialCircles.SPECIAL_CIRCLE_TEXTS);
	}

	public void goToTest() {
		this.getView().close();
		TestPageController.newInstance(this.getAccount(), this.getLanguage());
	}

	public void exit() {
		this.getView().close();
	}

	// newInstance methods
	public static UserMainController newInstance(Account account, Language language) {
		if (account == null || language == null) {
			return null;
		}
		if (!account.getType().equals(UserType.USER)) {
			new AbstractGUI(null) {
			}.showMessage("Provided account is not a User account!", true);
			return null;
		}
		return new UserMainController(account, language);
	}

	// constructors
	private UserMainController(Account account, Language language) {
		super(account, language);

		// set view
		this.setView(UserMainGUI.newInstance(account.getUsername(), language));

		// language combo box
		this.getView().getLanguageComboBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserMainController.this.changeLanguage();
			}
		});

		// log out button
		this.getView().getLogOutButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserMainController.this.logOut();
			}
		});

		// draw button
		this.getView().getDrawButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserMainController.this.goToDrawCircle();
			}
		});

		// inner button
		this.getView().getInnerButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserMainController.this.goToInnerCircle();
			}
		});

		// outer button
		this.getView().getOuterButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserMainController.this.goToOuterCircle();
			}
		});

		// special button
		this.getView().getSpecialButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserMainController.this.goToSpecialCircle();
			}
		});

		// test button
		this.getView().getTestButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserMainController.this.goToTest();
			}
		});

		// exit button
		this.getView().getExitButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserMainController.this.exit();
			}
		});
	}
}
