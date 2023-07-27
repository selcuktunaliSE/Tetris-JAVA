package com.selcuktunali;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tetris extends JFrame {


    public Tetris() {

   initMainMenuUI();
    }
    private void initMainMenuUI() {

        setLayout(new BorderLayout());

        Image image = new ImageIcon("/Users/selcuktunali/Desktop/Tetris/src/com/selcuktunali/tetris-multicolored-pattern-4u7ed6koskqhcez1.jpg").getImage();


        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this); // draws image
            }
        };


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        Font customFont = new Font("Serif", Font.BOLD, 24);


        JButton playButton = new JButton("Play");
        playButton.setFont(customFont);
        playButton.setForeground(Color.BLUE);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.addActionListener(e -> {
            getContentPane().removeAll();
            initUI();
            validate();
            repaint();
        });


        JButton highscoresButton = new JButton("Highscores");
        highscoresButton.setFont(customFont);
        highscoresButton.setForeground(Color.RED);
        highscoresButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        highscoresButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Highscores feature is not yet implemented.");
        });


        panel.add(Box.createVerticalGlue());
        panel.add(playButton);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(highscoresButton);
        panel.add(Box.createVerticalGlue());

        add(panel, BorderLayout.CENTER);

        setTitle("Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    private void initUI() {


        var board = new Board(this);
        add(board);
        board.start();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem returnMenuItem = new JMenuItem("Main Menu");
        JMenuItem returnMenuItem2 = new JMenuItem("Restart");
        JMenuItem returnMenuItem3 = new JMenuItem("Pause");
        menu.add(returnMenuItem);
        menu.add(returnMenuItem2);
        menu.add(returnMenuItem3);
        returnMenuItem.addActionListener(e -> {
            getContentPane().removeAll();
            initMainMenuUI();
            validate();
            repaint();
        });
        returnMenuItem2.addActionListener(e -> {
            getContentPane().removeAll();
            initUI();
            validate();
            repaint();
        });
        returnMenuItem3.addActionListener(e -> {
            if (board.isPaused) {
                board.unpause();
                returnMenuItem3.setText("Pause");
            } else {
                board.pause();
               returnMenuItem3.setText("Unpause");
            }
        });


        setJMenuBar(menuBar);

        setTitle("Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }



    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var game = new Tetris();
            game.setVisible(true);
        });
    }
}
