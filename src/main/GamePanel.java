package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInput;
import inputs.MouseInput;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 4095354161549570808L;
	
	private MouseInput mouseInput;
	private Game game;

	public GamePanel(Game game) { 
		mouseInput = new MouseInput(this);
		this.game = game;
		
		setPanelSize();
		addKeyListener(new KeyboardInput(this));
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setPreferredSize(size);
		System.out.println("Size: " + GAME_WIDTH + " : " + GAME_HEIGHT);
	}

	public void updateGame() { 

	}
 	
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		game.render(g);
	}
	
	public Game getGame() { 
		return game;
	}
}
