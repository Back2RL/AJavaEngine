package com.base.engine;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Leo on 15.04.2016.
 */
public class ResourceLoader {
    public static String loadShader(String filename) {
        StringBuilder shaderSource = new StringBuilder();

        try (BufferedReader shaderReader = new BufferedReader(new FileReader("./res/shaders/" + filename))) {
            String line;
            while ((line = shaderReader.readLine()) != null) {
                shaderSource.append(line).append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return shaderSource.toString();
    }
}
