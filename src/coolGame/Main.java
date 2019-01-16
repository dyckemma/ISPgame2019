/* Emma Dyck 
 * Mr. Harwood ICS4U ISP
 * Created January 8, 2019 
 * Last Edited January 10, 2019
 * A cool, graphic text-based adventure game
 */
package coolGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Main implements MouseListener, KeyListener {

	static final int TZ_SPEED = 0;
	static int panW = 800, panH = 500;
	int temp;
	JFrame window = new JFrame();
	JLabel text = new JLabel();
	JTextField command = new JTextField();
	private BufferedImage backImg = null;
	DrawingPanel drPanel;
	long t1 = System.currentTimeMillis();
	ArrayList<Room> roomList = new ArrayList<Room>();

	public static void main(String[] args) {
		new Main();
	}

	Main(){
		setup();

		Timer moveTimer = new Timer(TZ_SPEED, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long t2 = System.currentTimeMillis();
				t1=t2;
				drPanel.repaint();
			}
		});
		moveTimer.start();
	}

	//***************Setting up the window****************\\
	void setup() {
		Room.createAllRooms(roomList);

		window = new JFrame("GAMENAME");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		text = new JLabel("Press Enter to Start");
		command = new JTextField("                                                                                                              ");
		drPanel = new DrawingPanel();
		drPanel.addKeyListener(this);
		drPanel.addMouseListener(this);
		window.add(drPanel, BorderLayout.CENTER);
		drPanel.add(text);
		drPanel.add(command);

//		backImg = loadImage("desert.jpg");

		window.setVisible(true);
		drPanel.requestFocus();
		drPanel.repaint();
	}

	//**************Printing the story text**************\\	
	void printroom(int roomNum) {
		Room r = roomList.get(roomNum);
		text.setText(r.description);
		temp++;
	}
	void checktext() {
	}

//	BufferedImage loadImage(String fn) {
//		BufferedImage image = null;		
//		InputStream inputStr = Main.class.getClassLoader().getResourceAsStream(fn);
//		try {
//			image = ImageIO.read(inputStr);
//		} catch (IOException e){
//			System.out.println("image not found");
//		}
//		return image;
//	}
	
	void initGraphics() {
		panH = window.getSize().height;
		panW = window.getSize().width;
	}

	//*********Drawing the window and components*********\\
	private class DrawingPanel extends JPanel {
		DrawingPanel() {
			this.setBackground(Color.WHITE);
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //clear screen and repaint using background color
			initGraphics();
//			g.drawImage(backImg, 0, 0, panW, panH, drPanel);	//background image
			g.drawRect(6,3,panW, panH);
			g.fillRect(panH, panW, WIDTH, HEIGHT);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			drPanel.repaint();

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (temp == 0) printroom(Room.currentroom);
			else {
				command.setText("     ");
				checktext();
			}
			
			drPanel.repaint();		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

}