package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Bird extends Rectangle {
    private int spd = 15;
    public boolean isPressed = false;
    private BufferedImage sheet;
    private BufferedImage[] birdMovement;
    private ArrayList<Rectangle> tubes;
    private int imageIndex = 0;
    private boolean isFalling = false;
    private int frames = 0;

    public Bird(int x, int y, ArrayList<Rectangle> tubes) {
        setBounds(x, y, 32, 32);
        this.tubes = tubes;
        birdMovement = new BufferedImage[3];

        try {
            sheet = ImageIO.read(getClass().getResource("/birds.png"));

            birdMovement[0] = sheet.getSubimage(0, 0, 16, 16);
            birdMovement[1] = sheet.getSubimage(16, 0, 16, 16);
            birdMovement[2] = sheet.getSubimage(32, 0, 16, 16);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        isFalling = false;
        if (isPressed) {
            y -= spd;
            imageIndex = 2;
            frames = 0;
        } else {
            isFalling = true;
            y += spd;
            imageIndex = 1;
            frames++;
            if (frames > 15) frames = 15;
        }

        if (isFalling) {
            if (frames == 15) {
                imageIndex = 1;
            } else {
                imageIndex = 0;
            }
        }

        for (int i = 0; i < this.tubes.size(); i++) {
            if (this.intersects(this.tubes.get(i))) {
                FlappyBird.room = new Room(30);
                tubes = FlappyBird.room.tubes;
                y = FlappyBird.HEIGHT / 2;
                HighScore.addResult((int) FlappyBird.score);
                FlappyBird.score = 0;
            }
        }

        if (y >= FlappyBird.HEIGHT) {
            FlappyBird.room = new Room(30);
            tubes = FlappyBird.room.tubes;
            y = FlappyBird.HEIGHT / 2;
            HighScore.addResult((int) FlappyBird.score);
            FlappyBird.score = 0;
        }
    }

    public void render(Graphics g) {
        g.drawImage(birdMovement[imageIndex], x, y, width, height, null);
    }
}
