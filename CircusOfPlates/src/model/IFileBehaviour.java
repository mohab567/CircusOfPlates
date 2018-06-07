package model;

import java.io.File;
import java.io.IOException;

public interface IFileBehaviour {
    
    public void saveGame(File file) throws IOException;
    public void loadGame(File file) throws IOException, ClassNotFoundException;   

}
