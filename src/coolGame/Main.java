/* Emma Dyck 
 * Mr. Harwood ICS4U ISP
 * Created January 8, 2019 
 * Last Edited January 10, 2019
 * A cool, graphic text-based adventure game
 */
package coolGame;

import java.awt.Color;
import java.awt.Graphics;
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
		text = new JLabel();
		command = new JTextField("          ");
		drPanel = new DrawingPanel();
		drPanel.addKeyListener(this);
		drPanel.addMouseListener(this);
		window.add(drPanel);
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

	//*********Drawing the window and components*********\\
	private class DrawingPanel extends JPanel {
		DrawingPanel() {
			this.setBackground(Color.WHITE);	
		}
		@Override
		public void paintComponent(Graphics g) {
			panH = this.getHeight();
			panW = this.getWidth();
			panH = this.getHeight();

			super.paintComponent(g); //clear screen and repaint using background color
//			g.drawImage(backImg, 0, 0, panW, panH, drPanel);	//background image

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