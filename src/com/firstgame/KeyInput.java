package com.firstgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private boolean[] keydown = new boolean[4];

    private Handler handler;
    public KeyInput(Handler handler){
        this.handler = handler;
    }


    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){
                if(key == KeyEvent.VK_W) { tempObject.setVelY(-5); keydown[0] = true;}
                if(key == KeyEvent.VK_S) {tempObject.setVelY(5); keydown[1] = true;}
                if(key == KeyEvent.VK_D) {tempObject.setVelX(5); keydown[2] = true;}
                if(key == KeyEvent.VK_A) {tempObject.setVelX(-5);keydown[3] = true;}

            }
        }

        if(key == KeyEvent.VK_ESCAPE) System.exit(1);

    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){
                if(key == KeyEvent.VK_W) keydown[0] = false;
                if(key == KeyEvent.VK_S) keydown[1] = false;
                if(key == KeyEvent.VK_D) keydown[2] = false;
                if(key == KeyEvent.VK_A) keydown[3] = false;

                if(!keydown[0] && !keydown[1]) tempObject.setVelY(0);
                if(!keydown[2] && !keydown[3]) tempObject.setVelX(0);
            }


        }

    }
}
