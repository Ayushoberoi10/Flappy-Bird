import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

class AppPanel extends JPanel {
    int birdX = 100;
    int birdY = 200;
    int birdVelocity = 0;
    int pipeX = 500;
    int pipeGap = 150; // Gap between the pipes
    int pipeWidth = 60; // Width of the pipes
    int pipeSpeed = 3; // Speed at which the pipes move
    int pipeHeightTop = 200; // Height of the top pipe
    boolean gameOver = false; // Flag to indicate game over
    static BufferedImage BackImage;
    static BufferedImage BirdImage;
    static BufferedImage PipeUp;
    static BufferedImage PipeDown;

    Timer timer;

    AppPanel() {
        setSize(500, 500);
        loadImages();
        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameOver) {
                    gameLoop();
                }
                repaint();
            }
        });
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (gameOver) {
                    if (e.getKeyCode() == KeyEvent.VK_R) {
                        restartGame();
                    }
                } else {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        birdVelocity = -10; // Makes the bird "jump" upward
                    }
                }
            }
        });
        setFocusable(true);
    }

    private void loadImages() {
        try {
            BackImage = ImageIO.read(AppPanel.class.getResource("Fbbackground.jpg"));
            BirdImage = ImageIO.read(AppPanel.class.getResource("Birdimage.png"));
            PipeUp = ImageIO.read(AppPanel.class.getResource("pipeup.png"));
            PipeDown = ImageIO.read(AppPanel.class.getResource("pipedw.png"));
        } catch (IOException e) {
            System.out.println("Error loading images: " + e.getMessage());
        }
    }

    private void gameLoop() {
        birdY += birdVelocity;
        birdVelocity += 1; // Gravity effect

        pipeX -= pipeSpeed;
        if (pipeX + pipeWidth <= 0) { // Reset pipe position when it goes off-screen
            pipeX = 500;
            pipeHeightTop = (int) (Math.random() * 200) + 50; // Randomize top pipe height
        }

        if (birdY < 0 || birdY > 500 || checkPipeCollision()) {
            gameOver = true;
        }
    }

    private boolean checkPipeCollision() {
        // Collision with the top pipe
        if (birdX + 40 > pipeX && birdX < pipeX + pipeWidth && birdY < pipeHeightTop) {
            return true;
        }

        // Collision with the bottom pipe
        if (birdX + 40 > pipeX && birdX < pipeX + pipeWidth && birdY + 40 > pipeHeightTop + pipeGap) {
            return true;
        }

        return false;
    }

    private void restartGame() {
        birdX = 100;
        birdY = 200;
        birdVelocity = 0;
        pipeX = 500;
        pipeHeightTop = 200;
        gameOver = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(BackImage, 0, 0, 500, 500, null);
        g.drawImage(BirdImage, birdX, birdY, 50, 50, null);

        // Draw the top pipe normally
        g.drawImage(PipeDown, pipeX, 0, pipeWidth, pipeHeightTop, null);

        // Draw the bottom pipe
        g.drawImage(PipeUp, pipeX, pipeHeightTop + pipeGap, pipeWidth, 500 - (pipeHeightTop + pipeGap), null);

        // If the game is over, show "Game Over" and restart instructions
        if (gameOver) {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("GAME OVER", 120, 200);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press 'R' to Restart", 150, 250);
        }
    }
}
