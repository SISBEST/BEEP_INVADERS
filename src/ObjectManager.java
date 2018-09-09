import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship r;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	ArrayList <Projectile> p = new ArrayList <Projectile>();
	ArrayList <Alien> a = new ArrayList <Alien>();
	ObjectManager(Rocketship r){
		this.r = r;
	}
	void update(){
		r.update();
		for(int i = 0; i<p.size(); i++) {
			p.get(i).update();
		}
		for(int i = 0; i<a.size(); i++) {
			a.get(i).update();
		}
	}
	
	void draw(Graphics g){
		r.draw(g);
		for(int i = 0; i<p.size(); i++) {
			p.get(i).draw(g);
		}
		for(int i = 0; i<a.size(); i++) {
			a.get(i).draw(g);
		}
	}
	void addProjectile(Projectile pta) {
		p.add(pta);
	}
	void addAlien(Alien ata) {
		a.add(ata);
	}

public void manageEnemies(){
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
                addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
        }
}
}
