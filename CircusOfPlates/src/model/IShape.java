package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

public interface IShape {

    /*
     * A method having the colors as numbers in a switch case to be easily
     * randomly chosen during the game procedure. Where the colors are colored
     * images.
     */
    public abstract void chooseImageColor(int colorNumber);

    public int getColor();

    public void setColor(int color);

    public Point getPosition();

    public void setPosition(Point position);

    public BufferedImage getImg();

    public void setImg(BufferedImage img);

}
