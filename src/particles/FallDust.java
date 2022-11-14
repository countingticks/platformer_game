package particles;

import static utils.Constants.Particle.*;

public class FallDust extends Particle {

	public FallDust(int x, int y) {
		super(x, y, JUMP);
	}

	public void update() { 
		updateAnimationTick();
	}
}
