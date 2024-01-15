package dberkovics.Controller;

import dberkovics.View.Frame;
import dberkovics.View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

/**
 * Die Controller Klasse
 * @author David Berkovics
 * @version 05.11.2021
 */
public class Controller implements ActionListener {
    private View view;
    private Frame frame;

    public Controller() throws MalformedURLException {
        view = new View(this);
        frame=new Frame("Worttrainer",view);
    }
    public static void main(String[] args) throws MalformedURLException {
        new Controller();
    }
    /**
     * Der ActionListener
     * @param e Es wird der Actioncommand übernommen
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
    }
}
