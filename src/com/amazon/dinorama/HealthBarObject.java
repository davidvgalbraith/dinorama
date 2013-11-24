package com.amazon.dinorama;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

public class HealthBarObject extends DisplayableObject{

	/*
	 * don't uses these!
	 */
	public HealthBarObject(Resources res, int originX, int originY) {
		super(res, originX, originY);
	}
	
	/*
	 * PlayerEnum.PLAYER (left) or PlayerEnum.AI(right)
	 * position of healthBar is 2 variables in GlobalVariables.java
	 */
	public HealthBarObject(Resources res, PlayerEnum player){
		super(res, GlobalVariables.healthBarX, GlobalVariables.healthBarY);
		setImageDisplayed(BitmapFactory.decodeResource(res, R.drawable.health_back));
		if(player.equals(PlayerEnum.AI)){
			scaleX = -1;
			originX = 1280 - GlobalVariables.healthBarX;
		}
	}

}
