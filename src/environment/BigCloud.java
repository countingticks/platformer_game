package environment;

import static utils.Constants.Environment.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utils.LoadSave;

public class BigCloud {
	
	private float x, speed;
	private int y;
	private int cloudNumber = (int) Math.ceil((float) LoadSave.GetLevelData()[0].length * Game.TILES_SIZE / BIG_CLOUD_WIDTH);
	private BufferedImage img;
	
	public BigCloud(float x, int y, float speed) { 
		this.x = x;
		this.y = y;
		this.speed = speed;

		img = LoadSave.GetSpriteAtlas(LoadSave.BIG_CLOUDS);
	}
	
	public void update() { 
		x -= speed;
		
		if (x < -BIG_CLOUD_WIDTH)
			x += BIG_CLOUD_WIDTH;
	}
	
	public void draw(Graphics g, int lvlOffset) { 
		for (int i = 0; i < cloudNumber + 1; i++)
			g.drawImage(img, (int) x + i * BIG_CLOUD_WIDTH - lvlOffset, y, BIG_CLOUD_WIDTH, BIG_CLOUD_HEIGHT, null);
	}
}
