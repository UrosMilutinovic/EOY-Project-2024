import java.awt.Color;

public class Brick {

	private int x, y, w, h;
	private Color col;
	//test
	


public Brick() {
	x=30;
	y=0;
	w=0;
	h=0;
	col = Color.blue;
		
}

public Brick(int xV, int yV, int w, int h, Color c) {
	x=xV;
	y=yV;
	col=c;
	w=100;
	h=50;
	
}

//getters and setters

public int getX() {
	return x;
}

public int getY() {
	return y;
}

public int getW() {
	return w;
}

public int getH() {
	return h;
}

public void setX(int c) {
	x=c;
}

public void setY(int c) {
	y=c;
}

public void setColor(Color c) {
	col=c;
	}

public Color getCol() {
	return col;
}
 
public void setBrick() {
	
}


}


