package model;

public class Player2 extends Player {

    private static Player2 instance = null;
    private Score score;

    private Player2() {
    	this.setRightHandY(400);
    	this.setLeftHandY(355);
        this.setxAxis(600);
        score = new Score();
    }

    public static Player2 getInstance() {
        if (instance == null) {
            instance = new Player2();
        }
        return instance;
    }

    @Override
    public Score getScore() {
        // TODO Auto-generated method stub
        return score;
    }

}
