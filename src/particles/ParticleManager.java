package particles;

import java.awt.Graphics;
import static utils.Constants.PlayerConstants.*;

public class ParticleManager {
	
	private RunParticle runParticle;
	
	public ParticleManager() { 
		runParticle = new RunParticle();
	}
	
	public void update(int playerAction) { 
		switch (playerAction) { 
			case RUNNING -> {
				runParticle.update(playerAction);
			}
		}
		
		if (playerAction != RUNNING)
			if (runParticle.animStarted())
				runParticle.update(playerAction);
	}
	
	public void draw(Graphics g, int x, int y, int playerAction) { 
		switch (playerAction) { 
			case RUNNING -> { 
				runParticle.draw(g, x, y);
			}
		}
		
		if (playerAction != RUNNING)
			if (runParticle.animStarted())
				runParticle.draw(g, x, y);
	}
}
