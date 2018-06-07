package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ShapePool {

    private int maximumPoolSize;
    private List<Shape> manufacturedShapes;
    private List<Shape> usedShapes = new ArrayList<Shape>();
    private ShapeFactory factory;
    private Shape image;
    private static ShapePool instance;

    public List<Shape> getUsedShapes() {
        return usedShapes;
    }

    private ShapePool() {
        maximumPoolSize = 20;
        manufacturedShapes = new ArrayList<>();
        factory = new ShapeFactory();
    }

    public static ShapePool getInstance() {
        if (instance == null) {
            instance = new ShapePool();
        }
        return instance;

    }

    public void fillArray() {
        for (int i = 0; i < maximumPoolSize; i++) {
            image = factory.ShapePropertiesChooser();
            manufacturedShapes.add(image);
        }
    }

    public Shape getShape() {
        Shape img = manufacturedShapes.get(0);
        return img;
    }
    
    public Iterator getIterator() {
        return new ShapeIterator();
     }
    

    public void acquireShape() {
        if (manufacturedShapes.isEmpty()) {
            image = factory.ShapePropertiesChooser();
            usedShapes.add(image);
        } else {
            usedShapes.add(manufacturedShapes.get(0));
            manufacturedShapes.remove(0);
        }
    }

    public void releaseShape() {

        if (!usedShapes.isEmpty() && usedShapes.get(0).getPosition().y >= 800) {
            int x_Axis = factory.randomNumber(1200);
            int rdn = factory.randomNumber(4);
            Point p = new Point(x_Axis, 0);
            usedShapes.get(0).setPosition(p);
            usedShapes.get(0).chooseImageColor(rdn);
            manufacturedShapes.add(usedShapes.get(0));
            usedShapes.remove(0);
        }
    }
    public void emptyArray() {
    	usedShapes = new ArrayList<Shape>();
    	manufacturedShapes = new ArrayList<>();
    }
    public void updateY() {
        Iterator i = getIterator();
        while(i.hasNext()) {
            Shape s = (Shape) i.next();
            Point p = s.getPosition();
            p.y++;
            s.setPosition(p);    
        }
         
//        for (int i = 0; i < usedShapes.size(); i++) {
//            Point p = usedShapes.get(i).getPosition();
//            p.y++;
//            usedShapes.get(i).setPosition(p);     
//        }
        Player1.getInstance().update();
        Player2.getInstance().update();
        releaseShape();
    }

    
    
    
    private class ShapeIterator implements Iterator {

        int index;
        
        @Override
        public boolean hasNext() {
        
           if(index < usedShapes.size()){
              return true;
           }
           return false;
        }

        @Override
        public Shape next() {
        
           if(this.hasNext()){
              return usedShapes.get(index++);
           }
           return null;
        }     
    }

}
