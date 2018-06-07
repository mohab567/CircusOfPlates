package model;

import java.io.Serializable;
import java.util.List;

public class Memento_ implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// where the first number is the player and the second is the stack number
    private List<String> stack11;
    private List<String> stack12;
    private List<String> stack21;
    private List<String> stack22;
    private List<Integer> positionStack11;
    private List<Integer> positionStack12;
    private List<Integer> positionStack21;
    private List<Integer> positionStack22;
    private long deltatime;

    private Score score1;
    private Score score2;

    public Memento_(long deltatime,List<String> stack11,
            List<String> stack12, List<String> stack21,
            List<String> stack22,List<Integer> positionStack11,
            List<Integer> positionStack12, List<Integer> positionStack21,
            List<Integer> positionStack22, Score score1, Score score2) {
        this.deltatime = deltatime;
        this.stack11 = stack11;
        this.stack12 = stack12;
        this.stack21 = stack21;
        this.stack22 = stack22;
        this.score1 = score1;
        this.score2 = score2;
        this.positionStack11 = positionStack11;
        this.positionStack12 = positionStack12;
        this.positionStack21 = positionStack21;
        this.positionStack22 = positionStack22;
    }

    public long getdeltatime() {
        return deltatime;
    }

    public List<String> getSavedStack11() {
        return stack11;
    }

    public List<String> getSavedStack12() {
        return stack12;
    }

    public List<String> getSavedStack21() {
        return stack21;
    }

    public List<String> getSavedStack22() {
        return stack22;
    }
    
    public List<Integer> getPositionStack11() {
        return positionStack11;
    }

    public List<Integer> getPositionStack12() {
        return positionStack12;
    }

    public List<Integer> getPositionStack21() {
        return positionStack21;
    }

    public List<Integer> getPositionStack22() {
        return positionStack22;
    }

    public Score getSavedScore1() {
        return score1;
    }

    public Score getSavedScore2() {
        return score2;
    }

}
