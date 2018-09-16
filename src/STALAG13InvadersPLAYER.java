import java.awt.Dimension;

import javax.swing.*;

public class STALAG13InvadersPLAYER {
	JFrame f;
	final static int width = 500;
	final static int height = 800;
	GamePanel gp = new GamePanel();
	public static void main(String[] args) {
		STALAG13InvadersPLAYER li = new STALAG13InvadersPLAYER();
		li.setup();
	}
	STALAG13InvadersPLAYER(){
		f = new JFrame("	STALAG 13 INVADERS!");
	}
	void setup() {
		f.add(gp);
		f.addKeyListener(gp);
		f.setVisible(true);
		f.setSize(width, height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gp.StartGame();
	}
}
