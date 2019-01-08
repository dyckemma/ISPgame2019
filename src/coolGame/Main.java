/* Emma Dyck 
 * Mr. Harwood ICS4U ISP
 * Created January 8, 2019 
 * Last Edited January 8, 2019
 * A cool, graphic text-based adventure game
 */
package coolGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Main implements MouseListener, KeyListener {

	static final int TZ_SPEED = 0;
	static int panW = 800, panH = 500;
	JFrame window = new JFrame();
	DrawingPanel drPanel;
	long t1 = System.currentTimeMillis();

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
				printtext();
				drPanel.repaint();
			}
		});
		moveTimer.start();
	}

	//***************Setting up the window****************\\
	void setup() {
		window = new JFrame("GAMENAME");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		drPanel = new DrawingPanel();
		drPanel.addKeyListener(this);
		drPanel.addMouseListener(this);
		window.add(drPanel);


		window.setVisible(true);
		drPanel.requestFocus();
		drPanel.repaint();
	}
	
	//**************Printing the story text**************\\
	void printtext() {
		
	}
	
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
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}