package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import controller.RunGame;
import controller.Time;
import model.Json;
import model.Level;
import model.Player1;
import model.Player2;
import model.Shape;

public class GUI implements ActionListener {

    private static GUI instance = null;
    public static DrawingArea canvas;
    public JFrame frame;
    JPanel bar;
    RunGame R;
    List<Shape> shapes;
    BufferedImage crown1Img;
    BufferedImage crown2Img;
    BufferedImage background;
    public boolean pauseResume;
    JTextField score1;
    JTextField score2;
    JTextField level;

    public static GUI getInstance() {
        if (instance == null) {
            instance = new GUI();
        }
        return instance;
    }

    private GUI() {
        pauseResume = false;
        // TODO Auto-generated constructor stub
        canvas = new DrawingArea();
        bar = new JPanel();
        JButton pause = new JButton("Pause");
        JButton resume = new JButton("Start");
        JButton save = new JButton("Save");
        JButton load = new JButton("Load");
        resume.setBackground(new Color(222, 222, 222));
        resume.setSize(1000, 1000);
        resume.addActionListener(this);

        pause.setBackground(new Color(222, 222, 222));
        pause.setSize(1000, 1000);
        pause.addActionListener(this);

        save.setBackground(new Color(222, 222, 222));
        save.setSize(1000, 1000);
        save.addActionListener(this);

        load.setBackground(new Color(222, 222, 222));
        load.setSize(1000, 1000);
        load.addActionListener(this);

        final float fontSize = 20f;

        score1 = new JTextField("Score 1 :0");
        score1.setEditable(false);
        // score1.setBounds(1, 1, 9, 9);
        score1.setFont(score1.getFont().deriveFont(fontSize));
        score2 = new JTextField("Score 2 :0");
        score2.setEditable(false);
        // answerArea.setBounds(l1, l2, l2, l3);
        score2.setFont(score2.getFont().deriveFont(fontSize));
        level = new JTextField("Level :1");
        level.setEditable(false);
        // answerArea.setBounds(l1, l2, l2, l3);
        level.setFont(level.getFont().deriveFont(fontSize));

        bar.add(score1);
        bar.add(save);
        bar.add(load);
        bar.add(level);
        bar.add(pause);
        bar.add(resume);
        bar.add(score2);
        bar.setBackground(new Color(250, 125, 125));
        canvas.setVisible(true);
        R = new RunGame(0.01);
        shapes = R.platesToRender();
        canvas.keyAction();

        try {
            crown2Img = ImageIO.read(new File("img/clown2.png"));
            crown1Img = ImageIO.read(new File("img/clown1.png"));
            background = ImageIO.read(new File("img/backgroundImage.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private class DrawingArea extends JPanel implements MouseListener,
            MouseMotionListener {

        public DrawingArea() {
            setSize(500, 800);
            addMouseMotionListener(this);
            addMouseListener(this);

        }

        public void keyAction() {
            double x = Player2.getInstance().getxAxis();
            canvas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke
                    .getKeyStroke(KeyEvent.VK_RIGHT, 0), "RA");
            canvas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke
                    .getKeyStroke(KeyEvent.VK_LEFT,
                            0), "LA");

            canvas.getActionMap().put("RA", new AbstractAction() {
                /**
                 * 
                 */

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    Player2.getInstance().setxAxis(x + 30);
                }
            });
            canvas.getActionMap().put("LA", new AbstractAction() {
                /**
                 * 
                 */

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    Player2.getInstance().setxAxis(x - 30);
                }
            });
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(background, -20, 0, 1400, 700, this);
            g.drawImage(crown1Img, (int) Player1.getInstance().getxAxis(), 290,
                    450, 400, this);
            g.drawImage(crown2Img, (int) Player2.getInstance().getxAxis(), 290,
                    450, 400, this);

            for (int i = 0; i < shapes.size(); i++) {
                BufferedImage img = shapes.get(i).getImg();
                g.drawImage(img, shapes.get(i).getPosition().x, shapes.get(i)
                        .getPosition().y, 120, 40, this);
            }
            List<List<Shape>> s = new ArrayList<List<Shape>>();
            s.add(Player1.getInstance().getStack1());
            s.add(Player1.getInstance().getStack2());
            s.add(Player2.getInstance().getStack1());
            s.add(Player2.getInstance().getStack2());
            List<Integer> l = new ArrayList<Integer>();
            l.add((int) Player1.getInstance().getxAxis() + 75 - 50);
            l.add((int) Player1.getInstance().getxAxis() + 225 + 50);
            l.add((int) Player2.getInstance().getxAxis() + 75 - 50);
            l.add((int) Player2.getInstance().getxAxis() + 225 + 50);
            List<Shape> m;
            int location;
            for (int j = 0; j < s.size(); j++) {
                m = s.get(j);
                location = l.get(j);
                for (int i = 0; i < m.size(); i++) {

                    g.drawImage(m.get(i).getImg(), location, m.get(i)
                            .getPosition().y, 120, 40, this);
                }
            }

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub

            Point curPt = e.getPoint();
            Player1.getInstance().setxAxis(curPt.x - 200);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }

    public void run() {
        frame = new JFrame("Circus Of Plates");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frame.getContentPane();
        pane.add(bar, BorderLayout.NORTH);
        pane.add(canvas);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

    }

    public void reset() {
        R.resetLogic();
        canvas.keyAction();
        canvas.revalidate();
        canvas.repaint();
    }

    public void up() {
        R.run();
        canvas.keyAction();
        canvas.revalidate();
        canvas.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Start")) {
            Time.getInstance().cont();
        }
        if (action.equals("Pause")) {
            Time.getInstance().pause();
        } 
        if(action.equals("Save")) {
            Json s = new Json();
            try {
				s.saveGame(new File("CircusGame.json"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(action.equals("Load")) {
            Json s = new Json();
            try {
				s.loadGame(new File("CircusGame.json"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

    }

    public void updateScore() {
        score1.setText("Score 1 :" + Player1.getInstance().getScore()
                .getScore());
        score2.setText("Score 2 :" + Player2.getInstance().getScore()
                .getScore());
    }

    public void updateLevel(Level l) {

        level.setText("level :" + l.Name());
    }

	public void endGame() {
		String p1="Player 1 : "+Player1.getInstance().getState().getState();
		String p2="Player 2 : "+Player2.getInstance().getState().getState();
		 int pane = JOptionPane.showConfirmDialog(frame,
                 p1+"\n"+p2, "Game is finished",JOptionPane.DEFAULT_OPTION);
		 frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

}
