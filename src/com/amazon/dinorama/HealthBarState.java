package com.amazon.dinorama;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

public class HealthBarState extends DisplayableObject{
	
	PlayerEnum pEnum = PlayerEnum.NEUTRAL;
	
	/*
	 * don't use these!
	 */
	public HealthBarState(Resources res, int originX, int originY) {
		super(res, originX, originY);
	}
	
	/*
	 * PlayerEnum.PLAYER (left) or PlayerEnum.AI(right)
	 * position of healthBar is 2 variables in GlobalVariables.java
	 * the actual position of health bar is (28, 27) on healthbar
	 */
	public HealthBarState(Resources res, PlayerEnum pEnumeration){
		super(res, GlobalVariables.healthBarX+28, GlobalVariables.healthBarY+27);
		pEnum = pEnumeration;
		setImageDisplayed(BitmapFactory.decodeResource(res, R.drawable.health_front));
		if(pEnum.equals(PlayerEnum.AI)){
			scaleX = -1;
			originX = 1280 - GlobalVariables.healthBarX - 28;
		}
	}
	
	@Override
	public void update(){
		
		//if AI then update health flipped
		if(pEnum.equals(PlayerEnum.AI)){
			int currHealth = GlobalVariables.getAIHealth();
			scaleX = -((double) currHealth)/100;
		//if PLAYER then update health unflipped 
		}else if(pEnum.equals(PlayerEnum.PLAYER)){
			int currHealth = GlobalVariables.getPlayerHealth();
			scaleX = ((double) currHealth)/100;
		}
		
	}
}
