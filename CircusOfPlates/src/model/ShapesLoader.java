package model;

import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ShapesLoader {

    public ArrayList<Class<?>> Shapes;
    private ArrayList<String> classNames;
    public static ArrayList<ArrayList<BufferedImage>> imgAlbum;
    public static ArrayList<ArrayList<String>> imgAlbumNames;
    private static ShapesLoader instance;
    private File dir;

    private ShapesLoader() {
        imgAlbum = new ArrayList<>();
        imgAlbumNames = new ArrayList<>();
        Shapes = new ArrayList<>();
        classNames = new ArrayList<>();
        dir = new File("GameData");
        dir.mkdir();
    }

    public static ShapesLoader getInstance() {
        if (instance == null) {
            instance = new ShapesLoader();
        }
        return instance;
    }

    public void readClassNames() {
        File folder = new File("coloredImages");
        folder.mkdir();
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            classNames.add(listOfFiles[i].getName() + ".class");
            readImageName(listOfFiles[i]);
        }

        for (int i = 0; i < classNames.size(); i++) {
            Shapes.add(loadClass(new File(dir + "\\"), classNames.get(i)));
        }

    }

    public void readImageName(File name) {
        ArrayList<BufferedImage> image;
        ArrayList<String> names;

        if (name.isDirectory()) {
            image = new ArrayList<>();
            names = new ArrayList<>();
            for (final File f : name.listFiles()) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(f);
                    image.add(img);
                    names.add(f.getName());
                } catch (final IOException e) {
                    e.getStackTrace();
                }
            }
            imgAlbum.add(image);
            imgAlbumNames.add(names);
        }
    }

    public ArrayList<Class<?>> getList() {
        return Shapes;
    }

    public Class<?> loadClass(File source, String name) {

        try {

            String path = new File("").getAbsolutePath() + "\\model\\";
            new File(path).mkdirs();
            Files.copy(new File(source.toPath() + "\\" + name).toPath(),
                    new File(path + name).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            source = new File(new File("").getAbsolutePath());
            java.net.URL url = source.toURI().toURL();
            java.net.URL[] urls = new java.net.URL[] { url };

            // load this folder into Class loader

            ClassLoader cl = new URLClassLoader(urls);

            // load the Address class in 'c:\\other_classes\\'
            Class<?> cls = cl.loadClass("model." + name.substring(0, name
                    .indexOf('.')));

            try {
                Files.delete(new File(path + name).toPath());
                Files.delete(new File(new File("").getAbsolutePath()
                        + "\\model\\").toPath());
            } catch (Exception e) {}
            return cls;
        } catch (Exception e) {

        }
        return null;
    }

    public static void main(String[] args) {
        ShapesLoader l = new ShapesLoader();
        l.readClassNames();
    }

}
