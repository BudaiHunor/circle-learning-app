package client.presentation.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImagePanelGUI extends JPanel {
	private Image image;
	private String imageName;

	// getters
	private Image getImage() {
		return this.image;
	}

	public String getImageName() {
		return this.imageName;
	}

	// setters
	private void setImage(Image image) {
		this.image = image;
	}

	void setImageName(String imageName) {
		if (imageName == null) {
			this.repaint();
			return;
		}
		this.imageName = imageName;
		try {
			this.setImage(ImageIO.read(new File(imageName)));
		} catch (IOException e) {
			this.setImage(null);
			JOptionPane.showMessageDialog(this, "Image failed to load!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		this.repaint();
	}

	// methods
	public void drawImage(Graphics g) {
		if (this.getImage() != null) {
			g.drawImage(this.getImage(), 0, 0, this.getImage().getWidth(null), this.getImage().getHeight(null), null);
		}
	}

	// JPanel overrides
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawImage(g);
	}

	// newInstance methods

	// constructors
	public ImagePanelGUI(String fileName) {
		this.setImageName(imageName);
	}
}
