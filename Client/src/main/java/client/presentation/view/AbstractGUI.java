package client.presentation.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

abstract public class AbstractGUI extends JFrame {

	// getters

	// setters

	// methods
	public void close() {
		this.dispose();
	}

	public void showMessage(String message, boolean isError) {
		JOptionPane.showMessageDialog(this, message, isError ? "Error!" : "Success!",
				isError ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
	}

	// newInstance methods
	// CAN'T HAVE ANY!

	// constructors
	protected AbstractGUI(String title) {
		super(title);
	}
}
