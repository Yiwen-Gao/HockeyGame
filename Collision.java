import java.awt.Shape;

public class Collision {
	
	private int score;
	private boolean wasEmpty;
	
	public Collision() {
		score = 0;
		wasEmpty = true;
	}
	
	public void testIntersection(MovingObject puck, MovingObject stick) {	
		Shape puckShape = puck.getShape();
		Shape stickShape = stick.getShape();
		boolean intersects = (puckShape.getBounds2D()).intersects(stickShape.getBounds2D());
		if (!intersects) wasEmpty = true;
		if (intersects && wasEmpty) {
			puck.rebound();
			increaseScore();
			wasEmpty = false;
		}
	}
	
	private void increaseScore() {
		score++;
	}
	
	public int getScore() {
		return score;
	}
}
