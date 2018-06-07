package model;

import java.util.ArrayList;

import view.GUI;

public class LevelStrategy {
    ArrayList<Level> l = new ArrayList<Level>();
    private static long StartTime;
    private static long deltaTime;
    private Level current;

    public static long getDeltaTime() {
        return deltaTime;
    }

    public static void startTimeByDelta(long deltaTime) {
        StartTime = System.nanoTime() - deltaTime;
    }

    public LevelStrategy() {
        // StartTime=now;
        l.add(new LevelOne());
        l.add(new LevelTwo());
        l.add(new LevelThree());
    }

    public int getFPS() {
        long now = System.nanoTime();
        deltaTime = now - StartTime;
        for (Level level : l) {

            if (level.acceptRange(deltaTime)) {
                if (current != level) {
                    current = level;
                    GUI.getInstance().updateLevel(current);
                }
                return level.FPS();
            }
        }
        return -1;
    }

    public long getStartTime() {
        return StartTime;
    }

    public void setStartTime(long startTime) {
        StartTime = startTime;
    }

}
