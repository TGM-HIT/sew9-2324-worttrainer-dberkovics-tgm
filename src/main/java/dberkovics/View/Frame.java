package dberkovics.View;

import javax.swing.*;

/**
 * Die Frame Klasse des Worttrainers erstellt ein Frame
 * @author David Berkovics
 * @version 16.01.2024
 */
public class Frame extends JFrame {
    public Frame(String title, JPanel m) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(m);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
