package com.amazon.dinorama;

public class AIManager {

	protected Player player;
	protected Player enemy;
	
	protected final int target = 40;
	protected final int threshold = 80;
	protected int counter = 0;
	
	public AIManager(Player player, Player enemy) {
		this.player = player;
		this.enemy = enemy;
	}
	
//	public void update() {/* dummy */}
	
	public void update() {
		if (counter >= target + Math.random()*threshold) {
			int dist = Math.abs(player.originX - enemy.originX);
			System.err.println("updating AI: "+dist+", "+enemy.currentState);
//			move towards player
			if (player.originX < enemy.originX) {
//				randomly attack
				if (Math.pow(Math.random(), 4) < 1.0 - dist/1280.0) {
					if (!enemy.isAttacking()) {
						if (Math.random() < .5)
							enemy.attackLow();
						else
							enemy.attackHigh();
					}
				} else if (enemy.currentState != PlayerState.MOVELEFT) {
					if (Math.random() < 1.0 - Math.pow(dist/1280.0, 2))
						enemy.moveLeft();
					else
						enemy.forceIdle();
				}
			} else {
//				randomly attack
				if (Math.pow(Math.random(), 4) < 1.0 - dist/1280.0) {
					if (!enemy.isAttacking()) {
						if (Math.random() < .5)
							enemy.attackLow();
						else
							enemy.attackHigh();
					}
				} else if (enemy.currentState != PlayerState.MOVERIGHT) {
					if (Math.random() <  1.0 - Math.pow(dist/1280.0, 2))
						enemy.moveRight();
					else
						enemy.forceIdle();
				}
			}
			counter = 0;
		} else
			counter++;
	}
	
}
