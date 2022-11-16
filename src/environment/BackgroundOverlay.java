package environment;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import main.Game;
import utils.LoadSave;

public class BackgroundOverlay {
	
	private BigCloud bigCloud;
	private SmallCloud smallCloud[] = new SmallCloud[(int) Math.ceil((float) LoadSave.GetLevelData()[0].length * Game.TILES_SIZE / 400)];
	private Random random = new Random();
	private BufferedImage background;
	
	// small cloud
	private float minSize = 0.3f * Game.SCALE;
	private float maxSize = 0.6f * Game.SCALE;
	private float smallCloudSpeed = 0.05f * Game.SCALE;
	
	// big cloud
	private float bigCloudSpeed = 0.1f * Game.SCALE;
	
	public BackgroundOverlay() { 
		background = LoadSave.GetSpriteAtlas(LoadSave.PLAYING_BACKGROUND_IMG);
				
		for (int i = 0; i < smallCloud.length; i++) { 
			float size = random.nextFloat(minSize, maxSize);
			int cloudType = random.nextInt(1, 4);
			
			smallCloud[i] = new SmallCloud((int) ((100 + i * random.nextInt(200, 250)) * Game.SCALE), (int) (random.nextInt(50, 175) * Game.SCALE), smallCloudSpeed, size, cloudType);
		}
		
		bigCloud = new BigCloud(0, (int) (204 * Game.SCALE), bigCloudSpeed);
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
