package com.elrain.whattocook.util;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by Denys Husher on 08.06.15.
 */
public class ImageUtil {

    private static final String JPG = "jpg";

    /**
     * Encode image to string
     * @return encoded string
     */
    public static String encodeToString(String imagePath) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            ImageIO.write(image, JPG, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
}
