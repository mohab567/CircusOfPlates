package model;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json implements IFileBehaviour {

    private CareTaker CT;
    private Memento_ mem;

    public Json() {
        CT = new CareTaker();
        mem = CT.setData();
    }

    @Override
    public void saveGame(File file) throws IOException {
        try {
            FileWriter writer = new FileWriter(file);
            Gson gson = new GsonBuilder().disableHtmlEscaping()
                    .setPrettyPrinting().create();
            gson.toJson(mem, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public void loadGame(File file) throws IOException, ClassNotFoundException {
        
        try {
            Player1.getInstance().setStack1(new ArrayList<>());
            Player1.getInstance().setStack2(new ArrayList<>());
            Player2.getInstance().setStack1(new ArrayList<>());
            Player2.getInstance().setStack2(new ArrayList<>());
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();

            mem = gson.fromJson(br, Memento_.class);
            Player1.getInstance().getScore().setScore(mem.getSavedScore1()
                    .getScore());
            Player2.getInstance().getScore().setScore(mem.getSavedScore2()
                    .getScore());
            LevelStrategy.startTimeByDelta(mem.getdeltatime());
            rightHandP1();
            rightHandP2();
            leftHandP1();
            leftHandP2();

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void leftHandP1() {
        try {
            for (int i = 0; i < mem.getSavedStack11().size(); i++) {
                Shape s;
                if (mem.getSavedStack11().get(i).contains("Plate")) {
                    s = new Plate();

                } else {
                    s = new Hat();

                }
                if (mem.getSavedStack11().get(i).equals("brownHat.png") || mem
                        .getSavedStack11().get(i).equals("brownPlate.png")) {
                    s.chooseImageColor(0);
                } else if (mem.getSavedStack11().get(i).equals("cyanHat.png")
                        || mem
                                .getSavedStack11().get(i).equals(
                                        "cyanPlate.png")) {
                    s.chooseImageColor(1);
                } else if (mem.getSavedStack11().get(i).equals("greenHat.png")
                        || mem
                                .getSavedStack11().get(i).equals(
                                        "greenPlate.png")) {
                    s.chooseImageColor(2);
                } else if (mem.getSavedStack11().get(i).equals("redHat.png")
                        || mem
                                .getSavedStack11().get(i).equals(
                                        "redPlate.png")) {
                    s.chooseImageColor(3);
                } else if (mem.getSavedStack11().get(i).equals("yellowHat.png")
                        || mem.getSavedStack11().get(i).equals(
                                "yellowPlate.png")) {
                    s.chooseImageColor(4);
                }
                s.setPosition(new Point(360, mem.getPositionStack11().get(i)));

                Player1.getInstance().addToStack1(s);
                int index = mem.getSavedStack11().size() - 1;
                Player1.getInstance().setLeftHandY(mem.getPositionStack11()
                        .get(index)- 10);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    } 
    
    public void rightHandP1() {
        try {
            for (int i = 0; i < mem.getSavedStack12().size(); i++) {
                Shape s;
                if (mem.getSavedStack12().get(i).contains("Plate")) {
                    s = new Plate();
                  
                } else {
                    s = new Hat();
               
                }
                if (mem.getSavedStack12().get(i).equals("brownHat.png") || mem
                        .getSavedStack12().get(i).equals("brownPlate.png")) {
                    s.chooseImageColor(0);
                } else if (mem.getSavedStack12().get(i).equals("cyanHat.png")
                        || mem
                                .getSavedStack12().get(i).equals(
                                        "cyanPlate.png")) {
                    s.chooseImageColor(1);
                } else if (mem.getSavedStack12().get(i).equals("greenHat.png")
                        || mem
                                .getSavedStack12().get(i).equals(
                                        "greenPlate.png")) {
                    s.chooseImageColor(2);
                } else if (mem.getSavedStack12().get(i).equals("redHat.png")
                        || mem
                                .getSavedStack12().get(i).equals(
                                        "redPlate.png")) {
                    s.chooseImageColor(3);
                } else if (mem.getSavedStack12().get(i).equals("yellowHat.png")
                        || mem.getSavedStack12().get(i).equals(
                                "yellowPlate.png")) {
                    s.chooseImageColor(4);
                }
                s.setPosition(new Point(360, mem.getPositionStack12().get(i)));

                Player1.getInstance().addToStack2(s);
                int index = mem.getSavedStack12().size() - 1;
                Player1.getInstance().setRightHandY(mem.getPositionStack12()
                        .get(index)-10);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void leftHandP2() {
        try {
            for (int i = 0; i < mem.getSavedStack21().size(); i++) {
                Shape s;
                if (mem.getSavedStack21().get(i).contains("Plate")) {
                    s = new Plate();

                } else {
                    s = new Hat();
                   
                }
                if (mem.getSavedStack21().get(i).equals("brownHat.png") || mem
                        .getSavedStack21().get(i).equals("brownPlate.png")) {
                    s.chooseImageColor(0);
                } else if (mem.getSavedStack21().get(i).equals("cyanHat.png")
                        || mem
                                .getSavedStack21().get(i).equals(
                                        "cyanPlate.png")) {
                    s.chooseImageColor(1);
                } else if (mem.getSavedStack21().get(i).equals("greenHat.png")
                        || mem
                                .getSavedStack21().get(i).equals(
                                        "greenPlate.png")) {
                    s.chooseImageColor(2);
                } else if (mem.getSavedStack21().get(i).equals("redHat.png")
                        || mem
                                .getSavedStack21().get(i).equals(
                                        "redPlate.png")) {
                    s.chooseImageColor(3);
                } else if (mem.getSavedStack21().get(i).equals("yellowHat.png")
                        || mem.getSavedStack21().get(i).equals(
                                "yellowPlate.png")) {
                    s.chooseImageColor(4);
                }
                s.setPosition(new Point(360, mem.getPositionStack21().get(i)));

                Player2.getInstance().addToStack1(s);
                int index = mem.getSavedStack21().size() - 1;
                Player2.getInstance().setLeftHandY(mem.getPositionStack21()
                        .get(index)-10);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void rightHandP2() {
        try {
            for (int i = 0; i < mem.getSavedStack22().size(); i++) {
                Shape s;
                if (mem.getSavedStack22().get(i).contains("Plate")) {
                    s = new Plate();

                } else {
                    s = new Hat();
                   
                }
                if (mem.getSavedStack22().get(i).equals("brownHat.png") || mem
                        .getSavedStack22().get(i).equals("brownPlate.png")) {
                    s.chooseImageColor(0);
                } else if (mem.getSavedStack22().get(i).equals("cyanHat.png")
                        || mem
                                .getSavedStack22().get(i).equals(
                                        "cyanPlate.png")) {
                    s.chooseImageColor(1);
                } else if (mem.getSavedStack22().get(i).equals("greenHat.png")
                        || mem
                                .getSavedStack22().get(i).equals(
                                        "greenPlate.png")) {
                    s.chooseImageColor(2);
                } else if (mem.getSavedStack22().get(i).equals("redHat.png")
                        || mem
                                .getSavedStack22().get(i).equals(
                                        "redPlate.png")) {
                    s.chooseImageColor(3);
                } else if (mem.getSavedStack22().get(i).equals("yellowHat.png")
                        || mem.getSavedStack22().get(i).equals(
                                "yellowPlate.png")) {
                    s.chooseImageColor(4);
                }
                s.setPosition(new Point(360, mem.getPositionStack22().get(i)));

                Player2.getInstance().addToStack2(s);
                int index = mem.getSavedStack22().size() - 1;
                Player2.getInstance().setRightHandY(mem.getPositionStack22()
                        .get(index)-10);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
