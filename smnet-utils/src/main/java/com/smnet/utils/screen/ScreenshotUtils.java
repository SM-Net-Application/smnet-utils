package com.smnet.utils.screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static void take(File file, String format) {

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        try {

            final BufferedImage screenCapture = new Robot().createScreenCapture(new Rectangle(screenSize));

            final String fileAbsolutePath = file.getAbsolutePath();
            final int lastIndexOfPoint = fileAbsolutePath.lastIndexOf('.');

            if (lastIndexOfPoint > -1)
                format = fileAbsolutePath.substring(lastIndexOfPoint + 1);

            ImageIO.write(screenCapture, format, file);

        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
}
