package dberkovics.View;
import dberkovics.Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Die View Klasse des Worttrainers, hier wird das Layout erstellt
 * @author David Berkovics
 * @version 03.11.2021
 */
public class View extends JPanel {
    private Controller ctl;
    private JButton[] button;
    private JTextField textField;
    private JLabel[] labels=new JLabel[7];
    /**
     * Der Konstruktor der View Klasse
     * @param ctl Der Controller wird übernommen
     * @throws MalformedURLException
     */
    public View(Controller ctl) throws MalformedURLException {
        this.ctl=ctl;
        this.setLayout(new BorderLayout());
        button = new JButton[4];
        textField = new JTextField();
        textField.addActionListener(ctl);
        textField.setActionCommand("text");
        //OBEN
        JPanel oben = new JPanel();
        oben.setLayout(new GridLayout(2,1));
        labels[0] = new JLabel();
        labels[0].setText("Welches Wort wird unten dargestellt (Eingabe zum Überprüfen)?");
        oben.add(labels[0]);
        oben.add(textField);
        this.add(oben,BorderLayout.PAGE_START);

        labels[5] = new JLabel();   //Label fürs Bild
        this.add(labels[5]);

        //UNTEN
        JPanel unten = new JPanel();
        unten.setLayout(new GridLayout(3,3));
        labels[1] = new JLabel();
        labels[1].setText("Richtige Wörter: ");
        labels[2] = new JLabel("0",SwingConstants.CENTER);
        button[0] = new JButton();
        button[0].setText("Zurücksetzen");
        button[0].addActionListener(ctl);
        button[0].setActionCommand("reset");
        labels[3] = new JLabel();
        labels[3].setText("Anzahl Wörter: ");
        labels[4] = new JLabel("0",SwingConstants.CENTER);
        button[1] = new JButton();
        button[1].setText("Wort hinzufügen");
        button[1].addActionListener(ctl);
        button[1].setActionCommand("add");
        button[2] = new JButton();
        button[2].setText("Worttrainer Laden");
        button[2].addActionListener(ctl);
        button[2].setActionCommand("load");
        button[3] = new JButton();
        button[3].setText("Worttrainer speichern");
        button[3].addActionListener(ctl);
        button[3].setActionCommand("save");
        unten.add(labels[1]);
        unten.add(labels[2]);
        unten.add(button[0]);
        unten.add(labels[3]);
        unten.add(labels[4]);
        unten.add(button[1]);
        unten.add(button[2]);
        unten.add(button[3]);
        this.add(unten,BorderLayout.PAGE_END);
    }
    /**
     * Die Methode gibt den Text vom Textfeld zurück
     * @return Der Text vom Textfeld
     */
    public String getText() {
        return textField.getText();
    }
    /**
     * Die Methode updatet die Statistik
     * @param richtig Die Anzahl der richtig erratenen Wörter
     * @param anzahl Die Anzahl der Versuche
     * @param b Es wird geprüft ob das Wort richtig eingegeben wurde oder nicht
     */
    public void updateStats(int richtig, int anzahl,boolean b) {
        if(b) {
            labels[2].setText("" + richtig);
        }
        labels[4].setText("" + anzahl);
    }
    /**
     * Die Methode fügt das derzeitige Bild hinzu
     * @param url Die URL für das Bild wird übernommen
     * @throws MalformedURLException
     */
    public void updateImage(String url) throws MalformedURLException {
        ImageIcon icon = new ImageIcon(new URL(url));
        Image image = icon.getImage(); // umwandeln in ein Image-Objekt
        image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
        labels[5].setIcon(new ImageIcon(image));
        this.add(labels[5]);
    }
}
