package client.presentation.controller;

import client.model.Account;
import client.model.Language;

public abstract class AbstractController {
	private Account account;
	private Language language;

	// getters
	protected Account getAccount() {
		return this.account;
	}

	public Language getLanguage() {
		return this.language;
	}

	// setters
	private void setAccount(Account account) {
		this.account = account;
	}

	protected void setLangauge(Language language) {
		this.language = language;
	}

	// methods

	// newInstance methods
	// CAN'T HAVE ANY!

	// constructors
	protected AbstractController(Account account, Language language) {
		this.setAccount(account);
		this.setLangauge(language);
	}
}
