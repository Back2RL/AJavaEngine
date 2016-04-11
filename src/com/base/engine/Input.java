package com.base.engine;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;

/**
 * Created by Leo on 09.04.2016.
 */
public class Input {

    public static final int NUM_KEYCODES = 256;
    private static ArrayList<Integer> currentKeys = new ArrayList<>();
    private static ArrayList<Integer> downKeys = new ArrayList<>();
    private static ArrayList<Integer> upKeys = new ArrayList<>();

    public static final int NUM_MOUSEBUTTONS = 5;
    private static ArrayList<Integer> currentMouse = new ArrayList<>();
    private static ArrayList<Integer> downMouse = new ArrayList<>();
    private static ArrayList<Integer> upMouse = new ArrayList<>();

    public static void update() {
        upKeys.clear();
        for (int i = 0; i < Input.NUM_KEYCODES; ++i) {
            if (!getKey(i) && currentKeys.contains(i)) {
                upKeys.add(i);
            }
        }

        upMouse.clear();
        for (int i = 0; i < Input.NUM_MOUSEBUTTONS; ++i) {
            if (!getMouse(i) && currentMouse.contains(i)) {
                upMouse.add(i);
            }
        }

        downKeys.clear();
        for (int i = 0; i < Input.NUM_KEYCODES; ++i) {
            if (getKey(i) && !currentKeys.contains(i)) {
                downKeys.add(i);
            }
        }

        downMouse.clear();
        for (int i = 0; i < Input.NUM_MOUSEBUTTONS; ++i) {
            if (getMouse(i) && !currentMouse.contains(i)) {
                downMouse.add(i);
            }
        }

        currentKeys.clear();
        for (int i = 0; i < Input.NUM_KEYCODES; ++i) {
            if (getKey(i)) {
                currentKeys.add(i);
            }
        }

        currentMouse.clear();
        for (int i = 0; i < NUM_MOUSEBUTTONS; ++i) {
            if (getMouse(i)) {
                currentMouse.add(i);
            }
        }
    }

    public static boolean getKey(int keyCode) {
        return Keyboard.isKeyDown(keyCode);
    }

    public static boolean getKeyDown(int keycode) {
        return downKeys.contains(keycode);
    }

    public static boolean getKeyUp(int keycode) {
        return upKeys.contains(keycode);
    }

    public static boolean getMouse(int mouseButton) {
        return Mouse.isButtonDown(mouseButton);
    }

    public static boolean getMouseDown(int mouseButton) {
        return downMouse.contains(mouseButton);
    }

    public static boolean getMouseUp(int mouseButton) {
        return upMouse.contains(mouseButton);
    }

    public static Vector2f getMousePosition(){
        return new Vector2f(Mouse.getX(), Mouse.getY());
    }

}
