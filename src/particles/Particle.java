package particles;

import static utils.Constants.Particle.*;

public class Particle {
	
	protected int aniIndex, particleState, particleType;
	protected int aniTick, aniSpeed = 20;
	protected int x, y;
	
	public Particle(int x, int y, int particleType) { 
		this.x = x;
		this.y = y;
		this.particleType = particleType;
	}
	
	protected void newState(int particleState) { 
		this.particleState = particleState;
		aniTick = 0;
		aniIndex = 0;
	}
	
	protected void updateAnimationTick() { 
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(particleType)) { 
				aniIndex = 0;
			}
		}
	}
	
	public int getAniIndex() { 
		return aniIndex;
	}
	
	public int getParticleState() { 
		return particleState;
	}
	
	public int getX() { 
		return x;
	}
	
	public int getY() { 
		return y;
	}
}
