public class GameLoop implements Runnable {
    private boolean isRunning = false;
    private Thread gameThread;

    public synchronized void start() {
        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerTick = 1000000000.0 / 60.0; // 60 ticks per second in nanoseconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long now;

        while (isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            if (delta >= 1) {
                update(); // Process logic, movement, physics
                render(); // Draw the updated graphics
                delta--;
            }
        }
    }

    private void update() {

    }

    private void render() {
        // Drawing code goes here
    }
}