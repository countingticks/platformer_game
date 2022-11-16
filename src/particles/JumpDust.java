package particles;

import static utils.Constants.Particle.PARTICLE_JUMP;

public class JumpDust extends Particle {

	public JumpDust(int x, int y) {
		super(x, y, PARTICLE_JUMP);
	}

	public void update() { 
		updateAnimationTick();
	}
}
