import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class MyIcon implements Icon {
	
	private int width;
	private int height;
	private Object object;
	
	public MyIcon(int width, int height, Object object) {
		this.width = width;
		this.height = height;
		this.object = object;
	}
	
	public int getIconWidth() {
		return width;
	}
	
	public int getIconHeight() {
		return height;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2D = (Graphics2D) g;
		object.drawObject(g2D);
	}
}
