package com.omicron.animancy.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class RenderUtils {


    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            // write the image to a byte array
            javax.imageio.ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            // encode the byte array using Base64
            Base64.Encoder encoder = Base64.getEncoder();
            imageString = encoder.encodeToString(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageString;
    }
}
