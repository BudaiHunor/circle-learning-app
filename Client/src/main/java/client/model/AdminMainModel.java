package client.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;

public class AdminMainModel extends AbstractModel {
	private TableModel model;
	private String id;
	private String username;
	private String password;
	private String email;
	private String type;

	// getters
	public TableModel getTableModel() {
		return this.model;
	}

	public String getID() {
		return this.id;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}

	public String getType() {
		return this.type;
	}

	// setters
	public void setTableModel(TableModel model) {
		this.model = model;
		this.notifyAll(this);
	}

	public void setID(String id) {
		this.id = id;
		this.notifyAll(this);
	}

	public void setUsername(String username) {
		this.username = username;
		this.notifyAll(this);
	}

	public void setPassword(String password) {
		this.password = password;
		this.notifyAll(this);
	}

	public void setEmail(String email) {
		this.email = email;
		this.notifyAll(this);
	}

	public void setType(String type) {
		this.type = type;
		this.notifyAll(this);
	}

	// methods

	// newInstance methods
	public static AdminMainModel newInstance(List<ObserverIF> observers, TableModel model, String id, String username,
			String password, String email, String type) {
		if (observers == null || model == null || id == null || username == null || password == null || email == null
				|| type == null) {
			return null;
		}
		return new AdminMainModel(observers, model, id, username, password, email, type);
	}

	public static AdminMainModel newInstance(TableModel model, String id, String username, String password,
			String email, String type) {
		if (model == null || id == null || username == null || password == null || email == null || type == null) {
			return null;
		}
		return new AdminMainModel(new ArrayList<ObserverIF>(), model, id, username, password, email, type);
	}

	// constructors
	private AdminMainModel(List<ObserverIF> observers, TableModel model, String id, String username, String password,
			String email, String type) {
		super(observers);
		this.setTableModel(model);
		this.setID(id);
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setType(type);
	}
}
