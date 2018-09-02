import java.awt.Dimension;

import javax.swing.*;

public class LeagueInvaders {
	JFrame f;
	final static int width = 500;
	final static int height = 800;
	GamePanel gp = new GamePanel();
	public static void main(String[] args) {
		LeagueInvaders li = new LeagueInvaders();
		li.setup();
	}
	LeagueInvaders(){
		f = new JFrame();
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
