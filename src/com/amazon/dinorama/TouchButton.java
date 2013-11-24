package com.amazon.dinorama;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class TouchButton extends DisplayableObject {
	
	public static int size = 128;
	
	public TouchButtonDirection type;
	
	protected HashMap<TouchButtonDirection, Bitmap> imagesUp = new HashMap<TouchButtonDirection, Bitmap>();
	protected HashMap<TouchButtonDirection, Bitmap> imagesDown = new HashMap<TouchButtonDirection, Bitmap>();
	protected boolean tapped = false;
	
	protected enum TouchButtonDirection {
		HI_ATK,
		LO_ATK,
		HI_BLK,
		LO_BLK,
		LEFT,
		RIGHT
	}

	public TouchButton(Resources res, int originX, int originY, TouchButtonDirection dir) {
		super(res, originX, originY);
		type = dir;
		getImages();
		setImage();
	}
	
	public boolean hit(double x, double y) {
		tapped = x >= originX && x <= originX+size && y >= originY && y <= originY+size;
		return tapped;
	}
	
	public void release() {
		tapped = false;
	}
	
	protected void getImages() {
		imagesUp.put(TouchButtonDirection.HI_ATK, BitmapFactory.decodeResource(res, R.drawable.attackbuttonhigh));
		imagesUp.put(TouchButtonDirection.LO_ATK, BitmapFactory.decodeResource(res, R.drawable.attackbuttonlow));
		imagesUp.put(TouchButtonDirection.HI_BLK, BitmapFactory.decodeResource(res, R.drawable.arrow_hi));
		imagesUp.put(TouchButtonDirection.LO_BLK, BitmapFactory.decodeResource(res, R.drawable.arrow_lo));
		imagesUp.put(TouchButtonDirection.LEFT, BitmapFactory.decodeResource(res, R.drawable.directionbuttonleft));
		imagesUp.put(TouchButtonDirection.RIGHT, BitmapFactory.decodeResource(res, R.drawable.directionbuttonright));
		
		imagesDown.put(TouchButtonDirection.HI_ATK, BitmapFactory.decodeResource(res, R.drawable.attackbuttonpressedhigh));
		imagesDown.put(TouchButtonDirection.LO_ATK, BitmapFactory.decodeResource(res, R.drawable.attackbuttonpressedlow));
		imagesDown.put(TouchButtonDirection.HI_BLK, BitmapFactory.decodeResource(res, R.drawable.arrow_hi));
		imagesDown.put(TouchButtonDirection.LO_BLK, BitmapFactory.decodeResource(res, R.drawable.arrow_lo));
		imagesDown.put(TouchButtonDirection.LEFT, BitmapFactory.decodeResource(res, R.drawable.directionbuttonpressedleft));
		imagesDown.put(TouchButtonDirection.RIGHT, BitmapFactory.decodeResource(res, R.drawable.directionbuttonpressedright));
	}
	
	protected void setImage() {
		int image;
		if (!tapped)
			setImageDisplayed(imagesUp.get(type));
		else
			setImageDisplayed(imagesDown.get(type));
	}
	
	@Override
	public void update() {
		setImage();
	}
	
	public String toString() {
		return type.name();
	}
}
