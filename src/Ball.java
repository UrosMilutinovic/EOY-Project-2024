import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Ball {
	private int x;
	private int y;
	private int width;
	private int height;
	private int dx;
	private int dy;
	private boolean movert;
	private boolean movedn;
	private boolean moveup;

	private Color c;
	


public Ball() {
	x=300;
	y=650;
	width=30;
	height=40;
	dx=1;
	dy=1;
	movert=false;
	movedn=false;
	c=Color.CYAN;
}

public Ball(int x1, int y1, int w, int h, int dx1, int dy1, Color c1) {

	x=x1;
	y=y1;
	width=w;
	height=h;
	dx=dx1;
	dy=dy1;
	c= c1;

	
	movert= true;
	movedn=true;
	moveup = true;
	
}
public void setmovert() {
	movert=!movert;
}


public boolean Collision(Paddle l) {
	if(getX()+getW()>=l.getX() && getX()<=l.getX()+l.getW() && getY()+getH()>=l.getY() && getY()<=l.getY() + l.getH()) {
		setmoveUp();
		return true;

	}
	return false;
	
}






public void bounce() {
	if (movert) {
		x=x+dx;
	}
	else x-=dx;
	
	if (x<0) {
		movert=true;
	}
	if(x>800-60) {
		movert=false;
	}
		
	if (moveup) 
		{y=y-dy;
	}
	else y+=dy;
	
	
	if(y<0) {
		moveup=false;
	}
	if (y>600-80) {
		moveup=true;
	}
}

public void bounce1() {
	if (movert) {
		x=x+dx;
	}
	else x-=dx;
	
	if (x<0) {
		movert=true;
	}
	if(x>800-60) {
		movert=false;
	}
		
	if (moveup) 
		{y=y-dy;
	}
	else y+=dy;
	
	
	if(y<0) {
		moveup=false;
	}
	if (y>600-80) {
		moveup=true;
	}
}

public int getX() {
	return x;
}

public int getY() {
	return y;
}

public void setX(int c) {
x=c;
}

public void setY(int c) {
y=c;
}

public int getDX() {
	return dx;
}

public int getDY() {
	return dy;
}

public void setDx(int c) {
dx=c;
}

public void setDy(int c) {
	dy=c;
}
public int getW() {
	return width;
}
public int getH() {
	return height;
}

public Color getColor() {
	return c;
}

public void setW(int c) {
	width = c;
	
}

public void setH(int c) {
	height = c;
	
}

public void setmoveUp() {
	moveup=!moveup;
	
}

/*
public int getColor
() {
	return color;
}
*/






}
