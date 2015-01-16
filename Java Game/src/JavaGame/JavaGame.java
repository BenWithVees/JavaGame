package JavaGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class JavaGame extends JFrame implements Runnable {
	int x, y, xDirection, yDirection;
	private Image dbImage;
	private Graphics dbg;
	
	public void run(){
		try{
			while(true){
				move();
				Thread.sleep(2);
			}
			
		}
		catch(Exception e){
			System.out.println("Error");
		}
	}

	public void move() {
		x += xDirection;
		y += yDirection;
		if(x <= 0)
			x = 0;
		if(x >= 270)
			x = 270;
		if(y <= 18)
			y = 18;
		if(y >= 270)
			y = 270;
	}

	public void setXDirection(int xdir) {
		xDirection = xdir;

	}
	
	public void setYDirection(int ydir) {
		yDirection = ydir;
	}

	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keycode = e.getKeyCode();
			if (keycode == e.VK_LEFT) {
				setXDirection(-1);
			}
			if (keycode == e.VK_RIGHT) {
				setXDirection(+1);
			}
			if (keycode == e.VK_UP) {
				setYDirection(-1);
			}
			if (keycode == e.VK_DOWN) {
				setYDirection(+1);
			}
		}

		public void keyReleased(KeyEvent e) {
			int keycode = e.getKeyCode();
			if (keycode == e.VK_LEFT) {
				setXDirection(0);
			}
			if (keycode == e.VK_RIGHT) {
				setXDirection(0);
			}
			if (keycode == e.VK_UP) {
				setYDirection(0);
			}
			if (keycode == e.VK_DOWN) {
				setYDirection(0);
			}

		}
	}

	public JavaGame() {
		addKeyListener(new AL());
		setTitle("Java Game");
		setSize(300, 300);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x = 150;
		y = 150;
	}

	public void paint(Graphics g) {
		dbImage = createImage(getHeight(), getWidth());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

	public void paintComponent(Graphics g) {
		g.fillOval(x, y, 30, 30);
		repaint();

	}

	public static void main(String[] args) {
		JavaGame jg = new JavaGame();
		Thread t1 =  new Thread(jg);
		t1.start();
	}

}
