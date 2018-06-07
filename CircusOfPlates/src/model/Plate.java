package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Plate extends Shape {

    public ArrayList<BufferedImage> images;
    public ArrayList<String> names;

    public Plate() throws IOException {
        images = ShapesLoader.getInstance().imgAlbum.get(1);
        names = ShapesLoader.getInstance().imgAlbumNames.get(1);
    }

    @Override
    public void chooseImageColor(int colorNumber) {
        // its supposed to be void .
        try {

            this.setImg(images.get(colorNumber));
            this.setColor(colorNumber);
            this.setName(names.get(colorNumber));

        } catch (Exception e) {}

    }

}
