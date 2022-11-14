package particles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utils.LoadSave;
import static utils.Constants.Particle.*;

public class RunParticle {
	
	private BufferedImage[] imgs;
	private int tick, index, speed = 20;
	private boolean hasPlayedOnce = false;
	
	public RunParticle() { 
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.PARTICLE_ATLAS);
		imgs = new BufferedImage[5];
		
		for (int i = 0; i < imgs.length; i++)
			imgs[i] = temp.getSubimage(i * PARTICLE_WIDTH_DEFALT, 0, PARTICLE_WIDTH_DEFALT, PARTICLE_HEIGHT_DEFALT);
	}
	
	public void update(int playerAction) { 
		tick++;
		if (tick >= speed) {
			tick = 0;
			index++;
			if (index >= 5) { 
				hasPlayedOnce = true;
				index = 0;
			}
		}
	}
	
	public void draw(Graphics g, int x, int y) { 
		g.drawImage(imgs[index], x, y, PARTICLE_WIDTH, PARTICLE_HEIGHT, null);
	}
	
	public boolean hasPlayedOnce() { 
		return hasPlayedOnce;
	}
	
	public boolean animStarted() {
		return index != 0;
	}
	
	public int getIndex() { 
		return index;
	}
}
