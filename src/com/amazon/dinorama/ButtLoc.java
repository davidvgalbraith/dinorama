package com.amazon.dinorama;


public class ButtLoc {
	Arrows arrows = new Arrows();
	Attacks attacks = new Attacks();
	Blocks blocks = new Blocks();
	
	public class Arrows{
		MyPoint left = new MyPoint(), right = new MyPoint();
		
		public MyPoint getL(){
			return left;
		}
		public MyPoint getR(){
			return right;
		}
		public void setL(int inputX, int inputY){
			left.set(inputX, inputY);
		}
		public void setR(int inputX, int inputY){
			right.set(inputX, inputY);
		}
	}

	public class Attacks{
		MyPoint low = new MyPoint(), high = new MyPoint();
		
		public MyPoint getL(){
			return low;
		}
		public MyPoint getH(){
			return high;
		}
		public void setL(int inputX, int inputY){
			low.set(inputX, inputY);
		}
		public void setH(int inputX, int inputY){
			high.set(inputX, inputY);
		}
	}

	public class Blocks{
		MyPoint low = new MyPoint(), high = new MyPoint();
		
		public MyPoint getL(){
			return low;
		}
		public MyPoint getH(){
			return high;
		}
		public void setL(int inputX, int inputY){
			low.set(inputX, inputY);
		}
		public void setH(int inputX, int inputY){
			high.set(inputX, inputY);
		}	
	}
	
	public class MyPoint{
		int x=-1, y=-1;
		
		MyPoint(){}
		
		MyPoint(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}
		
		public void set(int inputX, int inputY){
			x = inputX;
			y = inputY;
		}
	}
	
	public ButtLoc(){}
	
	/*
	 * Arrows -> L, R (x, y)
	 * Attacks -> H, L (x, y)
	 * Blocks -> H, L (x, Y)
	 */
	public ButtLoc(int ArrowLX, int ArrowLY, int ArrowRX, int ArrowRY,
			int AttackHX, int AttackHY, int AttackLX, int AttackLY,
			int BlockHX, int BlockHY, int BlockLX, int BlockLY){
		arrows.setL(ArrowLX, ArrowLY);
		arrows.setR(ArrowRX, ArrowRY);
		
		attacks.setL(AttackLX, AttackLY);
		attacks.setH(AttackHX, AttackHY);
		
		blocks.setL(BlockLX, BlockLY);
		blocks.setH(BlockHX, BlockHY);
	}

	/*
	 * Arrows -> L, R (x, y)
	 * Attacks -> H, L (x, y)
	 * Blocks -> H, L (x, Y)
	 */
	public ButtLoc(int[] Arrows, int[] Attacks, int[] Blocks){
		arrows.setL(Arrows[0], Arrows[1]);
		arrows.setR(Arrows[2], Arrows[3]);
		
		attacks.setL(Attacks[0], Attacks[1]);
		attacks.setH(Attacks[2], Attacks[3]);
		
		blocks.setL(Blocks[0], Blocks[1]);
		blocks.setH(Blocks[2], Blocks[3]);
	}
	
	/*
	 * 2D array
	 * 0: Arrows -> L, R (x, y)
	 * 1: Attacks -> H, L (x, y)
	 * 2: Blocks -> H, L (x, Y)
	 */
	public ButtLoc(int[][] info){
		this(info[0], info[1], info[2]);
	}
	
	public Arrows getArrows(){
		return arrows;
	}
	
	public Attacks getAttacks(){
		return attacks;
	}
	
	public Blocks getBlocks(){
		return blocks;
	}
}
