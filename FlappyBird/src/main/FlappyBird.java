package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class FlappyBird extends Canvas implements Runnable, KeyListener {
    public static final int WIDTH = 640, HEIGHT = 480;
    private boolean running = false;
    private Thread thread;

    public static double score = 0;

    /* Game world room */
    public static Room room;
    /* Bird in the game world */
    public Bird bird;

    /* define a local variables ,
    giving specific size of the game window (1)
    adding a property which is waiting for pressing the right button to control the bird(2)
    initializing our game world and bird with values that we have choosed (3)
    */
    public FlappyBird() {
        /* 1 */
        Dimension d = new Dimension(FlappyBird.WIDTH, FlappyBird.HEIGHT);
        setPreferredSize(d);
        /* 2 */
        addKeyListener(this);
        /* 3 */
        this.room = new Room(30);
        this.bird = new Bird(20, FlappyBird.HEIGHT / 2, this.room.tubes);
    }

    /* synchronized keyword is all about different threads reading and writing to the same variables, objects and resources */
    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        /* creating a new thread using the current instance of the class */
        thread = new Thread(this);
        /* looking for the run method and executing it */
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame("Flappy Bird");
        FlappyBird flappyBird = new FlappyBird();
        jframe.add(flappyBird);

        /* user can't touch the size */
        jframe.setResizable(false);
        jframe.pack();

        /*
        when the window is closed the program stop working
        without this constraint the program continue it's execution even after closing the window
        */
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /* the program window will be open in the center of the screen */
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);

        flappyBird.start();
    }

    /* method for running and stoping the game process */
    @Override
    public void run() {
        int fps = 0;
        double timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double delta = 0;
        double ns = 100_000_000 / 60;
        /* loop for running the game */
        while (running) {
            long now = System.nanoTime();
            delta += (now / lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                update();
                render();
                fps++;
                delta--;
            }

            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + fps);
                fps = 0;
                timer += 1000;
            }
        }

        stop();
    }

    /* Provides the graphic of the program */
    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
        this.room.render(g);
        this.bird.render(g);
        g.setColor(Color.white);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 19));
        g.drawString("Score: " + (int) score, 10, 20);
        g.setColor(Color.black);
        g.drawString("High score: " + HighScore.getHighScore(), 150, 20);
        /* Releases system resources currently consumed by this BufferStrategy object */
        g.dispose();

        bs.show();
    }

    private void update() {
        this.room.update();
        this.bird.update();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.isPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.isPressed = false;
        }
    }
}
