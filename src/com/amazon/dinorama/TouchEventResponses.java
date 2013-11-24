package com.amazon.dinorama;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class TouchEventResponses implements OnTouchListener{
	
	ButtLoc button = new ButtLoc();
	ButtLoc.Arrows arrows = button.new Arrows();
	ButtLoc.Attacks attacks = button.new Attacks();
	ButtLoc.Blocks blocks = button.new Blocks();

	TouchEventResponses(ButtLoc loc){
		button = loc;
		arrows = loc.getArrows();
		attacks = loc.getAttacks();
		blocks = loc.getBlocks();
	}

	/*
	 * Sends back what button was pressed
	 */
	public Command requestedCommand(ButtLoc.MyPoint currLoc){	
		
		if(isInSquare(currLoc, arrows.getL())){
			return Command.LARROW;
		}
		if(isInSquare(currLoc, arrows.getR())){
			return Command.RARROW;
		}
		if(isInCircle(currLoc, attacks.getL())){
			return Command.LATTACK;
		}
		if(isInCircle(currLoc, attacks.getH())){
			return Command.HATTACK;
		}
		if(isInCircle(currLoc, blocks.getL())){
			return Command.LBLOCK;
		}
		if(isInCircle(currLoc, blocks.getH())){
			return Command.HBLOCK;
		}
		return Command.NA;
	}
	
	public enum Command{
		LARROW, RARROW, LATTACK, HATTACK, LBLOCK, HBLOCK, NA
	}
	
	/*
	 * first parameter is in a 64x64 square around second parameter
	 */
	private boolean isInSquare(ButtLoc.MyPoint currLoc, ButtLoc.MyPoint target){
		if(target.getX()-32 < currLoc.getX() && currLoc.getX() < target.getX()+32 &&
				target.getY()-32 < currLoc.getY() && currLoc.getY() < target.getY()+32){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	 * first parameter is in a circle of radius 32 around second parameter
	 */
	public boolean isInCircle(ButtLoc.MyPoint currLoc, ButtLoc.MyPoint target){
		double distX = Math.abs(target.getX() - currLoc.getX());
		double distY = Math.abs(target.getY() - currLoc.getY());
		double dist = Math.sqrt(distX*distX + distY*distY);
		if(dist < 32){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {

		int action = event.getAction();
		ButtLoc.MyPoint currLoc = button.new MyPoint((int) event.getRawX(), (int) event.getRawY());
		Command command = Command.NA;
				
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			command = requestedCommand(currLoc);
			
			switch(command){
			case LARROW : //CALL LEFT ARROW CODE
				break;
			case RARROW : //CALL RIGHT ARROW CODE
				break;
			case LATTACK : //CALL LOW ATTACK
				break;
			case HATTACK : //CALL HIGH ATTACK
				break;
			case LBLOCK : //CALL LOW BLOCK
				break;
			case HBLOCK : //CALL HIGH BLOCK
				break;
			case NA : //DO NOTHING
				break;
			}
			
		case MotionEvent.ACTION_UP:
			if(command==Command.LARROW || command==Command.RARROW){
				//CALL STOP MOTION
			}
			break;
		}

		return false;
	}

}
