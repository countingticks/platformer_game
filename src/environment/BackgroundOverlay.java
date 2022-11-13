package environment;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import main.Game;
import utils.LoadSave;

public class BackgroundOverlay {
	
	private BigCloud bigCloud;
	private SmallCloud smallCloud[] = new SmallCloud[10];
	private Random random = new Random();
	private BufferedImage background;
	
	public BackgroundOverlay() { 
		background = LoadSave.GetSpriteAtlas(LoadSave.PLAYING_BACKGROUND_IMG);
		
		for (int i = 0; i < smallCloud.length; i++) { 
			float size = random.nextFloat(0.6f, 1.2f);
			smallCloud[i] = new SmallCloud(200 + i * random.nextInt(400, 500), random.nextInt(100, 350), 0.1f, size);
		}
		
		bigCloud = new BigCloud(0, (int) (204 * Game.SCALE), 0.3f);
	}

	public void update() { 
		for (int i = 0; i < smallCloud.length; i++)
			smallCloud[i].update();
		
		bigCloud.update();
	}
	
	public void draw(Graphics g, int lvlOffset) { 
		g.drawImage(background, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
		
		for (int i = 0; i < smallCloud.length; i++)
			smallCloud[i].draw(g, lvlOffset);
		
		bigCloud.draw(g, lvlOffset);
	}
}
