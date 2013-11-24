package com.amazon.dinorama;

import android.content.res.Resources;
import android.graphics.Bitmap;

public class DisplayableObject {
	Bitmap imageDisplayed;
	int originX;
	int originY;
	double scaleX;
	double scaleY;
	Resources res;
	
	public DisplayableObject(Resources res, int originX, int originY){
		this.originX = originX;
		this.originY = originY;
		this.scaleX = 1;
		this.scaleY = 1;
		this.res = res;
	}
	
	public void setImageDisplayed(Bitmap bitmap){
		this.imageDisplayed = bitmap;
	}
	
	public Bitmap getImageDisplayed(){
		return imageDisplayed;
	}
	
	public int getX(){
		return originX;
	}
	
	public int getY(){
		return originY;
	}
	
	public double getScaleX(){
		return scaleX;
	}
	
	public void setScale(double passedScale){
		scaleX = passedScale;
		scaleY = passedScale;
	}
	
	public void setXScale(double passedScale){
		scaleX = passedScale;
	}
	
	public double getScaleY(){
		return scaleY;
	}
	
	public void update(){}
}
