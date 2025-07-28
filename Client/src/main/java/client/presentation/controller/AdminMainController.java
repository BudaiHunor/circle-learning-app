package client.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import client.model.Account;
import client.model.AccountValidators;
import client.model.AdminMainModel;
import client.model.Language;
import client.model.SpecialCircles;
import client.model.UserType;
import client.presentation.view.AbstractGUI;
import client.presentation.view.AdminMainGUI;
import client.repository.AccountFactory;

public class AdminMainController extends AbstractController {
	private AdminMainGUI view;

	private AdminMainModel model;

	// getters
	public AdminMainGUI getView() {
		return this.view;
	}

	private AdminMainModel getModel() {
		return this.model;
	}

	// setters
	public void setView(AdminMainGUI view) {
		this.view = view;
	}

	private void setModel(AdminMainModel model) {
		this.model = model;
	}

	// methods
	protected void changeLanguage() {
		// change language
		String string = this.getView().getLanguageString();
		Language language = Language.stringToLanguage(string);
		this.setLangauge(language);

		// frame title
		string = language.translated("Admin Main Page") + "!";
		this.getView().setTitle(string);

		// table
		DefaultTableModel model = (DefaultTableModel) this.getView().getTableModel();
		model.setColumnIdentifiers(new String[] { language.translated("ID"), language.translated("Username"),
				language.translated("Password"), language.translated("Email"), language.translated("Type") });

		// main title
		string = language.translated("Welcome") + ", Admin " + this.getAccount().getUsername() + "!";
		this.getView().getTitleLabel().setText(string);

		// id label
		string = language.translated("ID");
		this.getView().getIDLabel().setText(string);

		// username label
		string = language.translated("Username");
		this.getView().getUsernameLabel().setText(string);

		// password label
		string = language.translated("Password");
		this.getView().getPasswordLabel().setText(string);

		// email label
		string = language.translated("Email");
		this.getView().getEmailLabel().setText(string);

		// type label
		string = language.translated("Type");
		this.getView().getTypeLabel().setText(string);

		// clear button
		string = language.translated("Clear");
		this.getView().getClearButton().setText(string);

		// add button
		string = language.translated("Add");
		this.getView().getAddButton().setText(string);

		// get button
		string = language.translated("Get");
		this.getView().getGetButton().setText(string);

		// modify button
		string = language.translated("Modify");
		this.getView().getModifyButton().setText(string);

		// remove button
		string = language.translated("Remove");
		this.getView().getRemoveButton().setText(string);

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

	private void readAllAccounts() {
		Language language = this.getLanguage();

		List<Account> list = AccountFactory.allAccounts();

		String[][] data = new String[list.size()][5];
		String[] header = new String[] { language.translated("ID"), language.translated("Username"),
				language.translated("Password"), language.translated("Email"), language.translated("Type") };

		int i = 0;
		for (Account account : list) {
			data[i++] = new String[] { (account.getId() + ""), account.getUsername(), account.getPassword(),
					account.getEmail(), account.getType().toString() };
		}

		this.getModel().setTableModel(new DefaultTableModel(data, header));
	}

	private void clearFields() {
		this.getModel().setID("");
		this.getModel().setUsername("");
		this.getModel().setPassword("");
		this.getModel().setEmail("");
		this.getModel().setType("");
	}

	private void createAccount() {
		String username = this.getView().getUsernameString();
		if (!AccountValidators.validUsername(username)) {
			this.getView().showMessage("Invalid Username Format!", true);
			return;
		}
		String password = this.getView().getPasswordString();
		if (!AccountValidators.validPassword(password)) {
			this.getView().showMessage("Invalid Password Format!", true);
			return;
		}
		String email = this.getView().getEmailString();
		if (!AccountValidators.validEmail(email)) {
			this.getView().showMessage("Invalid Email Format!", true);
			return;
		}
		UserType type = UserType.fromString(this.getView().getTypeString());
		if (type == null) {
			this.getView().showMessage("Invalid Type Format!", true);
			return;
		}
		if (!AccountFactory.createAccount(username, password, email, type)) {
			this.getView().showMessage("Account failed to create!", true);
			return;
		}
		this.readAllAccounts();
		this.getView().showMessage("Account created successfully!", false);
	}

	private boolean readAccountByID() {
		int id;
		try {
			id = Integer.parseInt(this.getView().getIDString());
		} catch (NumberFormatException e) {
			this.clearFields();
			this.getView().showMessage("Number Format Error for ID field!", true);
			return false;
		}
		Account account = AccountFactory.readAccount(id);
		if (account == null) {
			this.clearFields();
			this.getView().showMessage("Account failed to be read!", true);
			return false;
		}

		this.getModel().setID(account.getId() + "");
		this.getModel().setUsername(account.getUsername());
		this.getModel().setPassword(account.getPassword());
		this.getModel().setEmail(account.getEmail());
		this.getModel().setType(account.getType().toString());
		this.readAllAccounts();
		return true;
	}

//private boolean readAccountByUsername() {
//	String username = this.getView().getUsernameString();
//	if (username == null) {
//		return false;
//	}
//
//	Account account = AccountFactory.readAccountByUsername(username, "Why password?!");
//
//	return true;
//}

	private void readAccount() {
		if (this.readAccountByID()) {
			// this.getView().showMessage("Succes!", false);
			return;
		}
	}

	private void updateAccount() {
		// valid ID format
		int id;
		try {
			id = Integer.parseInt(this.getView().getIDString());
		} catch (NumberFormatException e) {
			this.getView().showMessage("Number Format Error for ID field!", true);
			return;
		}
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
		// valid email format
		String email = this.getView().getEmailString();
		if (!AccountValidators.validEmail(email)) {
			this.getView().showMessage("Invalid Email Format!", true);
			return;
		}
		// valid type format
		UserType type = UserType.fromString(this.getView().getTypeString());
		if (type == null) {
			this.getView().showMessage("Invalid Type Format!", true);
			return;
		}

		boolean usernameOk = AccountFactory.updateAccount(id, "username", username);
		boolean passwordOk = AccountFactory.updateAccount(id, "password", password);
		boolean emailOk = AccountFactory.updateAccount(id, "email", email);
		boolean typeOk = AccountFactory.updateAccount(id, "isAdmin", type);
		if (!usernameOk || !passwordOk || !emailOk || !typeOk) {
			this.getView().showMessage("Account failed to update!", true);
			return;
		}
		this.readAllAccounts();
		this.getView().showMessage("Account updated successfully!", false);
	}

	private void deleteAccount() {
		int id;
		try {
			id = Integer.parseInt(this.getView().getIDString());
		} catch (NumberFormatException e) {
			this.getView().showMessage("Number Format Error for ID Field!", true);
			return;
		}
		if (!AccountFactory.deleteAccount(id)) {
			this.getView().showMessage("Account failed to delete!", true);
			return;
		}
		this.readAllAccounts();
		this.getView().showMessage("Account deleted successfully!", false);
	}

	private void logOut() {
		this.getView().close();
		MainController.newInstance(this.getLanguage());
	}

	private void goToDrawCircle() {
		this.getView().close();
		DrawCircleController.newInstance(this.getAccount(), this.getLanguage());
	}

	private void goToInnerCircle() {
		this.getView().close();
		InformationController.newInstance(this.getAccount(), this.getLanguage(), "Inscribed Circles",
				SpecialCircles.INSCRIBED_CIRCLE_IMAGES, SpecialCircles.INSCRIBED_CIRCLE_TEXTS);
	}

	private void goToOuterCircle() {
		this.getView().close();
		InformationController.newInstance(this.getAccount(), this.getLanguage(), "Circumscribed Circles",
				SpecialCircles.CIRCUMSCRIBED_CIRCLE_IMAGES, SpecialCircles.CIRCUMSCRIBED_CIRCLE_TEXTS);
	}

	private void goToSpecialCircle() {
		this.getView().close();
		InformationController.newInstance(this.getAccount(), this.getLanguage(), "Special Circles",
				SpecialCircles.SPECIAL_CIRCLE_IMAGES, SpecialCircles.SPECIAL_CIRCLE_TEXTS);
	}

	private void goToTest() {
		this.getView().close();
		TestPageController.newInstance(this.getAccount(), this.getLanguage());
	}

	private void exit() {
		this.getView().close();
	}

	// newInstance methods
	public static AdminMainController newInstance(Account account, Language language) {
		if (account == null || language == null) {
			return null;
		}
		if (!account.getType().equals(UserType.ADMIN)) {
			new AbstractGUI(null) {
			}.showMessage("Provided account is not an Admin account!", true);
			return null;
		}
		return new AdminMainController(account, language);
	}

	// constructors
	private AdminMainController(Account account, Language language) {
		super(account, language);

		// set view
		this.setView(AdminMainGUI.newInstance(this.getAccount().getUsername(), language));

		// language combo box
		this.getView().getLanguageComboBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.changeLanguage();
			}
		});

		// button clear
		this.getView().getClearButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.clearFields();
			}
		});

		// button add
		this.getView().getAddButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.createAccount();
			}
		});

		// button get
		this.getView().getGetButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.readAccount();
			}
		});

		// button modify
		this.getView().getModifyButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.updateAccount();
			}
		});

		// button remove
		this.getView().getRemoveButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.deleteAccount();
			}
		});

		// log out button
		this.getView().getLogOutButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.logOut();
			}
		});

		// draw button
		this.getView().getDrawButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.goToDrawCircle();
			}
		});

		// inner button
		this.getView().getInnerButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.goToInnerCircle();
			}
		});

		// outer button
		this.getView().getOuterButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.goToOuterCircle();
			}
		});

		// special button
		this.getView().getSpecialButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.goToSpecialCircle();
			}
		});

		// test button
		this.getView().getTestButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.goToTest();
			}
		});

		// exit button
		this.getView().getExitButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMainController.this.exit();
			}
		});

		// set model
		this.setModel(AdminMainModel.newInstance(new DefaultTableModel(0, 5), "", "", "", "", ""));
		this.getModel().addObserver(this.getView());

		// update table
		this.readAllAccounts();
	}
}
