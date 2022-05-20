package com.firstgame;

import java.awt.*;

public class BasicEnemy extends GameObject{
    private Handler handler;
    public BasicEnemy(int x, int y, ID id, Handler handler) {

        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 52){
            velY *= -1;
        }
        if(x <= 0 || x >= Game.WIDTH - 32){
            velX *= -1;
        }

        handler.addObject(new BasicTrail((int)x, (int)y, ID.Trail, Color.red, 16,16, 0.04f, handler));
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
