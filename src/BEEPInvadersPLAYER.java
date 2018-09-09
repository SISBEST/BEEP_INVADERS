import java.awt.Dimension;

import javax.swing.*;

public class BEEPInvadersPLAYER {
	JFrame f;
	final static int width = 500;
	final static int height = 800;
	GamePanel gp = new GamePanel();
	public static void main(String[] args) {
		BEEPInvadersPLAYER li = new BEEPInvadersPLAYER();
		li.setup();
	}
	BEEPInvadersPLAYER(){
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
