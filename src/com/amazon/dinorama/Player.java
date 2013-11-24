package com.amazon.dinorama;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Player extends DisplayableObject {
	//Images
	private ArrayList<Bitmap> playerImages;
	
	private final int boundary = 96;
	
	private boolean hitting = false;
	
	private void initImageMap(){
		playerImages = new ArrayList<Bitmap>();
		Bitmap idle, step1, step2, hA1, hA2, lA1, lA2;
		
		System.out.println("d:"+dinoType);
		if(dinoType == 1){
			idle = BitmapFactory.decodeResource(res, R.drawable.stego_1_pink);
			step1 = BitmapFactory.decodeResource(res, R.drawable.stego_6_pink);
			step2 = BitmapFactory.decodeResource(res, R.drawable.stego_7_pink);
			hA1 = BitmapFactory.decodeResource(res, R.drawable.stego_2_pink);
			hA2 = BitmapFactory.decodeResource(res, R.drawable.stego_3_pink);
			lA1 = BitmapFactory.decodeResource(res, R.drawable.stego_4_pink);
			lA2 = BitmapFactory.decodeResource(res, R.drawable.stego_5_pink);			
			
			playerImages.add(idle);
			playerImages.add(step1);
			playerImages.add(step2);
			playerImages.add(hA1); 
			playerImages.add(hA2);
			playerImages.add(lA1);
			playerImages.add(lA2);

		}else if(dinoType == 2){
			playerImages = new ArrayList<Bitmap>();
			idle = BitmapFactory.decodeResource(res, R.drawable.stego_1_orange);
			step1 = BitmapFactory.decodeResource(res, R.drawable.stego_6_orange);
			step2 = BitmapFactory.decodeResource(res, R.drawable.stego_7_orange);
			hA1 = BitmapFactory.decodeResource(res, R.drawable.stego_2_orange);
			hA2 = BitmapFactory.decodeResource(res, R.drawable.stego_3_orange);
			lA1 = BitmapFactory.decodeResource(res, R.drawable.stego_4_orange);
			lA2 = BitmapFactory.decodeResource(res, R.drawable.stego_5_orange);
			
			playerImages.add(idle);
			playerImages.add(step1);
			playerImages.add(step2);
			playerImages.add(hA1);
			playerImages.add(hA2);
			playerImages.add(lA1);
			playerImages.add(lA2);
		}else if(dinoType == 3){
			idle = BitmapFactory.decodeResource(res, R.drawable.stego_1_green);
			step1 = BitmapFactory.decodeResource(res, R.drawable.stego_6_green);
			step2 = BitmapFactory.decodeResource(res, R.drawable.stego_7_green);
			hA1 = BitmapFactory.decodeResource(res, R.drawable.stego_2_green);
			hA2 = BitmapFactory.decodeResource(res, R.drawable.stego_3_green);
			lA1 = BitmapFactory.decodeResource(res, R.drawable.stego_4_green);
			lA2 = BitmapFactory.decodeResource(res, R.drawable.stego_5_green);
			
			playerImages.add(idle);
			playerImages.add(step1);
			playerImages.add(step2);
			playerImages.add(hA1);
			playerImages.add(hA2);
			playerImages.add(lA1);
			playerImages.add(lA2);
		}else if(dinoType == 4){
			idle = BitmapFactory.decodeResource(res, R.drawable.stego_1_blue);
			step1 = BitmapFactory.decodeResource(res, R.drawable.stego_6_blue);
			step2 = BitmapFactory.decodeResource(res, R.drawable.stego_7_blue);
			hA1 = BitmapFactory.decodeResource(res, R.drawable.stego_2_blue);
			hA2 = BitmapFactory.decodeResource(res, R.drawable.stego_3_blue);
			lA1 = BitmapFactory.decodeResource(res, R.drawable.stego_4_blue);
			lA2 = BitmapFactory.decodeResource(res, R.drawable.stego_5_blue);
			
			playerImages.add(idle);
			playerImages.add(step1);
			playerImages.add(step2);
			playerImages.add(hA1);
			playerImages.add(hA2);
			playerImages.add(lA1);
			playerImages.add(lA2);
		}
		
	}
	
	//Constants
	private final int speed = 4;
	
	//Stats
	private int dinoType;
	private int health = 100;

	//State
	protected boolean buttonPressed = false;
	protected boolean attackComplete = true;
	protected PlayerState currentState = PlayerState.IDLE;
	protected int stateCounter = 0;
	
	public Player(Resources res, int originX, int originY){
		super(res, originX, originY + GlobalVariables.groundOffset);
		dinoType = DinoNumWrapper.dinoNum;
		initImageMap();
	}
	
	protected void changeDinoType(int type) {
		dinoType = ((int)(Math.random()*4)+1);
		initImageMap();
	}
	
	private void idle(){
		hitting = false;
		setImageDisplayed(playerImages.get(0));
		stateCounter = 0;
	}
		
	private void step(){
		hitting = false;		
		if((stateCounter >= 0) && (stateCounter < 19)){
			setImageDisplayed(playerImages.get(1));
		}else if((stateCounter >= 19) && (stateCounter < 38)){
			setImageDisplayed(playerImages.get(2));
		}else{
			stateCounter = 0;
		}
	}
	
	private void movementRight(){
		hitting = false;
		step();
		if ((scaleX == 1 && originX < 800+boundary-speed) || (scaleX == -1 && originX < 1280+boundary-speed))
			originX += speed;
	}
	private void movementLeft(){
		hitting = false;
		step();
		if ((scaleX == 1 && originX > -boundary+speed) || (scaleX == -1 && originX > 480-boundary+speed))
			originX -= speed;
	}
	
	private void attackingHigh(){
		hitting = (stateCounter == 5);
		
		if((stateCounter >= 0) && (stateCounter < 5)){
			setImageDisplayed(playerImages.get(3));
		}else if((stateCounter >= 5) && (stateCounter < 20)){
			setImageDisplayed(playerImages.get(4));
		}else if((stateCounter >= 20) && (stateCounter < 25)){
			setImageDisplayed(playerImages.get(3));
		}else{
			setImageDisplayed(playerImages.get(0));
			attackComplete = true;
			stateCounter = 0;
			currentState = PlayerState.IDLE;
		}
	}
	
	private void attackingLow(){
		hitting = (stateCounter == 5);
		
		if((stateCounter >= 0) && (stateCounter < 5)){
			setImageDisplayed(playerImages.get(5));
		}else if((stateCounter >= 5) && (stateCounter < 20)){
			setImageDisplayed(playerImages.get(6));
		}else if((stateCounter >= 20) && (stateCounter < 25)){
			setImageDisplayed(playerImages.get(5));
		}else{
			setImageDisplayed(playerImages.get(0));
			attackComplete = true;
			stateCounter = 0;
			currentState = PlayerState.IDLE;
		}
	}

	public void update(){
		stateCounter++;
		if(currentState == PlayerState.IDLE){
			idle();
		}

		if(buttonPressed){
			if(currentState == PlayerState.MOVERIGHT){
				movementRight();
			}else if(currentState == PlayerState.MOVELEFT){
					movementLeft();
			}else if(currentState == PlayerState.HIGHATTACK){
				if(attackComplete == false){
					attackingHigh();
				}
			}else if(currentState == PlayerState.LOWATTACK){
				if(attackComplete == false){
					attackingLow();
				}
			}
		}

	}
	
	public boolean isHitting() {
		return hitting;
	}
	
	public void forceIdle(){
		buttonPressed = false;
		stateCounter = 0;
		currentState = PlayerState.IDLE;
		
	}
	
	public void moveRight(){
		buttonPressed = true;
		currentState = PlayerState.MOVERIGHT;
	}
	
	public void moveLeft(){
		buttonPressed = true;
		currentState = PlayerState.MOVELEFT;
	}
	
	public void attackHigh(){
		buttonPressed = true;
		attackComplete = false;
		currentState = PlayerState.HIGHATTACK;	
	}
	
	public void attackLow(){
		buttonPressed = true;
		attackComplete = false;
		currentState = PlayerState.LOWATTACK;
	}
	
	public boolean isAttacking(){
		return !attackComplete;
	}

	protected int getCenteredX() {
		return (int) (originX + scaleX*240);
	}


	public void setRelativeX(int i) {
		originX += i;		
	}
	
}

//check distance
//what stat theyre in when attacking, if attacking dont do damaging
