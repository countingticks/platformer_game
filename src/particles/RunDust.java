package particles;

import static utils.Constants.Particle.PARTICLE_RUNNING;

public class RunDust extends Particle {

	public RunDust(int x, int y) {
		super(x, y, PARTICLE_RUNNING);
	}

	public void update() { 
		updateAnimationTick();
	}
}
