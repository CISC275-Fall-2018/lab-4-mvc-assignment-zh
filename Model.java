import java.awt.Color;
import java.util.Scanner;
//Zhihao Zhang

/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/


class Model{
	private int xloc = 0;
	private int yloc = 0;
	private final int xIncr = 8;
	private final int yIncr = 2;
	int xdir = 1;
    int ydir = 0;
	int width;
	int height;
	int imgWidth;
	int imgHeight;
	int direction=0;
	
	public Model(int w,int h,int iw,int ih) {
		this.width = w;
		this.height = h;
		this.imgWidth = iw;
		this.imgHeight = ih;
		
	}

	public void update() {
		//check if hit boundaries
		if(xloc+xIncr+(imgWidth*(154.0/165)) > width) {
			xdir = 0;
		}
		if(yloc+yIncr+(imgHeight*(187.0/165)) > height) {
			ydir = 1;
		}
		if(xloc-xIncr+(imgWidth*(27.0/165)) < 0) {
			xdir = 1;
		}
		if(yloc-yIncr+(imgHeight*(25.0/165)) < 0) {
			ydir = 0;
		}
		//call move method
		move();
	}

	private void move() {
		if (direction == 3){
			xloc+=xIncr;
			yloc+=yIncr;
		}
		if (direction == 5){
			xloc-=xIncr;
			yloc+=yIncr;
		}
		if (direction == 7){    	
			xloc-=xIncr;
			yloc-=yIncr;
		}
		if (direction == 1){    		
			xloc+=xIncr;
			yloc-=yIncr;
		}
	}
		
	public int getX() {
		// TODO Auto-generated method stub
		return xloc;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return yloc;
	}

	public int getDirect() {
		//get dirction from xdir&ydir.
		if (xdir == 1 & ydir == 0){
			return direction = 3;	
		}
		if (xdir == 0 & ydir == 0){
			return direction = 5;	
		}
		if (xdir == 0 & ydir == 1){    	
			return direction = 7;
		}
		if (xdir == 1 & ydir == 1){    	
			return direction = 1;
		}
		return direction;
		
	
	}
		}
