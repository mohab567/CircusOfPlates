package model;

import java.io.Serializable;

import view.GUI;

public class Score implements Serializable  {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int matchScore;
    
    Score() {
        matchScore = 0;
       // this.addObserver(GUI.getInstance());
    }


    public void incrementScore() {
        matchScore++;
       GUI.getInstance().updateScore();
    }
    public int getScore() {
        return matchScore;
    }
   
    public void setScore(int score) {
        matchScore = score;
    }

}
