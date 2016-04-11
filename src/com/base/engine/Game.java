package com.base.engine;


import org.lwjgl.input.Keyboard;


/**
 * Created by Leo on 09.04.2016.
 */
public class Game {

    public Game() {

    }

    public void input() {
        if (Input.getKeyDown(Keyboard.KEY_UP)) {
            System.out.println("Up was pressed");
        }
        if (Input.getKeyUp(Keyboard.KEY_UP)) {
            System.out.println("Up was released");
        }

        if (Input.getKeyDown(0)) {
            System.out.println("left pressed");
        }
        if (Input.getMouseDown(1)) {
            System.out.println("right clicked at " + Input.getMousePosition());
        }

    }

    public void update() {

    }

    public void render() {

    }
}
