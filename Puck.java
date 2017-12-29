import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Puck implements MovingObject {

	private int x;
	private int y;	
	private Ellipse2D.Double puck;
	private boolean down = true;
	private boolean rebound = false;
	
	private final int UNIT = 25;
	private final int ICON_W = 600;
	private final int ICON_H = 250;
	
	public Puck() {
		x = 0;
		y = ICON_H/2;
	}
	
	public void drawObject(Graphics2D g2D) {
		puck = new Ellipse2D.Double(x, y, UNIT, UNIT);
		g2D.fill(puck);
		g2D.setColor(Color.WHITE);
		g2D.setFont(new Font("SansSerif", Font.PLAIN, 8));
		g2D.drawString("NHL", x + UNIT/4, y + UNIT*2/3);
	}
	
	public void moveObject(int xChange, int yChange) {
		if (x < ICON_W - UNIT) {
			if (x - xChange < 0) rebound = false;
			if (!rebound) x += xChange;
			else x -= xChange;
			
			if (y < 0) down = true;
			else if (y + yChange > ICON_H - UNIT) down = false;
			if (down) y += yChange; 
			else y -= yChange;
		}
	}
	
	public Shape getShape() {
		return puck;
	}
	
	public void rebound() {
		rebound = true;
	}
}
