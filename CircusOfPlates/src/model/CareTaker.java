package model;

import java.util.ArrayList;
import java.util.List;


public class CareTaker {

    private Originator origion;
    private Memento_ mem;
    private List<String> imagesStack11;
    private List<String> imagesStack12;
    private List<String> imagesStack21;
    private List<String> imagesStack22;
    private List<Integer> positionStack11;
    private List<Integer> positionStack12;
    private List<Integer> positionStack21;
    private List<Integer> positionStack22;

    public CareTaker() {
        origion = new Originator();
        imagesStack11 = new ArrayList<>();
        imagesStack12 = new ArrayList<>();
        imagesStack21 = new ArrayList<>();
        imagesStack22 = new ArrayList<>();
        positionStack11 = new ArrayList<>();
        positionStack12 = new ArrayList<>();
        positionStack21 = new ArrayList<>();
        positionStack22 = new ArrayList<>();
    }

    public Memento_ setData() {
        fillArrays();
       mem = origion.saveStateToMemento(LevelStrategy.getDeltaTime(), imagesStack11,
                imagesStack12, imagesStack21, imagesStack22,positionStack11,positionStack12,
                positionStack21, positionStack22,Player1.getInstance().getScore(),
                Player2.getInstance().getScore());
        return mem;
    }

    public void fillArrays() {
        for (int i = 0; i < Player1.getInstance().getStack1().size(); i++) {
            String s = Player1.getInstance().getStack1().get(i).getName();
            imagesStack11.add(s);
            positionStack11.add(Player1.getInstance().getStack1().get(i).getPosition().y);
        }
        for (int i = 0; i < Player1.getInstance().getStack2().size(); i++) {
            String s = Player1.getInstance().getStack2().get(i).getName();
            imagesStack12.add(s);
            positionStack12.add(Player1.getInstance().getStack2().get(i).getPosition().y);
        }
        for (int i = 0; i < Player2.getInstance().getStack1().size(); i++) {
            String s = Player2.getInstance().getStack1().get(i).getName();
            imagesStack21.add(s);
            positionStack21.add(Player2.getInstance().getStack1().get(i).getPosition().y);
        }
        for (int i = 0; i < Player2.getInstance().getStack2().size(); i++) {
            String s = Player2.getInstance().getStack2().get(i).getName();
            imagesStack22.add(s);
            positionStack22.add(Player2.getInstance().getStack2().get(i).getPosition().y);
        }
    }

}
