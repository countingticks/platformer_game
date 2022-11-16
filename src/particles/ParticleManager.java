package particles;

import static utils.Constants.Particle.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import utils.LoadSave;

public class ParticleManager {

	private BufferedImage[][] particleArray;
	private ArrayList<RunDust> runDust = new ArrayList<>();
	private ArrayList<JumpDust> jumpDust = new ArrayList<>();
	private ArrayList<FallDust> fallDust = new ArrayList<>();
	
	public ParticleManager()  {
		loadParticleImgs();
	}
	
	public void addParticle(int type, int x, int y) { 
		switch (type) { 
			case PARTICLE_RUNNING -> runDust.add(new RunDust(x, y));
			case PARTICLE_JUMP -> jumpDust.add(new JumpDust(x, y));
			case PARTICLE_FALL -> fallDust.add(new FallDust(x, y));
		}
	}
	
	public void update() { 
		popParticle();
		
		if (!runDust.isEmpty())
			updateRunDust();
		
		updateJumpDust();
		updateFallDust();
	}
	
	private void updateRunDust() { 
		for (RunDust c : runDust)
			c.update();
	}
	
	private void updateJumpDust() { 
		for (JumpDust c : jumpDust)
			c.update();
	}
	
	private void updateFallDust() { 
		for (FallDust c : fallDust)
			c.update();
	}
	
	private void popParticle() { 
		if (!runDust.isEmpty())
			popRunDust();
	}
	
	private void popRunDust() { 
		for (int i = 0; i < runDust.size(); i++)
			if (runDust.get(0).getPlayedOnce())
				runDust.remove(i);
	}
	
	public void draw(Graphics g, int lvlOffset) {
		if (!runDust.isEmpty())
			drawRunDust(g, lvlOffset);
		
		drawJumpDust(g, lvlOffset);
		drawFallDust(g, lvlOffset);
	}
	
	private void drawRunDust(Graphics g, int lvlOffset) { 
		for (RunDust c : runDust)
			g.drawImage(particleArray[0][c.getAniIndex()], c.getX() - lvlOffset, c.getY(), PARTICLE_WIDTH, PARTICLE_HEIGHT, null);
	}
	
	private void drawJumpDust(Graphics g, int lvlOffset) { 
		for (JumpDust c : jumpDust)
			g.drawImage(particleArray[1][c.getAniIndex()], c.getX() - lvlOffset, c.getY(), PARTICLE_WIDTH, PARTICLE_HEIGHT, null);
	}
	
	private void drawFallDust(Graphics g, int lvlOffset) { 
		for (FallDust c : fallDust)
			g.drawImage(particleArray[2][c.getAniIndex()], c.getX() - lvlOffset, c.getY(), PARTICLE_WIDTH, PARTICLE_HEIGHT, null);
	}

	private void loadParticleImgs() {
		particleArray = new BufferedImage[3][6];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.PARTICLE_ATLAS);
		for (int j = 0; j < particleArray.length; j++) 
			for (int i = 0; i < particleArray.length; i++)
				particleArray[j][i] = temp.getSubimage(i * PARTICLE_WIDTH_DEFALT, j * PARTICLE_HEIGHT_DEFALT, PARTICLE_WIDTH_DEFALT, PARTICLE_HEIGHT_DEFALT);
	}
}
