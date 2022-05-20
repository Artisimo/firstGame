package com.firstgame;

import java.awt.*;

import static com.firstgame.Game.clamp;

public class HUD {
    public static int HEALTH = 100;

    private int green = 255;

    private int score = 0;
    private int level = 1;

    public void tick(){

        HEALTH = (int) clamp(HEALTH, 0, 100);
        green = 255 * HEALTH/ 100;
        score++;
    }
    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(160, green, 0));
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
