package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Shape implements IShape {

    private Point position;
    private BufferedImage img;
    private int color;
    private String name;
    
    public Shape() {
        // TODO Auto-generated constructor stub
        position = new Point();

    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;

    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void chooseImageColor(int colorNumber) {
    };

}
