package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Hat extends Shape {

    public ArrayList<BufferedImage> images;
    public ArrayList<String> names;

   public Hat() throws IOException {
        images = ShapesLoader.getInstance().imgAlbum.get(0);
        names = ShapesLoader.getInstance().imgAlbumNames.get(0);
    }

    @Override
    public void chooseImageColor(int colorNumber) {

        try {

            this.setImg(images.get(colorNumber));
            this.setColor(colorNumber);
            this.setName(names.get(colorNumber));

        } catch (Exception e) {}

    }

}
