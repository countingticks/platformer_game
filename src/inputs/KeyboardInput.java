package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gamestates.Gamestate;
import main.GamePanel;

public class KeyboardInput implements KeyListener {

	private GamePanel gamePanel;
	
	public KeyboardInput(GamePanel gamePanel) { 
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(Gamestate.state) { 
			case MENU -> gamePanel.getGame().getMenu().keyReleased(e);
			case PLAYING -> gamePanel.getGame().getPlaying().keyReleased(e);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(Gamestate.state) { 
			case MENU -> gamePanel.getGame().getMenu().keyPressed(e);
			case PLAYING -> gamePanel.getGame().getPlaying().keyPressed(e);
		}
	}
}
