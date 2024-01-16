package dberkovics.Controller;

import dberkovics.Model.*;
import dberkovics.View.Frame;
import dberkovics.View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

    private PersistenzStrategy persistenzStrategy = new JSONPersistenz();

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
        switch(cmd){
            case "reset":
                this.wortTrainer = new WortTrainer(wortListe);
                view.updateStats(0,0,true);
                break;
            case "add":
                String wort =JOptionPane.showInputDialog(null,"Bitte Geben Sie ein Wort ein");
                String url = JOptionPane.showInputDialog(null,"Bitte geben Sie eine URL ein");
                WortEintrag w2 = new WortEintrag(wort,url);
                int r = wortTrainer.getRichtig();
                int a = wortTrainer.getAbgefragt();
                wortListe.add(w2);
                wortTrainer = new WortTrainer(wortListe);
                wortTrainer.setAbgefragt(a);
                wortTrainer.setRichtig(r);
                break;
            case "text":
                if(wortTrainer.checkEintrag(view.getText())==true) {
                    view.updateStats(wortTrainer.getRichtig(),wortTrainer.getAbgefragt(),true);
                    try {
                        view.updateImage(wortTrainer.randomEintrag().getUrl());
                    } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                    }
                }
                else {
                    view.updateStats(wortTrainer.getRichtig(),wortTrainer.getAbgefragt(),false);
                }
                break;
            case "save":
                try {
                    persistenzStrategy.save(wortTrainer);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "load":
                try {
                    wortTrainer=persistenzStrategy.load();
                    view.updateStats(wortTrainer.getRichtig(),wortTrainer.getAbgefragt(),true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }
}
