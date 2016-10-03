package com.base.engine;

/**
 * Created by Leo on 09.04.2016.
 */
public class MainComponent {
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final String TITEL = "AJavaGameEngine";
    public static final int FRAME_CAP = 60;

    double GameTime = 0.0;

    private boolean bIsRunning;
    private Game game;

    public MainComponent() {
        System.out.println(RenderUtil.getOpenGLVersion());
        RenderUtil.initGraphics();
        bIsRunning = false;
        game = new Game();
    }

    //cleanUp();

    public static void main(String[] args) {
        System.out.println("starting engine...");
        Window.createWindow(WIDTH, HEIGHT, TITEL + " " + WIDTH + "x" + HEIGHT);

        MainComponent game = new MainComponent();
        game.start();
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

        GameTime = 0.0;
        double lastTime = Time.getTimeSeconds();
        final double maxDeltaTime = 1.0 / FRAME_CAP;

        int fpsCounter = 0;

        while (bIsRunning) {
            double startTime = Time.getTimeSeconds();
            double DeltaTime = startTime - lastTime;
            lastTime = startTime;

            ++fpsCounter;

            if (Window.isCloseRequested()) {
                stop();
            }

            game.input();
            game.update();
            Input.Update();
            render();

            double renderTime = Time.getTimeSeconds() - startTime;
            if (renderTime < maxDeltaTime) {
                double sleepTimeSeconds = maxDeltaTime - renderTime;
                int sleepTimeNano = (int) ((sleepTimeSeconds * Time.SECOND) % 1000);
                long sleepTimeMilli = (long) (sleepTimeSeconds * 1000);
                try {
                    System.out.println(sleepTimeMilli + "ms; " + sleepTimeNano + "ns");
                    Thread.sleep(sleepTimeMilli, sleepTimeNano);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void render() {

//        RenderUtil.clearScreen();
        game.render();
  //      Window.render();
    }

    private void cleanUp() {

        //Window.dispose();
    }
}
