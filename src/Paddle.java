import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Paddle {
	private int x;
	private int y;
	private int width;
	private int height;
	private int dx;
	private int dy;
	private Color c;
	private int score;
	


public Paddle() {
	x=0;
	y=300;
	width=20;
	height=100;
	dx= 0;
	dy = 0;
	
}

public Paddle(int x1, int y1, int w, int h, int dx1, int dy1,  Color c1) {
	x=x1;
	y=y1;
	width=w;
	height=h;
	dx=dx1;
	dy=dy1;

}


public void keymove() {
	x+=dx;
	y+=dy;
	if(y+height>=570)
		y=570-height;
	else if(y<=0) {
		y = 0;
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

public int getScore() {
	return score;
}

public void setScore(int c) {
	score+=c;
}

public void resetScore(int c) {
	score = c;
}


/*
public int getColor() {
	return color;
}
*/


}