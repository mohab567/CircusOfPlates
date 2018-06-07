package model;

public class Player1 extends Player {

    private static Player1 instance = null;
    private Score score;

    private Player1() {
    	this.setLeftHandY(400);
    	this.setRightHandY(355);
        this.setxAxis(300);
        score = new Score();
    }

    public static Player1 getInstance() {
        if (instance == null) {
            instance = new Player1();
        }
        return instance;
    }

    @Override
    public Score getScore() {
        // TODO Auto-generated method stub
        return score;
    }

}
