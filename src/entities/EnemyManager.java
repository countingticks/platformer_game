package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gamestates.Playing;
import main.Game;
import utils.LoadSave;
import static utils.Constants.EnemyConstants.*;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[][] crabbyArray;
	private ArrayList<Crabby> crabbies = new ArrayList<>();

	public EnemyManager(Playing playing) {
		this.playing = playing;
		loadEnemyImgs();
		addEnemies();
	}

	private void addEnemies() {
		crabbies = LoadSave.GetCrabs();
	}

	public void update(int[][] lvlData, Player player) {
		for (Crabby c : crabbies)
			c.update(lvlData, player);
	}

	public void draw(Graphics g, int lvlOffset) {
		drawCrabs(g, lvlOffset);
	}

	private void drawCrabs(Graphics g, int lvlOffset) {
		for (Crabby c : crabbies) {
			g.drawImage(crabbyArray[c.getEnemyState()][c.getAniIndex()], (int) c.getHitbox().x - lvlOffset - CRABBY_DRAWOFFSET_X, (int) c.getHitbox().y - CRABBY_DRAWOFFSET_Y, CRABBY_WIDTH, CRABBY_HEIGHT, null);			
			
			if (Game.DEBUG)
				c.drawHitbox(g, lvlOffset);
		}
	}

	private void loadEnemyImgs() {
		crabbyArray = new BufferedImage[5][9];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.CRABBY_ATLAS);
		for (int j = 0; j < crabbyArray.length; j++)
			for (int i = 0; i < crabbyArray[j].length; i++)
				crabbyArray[j][i] = temp.getSubimage(i * CRABBY_WIDTH_DEFAULT, j * CRABBY_HEIGHT_DEFAULT, CRABBY_WIDTH_DEFAULT, CRABBY_HEIGHT_DEFAULT);
	}
}