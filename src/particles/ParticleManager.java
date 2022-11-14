package particles;

import static utils.Constants.Particle.PARTICLE_HEIGHT;
import static utils.Constants.Particle.PARTICLE_HEIGHT_DEFALT;
import static utils.Constants.Particle.PARTICLE_WIDTH;
import static utils.Constants.Particle.PARTICLE_WIDTH_DEFALT;

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
		addParticle();
	}
	
	public void addParticle() { 
		runDust.add(new RunDust(400, 400));
		runDust.add(new RunDust(400, 300));
		jumpDust.add(new JumpDust(500, 400));
		fallDust.add(new FallDust(600, 400));
	}
	
	public void update() { 
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
	
	public void draw(Graphics g, int lvlOffset) {
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
