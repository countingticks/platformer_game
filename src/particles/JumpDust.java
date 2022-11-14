package particles;

import static utils.Constants.Particle.*;

public class JumpDust extends Particle {

	public JumpDust(int x, int y) {
		super(x, y, JUMP);
	}

	public void update() { 
		updateAnimationTick();
	}
}
