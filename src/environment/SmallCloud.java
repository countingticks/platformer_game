package environment;

import static utils.Constants.Environment.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utils.LoadSave;

public class SmallCloud {
	
	float x, speed, size;
	int y;
	BufferedImage img;
	
	public SmallCloud(float x, int y, float speed, float size) { 
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.size = size;

		img = LoadSave.GetSpriteAtlas(LoadSave.SMALL_CLOUDS);
	}
	
	public void update() { 
		x -= speed;
		
		if (x + SMALL_CLOUD_WIDTH < 0)
			x += LoadSave.GetLevelData()[0].length * Game.TILES_SIZE + SMALL_CLOUD_WIDTH;
	}
	
	public void draw(Graphics g, int lvlOffset) { 
		g.drawImage(img, (int) x - lvlOffset, y, (int) (SMALL_CLOUD_WIDTH * size), (int) (SMALL_CLOUD_HEIGHT * size), null);
	}
}
