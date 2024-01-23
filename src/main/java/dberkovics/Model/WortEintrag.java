package dberkovics.Model;

import javax.swing.*;

/**
 * Die Klasse erstellt einen Worteintrag und beeinhaltet auch noch Methoden für den Worteintrag
 * @author David Berkovics
 * @version 16.01.2024
 */

public class WortEintrag {
    String wort, url;
    /**
     * Die Methode erstellt ein WortEintrag
     * @param wort Das Wort wird übernommen
     * @param url Die URL wird übernommen
     */
    public WortEintrag(String wort, String url) {
        if(wort!=null&&wort.length()>2&&checkURL(url)) {
            this.wort=wort;
            this.url=url;
        }
        else {
            JOptionPane.showMessageDialog(null,"Wort zu kurz oder URL falsch");
        }
    }

    /**
     * Die Methode überprüft ob die URL gültig ist
     * @param u Die zu überprüfende URL
     * @return Das Ergebnis der Überprüfung
     */
    public static boolean checkURL(String u) {
        return (u.matches("(?:(?:https?|ftp):\\/\\/|\\b(?:[a-z\\d]+\\.))(?:(?:[^\\s()<>]+|\\((?:[^\\s()<>]+|(?:\\([^\\s()<>]+\\)))?\\))+(?:\\((?:[^\\s()<>]+|(?:\\(?:[^\\s()<>]+\\)))?\\)|[^\\s`!()\\[\\]{};:'\".,<>?«»“”‘’]))?"));
    }
    /**
     * Nach überprüfen der URL wird die URL gesetzt
     * @param url Die URL
     */
    public void setUrl(String url) {
        if(checkURL(url)){
            this.url=url;
        }
        else {
            System.err.println("URL falsch");
        }
    }
    /**
     * Die Methode setzt ein Wort
     * @param wort Das wort wird übernommen
     */
    public void setWort(String wort) {
        if (wort.length() > 2) {
            this.wort = wort;
        }
        else
            System.out.println("Falsche Eingabe");
    }
    /**
     * Die URL gibt die URL zurück
     * @return Die url wird zurückgegeben
     */
    public String getUrl() {
        return url;
    }
    /**
     * Das Wort wird zurückgegeben
     * @return Das Wort wird zurückgegeben
     */
    public String getWort() {
        return wort;
    }
    /**
     * Die Methode gibt das Wort und die Url aus
     * @return Ein String der Wort + URL ausgibt
     */
    @Override
    public String toString() {
        return wort+" ; "+url;
    }

}
