package particles;

import static utils.Constants.Particle.*;

public class RunDust extends Particle {

	public RunDust(int x, int y) {
		super(x, y, RUNNING);
	}

	public void update() { 
		updateAnimationTick();
	}
}
