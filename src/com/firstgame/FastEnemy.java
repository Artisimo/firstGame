package com.firstgame;

import java.awt.*;

public class FastEnemy extends GameObject{
    private Handler handler;
    public FastEnemy(int x, int y, ID id, Handler handler) {

        super(x, y, id);
        this.handler = handler;
        velX = 10;
        velY = 10;
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

        handler.addObject(new BasicTrail(x, y, ID.Trail, Color.orange, 16,16, 0.08f, handler));
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(x, y, 10, 10);
    }
}
