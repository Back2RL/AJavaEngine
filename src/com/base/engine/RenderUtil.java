package com.base.engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;
/**
 * Created by Leo on 15.04.2016.
 */
public class RenderUtil {

    public static  void clearScreen(){
        //TODO: Stencil Buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public static void initGraphics(){
        glClearColor(0,0,0,0);

        glFrontFace(GL_CW);
        glCullFace(GL_BACK);
        glEnable(GL_CULL_FACE);
        glEnable(GL_DEPTH_TEST);

        //TODO: Depth clamp for later

        glEnable(GL_FRAMEBUFFER_SRGB);
    }

    public static  String getOpenGLVersion(){
        return glGetString(GL_VERSION);
    }

}
