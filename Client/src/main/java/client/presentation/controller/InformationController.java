package client.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.model.Account;
import client.model.InformationModel;
import client.model.Language;
import client.presentation.view.InformationGUI;

public class InformationController extends AbstractController {
	private InformationGUI view;

	private InformationModel model;

	// getters
	private InformationGUI getView() {
		return this.view;
	}

	private InformationModel getModel() {
		return this.model;
	}

	// setters
	private void setView(InformationGUI view) {
		this.view = view;
	}

	private void setModel(InformationModel model) {
		this.model = model;
	}

	// methods
	private void goToMain() {
		this.getView().close();
		if (this.getAccount() == null) {
			MainController.newInstance(this.getLanguage());
			return;
		}
		switch (this.getAccount().getType()) {
		case ADMIN:
			AdminMainController.newInstance(this.getAccount(), this.getLanguage());
			return;
		case USER:
			UserMainController.newInstance(this.getAccount(), this.getLanguage());
			return;
		}
	}

	private void showPrevious() {
		this.getModel().decIndex();
	}

	private void showNext() {
		this.getModel().incIndex();
	}

	// newInstance methods
	public static InformationController newInstance(Account account, Language language, String title,
			String[] imageNames, String[] textNames) {
		if (language == null || title == null || imageNames == null || textNames == null) {
			return null;
		}
		return new InformationController(account, language, title, imageNames, textNames);
	}

	// constructors
	private InformationController(Account account, Language language, String title, String[] imageNames,
			String[] textNames) {
		super(account, language);

		// set view
		this.setView(InformationGUI.newInstance(language, title));

		// button back
		this.getView().getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InformationController.this.goToMain();
			}
		});

		// button prev
		this.getView().getPreviousButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InformationController.this.showPrevious();
			}
		});

		// button next
		this.getView().getNextButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InformationController.this.showNext();
			}
		});

		// set model
		this.setModel(InformationModel.newInstance(imageNames, textNames));
		this.getModel().addObserver(this.getView());
		// notify the new observer/the view
		this.getModel().notifyAll(this.getModel());
	}
}
