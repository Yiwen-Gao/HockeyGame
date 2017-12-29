import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Scoreboard implements Object {
	
	private static int score;
	
	private final int UNIT = 25;
	private final int ICON_W = 600;
	private final int ICON_H = 250;
	
	public Scoreboard(int score) {
		this.score = score;
	}

	public void drawObject(Graphics2D g2D) {
		Rectangle2D.Double board = new Rectangle2D.Double(UNIT/10, UNIT/10, ICON_W/4.5, ICON_H/4);
		g2D.fill(board);
		
		g2D.setColor(Color.WHITE);
		g2D.drawString("SCOREBOARD", UNIT, UNIT);
		g2D.setFont(new Font("SansSerif", Font.PLAIN, 12));
		g2D.drawString("HOME", UNIT/2, UNIT*7/4);
		g2D.drawString(score + "", UNIT/2, UNIT*9/4);
		g2D.drawString("GUEST", UNIT*7/2, UNIT*7/4);
		g2D.drawString("X", UNIT*7/2, UNIT*9/4);
	}
}
