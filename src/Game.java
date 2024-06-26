import javax.management.openmbean.SimpleType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.*;


public class Game extends JPanel implements Runnable, KeyListener{
	private BufferedImage back;
	private Paddle player;
	private Ball ball;

	private Ball ball2;
	private Ball ball3;
	private Ball ball4;
	private Ball ball5;

	private double currtime1;
	private double time1;
	private Paddle player2;
	private Paddle player3;
	private Sound p;
	private Pictures background;
	private Pictures background2;
	private Pictures background3;
	private boolean start;
	private Sound p2;
	private char screen;
	private int key;
	private Sound m;
	private Sound m2;
	private int len;
	private int len2;
	private int len3;
	private int len4;
	private int len5;
	private int lives;
	private int lives2;
	private int lives3;
	private int lives4;
	private int lives5;

	private int score;
	private boolean collide;
	private ArrayList <Brick> BrickList;

	private ArrayList <Brick> BrickList1;
	private ArrayList <Brick> BrickList2;
	private ArrayList <Brick> BrickList3;
	private ArrayList <Brick> BrickList4;
	private int Screen_W;
	private int Brick_W;
	private int Brick_H;
	private int level;
	private boolean start1;
	private Pictures HomeBi;


	
	private Brick b1;
	
	public Game() {
		back=null;
		new Thread(this).start();
		this.addKeyListener(this);

		HomeBi = new Pictures("Homescreen Background.png", 0,0,785, 560);
		
		key=-1;
		player = new Paddle(10, 300, 20, 100,0 ,0, Color.BLACK);
		ball = new Ball(400, 300, 50, 50, 0, 0, Color.CYAN);
		ball2 = new Ball(400, 400, 50, 50, 0, 0, Color.CYAN);
		ball3 = new Ball(400, 400, 50, 50, 0, 0, Color.CYAN);
		ball4 = new Ball(400, 400, 50, 50, 0, 0, Color.CYAN);
		ball5 = new Ball(400, 400, 50, 50, 0, 0, Color.CYAN);


		time1=System.currentTimeMillis();
		currtime1=0;
		player2 = new Paddle(750, 300, 20, 100,0 ,0, Color.BLACK);
		player3 = new Paddle (270, 570, 100, 20, 0, 0, Color.red);
		p = new Sound();
		p2 = new Sound();
		p2.playmusic("Background music.wav");

		score=0;
		
		background= new Pictures ("background.png", 0,0, 800, 600);
		background2= new Pictures ("BrickBrerakerBackground.png", 0,0, 800, 600);
		background3= new Pictures ("BrickBrerakerBackground.png", 0,0, 800, 600);
		//BrickList = setBricks();

		start = false;
		start1 = true;

		
		//----------------------------------------------------------------------------------------
		
		len = 0;
		len2 = 0;
		len3 = 0;
		len4 =0;
		len5 = 0;

		//BrickList = setBricks();
		lives = 3;
		lives2 = 3;
		lives3 = 3;
		lives4 = 3;
		lives5 = 3;

		
		//-----------------------------------------------------------
		
		Screen_W = 800;
		Brick_W = 100;
		Brick_H = 50;
	
		//---------------------

		BrickList1=setBricks1();
		BrickList2=setBricks2();
		BrickList3=setBricks3();
		BrickList4=setBricks4();

		//----------------------------------------

		p2 = new Sound();
		p2.playmusic("Background music.wav");

	}
		
	
	public void drawBricks(Graphics g2d){
		for(Brick b: BrickList) {
			g2d.setColor(b.getCol());
			g2d.fillRect(b.getX(), b.getY(), b.getW(), b.getH());
		}
	}
	
	//level 1
	private ArrayList<Brick> setBricks1() {
		// TODO Auto-generated method stub
		ArrayList <Brick> temp1 = new ArrayList <Brick>();
		int y=0;	
		for(int i=0; i<5; i++) {
			int x=20;
			for (int j=0; j<6; j++) {
			temp1.add( new Brick(x,y,new Color(getRandNum(),getRandNum(),getRandNum() ) ));
			x+=120;
			}
			y+=70;

		}
		
		return temp1;
	}

	public void drawBricks1(Graphics g2d){
		for(Brick g: BrickList1) {
			g2d.setColor(g.getCol());
			g2d.fillRect(g.getX(), g.getY(), g.getW(), g.getH());
		}
	}
	private ArrayList<Brick> setBricks2() {
		// TODO Auto-generated method stub
		ArrayList <Brick> temp2 = new ArrayList <Brick>();
		int y=0;	
		for(int i=0; i<3; i++) {
			int x=20;
			for (int j=0; j<6; j++) {
			temp2.add( new Brick(x,y,new Color(getRandNum(),getRandNum(),getRandNum() ) ));
			x+=120;
			}
			y+=140;

		}
		
		return temp2;
	}

	public void drawBricks2(Graphics g2d){
		for(Brick g: BrickList2) {
			g2d.setColor(g.getCol());
			g2d.fillRect(g.getX(), g.getY(), g.getW(), g.getH());
		}
	}

	private ArrayList<Brick> setBricks3() {
		// TODO Auto-generated method stub
		ArrayList <Brick> temp3 = new ArrayList <Brick>();
		int y=0;	
		for(int i=0; i<6; i++) {
			int x=40;
			for (int j=0; j<4; j++) {
			temp3.add( new Brick(x,y,new Color(getRandNum(),getRandNum(),getRandNum() ) ));
			x+=200;
			}
			y+=60;

		}
		
		return temp3;
	}

	public void drawBricks3(Graphics g2d){
		for(Brick g: BrickList3) {
			g2d.setColor(g.getCol());
			g2d.fillRect(g.getX(), g.getY(), g.getW(), g.getH());
		}
	}

	private ArrayList<Brick> setBricks4() {
		// TODO Auto-generated method stub
		ArrayList <Brick> temp4 = new ArrayList <Brick>();
		
				temp4.add(new Brick(230, 98, 100, 30, setRandomColor()));
				temp4.add(new Brick(450 , 98, 100, 30, setRandomColor()));
				
				temp4.add(new Brick(150 , 128, 100, 30, setRandomColor()));
				temp4.add(new Brick(350 , 128, 100, 30, setRandomColor()));
				temp4.add(new Brick(550 , 128, 100, 30, setRandomColor()));
				
				temp4.add(new Brick(100 , 158, 100, 30, setRandomColor()));
				temp4.add(new Brick(600 , 158, 100, 30, setRandomColor()));

				temp4.add(new Brick(100 , 188, 100, 30, setRandomColor()));
				temp4.add(new Brick(600 , 188, 100, 30, setRandomColor()));

				temp4.add(new Brick(150 , 218, 100, 30, setRandomColor()));
				temp4.add(new Brick(550 , 218, 100, 30, setRandomColor()));

				// 

				temp4.add(new Brick(200 , 248, 100, 30, setRandomColor()));
				temp4.add(new Brick(500 , 248, 100, 30, setRandomColor()));

				temp4.add(new Brick(250 , 278, 100, 30, setRandomColor()));
				temp4.add(new Brick(450 , 278, 100, 30, setRandomColor()));

				temp4.add(new Brick(350 , 308, 100, 30, setRandomColor()));

			



				//System.out.println("These work");
		return temp4;
	}

	public void drawBricks4(Graphics g2d){
		
		for(Brick g: BrickList4) {
			g2d.setColor(g.getCol());
			g2d.fillRect(g.getX(), g.getY(), g.getW(), g.getH());
			//System.out.println(g.getX() + " y "+ g.getY()+ " w"+ g.getW());
		}
	}

	int[][] smileyCoordinates = {
            {280, 120, 80, 60},  
            {440, 120, 80, 60},  
            {360, 200, 80, 60},  
            {240, 300, 80, 60},  
            {320, 320, 80, 60}, 
            {400, 320, 80, 60},  
            {480, 300, 80, 60},  
            {280, 340, 80, 60},  
            {360, 340, 80, 60},  
            {440, 340, 80, 60},  
            {120, 300, 80, 60},  
            {600, 300, 80, 60},  
            {200, 62, 80, 60},   
            {200, 122, 80, 60},  
            {200, 182, 80, 60}, 
            {520, 62, 80, 60},   
            {520, 122, 80, 60},  
            {520, 182, 80, 60},  
            {360, 240, 80, 60},  
            {360, 300, 80, 60},  
            {200, 360, 80, 60}, 
            {520, 360, 80, 60},  
            {280, 420, 80, 60},  
            {360, 420, 80, 60}, 
            {440, 420, 80, 60}  
            
            
        };


        
public int getRandNum() {
	return (int)(Math.random()*255)+1;
}
	
		//collide=false;
		public void screen(Graphics g2d) {
			//System.out.println(screen);
			switch(screen) {
		case 'S':
			
//g2d.drawImage(new ImageIcon(background3.getPic()).getImage(), background3.getX(), background3.getY(), background3.getwidth(), background3.getheight() , this);
	g2d.drawString("KEY" + key, 340, 600);
	g2d.setFont(new Font("chiller",Font.BOLD, 30) );
	g2d.drawString("Press ___ to play Multiplayer - Easy", 30, 40);
			
			break;
			
		case 'M':
		g2d.clearRect(0, 0, getSize().width, getSize().height); 

			
			g2d.drawString("KEY" + key, 340, 600);
			g2d.drawImage(new ImageIcon(background.getPic()).getImage(), background.getX(), background.getY(), background.getwidth(), background.getheight() , this);

			g2d.fillOval(ball.getX(), ball.getY(), ball.getW(), ball.getH());

			g2d.fillRect(10, player.getY(), player.getW(), player.getH());
			g2d.fillRect(750, player2.getY(), player2.getW(), player2.getH());

			g2d.setColor(Color.BLACK);
			g2d.setFont(new Font("",Font.BOLD, 50) );
			g2d.drawString(new DecimalFormat("#0.00").format(currtime1),350,550);
			//System.out.println(key);
			
			if (start) {
			currtime1= (System.currentTimeMillis()-time1)/1000;
			}
			
			g2d.setFont(new Font("chiller",Font.BOLD, 30) );
			g2d.drawString("SCORE 1: "+player.getScore(), 150, 30);
			g2d.drawString("SCORE 2: "+player2.getScore(), 500, 30);

			if (ball.Collision(player)) {
			//	p.playmusic("Pong Sound Effect.wav");
				move();
			}
			
			else if (ball.Collision(player2)) {
				//p.playmusic("Pong Sound Effect.wav");
				move();
			}
			
			else if (ball.getX()<31) {
				ball.setDx(0);
				ball.setDy(0);
				ball.setX(365);
				ball.setY(300);
				player2.setScore(1);
				g2d.setColor(Color.blue);
				g2d.setFont(new Font("chiller", Font.BOLD,25) );
				start = false;
				//g2d.drawString("GAME OVER", 300, 300);
			} 
			
			else if (ball.getX()>720) {
				ball.setDx(0);
				ball.setDy(0);
				ball.setX(365);
				ball.setY(300);
				player.setScore(1);
				g2d.setColor(Color.blue);
				g2d.setFont(new Font("chiller", Font.BOLD,25) );
				//g2d.drawString("GAME OVER", 300, 300);
				start = false;
			}
				
			else move();
			
			if (player.getScore() > 4 ) { 
				g2d.setColor(Color.RED);
				g2d.drawString("Player 1 Wins!!!", 350, 150);
			}
			else if (player2.getScore() > 4) {
				g2d.setColor(Color.RED);
				g2d.drawString("Player 2 Wins!!!", 350, 150);

			}
			break;
			
			
			case 'P':
			g2d.clearRect(0, 0, getSize().width, getSize().height); 
			g2d.drawImage(new ImageIcon(background2.getPic()).getImage(), background2.getX(), background2.getY(), background2.getwidth(), background2.getheight() , this);
			
			g2d.setFont(new Font ("Times New Roman", Font.BOLD, 25));
			g2d.drawString("LIVES:" + lives2, 50, 550);

				drawBricks1(g2d);
				//level = 1;
				//BrickList = setBricks();
				//drawBricks(g2d);

				//len2 = BrickList.size();
				//System.out.println(len2);
				//System.out.println("BRICKLIST HERE");


				g2d.fillRect(player3.getX(), 570, player3.getW(), player3.getH());
				g2d.setColor(Color.BLUE);
				g2d.setFont(new Font ("Times New Roman", Font.BOLD, 50));
				//g2d.drawString("Lives: " + lives, 60, 500);
				g2d.fillOval(ball2.getX(), ball2.getY(), ball2.getW(), ball2.getH());

				
				
				collision1(); 
				if (ball2.Collision(player3)) {
					//m.playmusic("Pong Sound Effect.wav");
					move();

				}

				g2d.fillRect(player3.getX(), player3.getY(), player3.getW(), player3.getH());

				move();
				
				if (ball2.getY() > 600-80) {
					lives2--;
					ball2.setX(430);
					ball2.setY(400);
					ball2.setDx(0);
					ball2.setDy(0);
					ball2.setmoveUp();
					System.out.println("Why is the game not loosing");
				}
				
				if (lives2 == 0) {
					g2d.setColor(Color.BLUE);
					g2d.drawRect(0,0,1000,1000);
					g2d.drawString("YOU LOSE", 300, 500);
				} else if (BrickList1.size() == 0 || BrickList2.size() == 0 ||BrickList3.size() == 0 || BrickList4.size() == 0) {
					g2d.setColor(Color.RED);
					g2d.drawRect(0,0,1000,1000);
					g2d.drawString("YOU WIN", 300, 500);
					ball2.setDx(0);
					ball2.setDy(0);
				}
				
			break;	
			
				case 'L':
					
					//len3 = BrickList3.size();
					
					g2d.drawImage(new ImageIcon(background2.getPic()).getImage(), background2.getX(), background2.getY(), background2.getwidth(), background2.getheight() , this);								
					g2d.setFont(new Font ("Times New Roman", Font.BOLD, 25));
					g2d.drawString("LIVES:" + lives3, 50, 550);

					
					drawBricks2(g2d);

					g2d.fillRect(player3.getX(), 570, player3.getW(), player3.getH());

					g2d.setColor(Color.BLUE);
					g2d.setFont(new Font ("Times New Roman", Font.BOLD, 100));
					g2d.drawString("Lives: " + lives, 60, 670);
					g2d.fillOval(ball3.getX(), ball3.getY(), ball3.getW(), ball3.getH());
					
					collision2(); 
					if (ball3.Collision(player3)) {
						//m.playmusic("Pong Sound Effect.wav");
						move();
					}
					
					g2d.fillRect(player3.getX(), player3.getY(), player3.getW(), player3.getH());

					move();
					
					if (ball3.getY() > 600-80) {
						lives3--;
						ball3.setX(430);
						ball3.setY(400);
						ball3.setDx(0);
						ball3.setDy(0);
						ball3.setmoveUp();
					}
					
					/*
					if (lives == 0) {
						g2d.drawString("YOU LOSE", 300, 500);
					} else if (len2 == 0) {
						g2d.drawString("YOU WIN", 300, 500);
						ball2.setDx(0);
						ball2.setDy(0);

					}
				 */ 

				 if (lives3 == 0) {
					g2d.setColor(Color.BLUE);
					g2d.drawRect(0,0,1000,1000);
					g2d.drawString("YOU LOSE", 300, 500);
				} else if (BrickList1.size() == 0 || BrickList2.size() == 0 ||BrickList3.size() == 0 || BrickList4.size() == 0) {
					g2d.setColor(Color.RED);
					g2d.drawRect(0,0,1000,1000);
					g2d.drawString("YOU WIN", 300, 500);
					ball2.setDx(0);
					ball2.setDy(0);
				}
				break;
			
				case'W':
				if (lives == 0) {
					g2d.setColor(Color.BLUE);
					g2d.drawRect(0,0,1000,1000);
					g2d.drawString("YOU LOSE", 300, 500);
				} else if (BrickList1.size() == 0 || BrickList2.size() == 0 ||BrickList3.size() == 0 || BrickList4.size() == 0) {
					g2d.setColor(Color.RED);
					g2d.drawRect(0,0,1000,1000);
					g2d.drawString("YOU WIN", 300, 500);
					ball2.setDx(0);
					ball2.setDy(0);
				}
					
				break;
			case 'N':
			g2d.drawImage(new ImageIcon(background2.getPic()).getImage(), background2.getX(), background2.getY(), background2.getwidth(), background2.getheight() , this);								
			g2d.setFont(new Font ("Times New Roman", Font.BOLD, 25));
			g2d.drawString("LIVES:" + lives4, 50, 550);

			drawBricks3(g2d);
			//System.out.println("IT SHOULD BE RUNNING");

			g2d.fillRect(player3.getX(), 570, player3.getW(), player3.getH());
				g2d.setColor(Color.BLUE);
				g2d.setFont(new Font ("Times New Roman", Font.BOLD, 50));
				g2d.drawString("Lives: " + lives, 60, 670);
				g2d.fillOval(ball4.getX(), ball4.getY(), ball4.getW(), ball4.getH());

				
				
				collision3(); 
				if (ball4.Collision(player3)) {
					//m.playmusic("Pong Sound Effect.wav");
					move();

				}

				g2d.fillRect(player3.getX(), player3.getY(), player3.getW(), player3.getH());

				move();
				
				if (ball4.getY() > 600-80) {
					lives4--;
					ball4.setX(430);
					ball4.setY(400);
					ball4.setDx(0);
					ball4.setDy(0);
					ball4.setmoveUp();
					ball4.setmoveUp();

				}

				if (lives4 == 0) {
					g2d.setColor(Color.BLUE);
					g2d.drawRect(0,0,1000,1000);
					g2d.setColor(Color.WHITE);

					g2d.drawString("YOU LOSE", 300, 500);
				} else if (BrickList1.size() == 0 || BrickList2.size() == 0 ||BrickList3.size() == 0 || BrickList4.size() == 0) {
					g2d.setColor(Color.GREEN);
					g2d.drawRect(0,0,1000,1000);
					g2d.setColor(Color.WHITE);
					g2d.drawString("YOU WIN", 300, 500);
					ball2.setDx(0);
					ball2.setDy(0);
				}

 				break;
				 case 'H':
				 g2d.drawImage(new ImageIcon(background2.getPic()).getImage(), background2.getX(), background2.getY(), background2.getwidth(), background2.getheight() , this);								
				 g2d.setFont(new Font ("Times New Roman", Font.BOLD, 25));
				 g2d.drawString("LIVES:" + lives5, 50, 550);

				 drawBricks4(g2d);
				// System.out.println("IT SHOULD BE RUNNING case H");
	 
				 g2d.fillRect(player3.getX(), 570, player3.getW(), player3.getH());
					 g2d.setColor(Color.BLUE);
					 g2d.setFont(new Font ("Times New Roman", Font.BOLD, 50));
					 g2d.drawString("Lives: " + lives, 60, 670);
					 g2d.fillOval(ball5.getX(), ball5.getY(), ball5.getW(), ball5.getH());
	 
					 
					 
					 collision4(); 
					 if (ball5.Collision(player3)) {
						 //m.playmusic("Pong Sound Effect.wav");
						 move();
	 
					 }
	 
					 g2d.fillRect(player3.getX(), player3.getY(), player3.getW(), player3.getH());
	 
					 move();
					 
					 if (ball5.getY() > 600-80) {
						 lives5--;
						 ball5.setX(430);
						 ball5.setY(400);
						 ball5.setDx(0);
						 ball5.setDy(0);
						 ball5.setmoveUp();
					 }

					 if (lives5 == 0) {
						g2d.setColor(Color.BLUE);
						g2d.drawRect(0,0,1000,1000);
						g2d.drawString("YOU LOSE", 300, 500);
					} else if (BrickList1.size() == 0 || BrickList2.size() == 0 ||BrickList3.size() == 0 || BrickList4.size() == 0) {
						g2d.setColor(Color.RED);
						g2d.drawRect(0,0,1000,1000);
						g2d.drawString("YOU WIN", 300, 500);
						ball2.setDx(0);
						ball2.setDy(0);
					}

					  break;
				 }
			}
		
			

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		}
		catch(Exception e){}
		
	}
	public void paint (Graphics g)
	{
		Graphics2D twoDgraph = (Graphics2D)g;
		if (back==null) {
			back =(BufferedImage) (createImage(getWidth(), getHeight()));
				}

		Graphics g2d = back.createGraphics();
		
		//this clears the old image, like an EtchASketch. If you see the old image when we learn motion, you deleted this line.
		g2d.clearRect(0, 0, getSize().width, getSize().height); 

		//START CODING GRAPHICS HERE
		

		//screen(g2d);
if(start1){
	drawStartScreen(g2d);
		if(key == 49 & start1){
			screen = 'P';
			start1 = false;
		} else if (key == 50 & start1){
			screen = 'L';
			start1 = false;

		}else if (key == 51 & start1){
			screen = 'N';
			start1 = false;

		}else if (key == 52 & start1){
			System.out.println(key);
			screen = 'H';
			start1 = false;
			System.out.println("HEART SHOULD BE HERE");
		}
		else if (key == 53 & start1){
			screen = 'M';
			start1 = false;
		}
}
else
{
	screen(g2d);
}
			
			
			
		//This line tells the program to draw everything above. If you delete this, nothing will show up		twoDgraph.drawImage(back, 0, 0, null);
	twoDgraph.drawImage(back, 0, 0, null);
	}
/* 
	public boolean collision() {
		for(int i=0; i<BrickList.size(); i++) {
			if(ball.getY()<= (BrickList.get(i).getY()) && ball.getX()<=(BrickList.get(i).getX() + BrickList.get(i).getW()) && ball.getX()+ball.getW()>=BrickList.get(i).getX())  {
				BrickList.remove(i);
				System.out.println("collision");
				ball.setmoveUp();
				len = getLength();
				//ball.setmovert();
				return true;
			}
		}
		return false;
		
}
*/
	//lvl 1
	public boolean collision1() {
		for(int i=0; i<BrickList1.size(); i++) {
			if(ball2.getY()<= (BrickList1.get(i).getY()) && ball2.getX()<=(BrickList1.get(i).getX() + BrickList1.get(i).getW()) && ball2.getX()+ball2.getW()>=BrickList1.get(i).getX())  {
				BrickList1.remove(i);
				//System.out.println("collision2 vc");
				ball2.setmoveUp();
				len2 = getLength();
				//ball.setmovert();
				return true;
			}
		}
		return false;
		
}
	//lvl 2
public boolean collision2() {
	for(int i=0; i<BrickList2.size(); i++) {
		if(ball3.getY()<= (BrickList2.get(i).getY()) && ball3.getX()<=(BrickList2.get(i).getX() + BrickList2.get(i).getW()) && ball3.getX()+ball3.getW()>=BrickList2.get(i).getX())  {
			BrickList2.remove(i);
			//System.out.println("collision2 vc");
			ball3.setmoveUp();
			len3 = getLength();
			//ball.setmovert();
			return true;
		}
	}
	return false;
	
}	
	//lvl 3
	public boolean collision3() {
		for(int i=0; i<BrickList3.size(); i++) {
			if(ball4.getY()<= (BrickList3.get(i).getY()) && ball4.getX()<=(BrickList3.get(i).getX() + BrickList3.get(i).getW()) && ball4.getX()+ball4.getW()>=BrickList3.get(i).getX())  {
				BrickList3.remove(i);
				//System.out.println("collision3 happen");
				ball4.setmoveUp();
				len4 = getLength();
				//ball.setmovert();
				return true;
			}
		}
		return false;
		
}
//lvl 4
public boolean collision4() {
	for(int i=0; i<BrickList4.size(); i++) {
		if(ball5.getY()<= (BrickList4.get(i).getY()) && ball5.getX()<=(BrickList4.get(i).getX() + BrickList4.get(i).getW()) && ball5.getX()+ball5.getW()>=BrickList4.get(i).getX())  {
			BrickList4.remove(i);
			//System.out.println("collision3 happen");
			ball5.setmoveUp();
			len5 = getLength();
			//ball.setmovert();
			return true;
		}
	}
	return false;
	
}
	

	
	public void move() {
		ball.bounce();
		ball2.bounce();
		ball3.bounce();
		ball4.bounce();
		ball5.bounce();



		player2.keymove();
		player.keymove();
		player3.keymove();
		

	}
	
	public int setRandomInt() {
		return (int) (Math.random()*106)+150;
	}
	
	public Color setRandomColor() {
		Color random_Color = new Color (setRandomInt(), setRandomInt(), setRandomInt());
		return random_Color;
	}
	
	public void drawStartScreen(Graphics g2d) {
		//create start screen
		g2d.drawImage(new ImageIcon(HomeBi.getPic()).getImage(), HomeBi.getX(), HomeBi.getY(), HomeBi.getwidth(), HomeBi.getheight(),this);
		
	}
	
	
	
	public void keyTyped(KeyEvent e) {
	
		
	}
	
	public void keyPressed(KeyEvent e) {
		key=e.getKeyCode();
		//System.out.println(key);
		/*
		if (key==39) {
			player.setDx(2);
					}
		if (key==37) {
			player.setDx(-2);
			
		}
		*/
		
		if (key==38) {
			player2.setDy(-2);
			// Arrow Up
		}
		if (key==40) {
			player2.setDy(2);
			// Arrow Down
		}
		
		if (key==87) {
			player.setDy(-2);
			// W
		}
		if (key==83) {
			player.setDy(2);
			// S
		}
		if (key==82) {
		//R
		
		}

		if (key==32) {
			ball.setDx(2);
			ball.setDy(2);
			start = true;
			time1=System.currentTimeMillis();
			ball.setW(50);
			ball.setH(50);
			ball2.setDx(2);
			ball2.setDy(2);

			ball3.setDx(2);
			ball3.setDy(2);

			ball4.setDx(2);
			ball4.setDy(2);

			ball5.setDx(2);
			ball5.setDy(2);

			// Spacebar
		}                 
		
		if(key == 86) {
			ball.setH(100);
			ball.setW(100);
			// V
		}	
		
		if (key == 82) {
			ball.setDx(0);
			ball.setDy(0);
			ball.setX(365);

			ball2.setDx(0);
			ball2.setDy(0);
			ball2.setX(418);
			ball2.setY(375);

			ball3.setDx(0);
			ball3.setDy(0);
			ball3.setX(418);
			ball3.setY(375);

			ball4.setDx(0);
			ball4.setDy(0);
			ball4.setX(418);
			ball4.setY(375);

			ball5.setDx(0);
			ball5.setDy(0);
			ball5.setX(418);
			ball5.setY(375);

			player.resetScore(0);
			player2.resetScore(0);
			ball.setW(50);
			ball.setH(50);
			start1 = true;

			lives = 3;
			lives2 = 3;
			lives3 = 3;
			lives4 = 3;
			lives5 = 3;
		 


		BrickList1=setBricks1();
		BrickList2=setBricks2();
		BrickList3=setBricks3();
		BrickList4=setBricks4();

			player.resetScore(0);
			player2.resetScore(0);

			//R
		}
		if (key==66) {
			screen ='M';
			//B
		}
	
		if (key==37) {
			player3.setDx(-3);
		 // Arrow Left
		}
		if (key==39) {
			player3.setDx(3);
		}
			// Arrow Right
		/*
		}
		if (key==49) {
			screen 	= 'P';
			//1
		}
		if ( key == 50) {
			// 2
			screen = 'L';
		}
		if ( key == 51) {
			// 3
			screen = 'N';
		}
		if ( key == 52) {
			// 4
			screen = 'H';
		}
		*/
	}
	
	public void keyReleased(KeyEvent e){
		key=e.getKeyCode();
		
		if (key==38 || key==40) {
			player2.setDy(0);
			// Arrow Up / Arrow Down
		}
		if (key==83 || key==87) {
			player.setDy(0);
			
			// S or W
		}
		if (key==37 || key==39) {
			player3.setDx(0);
			
			// S or W
		}
	}
	
	public int getLength() {
		return BrickList.size();

	}
		}