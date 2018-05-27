package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Room {
    /* Array of all obstacles in the game world */
    public ArrayList<Rectangle> tubes;

    private int spd = 15;
    private final int SPACE_BETWEEN_TUBES = 96;

    private final int WIDTH_TUBES = 32;

    private Random random;
    /* Interval of time to respond tubes */
    private int time;
    private int currentTime = 0;

    public Room(int time) {
        this.tubes = new ArrayList<>();
        this.time = time;
        this.random = new Random();
    }

    public void update() {
        this.currentTime++;

        if (currentTime == time) {
            /* Create a new tube , with random height, and constant other properties*/
            this.currentTime = 0;

            int y1 = 0;
            int height1 = random.nextInt(FlappyBird.HEIGHT / 2);

            int y2 = height1 + SPACE_BETWEEN_TUBES;
            int height2 = FlappyBird.HEIGHT - y2;

            tubes.add(new Rectangle(FlappyBird.WIDTH, y1, WIDTH_TUBES, height1));
            tubes.add(new Rectangle(FlappyBird.WIDTH, y2, WIDTH_TUBES, height2));
        }

        for (int i = 0; i < this.tubes.size(); i++) {
            Rectangle rec = tubes.get(i);
            rec.x -= this.spd;


            if (rec.x + rec.y <= 0) {
                tubes.remove(i--);
                FlappyBird.score += 0.5;
                continue;
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);

        for (int i = 0; i < this.tubes.size(); i++) {
            Rectangle rec = tubes.get(i);
            g.fillRect(rec.x, rec.y, rec.width, rec.height);
        }
    }
}
