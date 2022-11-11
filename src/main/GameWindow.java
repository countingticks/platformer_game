package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -2966312657225755808L;

	public GameWindow(GamePanel gamePanel) { 
		setTitle("Platformer Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(gamePanel);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowLostFocus(WindowEvent e) {
				gamePanel.getGame().windowFocusLost();
			} 
			
			@Override
			public void windowGainedFocus(WindowEvent e) {
				
			}
		});
	}
}
