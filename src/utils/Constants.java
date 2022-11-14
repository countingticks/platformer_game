package utils;

import main.Game;

public class Constants {
	
	public static class EnemyConstants { 
		public static final int CRABBY = 0;
		
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int ATTACK = 2;
		public static final int HIT = 3;
		public static final int DEAD = 4;
		
		public static final int CRABBY_WIDTH_DEFAULT = 72;
		public static final int CRABBY_HEIGHT_DEFAULT = 32;
		
		public static final int CRABBY_WIDTH = (int) (CRABBY_WIDTH_DEFAULT * Game.SCALE);
		public static final int CRABBY_HEIGHT = (int) (CRABBY_HEIGHT_DEFAULT * Game.SCALE);
		
		public static final int CRABBY_DRAWOFFSET_X = (int) (26 * Game.SCALE);
		public static final int CRABBY_DRAWOFFSET_Y = (int) (9 * Game.SCALE);
		
		public static int GetSpriteAmount(int enemy_type, int enemy_state) { 
			switch (enemy_type) { 
				case CRABBY -> {
					int state = 0;
					
					switch (enemy_state) { 
						case IDLE -> state = 9;
						case RUNNING -> state = 6;
						case ATTACK -> state = 7;
						case HIT -> state = 4;
						case DEAD -> state = 5;
					}
					return state;
				}
			}
			return 0;
		}
	}
	
	public static class Particle { 
		public static final int PARTICLE_WIDTH_DEFALT = 52;
		public static final int PARTICLE_HEIGHT_DEFALT = 20;
		
		public static final int PARTICLE_WIDTH = (int) (PARTICLE_WIDTH_DEFALT * Game.SCALE);
		public static final int PARTICLE_HEIGHT = (int) (PARTICLE_HEIGHT_DEFALT * Game.SCALE);
	}
	
	public static class Environment { 
		public static final int BIG_CLOUD_WIDTH_DEFAULT = 448;
		public static final int BIG_CLOUD_HEIGHT_DEFAULT = 101;
		
		public static final int BIG_CLOUD_WIDTH = (int) (BIG_CLOUD_WIDTH_DEFAULT * Game.SCALE);
		public static final int BIG_CLOUD_HEIGHT = (int) (BIG_CLOUD_HEIGHT_DEFAULT * Game.SCALE);
		
		public static final int SMALL_CLOUD1_WIDTH_DEFAULT = 74;
		public static final int SMALL_CLOUD1_HEIGHT_DEFAULT = 24;
		
		public static final int SMALL_CLOUD1_WIDTH = (int) (SMALL_CLOUD1_WIDTH_DEFAULT * Game.SCALE);
		public static final int SMALL_CLOUD1_HEIGHT = (int) (SMALL_CLOUD1_HEIGHT_DEFAULT * Game.SCALE);
		
		public static final int SMALL_CLOUD2_WIDTH_DEFAULT = 133;
		public static final int SMALL_CLOUD2_HEIGHT_DEFAULT = 35;
		
		public static final int SMALL_CLOUD2_WIDTH = (int) (SMALL_CLOUD2_WIDTH_DEFAULT * Game.SCALE);
		public static final int SMALL_CLOUD2_HEIGHT = (int) (SMALL_CLOUD2_HEIGHT_DEFAULT * Game.SCALE);
		
		public static final int SMALL_CLOUD3_WIDTH_DEFAULT = 140;
		public static final int SMALL_CLOUD3_HEIGHT_DEFAULT = 39;
		
		public static final int SMALL_CLOUD3_WIDTH = (int) (SMALL_CLOUD3_WIDTH_DEFAULT * Game.SCALE);
		public static final int SMALL_CLOUD3_HEIGHT = (int) (SMALL_CLOUD3_HEIGHT_DEFAULT * Game.SCALE);
	}
	
	public static class UI { 
		public static class Buttons { 
			public static final int B_WIDTH_DEFAULT = 140;
			public static final int B_HEIGHT_DEFAULT = 56;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}
		
		public static class PauseButtons { 
			public static final int SOUND_SIZE_DEFAULT = 42;
			public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * Game.SCALE);
		}
		
		public static class URMButtons {
			public static final int URM_SIZE_DEFAULT = 56;
			public static final int URM_SIZE = (int) (URM_SIZE_DEFAULT * Game.SCALE);
		}
		
		public static class VolumeButtons { 
			public static final int VOLUME_WIDTH_DEFAULT = 28;
			public static final int VOLUME_HEIGHT_DEFAULT = 44;
			public static final int SLIDER_WIDTH_DEFAULT = 215;
			
			public static final int VOLUME_WIDTH = (int) (VOLUME_WIDTH_DEFAULT * Game.SCALE);
			public static final int VOLUME_HEIGHT = (int) (VOLUME_HEIGHT_DEFAULT * Game.SCALE);
			public static final int SLIDER_WIDTH = (int) (SLIDER_WIDTH_DEFAULT * Game.SCALE);
		}
	}

	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class PlayerConstants {
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int GROUND = 4;
		public static final int HIT = 5;
		public static final int ATTACK_1 = 6;
		public static final int ATTACK_JUMP_1 = 7;
		public static final int ATTACK_JUMP_2 = 8;

		public static int GetSpriteAmount(int player_action) {
			int action = 1;
			
			switch (player_action) {
				case RUNNING -> action = 6;
				case IDLE -> action = 5;
				case HIT -> action = 4;
				case JUMP, ATTACK_1, ATTACK_JUMP_1, ATTACK_JUMP_2 -> action = 3;
				case GROUND -> action = 2;
				case FALLING -> action = 1;
			}
			return action;
		}
	}

}
