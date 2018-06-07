package model;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

import view.GUI;

public class Player implements IPlayer {
    private MatchState state;

    public MatchState getState() {
        return state;
    }

    public void setState(MatchState state) {
        this.state = state;
    }

    private double x;
    private int leftHandY = 0;
    private int rightHandY = 0;

    public void setLeftHandY(int leftHandY) {
        this.leftHandY = leftHandY;
    }

    public void setRightHandY(int rightHandY) {
        this.rightHandY = rightHandY;
    }

    private List<Shape> stack1;
    private List<Shape> stack2;

    @Override
    public Score getScore() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Shape> getStack1() {
        return stack1;
    }

    public void setStack1(List<Shape> s) {
       stack1 = s;
    }

    public void setStack2(List<Shape> s) {
        stack2 = s;
     }
    
    public List<Shape> getStack2() {
        return stack2;
    }

    public void addToStack1(Shape s) {
        stack1.add(s);
    }

    public void addToStack2(Shape s) {
        stack2.add(s);
    }

    public int getRightHandY() {
        return rightHandY;
    }

    public void incRightHandY() {
        this.rightHandY -= 10;
    }

    public int getLeftHandY() {
        return leftHandY;
    }

    public void incLeftHandY() {
        this.leftHandY -= 10;
    }

    public Player() {
        state = new Tie();
        stack1 = new ArrayList<Shape>();
        stack2 = new ArrayList<Shape>();
    }

    public void setxAxis(double x) {
        this.x = x;
    }

    public double getxAxis() {
        return x;
    }

    /*
     * check color of successive shapes and increase score if 3 successive
     * similar are found
     */
    private void calculateScore(List<Shape> stack, int handY) {
        if (stack.size() >= 3) {
            int index1 = stack.size() - 1;
            int index2 = index1 - 1;
            int index3 = index1 - 2;
            if (stack.get(index1).getColor() == stack.get(index2).getColor() &&
                    stack.get(index2).getColor() == stack.get(index3)
                            .getColor()) {
                stack.remove(index1);
                stack.remove(index2);
                stack.remove(index3);
                if (handY == 1) {
                    decLeftHandY();
                } else if (handY == 2) {
                    decRightHandY();
                }
                getScore().incrementScore();
                compareScore();
                // Log4j.logger.debug(
                // "three consecutive similar colors, Score INCREMENTED");
            }

        }
    }

    public void compareScore() {
        if (Player1.getInstance().getScore().getScore() > Player2.getInstance()
                .getScore().getScore()) {
            Player1.getInstance().setState(new Winner());
            Player2.getInstance().setState(new Loser());
        } else if (Player1.getInstance().getScore().getScore() < Player2
                .getInstance().getScore().getScore()) {
            Player2.getInstance().setState(new Winner());
            Player1.getInstance().setState(new Loser());
        } else {
            Player2.getInstance().setState(new Tie());
            Player1.getInstance().setState(new Tie());
        }
    }

    private void decLeftHandY() {
        leftHandY += 30;

    }

    private void decRightHandY() {
        rightHandY += 30;

    }

    boolean withinLeftRange(Shape s) {
        int x = (int) this.getxAxis();
        ValueRange range = ValueRange.of(x + 25 - 50, x + 125 - 50);
        return range.isValidValue(s.getPosition().x) && this.getLeftHandY() - s
                .getPosition().y == 0;

    }

    boolean withinRightRange(Shape s) {
        int x = (int) this.getxAxis();
        ValueRange range = ValueRange.of(x + 175 + 50, x + 275 + 50);
        return range.isValidValue(s.getPosition().x) && this.getRightHandY() - s
                .getPosition().y == 0;
    }

    public void update() {
        for (int i = 0; i < ShapePool.getInstance().getUsedShapes()
                .size(); i++) {
            Shape s = ShapePool.getInstance().getUsedShapes().get(i);
            if (withinLeftRange(s)) {
                // Log4j.logger.debug("added to stack1");
                this.addToStack1(s);
                ShapePool.getInstance().getUsedShapes().remove(i);
                this.incLeftHandY();
            } else if (withinRightRange(s)) {
                // Log4j.logger.debug("added to stack2");
                this.addToStack2(s);
                ShapePool.getInstance().getUsedShapes().remove(i);
                this.incRightHandY();
            } else {
                // Log4j.logger.debug("Not Within Range");
            }
        }

        calculateScore(this.getStack1(), 1);
        calculateScore(this.getStack2(), 2);
        checkHeight();
    }

    // check for height to end the game if required
    public void checkHeight() {
         if(this.getLeftHandY()<=50||this.getRightHandY()<=50){
        	 GUI.getInstance().endGame();
         }
    }

}
