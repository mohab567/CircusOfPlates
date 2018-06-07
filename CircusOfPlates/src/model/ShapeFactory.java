package model;

import java.awt.Point;
import java.util.ArrayList;

import view.GUI;

public class ShapeFactory {

    private Shape shape;
    private ArrayList<Class<?>> shapesList = new ArrayList<Class<?>>();
    private int x_Axis;
    private int y_Axis;
    private int randomNum;
    private ShapesLoader loader;

    public ShapeFactory() {
        loader = ShapesLoader.getInstance();
        loader.readClassNames();
        shapesList = loader.Shapes;
        }

    // generate new Shape with randomly chosen colors,
    // x-axis position and shape class
    public Shape ShapePropertiesChooser() {

        randomNum = randomNumber(shapesList.size());
        int randomNum1 = randomNumber(5);
        
        shape = new Shape();
        try {
            shape = (Shape) shapesList.get(randomNum).newInstance();
          //  Log4j.logger.debug("random shape chosen");
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        shape.chooseImageColor(randomNum1);
      //  Log4j.logger.debug("random color chosen");
        
        x_Axis = randomNumber(1200);
        y_Axis = 0;
        shape.setPosition(new Point(x_Axis, y_Axis));
       // Log4j.logger.debug("random place chosen");
       // Log4j.logger.debug("A NEW ShAPE IS READY");
        return shape;
    }

    public int randomNumber(int length) {
        // generate random number from 0 to length-1
        return (int) (Math.floor(Math.random() * (length)));
    }
}
