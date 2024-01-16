package dberkovics.Controller;

import dberkovics.Model.WortEintrag;
import dberkovics.Model.WortListe;
import dberkovics.Model.WortTrainer;
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
    private WortTrainer wortTrainer;
    private WortListe wortListe;
    private WortEintrag w,w1;

    public Controller() throws MalformedURLException {
        view = new View(this);
        frame=new Frame("Worttrainer",view);
        wortListe = new WortListe();
        w = new WortEintrag("Hund","https://www.pinclipart.com/picdir/middle/20-206356_wenn-hund-clipart.png");
        w1 = new WortEintrag("Katze","https://media.4-paws.org/a/5/c/4/a5c4c9cdfd3a8ecb58e9b1a5bd496c9dfbc3cedc/VIER%20PFOTEN_2020-10-07_00132-2890x2000-1920x1329.jpg");
        wortListe.add(w);
        wortListe.add(w1);
        wortTrainer=new WortTrainer(wortListe);
        view.updateImage(wortTrainer.randomEintrag().getUrl());
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
