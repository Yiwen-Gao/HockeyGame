import java.awt.Shape;

public interface MovingObject extends Object {
	public void moveObject(int xChange, int yChange);
	public Shape getShape();
	public void rebound();
}
