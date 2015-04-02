package MAndApps.apps.spacewars.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import MAndApps.apps.spacewars.SpaceWars;
import MAndApps.apps.spacewars.entity.enemy.NormalEnemy;
import MAndApps.apps.spacewars.gun.Gun;
import MAndApps.apps.spacewars.tools.Direction;
import MAndApps.apps.spacewars.tools.Entity;
import MAndEngine.Engine;

public class Player extends Entity {
	private final static int WIDTH = 16, HEIGHT = 16;
	private double x = 512, y = 550;
	private static final double ACC = 0.5, MAXSPEED = 5;
	private double dx = 0, dy = 0;
	private boolean A = false, S = false, D = false, W = false, alive = true;
	private Random r = new Random();
	private Gun gun = new Gun(Bullet.BASIC, 25, (int)x, (int)y);
	private boolean goBoom = false;

	public Player() {
		super((int) 512, (int) 550, WIDTH, HEIGHT);
	}

	@Override
	public int tick() {
		double ACC = Player.ACC * Engine.deltaTime / 10;
		double dx = this.dx * Engine.deltaTime / 10;
		double dy = this.dy * Engine.deltaTime / 10;
		
		if (goBoom) {
			SpaceWars.BOOM(50, 1.2, 50, 50, 50, 30, (int) x, (int) y, 550, true,
					false, 3);
			goBoom = false;
		}
		gun.tick();
		if (alive) {

			if (time != 1)
				time -= 0.05d;
			if (time < 1)
				time = 1;

			if (D && !A)
				dx += ACC;
			else if (A && !D) {
				dx -= ACC;
			} else {
				if ((int) (dx * 100) > 0)
					dx -= ACC;
				else if ((int) (dx * 100) < 0)
					dx += ACC;
				else
					dx = 0;
			}

			if (S && !W)
				dy += ACC;
			else if (W && !S) {
				dy -= ACC;
			} else {
				if ((int) (dy * 100) > 0)
					dy -= ACC;
				else if ((int) (dy * 100) < 0)
					dy += ACC;
				else
					dy = 0;
			}

			if (dx > MAXSPEED)
				while (dx > MAXSPEED)
					dx -= ACC;
			if (dx < 0 - MAXSPEED)
				while (dx < 0 - MAXSPEED)
					dx += ACC;
			if (dy > MAXSPEED)
				while (dy > MAXSPEED)
					dy -= ACC;
			if (dy < 0 - MAXSPEED)
				while (dy < 0 - MAXSPEED)
					dy += ACC;

			y += dy;
			x += dx;

			if (x > SpaceWars.getWIDTH() - WIDTH)
				while (x > SpaceWars.getWIDTH() - WIDTH)
					x--;
			if (x < 0)
				while (x < 0)
					x++;

			if (y > SpaceWars.getHEIGHT() - HEIGHT)
				while (y > SpaceWars.getHEIGHT() - HEIGHT)
					y--;
			if (y < 0)
				while (y < 0)
					y++;

		} else {
			x = -1;
			y = -1;
			if (timer > 4 * 50) {
				alive = true;
				x = 512;
				y = 550;
			}
			timer++;
		}
		updateBoundingBox((int) x, (int) y, WIDTH, HEIGHT);

		return 0;
	}

	private int timer = 0;

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		if (alive) {
			int temp;
			try {
				temp = r.nextInt((int) time);
			} catch (Exception e) {
				temp = 1;
			}
			if (temp == 0)
				g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
		}
		gun.render(g);
	}

	private double time = 0;

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			W = true;
			break;
		case KeyEvent.VK_D:
			D = true;
			break;
		case KeyEvent.VK_S:
			S = true;
			break;
		case KeyEvent.VK_A:
			A = true;
			break;
		case KeyEvent.VK_I:
			shoot(Direction.UP);
			break;
		case KeyEvent.VK_J:
			shoot(Direction.LEFT);
			break;
		case KeyEvent.VK_K:
			shoot(Direction.DOWN);
			break;
		case KeyEvent.VK_L:
			shoot(Direction.RIGHT);
			break;
		}
	}

	private void shoot(int direction) {
        gun.updatePosition((int)x + WIDTH/2, (int)y + HEIGHT/2);
		gun.shoot(direction);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			W = false;
			break;
		case KeyEvent.VK_D:
			D = false;
			break;
		case KeyEvent.VK_S:
			S = false;
			break;
		case KeyEvent.VK_A:
			A = false;
			break;
		}

	}

	public boolean getAlive() {
		return alive;
	}

}
