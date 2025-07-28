package client.presentation.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class DrawingPanelGUI extends JPanel {
	private int x, y, radius, thickness;
	private Color color;

	// getters
	int getCircleX() {
		return this.x;
	}

	int getCircleY() {
		return this.y;
	}

	int getCircleRadius() {
		return this.radius;
	}

	Color getCircleColor() {
		return this.color;
	}

	int getCircleThickness() {
		return this.thickness;
	}

	// setters
	void setCircleX(int x) {
		this.x = x;
		this.repaint();
	}

	void setCircleY(int y) {
		this.y = y;
		this.repaint();
	}

	void setCircleRadius(int radius) {
		this.radius = radius;
		this.repaint();
	}

	void setCircleColor(Color color) {
		this.color = color;
		this.repaint();
	}

	void setCircleThickness(int thickness) {
		this.thickness = thickness;
		this.repaint();
	}

	// methods
	public void mousePressed(int x, int y) {
		this.setCircleX(x);
		this.setCircleY(y);
		this.setCircleRadius(0);
		// TODO this.repaint();

		// System.out.println("Mouse pressed! X=" + x + " Y=" + y);
	}

	private int computeRadius(int x1, int y1, int x2, int y2) {
		return (int) Math.round(Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
//		int dx = Math.abs(x1 - x2);
//		int dy = Math.abs(y1 - y2);
//		int radius = Math.min(dx, dy);
//		return radius;
	}

	public void mouseDragged(int x, int y) {
		this.setCircleRadius(this.computeRadius(this.getCircleX(), this.getCircleY(), x, y));
		// TODO this.repaint();

		// System.out.println("Mouse dragged! X=" + x + " Y=" + y);
	}

	private int corner1X() {
		return this.getCircleX() - this.getCircleRadius() - this.getCircleThickness() / 2;
	}

	private int corner1Y() {
		return this.getCircleY() - this.getCircleRadius() - this.getCircleThickness() / 2;
	}

	private int size1() {
		return 2 * this.getCircleRadius() + this.getCircleThickness();
	}

	private int corner2X() {
		return this.getCircleX() - this.getCircleRadius() - this.getCircleThickness() / 2 + this.getCircleThickness();
	}

	private int corner2Y() {
		return this.getCircleY() - this.getCircleRadius() - this.getCircleThickness() / 2 + this.getCircleThickness();
	}

	private int size2() {
		return 2 * this.getCircleRadius() - this.getCircleThickness();
	}

	private void drawCircle(Graphics g) {
		// set variables
		int cor1x = this.corner1X();
		int cor1y = this.corner1Y();
		int size1 = this.size1();
		int cor2x = this.corner2X();
		int cor2y = this.corner2Y();
		int size2 = this.size2();
		Color color = this.getCircleColor();

		// set the old and new colors
		Color oldColor = g.getColor();
		g.setColor(color);

		// draw the circle
		g.fillOval(cor1x, cor1y, size1, size1);
		g.setColor(Color.WHITE);
		g.fillOval(cor2x, cor2y, size2, size2);

		// set back the old color
		g.setColor(oldColor);
	}

	// JPanel overrides
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawCircle(g);
	}

	// newInstance methods

	// constructors
	public DrawingPanelGUI() {
		this.setCircleX(0);
		this.setCircleY(0);
		this.setCircleRadius(0);
		this.setCircleColor(Color.BLACK);
		this.setCircleThickness(2);

		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				DrawingPanelGUI.this.mousePressed(e.getX(), e.getY());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			};
		});

		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				DrawingPanelGUI.this.mouseDragged(e.getX(), e.getY());
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}
