package com.firstgame;

import java.awt.*;

public class SmartEnemy extends GameObject{
    private Handler handler;

    private GameObject player;
    public SmartEnemy(int x, int y, ID id, Handler handler) {

        super(x, y, id);
        this.handler = handler;

        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player){
                player = handler.object.get(i);
            }
        }
        velX = 1;
        velY = 1;
    }

    @Override
    public void tick() {


        int px = player.getX();
        int py = player.getY();

        if(x - px < 0) {
            x += velX;
        }
        else {
            x -= velX;
        }

        if(y -py < 0) {
            y+=velY;
        }
        else {
            y-=velY;
        }

        if(y <= 0 || y >= Game.HEIGHT - 52){
            velY *= -1;
        }
        if(x <= 0 || x >= Game.WIDTH - 32){
            velX *= -1;
        }

        handler.addObject(new BasicTrail((int)x, (int)y, ID.Trail, Color.magenta, 16,16, 0.08f, handler));
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int)x,(int) y, 10, 10);
    }
}
