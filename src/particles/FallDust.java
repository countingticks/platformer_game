package particles;

import static utils.Constants.Particle.PARTICLE_FALL;

public class FallDust extends Particle {

	public FallDust(int x, int y) {
		super(x, y, PARTICLE_FALL);
	}

	public void update() { 
		updateAnimationTick();
	}
}
