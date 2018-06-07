package model;

import java.util.List;

public class Originator {
    private long deltatime;
    // where the first number is the player and the second is the stack number
    private List<String> stack11;
    private List<String> stack12;
    private List<String> stack21;
    private List<String> stack22;
    private List<Integer> positionStack11;
    private List<Integer> positionStack12;
    private List<Integer> positionStack21;
    private List<Integer> positionStack22;
    private Score score;

    public void setDeltatime(long deltatime) {
        this.deltatime = deltatime;
    }

    public void setStack11(List<String> stack11) {
        this.stack11 = stack11;
    }

    public void setStack21(List<String> stack21) {
        this.stack21 = stack21;
    }

    public void setStack22(List<String> stack22) {
        this.stack22 = stack22;
    }

    public void setStack12(List<String> stack12) {
        this.stack12 = stack12;
    }
    
    public void setPositionStack11(List<Integer> positionStack11) {
        this.positionStack11 = positionStack11;
    }

    public void setPositionStack12(List<Integer> positionStack12) {
        this.positionStack12 = positionStack12;
    }

    public void setPositionStack21(List<Integer> positionStack21) {
        this.positionStack21 = positionStack21;
    }

    public void setPositionStack22(List<Integer> positionStack22) {
        this.positionStack22 = positionStack22;
    }

    public void setScore(Score score) {
        this.score = score;
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
    public List<Integer> getSavedPositionStack11() {
        return positionStack11;
    }

    public List<Integer> getSavedPositionStack12() {
        return positionStack12;
    }

    public List<Integer> getSavedPositionStack21() {
        return positionStack21;
    }

    public List<Integer> getSavedPositionStack22() {
        return positionStack22;
    }

    public Score getSavedScore() {
        return score;
    }

    public Memento_ saveStateToMemento(long deltatime,List<String> stack11,
            List<String> stack12, List<String> stack21,
            List<String> stack22,List<Integer> positionStack11,
            List<Integer> positionStack12, List<Integer> positionStack21,
            List<Integer> positionStack22, Score score1, Score score2) {
        return new Memento_(deltatime,stack11,stack12,stack21,stack22,positionStack11,
                positionStack12,positionStack21,positionStack22,score1,score2);
    }

    public void getDataFromMemento(Memento_ memento) {
    	deltatime = memento.getdeltatime();
        stack11 = memento.getSavedStack11();
        stack12 = memento.getSavedStack12();
        stack21 = memento.getSavedStack21();
        stack22 = memento.getSavedStack22();
        positionStack11 = memento.getPositionStack11();
        positionStack12 = memento.getPositionStack12();
        positionStack21 = memento.getPositionStack21();
        positionStack22 = memento.getPositionStack22();
        score = memento.getSavedScore1();
        score = memento.getSavedScore2();
    }

}
