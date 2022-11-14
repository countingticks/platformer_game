package gamestates;

import static utils.Constants.Environment.BIG_CLOUD_HEIGHT;
import static utils.Constants.Environment.BIG_CLOUD_WIDTH;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import entities.EnemyManager;
import entities.Player;
import environment.BackgroundOverlay;
import levels.LevelManager;
import main.Game;
import ui.PauseOverlay;
import utils.LoadSave;

public class Playing extends State implements Statemethods {
	
	private Player player;
	private LevelManager levelManager;
	private EnemyManager enemyManager;
	private PauseOverlay pauseOverlay;
	private boolean paused = false;
	
	private int xLvlOffset;
	private int leftBorder = (int) (0.4 * Game.GAME_WIDTH);
	private int rightBorder = (int) (0.6 * Game.GAME_WIDTH);
	private int lvlTilesWide = LoadSave.GetLevelData()[0].length;
	private int maxTilesOffset = lvlTilesWide - Game.TILES_IN_WIDTH;
	private int maxLvlOffsetX = maxTilesOffset * Game.TILES_SIZE;

	private BackgroundOverlay bgOverlay;
	
	public Playing(Game game) {
		super(game);
		initClasses();
	}
	
	private void initClasses() { 
		levelManager = new LevelManager(game);
		enemyManager = new EnemyManager(this);
		player = new Player(200, 200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE));
		player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
		pauseOverlay = new PauseOverlay(this);
		bgOverlay = new BackgroundOverlay();
	}

	@Override
	public void update() {
		if (!paused) { 
			levelManager.update();
			player.update();
			enemyManager.update(levelManager.getCurrentLevel().getLevelData(), player);
			bgOverlay.update();
			checkCloseToBorder();
		} else 
			pauseOverlay.update();
	}

	private void checkCloseToBorder() {
		int playerX = (int) player.getHitbox().x;
		int diff = playerX - xLvlOffset;
		
		if (diff > rightBorder)
			xLvlOffset += diff - rightBorder;
		else if (diff < leftBorder)
			xLvlOffset += diff - leftBorder;
		
		if (xLvlOffset > maxLvlOffsetX)
			xLvlOffset = maxLvlOffsetX;
		else if (xLvlOffset < 0)
			xLvlOffset = 0;
	}

	@Override
	public void draw(Graphics g) {		
		bgOverlay.draw(g, xLvlOffset);
		levelManager.draw(g, xLvlOffset);
		player.render(g, xLvlOffset);
		enemyManager.draw(g, xLvlOffset);

		if (paused) { 
			g.setColor(new Color(0,0,0,150));
			g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
			pauseOverlay.draw(g);
		}
	}

	public void mouseDragged(MouseEvent e) { 
		if (paused)
			pauseOverlay.mouseDragged(e);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) { 
			player.setAttacking(true);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (paused)
			pauseOverlay.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (paused)
			pauseOverlay.mouseReleased(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (paused)
			pauseOverlay.mouseMoved(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) { 
			case KeyEvent.VK_A -> player.setLeft(true);
			case KeyEvent.VK_D -> player.setRight(true);
			case KeyEvent.VK_SPACE -> player.setJump(true);
			case KeyEvent.VK_Z -> game.toggleDebug(true);
			case KeyEvent.VK_ESCAPE -> paused = !paused;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) { 
			case KeyEvent.VK_A -> player.setLeft(false);
			case KeyEvent.VK_D -> player.setRight(false);
			case KeyEvent.VK_SPACE -> player.setJump(false);
		}
	}
	
	public void unpauseGame() { 
		paused = false;
	}
	
	public void windowFocusLost() { 
		player.resetDirBooleans();
	}
	
	public Player getPlayer() { 
		return player;
	}
}
