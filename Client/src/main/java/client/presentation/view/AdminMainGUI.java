package client.presentation.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.TableModel;

import client.model.AdminMainModel;
import client.model.Language;
import client.model.ObserverIF;

public class AdminMainGUI extends AbstractGUI implements ObserverIF {
	private JTable table;
	private JTextField fieldID;
	private JTextField fieldUsername;
	private JTextField fieldPassword;
	private JTextField fieldEmail;
	private JTextField fieldType;

	private JButton buttonLogOut;
	private JButton buttonInner;
	private JButton buttonOuter;
	private JButton buttonSpecial;
	private JButton buttonDraw;
	private JButton buttonTest;
	private JButton buttonExit;

	private JButton buttonClear;
	private JButton buttonAdd;
	private JButton buttonGet;
	private JButton buttonModify;
	private JButton buttonRemove;

	private JComboBox<String> languageComboBox;

	private JLabel labelTitle;

	private JLabel labelID;
	private JLabel labelUsername;
	private JLabel labelPassword;
	private JLabel labelEmail;
	private JLabel labelType;

	// getters
	private JTable getTable() {
		return this.table;
	}

	private JTextField getIDField() {
		return this.fieldID;
	}

	private JTextField getUsernameField() {
		return this.fieldUsername;
	}

	private JTextField getPasswordField() {
		return this.fieldPassword;
	}

	private JTextField getEmailField() {
		return this.fieldEmail;
	}

	private JTextField getTypeField() {
		return this.fieldType;
	}

	public JButton getLogOutButton() {
		return this.buttonLogOut;
	}

	public JButton getInnerButton() {
		return this.buttonInner;
	}

	public JButton getOuterButton() {
		return this.buttonOuter;
	}

	public JButton getSpecialButton() {
		return this.buttonSpecial;
	}

	public JButton getDrawButton() {
		return this.buttonDraw;
	}

	public JButton getTestButton() {
		return this.buttonTest;
	}

	public JButton getExitButton() {
		return this.buttonExit;
	}

	public JButton getClearButton() {
		return this.buttonClear;
	}

	public JButton getAddButton() {
		return this.buttonAdd;
	}

	public JButton getGetButton() {
		return this.buttonGet;
	}

	public JButton getModifyButton() {
		return this.buttonModify;
	}

	public JButton getRemoveButton() {
		return this.buttonRemove;
	}

	public JComboBox<String> getLanguageComboBox() {
		return this.languageComboBox;
	}

	public JLabel getTitleLabel() {
		return this.labelTitle;
	}

	public JLabel getIDLabel() {
		return this.labelID;
	}

	public JLabel getUsernameLabel() {
		return this.labelUsername;
	}

	public JLabel getPasswordLabel() {
		return this.labelPassword;
	}

	public JLabel getEmailLabel() {
		return this.labelEmail;
	}

	public JLabel getTypeLabel() {
		return this.labelType;
	}

	// setters
	private void setTable(JTable table) {
		this.table = table;
	}

	private void setIDField(JTextField field) {
		this.fieldID = field;
	}

	private void setUsernameField(JTextField field) {
		this.fieldUsername = field;
	}

	private void setPasswordField(JTextField field) {
		this.fieldPassword = field;
	}

	private void setEmailField(JTextField field) {
		this.fieldEmail = field;
	}

	private void setTypeField(JTextField field) {
		this.fieldType = field;
	}

	private void setLogOutButton(JButton button) {
		this.buttonLogOut = button;
	}

	private void setInnerButton(JButton button) {
		this.buttonInner = button;
	}

	private void setOuterButton(JButton button) {
		this.buttonOuter = button;
	}

	private void setSpecialButton(JButton button) {
		this.buttonSpecial = button;
	}

	private void setDrawButton(JButton button) {
		this.buttonDraw = button;
	}

	private void setTestButton(JButton button) {
		this.buttonTest = button;
	}

	private void setExitButton(JButton button) {
		this.buttonExit = button;
	}

	private void setClearButton(JButton button) {
		this.buttonClear = button;
	}

	private void setAddButton(JButton button) {
		this.buttonAdd = button;
	}

	private void setGetButton(JButton button) {
		this.buttonGet = button;
	}

	private void setModifyButton(JButton button) {
		this.buttonModify = button;
	}

	private void setRemoveButton(JButton button) {
		this.buttonRemove = button;
	}

	private void setLanguageComboBox(JComboBox<String> comboBox) {
		this.languageComboBox = comboBox;
	}

	private void setTitleLabel(JLabel label) {
		this.labelTitle = label;
	}

	private void setIDLabel(JLabel label) {
		this.labelID = label;
	}

	private void setUsernameLabel(JLabel label) {
		this.labelUsername = label;
	}

	private void setPasswordLabel(JLabel label) {
		this.labelPassword = label;
	}

	private void setEmailLabel(JLabel label) {
		this.labelEmail = label;
	}

	private void setTypeLabel(JLabel label) {
		this.labelType = label;
	}

	// methods
	public TableModel getTableModel() {
		return this.getTable().getModel();
	}

	private void setTableModel(TableModel model) {
		this.getTable().setModel(model);
	}

	public String getIDString() {
		return this.getIDField().getText();
	}

	private void setIDString(String id) {
		this.getIDField().setText(id);
	}

	public String getUsernameString() {
		return this.getUsernameField().getText();
	}

	private void setUsernameString(String username) {
		this.getUsernameField().setText(username);
	}

	public String getPasswordString() {
		return this.getPasswordField().getText();
	}

	private void setPasswordString(String password) {
		this.getPasswordField().setText(password);
	}

	public String getEmailString() {
		return this.getEmailField().getText();
	}

	private void setEmailString(String email) {
		this.getEmailField().setText(email);
	}

	public String getTypeString() {
		return this.getTypeField().getText();
	}

	private void setTypeString(String type) {
		this.getTypeField().setText(type);
	}

	public String getLanguageString() {
		return (String) this.getLanguageComboBox().getSelectedItem();
	}

	private void setLanguageString(String language) {
		this.getLanguageComboBox().setSelectedItem(language);
	}

//	public void updateTableLanguage(Language language) {
//		DefaultTableModel model = (DefaultTableModel) this.getTableModel();
//		model.setColumnIdentifiers(new String[] { language.translated("ID"), language.translated("Username"),
//				language.translated("Password"), language.translated("Email"), language.translated("Type") });
//	}

	// ObserverIF overrides
	@Override
	public void update(Object obj) {
		AdminMainModel model = (AdminMainModel) obj;

		this.setTableModel(model.getTableModel());
		this.setIDString(model.getID());
		this.setUsernameString(model.getUsername());
		this.setPasswordString(model.getPassword());
		this.setEmailString(model.getEmail());
		this.setTypeString(model.getType());
	}

	// newInstance methods
	public static AdminMainGUI newInstance(String username, Language language) {
		return new AdminMainGUI(username, language);
	}

	// constructors
	private AdminMainGUI(String username, Language language) {
		// set frame
		super(language.translated("Admin Main Page") + "!");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(1150, 650);

		Dimension dimTextFieldWide = new Dimension(180, 20);
		Dimension dimTextFieldNarrow = new Dimension(120, 20);
		Dimension dimButton = new Dimension(125, 50);

		// TITLE PANEL ==================================================

		// title label
		this.setTitleLabel(
				new JLabel(language.translated("Welcome") + ", Admin " + username + "!", SwingConstants.CENTER));
		this.getTitleLabel().setPreferredSize(new Dimension(800, 50));
		this.getTitleLabel().setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		// panel title
		JPanel panelTitle = new JPanel();
		panelTitle.add(this.getTitleLabel());

		// ADMIN PANEL ==================================================

		// table data
		this.setTable(new JTable());
		// scroll table
		JScrollPane scroll = new JScrollPane(this.getTable());
		scroll.setPreferredSize(new Dimension(900, 250));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// panel scroll
		JPanel panelScroll = new JPanel();
		panelScroll.add(scroll);

		// label id
		this.setIDLabel(new JLabel(language.translated("ID"), SwingConstants.CENTER));
		// label username
		this.setUsernameLabel(new JLabel(language.translated("Username"), SwingConstants.CENTER));
		// label password
		this.setPasswordLabel(new JLabel(language.translated("Password"), SwingConstants.CENTER));
		// label email
		this.setEmailLabel(new JLabel(language.translated("Email"), SwingConstants.CENTER));
		// label type
		this.setTypeLabel(new JLabel(language.translated("Type"), SwingConstants.CENTER));

		// field id
		this.setIDField(new JTextField());
		this.getIDField().setPreferredSize(dimTextFieldNarrow);
		// panel field id
		JPanel panelID = new JPanel();
		panelID.add(this.getIDField());

		// field username
		this.setUsernameField(new JTextField());
		this.getUsernameField().setPreferredSize(dimTextFieldWide);
		// panel field username
		JPanel panelUsername = new JPanel();
		panelUsername.add(this.getUsernameField());

		// field password
		this.setPasswordField(new JTextField());
		this.getPasswordField().setPreferredSize(dimTextFieldWide);
		// panel field password
		JPanel panelPassword = new JPanel();
		panelPassword.add(this.getPasswordField());

		// field email
		this.setEmailField(new JTextField());
		this.getEmailField().setPreferredSize(dimTextFieldWide);
		// panel field email
		JPanel panelEmail = new JPanel();
		panelEmail.add(this.getEmailField());

		// field type
		this.setTypeField(new JTextField());
		this.getTypeField().setPreferredSize(dimTextFieldNarrow);
		// panel field type
		JPanel panelType = new JPanel();
		panelType.add(this.getTypeField());

		// button clear
		this.setClearButton(new JButton(language.translated("Clear") + "!"));
		this.getClearButton().setPreferredSize(dimButton);
		// panel button all
		JPanel panelButtonClear = new JPanel();
		panelButtonClear.add(this.getClearButton());

		// button add
		this.setAddButton(new JButton(language.translated("Add") + "!"));
		this.getAddButton().setPreferredSize(dimButton);
		// panel button add
		JPanel panelButtonAdd = new JPanel();
		panelButtonAdd.add(this.getAddButton());

		// button get
		this.setGetButton(new JButton(language.translated("Get") + "!"));
		this.getGetButton().setPreferredSize(dimButton);
		// panel button get
		JPanel panelButtonGet = new JPanel();
		panelButtonGet.add(this.getGetButton());

		// button modify
		this.setModifyButton(new JButton(language.translated("Modify") + "!"));
		this.getModifyButton().setPreferredSize(dimButton);
		// panel button modify
		JPanel panelButtonModify = new JPanel();
		panelButtonModify.add(this.getModifyButton());

		// button remove
		this.setRemoveButton(new JButton(language.translated("Remove") + "!"));
		this.getRemoveButton().setPreferredSize(dimButton);
		// panel button remove
		JPanel panelButtonRemove = new JPanel();
		panelButtonRemove.add(this.getRemoveButton());

		// panel components
		JPanel panelComponents = new JPanel();
		panelComponents.add(this.getIDLabel());
		panelComponents.add(this.getUsernameLabel());
		panelComponents.add(this.getPasswordLabel());
		panelComponents.add(this.getEmailLabel());
		panelComponents.add(this.getTypeLabel());
		panelComponents.add(panelID);
		panelComponents.add(panelUsername);
		panelComponents.add(panelPassword);
		panelComponents.add(panelEmail);
		panelComponents.add(panelType);
		panelComponents.add(panelButtonClear);
		panelComponents.add(panelButtonAdd);
		panelComponents.add(panelButtonGet);
		panelComponents.add(panelButtonModify);
		panelComponents.add(panelButtonRemove);
		panelComponents.setLayout(new GridLayout(0, 5));

		// USER PANEL ==================================================

		// language combo box
		this.setLanguageComboBox(new JComboBox<String>(Language.names()));
		this.getLanguageComboBox().setPreferredSize(new Dimension(125, 30));
		this.getLanguageComboBox().setSelectedItem(language.toString());
		// panel language combo box
		JPanel panelLanguage = new JPanel();
		panelLanguage.add(this.getLanguageComboBox());

		// log out button
		this.setLogOutButton(new JButton(language.translated("Log Out") + "!"));
		this.getLogOutButton().setPreferredSize(dimButton);
		// panel log out button
		JPanel panelLogOut = new JPanel();
		panelLogOut.add(this.getLogOutButton());

		// draw button
		this.setDrawButton(new JButton(language.translated("Draw") + "!"));
		this.getDrawButton().setPreferredSize(dimButton);
		// panel draw button
		JPanel panelDraw = new JPanel();
		panelDraw.add(this.getDrawButton());

		// inner circle button
		this.setInnerButton(new JButton(language.translated("Inscribed") + "!"));
		this.getInnerButton().setPreferredSize(dimButton);
		// panel inner circle button
		JPanel panelInner = new JPanel();
		panelInner.add(this.getInnerButton());

		// outer circle button
		this.setOuterButton(new JButton(language.translated("Circumscribed") + "!"));
		this.getOuterButton().setPreferredSize(dimButton);
		// panel outer circle button
		JPanel panelOuter = new JPanel();
		panelOuter.add(this.getOuterButton());

		// special circle button
		this.setSpecialButton(new JButton(language.translated("Special") + "!"));
		this.getSpecialButton().setPreferredSize(dimButton);
		// panel special circle button
		JPanel panelSpecial = new JPanel();
		panelSpecial.add(this.getSpecialButton());

		// test button
		this.setTestButton(new JButton(language.translated("Test") + "!"));
		this.getTestButton().setPreferredSize(dimButton);
		// panel test button
		JPanel panelTest = new JPanel();
		panelTest.add(this.getTestButton());

		// exit button
		this.setExitButton(new JButton(language.translated("Exit") + "!"));
		this.getExitButton().setPreferredSize(dimButton);
		// panel exit button
		JPanel panelExit = new JPanel();
		panelExit.add(this.getExitButton());

		// admin panel
		JPanel adminPanel = new JPanel();
		adminPanel.add(panelScroll);
		adminPanel.add(panelComponents);
		adminPanel.setLayout(new GridLayout(0, 1));

		// user panel
		JPanel userPanel = new JPanel();
		userPanel.add(panelLanguage);
		userPanel.add(panelInner);
		userPanel.add(panelOuter);
		userPanel.add(panelSpecial);
		userPanel.add(panelDraw);
		userPanel.add(panelTest);
		userPanel.add(panelLogOut);
		userPanel.add(panelExit);
		userPanel.setLayout(new GridLayout(0, 1));

		// main panel
		JPanel mainPanel = new JPanel();
		mainPanel.add(panelTitle);
		mainPanel.add(adminPanel);
		mainPanel.add(userPanel);

		this.setContentPane(mainPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
