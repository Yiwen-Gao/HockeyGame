import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Field implements Object {
	
	private final int UNIT = 25;
	private final int ICON_W = 600;
	private final int ICON_H = 250;
	
	public void drawObject(Graphics2D g2D) {
		drawRed(g2D);
		drawBlue(g2D);
	}
	
	private void drawRed(Graphics2D g2D) {
		Ellipse2D.Double hotCircle = new Ellipse2D.Double(ICON_W/2 - 3*UNIT, ICON_H/2 - 3*UNIT, 6*UNIT, 6*UNIT);
		Rectangle2D.Double blue1 = new Rectangle2D.Double(ICON_W/3, 0, 5, ICON_H);
		Rectangle2D.Double blue2 = new Rectangle2D.Double(ICON_W*2/3, 0, 5, ICON_H);
		
		Color turquoise = new Color(0, 140, 175);
		g2D.setColor(turquoise);
		g2D.draw(hotCircle);
		g2D.fill(blue1);
		g2D.fill(blue2);
	}
	
	private void drawBlue(Graphics2D g2D) {
		Rectangle2D.Double beam = new Rectangle2D.Double(ICON_W/2, 0, 5, ICON_H);
		Ellipse2D.Double smallCircle1 = new Ellipse2D.Double(ICON_W/3 + 2*UNIT, ICON_H/8, UNIT/4, UNIT/4);
		Ellipse2D.Double smallCircle2 = new Ellipse2D.Double(ICON_W*2/3 - 2*UNIT, ICON_H/8, UNIT/4, UNIT/4);
		Ellipse2D.Double smallCircle3 = new Ellipse2D.Double(ICON_W/3 + 2*UNIT, ICON_H*7/8, UNIT/4, UNIT/4);
		Ellipse2D.Double smallCircle4 = new Ellipse2D.Double(ICON_W*2/3 - 2*UNIT, ICON_H*7/8, UNIT/4, UNIT/4);
		Line2D.Double goal1 = new Line2D.Double(ICON_W/8, 0, ICON_W/8, ICON_H);
		Line2D.Double goal2 = new Line2D.Double(ICON_W*7/8, 0, ICON_W*7/8, ICON_H);
		
		Color darkRed = new Color(195, 0, 0);
		g2D.setColor(darkRed);
		g2D.fill(beam);
		g2D.fill(smallCircle1);
		g2D.fill(smallCircle2);
		g2D.fill(smallCircle3);
		g2D.fill(smallCircle4);
		g2D.draw(goal1);
		g2D.draw(goal2);
	}
}