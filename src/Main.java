
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private static final int WIDTH =800;
	private static final int HEIGHT=600;
	
	public Main () {
		super("RETRO PONG");

		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		//Color RoyalBlue = new Color(22,13,193);
		//sets the new color. Think of the computer picking up a pen
		//g2d.setColor(ivory);
		//setBackground(RoyalBlue); 
		getContentPane().add(play);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {  
		Main run = new Main();
		

	}


}
