package com.base.engine;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.GL_GEOMETRY_SHADER;

/**
 * Created by Leo on 15.04.2016.
 */
public class Shader {
    public Shader() {
        program = glCreateProgram();
        if (program == 0) {
            System.err.println("Shader creation failed: Could not find valid memory location in Constructor");
            System.exit(1);
        }
    }

    private int program;

    public void bind() {
        glUseProgram(program);
    }

    public void addVertexShader(String text) {
        addProgram(text, GL_VERTEX_SHADER);
    }

    public void addGeometryShader(String text) {
        addProgram(text, GL_GEOMETRY_SHADER);
    }

    public void addFragmentShader(String text) {
        addProgram(text, GL_FRAGMENT_SHADER);
    }

    public void compileShader() {
        glLinkProgram(program);
        if (glGetProgrami(program, GL_LINK_STATUS) == 0) {
            System.err.println(glGetProgramInfoLog(program, 1024));
            System.exit(1);
        }
        glValidateProgram(program);
        if (glGetProgrami(program, GL_VALIDATE_STATUS) == 0) {
            System.err.println(glGetProgramInfoLog(program, 1024));
            System.exit(1);
        }
    }

    public void addProgram(String text, int type) {
        int shader = glCreateShader(type);
        if (shader == 0) {
            System.err.println("Shader creation failed: 1. Could not find valid memory location when adding shader");
            System.exit(1);
        }
        glShaderSource(shader, text);
        glCompileShader(shader);
        if (glGetShaderi(shader, GL_COMPILE_STATUS) == 0) {
            System.err.println("Shader creation failed: 2. Could not find valid memory location when adding shader");
            System.exit(1);
        }
        glAttachShader(program,shader );
    }

}
