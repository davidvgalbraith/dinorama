package com.amazon.dinorama;

public class GameLogic {
	private Player user;
	private Player ai;
	private int hitBoxDistance = 480 + 32;
	
	public GameLogic(Player user, Player ai){
		this.user = user;
		this.ai = ai;
	}
	
	public void update(){
		userAttacks();
		aiAttacks();
		checkOrientation();
	}

	public void userAttacks(){
		if(user.isHitting()){
			if(user.currentState != ai.currentState){
				int displacement = Math.abs((ai.getCenteredX() - user.getCenteredX()));
				if(displacement < hitBoxDistance){					
					if(GlobalVariables.AIHealth > 0){
						GlobalVariables.AIHealth -= 10;
					}else{
						GlobalVariables.gameResult = 1;
					}
				}
			}
		}
	}
	
	public void aiAttacks(){
		if(ai.isHitting()){
			if(user.currentState != ai.currentState){
				int displacement = Math.abs((ai.getCenteredX() - user.getCenteredX()));
				if(displacement < hitBoxDistance){
					if(GlobalVariables.playerHealth > 0){
						GlobalVariables.playerHealth -= 10;
					}else{
						GlobalVariables.gameResult = 2;
					}				
				}
			}
		}
	}
	
	//should be called on update
	public void checkOrientation(){
		if(user.getCenteredX() < ai.getCenteredX()){
			if(user.getScaleX() == -1){
				user.setXScale(1);
				user.setRelativeX(-480);
			}
			if(ai.getScaleX() == 1){
				ai.setXScale(-1);
				ai.setRelativeX(480);
			}
			
		}else{
			if(user.getScaleX() == 1){
				user.setXScale(-1);
				user.setRelativeX(480);
			}
			if(ai.getScaleX() == -1){
				ai.setXScale(1);
				ai.setRelativeX(-480);
			}
			
		}
	}
	
	
	
	
	
}
