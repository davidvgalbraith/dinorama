package com.amazon.dinorama;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

public class TestItem extends DisplayableObject {
	
	private int startX;
	private double offset;

	public TestItem(Resources res, int originX, int originY) {
		super(res, originX, originY);
		setImageDisplayed(BitmapFactory.decodeResource(res, R.drawable.test));
//		System.out.println(getImageDisplayed());
		startX = originX;
		offset = Math.random()*3.14;
	}
	
	@Override
	public void update() {
		originX = (int) (startX + 128*Math.cos(System.currentTimeMillis()/1000.0+offset));
	}

}
