package client.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.model.Language;
import client.model.SpecialCircles;
import client.presentation.view.MainGUI;

public class MainController extends AbstractController {
	private MainGUI view;

	// getters
	private MainGUI getView() {
		return this.view;
	}

	// setters
	private void setView(MainGUI view) {
		this.view = view;
	}

	// methods
	private void changeLanguage() {
		// change language
		String string = this.getView().getLanguageString();
		Language language = Language.stringToLanguage(string);
		this.setLangauge(language);

		// frame title
		string = language.translated("Offline Main Page") + "!";
		this.getView().setTitle(string);

		// main title
		string = language.translated("Welcome to the Circle Learning App") + "!";
		this.getView().getTitleLabel().setText(string);

		// log in button
		string = language.translated("Log In") + "!";
		this.getView().getLogInButton().setText(string);

		// sign up button
		string = language.translated("Sign Up") + "!";
		this.getView().getSignUpButton().setText(string);

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

		// exit button
		string = language.translated("Exit") + "!";
		this.getView().getExitButton().setText(string);
	}

	private void goToLogIn() {
		this.getView().close();
		LogInController.newInstance(this.getLanguage());
	}

	private void goToSignUp() {
		this.getView().close();
		SignUpController.newInstance(this.getLanguage());
	}

	private void goToDrawCircle() {
		this.getView().close();
		DrawCircleController.newInstance(null, this.getLanguage());
	}

	private void goToInnerCircle() {
		this.getView().close();
		InformationController.newInstance(null, this.getLanguage(), this.getLanguage().translated("Inscribed Circles"),
				SpecialCircles.INSCRIBED_CIRCLE_IMAGES, SpecialCircles.INSCRIBED_CIRCLE_TEXTS);
	}

	private void goToOuterCircle() {
		this.getView().close();
		InformationController.newInstance(null, this.getLanguage(),
				this.getLanguage().translated("Circumscribed Circles"), SpecialCircles.CIRCUMSCRIBED_CIRCLE_IMAGES,
				SpecialCircles.CIRCUMSCRIBED_CIRCLE_TEXTS);
	}

	private void goToSpecialCircle() {
		this.getView().close();
		InformationController.newInstance(null, this.getLanguage(), this.getLanguage().translated("Special Circles"),
				SpecialCircles.SPECIAL_CIRCLE_IMAGES, SpecialCircles.SPECIAL_CIRCLE_TEXTS);
	}

	private void exit() {
		this.getView().close();
	}

	// newInstance methods
	public static MainController newInstance(Language language) {
		if (language == null) {
			return null;
		}
		return new MainController(language);
	}

	/**
	 * MainController with default English language.
	 */
	public static MainController newInstance() {
		return new MainController(Language.ENGLISH);
	}

	// constructors
	private MainController(Language language) {
		super(null, language);

		// set view
		this.setView(MainGUI.newInstance(language));

		// language combo box
		this.getView().getLanguageComboBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.this.changeLanguage();
			}
		});

		// log in button
		this.getView().getLogInButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.this.goToLogIn();
			}
		});

		// sign up button
		this.getView().getSignUpButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.this.goToSignUp();
			}
		});

		// draw button
		this.getView().getDrawButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.this.goToDrawCircle();
			}
		});

		// inner button
		this.getView().getInnerButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.this.goToInnerCircle();
			}
		});

		// outer button
		this.getView().getOuterButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.this.goToOuterCircle();
			}
		});

		// special button
		this.getView().getSpecialButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.this.goToSpecialCircle();
			}
		});

		// exit button
		this.getView().getExitButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.this.exit();
			}
		});
	}
}
