import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Stick implements MovingObject {
	
	private int x;
	private int y;
	private Rectangle2D.Double stick;
	
	private final int UNIT = 25;
	private final int ICON_W = 600;
	private final int ICON_H = 250;
	
	public Stick() {
		x = ICON_W*7/8;
		y = ICON_H/2 - UNIT;
	}
	
	public void drawObject(Graphics2D g2D) {
		stick = new Rectangle2D.Double(x, y, UNIT/4, UNIT);
		g2D.fill(stick);
	}
	
	public void moveObject(int xChange, int yChange) {
		if (y + yChange > 0 && y + yChange < ICON_H - UNIT)
			y += yChange;
	}
	
	public Shape getShape() {
		return stick;
	}

	public void rebound() {
		throw new UnsupportedOperationException("Operation not supported.");
	}
}
