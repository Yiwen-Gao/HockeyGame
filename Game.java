import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Game {

	private static JFrame myFrame = new JFrame();
	private static MovingObject puck;
	private static MovingObject stick;
	
	private static int puckXDir = (int) (Math.random() * 5 + 10);
	private static int puckYDir = (int) (Math.random() * 5 + 10);
	private static final int ICON_W = 600;
	private static final int ICON_H = 250;
	
	public static void main(String[] args) {
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createGame();
	}
	
	public static void createGame() {
		createPuck();
		createStick();
		
		Collision collision = new Collision();
		final int DELAY = 100;
		Timer myTimer = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				collision.testIntersection(puck, stick);
				int score = collision.getScore();
				createSetting(score);
			}
		});
		myTimer.start();
	}
	
	public static void createPuck() {
		puck = new Puck();
		Icon puckIcon = new MyIcon(ICON_W, ICON_H, puck);
		JLabel puckLabel = new JLabel(puckIcon);
		myFrame.add(puckLabel);
		myFrame.pack();		
		
		final int DELAY = 100;
		Timer myTimer = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				puck.moveObject(puckXDir, puckYDir);
				puckLabel.repaint();
			}
		});
		myTimer.start();
	}
	
	public static void createStick() {
		stick = new Stick();
		Icon stickIcon = new MyIcon(ICON_W, ICON_H, stick);
		JLabel stickLabel = new JLabel(stickIcon);
		myFrame.add(stickLabel);
		myFrame.pack();
		myFrame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP)
					stick.moveObject(0, -10);
				else if (e.getKeyCode() == KeyEvent.VK_DOWN)
					stick.moveObject(0, 10);
			}
			public void keyReleased(KeyEvent e) {}
		});
	}
	
	public static void createSetting(int score) {
		Object field = new Field();
		Icon fieldIcon = new MyIcon(ICON_W, ICON_H, field);
		JLabel fieldLabel = new JLabel(fieldIcon);
		myFrame.add(fieldLabel);
		myFrame.pack();
		
		Object scoreboard = new Scoreboard(score);
		Icon scoreboardIcon = new MyIcon(ICON_W, ICON_H, scoreboard);
		JLabel scoreboardLabel = new JLabel(scoreboardIcon);
		myFrame.add(scoreboardLabel);
		myFrame.pack();
	}
}

