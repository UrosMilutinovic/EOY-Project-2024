public class Pictures {

	private String pic;
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int width;
	private int height;
	private boolean mballdn;
	private boolean mballrt;

	
	public Pictures() {
		pic = "";
		x= 0;
		y=0;
		dx=0;
		dy=0;
		mballdn=false;
		mballrt=false;
	}

	public Pictures(String s, int x1, int y1, int w, int h) {
		pic = s;
		x=x1;
		y=y1;
		width=w;
		height=h;
		dx=0;
		dy=0;
		mballdn=false;
		mballrt=false;
		
	}
	
	
	public Pictures(String s, int x1, int y1, int dx1, int dy1, boolean rt, boolean dn, int w1, int h1) {
		pic = s;
		x=x1;
		y=y1;
		dx=dx1;
		dy=dy1;
		height=h1;
		width=w1;
		mballrt=true;
		mballdn=false;
		
				
	}
	
	public boolean Collision(Pictures b) {
		if(getX()+getwidth()>=b.getX() && getX()<=b.getX()+b.getwidth() && getY()+getheight()>=b.getY() && getY()<=b.getY() + b.getheight()) 
		return true;
		return false;
	}
	
	public void keymove() {
		x+=dx;
		y+=dy;
		if(x+width>=800)
			x=800-width;
	}
	
	public void bounce() {
		if (mballrt) {
			x=x+dx;
		}
		else x-=dx;
		
		if (x<0) {
			mballrt=true;
		}
		if(x>800-width) {
			mballrt=false;
		}
			
		if (mballdn) 
			{y=y+dy;
		}
		else y-=dy;
		
		if(y<0) {
			mballdn=true;
		}
		if (y>600-width) {
			mballdn=false;
		}
		
			
	}
	
	public String getPic() {
		return pic;
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
}