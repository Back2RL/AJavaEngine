package com.base.engine;


import org.lwjgl.input.Keyboard;


/**
 * Created by Leo on 09.04.2016.
 */
public class Game {
    private Mesh mesh;
    private Shader shader;

    public Game() {
        mesh = new Mesh();
        shader = new Shader();
        Vertex[] data = new Vertex[]{
                new Vertex(new Vector3f(-1, -1, 0)),
                new Vertex(new Vector3f(0, 1, 0)),
                new Vertex(new Vector3f(1, -1, 0))
        };

        mesh.addVertices(data);
        shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
        shader.addFragmentShader(ResourceLoader.loadShader("fragmentShader.fs"));
    }

    public void input() {
        if (Input.GetKeyDown(Keyboard.KEY_UP)) {
            System.out.println("Up was pressed");
        }
        if (Input.GetKeyUp(Keyboard.KEY_UP)) {
            System.out.println("Up was released");
        }

        if (Input.GetKeyDown(0)) {
            System.out.println("left pressed");
        }
        if (Input.GetMouseDown(1)) {
            System.out.println("right clicked at " + Input.GetMousePosition());
        }

    }

    public void update() {

    }

    public void render() {
        shader.bind();
        mesh.draw();
    }
}
