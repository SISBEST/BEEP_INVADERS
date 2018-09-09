import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer fr;
	GameObject go;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font fsub;
	Rocketship r = new Rocketship(250, 700, 50, 50);
	ObjectManager om = new ObjectManager(r);
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if(currentState == MENU_STATE){

            updateMenuState();

		}else if(currentState == GAME_STATE){

            updateGameState();

    }else if(currentState == END_STATE){

            updateEndState();

    }
	}
	GamePanel(){
		fr = new Timer(1000/60, this);
		fr.start();
		titleFont = new Font("Arial", Font.BOLD, 48);
		titleFont = new Font("Arial", Font.PLAIN, 20);
	}
	void StartGame(){
	}
	@Override

	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){

            drawMenuState(g);

    }else if(currentState == GAME_STATE){

            drawGameState(g);

    }else if(currentState == END_STATE){

            drawEndState(g);

    }
	  }
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 10) {
			currentState++;
			if(currentState > END_STATE){
                currentState = MENU_STATE;
        }
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT && currentState == GAME_STATE) {
			r.x-= r.speed;
			r.update();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT && currentState == GAME_STATE) {
			r.x+= r.speed;
			r.update();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE && currentState == GAME_STATE) {
			om.addProjectile(new Projectile(r.x, r.y, 10, 10));
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		om.update();
	}
	void updateEndState() {
	
}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height); 
		g.setFont(titleFont);
		g.setColor(Color.CYAN);
		g.drawString("BEEP INVADERS!", 30, 50);
		g.setFont(fsub);
		g.setColor(Color.GREEN);
		g.drawString("SPACE for instructions, ENTER to play!", 30, 80);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		om.draw(g);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height); 
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 30, 50);
		g.setFont(fsub);
		g.setColor(Color.GREEN);
		g.drawString("Sorry...", 30, 80);
}
}
