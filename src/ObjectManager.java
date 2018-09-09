import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship r;
	int score = 0;
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
                addAlien(new Alien(new Random().nextInt(BEEPInvadersPLAYER.width), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
        }
}
void purgeObjects() {
	for(int i = 0; i<p.size(); i++) {
		if(p.get(i).isAlive == false) {
			p.remove(p.get(i));
		}
	}
	for(int i = 0; i<a.size(); i++) {
		if(a.get(i).isAlive == false) {
			a.remove(a.get(i));
		}
	}
}
void checkCollision() {
	for(Alien b : a){

        if(r.collisionBox.intersects(b.collisionBox)){
                r.isAlive = false;
        }
        for(int i = 0; i<p.size(); i++) {
        	if(p.get(i).collisionBox.intersects(b.collisionBox)){
        		p.get(i).isAlive = false;
        		b.isAlive = false;
        		score++;
        	}
        }
}
}
}
