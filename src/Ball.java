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
	private Color c;
	


public Ball() {
	x=300;
	y=300;
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
	
}
public void setmovert() {
	movert=!movert;
}


public boolean Collision(Paddle b) {
	if(getX()+getwidth()>=b.getX() && getX()<=b.getX()+b.getwidth() && getY()+getheight()>=b.getY() && getY()<=b.getY() + b.getheight()) {
		setmovert();
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
		
	if (movedn) 
		{y=y+dy;
	}
	else y-=dy;
	
	
	if(y<0) {
		movedn=true;
	}
	if (y>600-80) {
		movedn=false;
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


public void setDx(int c) {
dx=c;
}

public void setDy(int c) {
	dy=c;
}
public int getwidth() {
	return width;
}
public int getheight() {
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



/*
public int getColor
() {
	return color;
}
*/





}