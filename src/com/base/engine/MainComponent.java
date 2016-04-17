package com.base.engine;

/**
 * Created by Leo on 09.04.2016.
 */
public class MainComponent {
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final String TITEL = "AJavaGameEngine";
    public static final int FRAME_CAP = 200;

    private boolean bIsRunning;
    private Game game;

    public MainComponent() {
        System.out.println(RenderUtil.getOpenGLVersion());
        RenderUtil.initGraphics();
        bIsRunning = false;
        game = new Game();
    }

    public void start() {
        if (bIsRunning) return;
        run();

    }

    public void stop() {
        if (!bIsRunning) return;
        bIsRunning = false;
    }

    private void run() {
        bIsRunning = true;

        int frames = 0;
        long frameCounter = 0;

        final double frameTime = 1.0 / FRAME_CAP;

        long lastTime = Time.getTime();
        double unprocessedTime = 0.0;

        while (bIsRunning) {
            boolean bRender = false;

            long startTime = Time.getTime();
            long passedTime = startTime - lastTime;
            lastTime = startTime;

            unprocessedTime += passedTime / (double) Time.SECOND;
            frameCounter += passedTime;

            while (unprocessedTime > frameTime) {
                bRender = true;

                unprocessedTime -= frameTime;

                if (Window.isCloseRequested()) {
                    stop();
                }

                Time.setDelta(frameTime);


                game.input();
                game.update();
                Input.Update();

                if (frameCounter >= Time.SECOND) {
                    System.out.println(frames);
                    frames = 0;
                    frameCounter = 0;
                }

            }

            if (bRender) {
                render();
                ++frames;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        cleanUp();
    }

    private void render() {

        RenderUtil.clearScreen();
        game.render();
        Window.render();
    }

    private void cleanUp() {
        Window.dispose();
    }

    public static void main(String[] args) {
        System.out.println("starting engine...");
        Window.createWindow(WIDTH, HEIGHT, TITEL + " " + WIDTH + "x" + HEIGHT);

        MainComponent game = new MainComponent();
        game.start();
    }


}
