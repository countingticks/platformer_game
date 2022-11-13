package environment;

import static utils.Constants.Environment.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utils.LoadSave;

public class SmallCloud {
	
	float x, speed, size;
	int y, type;
	BufferedImage img;
	
	public SmallCloud(float x, int y, float speed, float size, int type) { 
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.size = size;
		this.type = type;

		switch (type) {
			case 1 -> img = LoadSave.GetSpriteAtlas(LoadSave.SMALL_CLOUDS1);
			case 2 -> img = LoadSave.GetSpriteAtlas(LoadSave.SMALL_CLOUDS2);
			case 3 -> img = LoadSave.GetSpriteAtlas(LoadSave.SMALL_CLOUDS3);
		}
	}
	
	public void update() { 
		x -= speed;
		
		switch (type) {
			case 1 -> {
				if (x + SMALL_CLOUD1_WIDTH < 0)
					x += LoadSave.GetLevelData()[0].length * Game.TILES_SIZE + SMALL_CLOUD1_WIDTH;
			}
			case 2 -> {
				if (x + SMALL_CLOUD2_WIDTH < 0)
					x += LoadSave.GetLevelData()[0].length * Game.TILES_SIZE + SMALL_CLOUD2_WIDTH;
			}
			case 3 -> {
				if (x + SMALL_CLOUD3_WIDTH < 0)
					x += LoadSave.GetLevelData()[0].length * Game.TILES_SIZE + SMALL_CLOUD3_WIDTH;
			}
		}
	}
	
	public void draw(Graphics g, int lvlOffset) { 
		switch (type) {
			case 1 -> g.drawImage(img, (int) x - lvlOffset, y, (int) (SMALL_CLOUD1_WIDTH * size), (int) (SMALL_CLOUD1_HEIGHT * size), null);
			case 2 -> g.drawImage(img, (int) x - lvlOffset, y, (int) (SMALL_CLOUD2_WIDTH * size), (int) (SMALL_CLOUD2_HEIGHT * size), null);
			case 3 -> g.drawImage(img, (int) x - lvlOffset, y, (int) (SMALL_CLOUD3_WIDTH * size), (int) (SMALL_CLOUD3_HEIGHT * size), null);
		}
	}
}
