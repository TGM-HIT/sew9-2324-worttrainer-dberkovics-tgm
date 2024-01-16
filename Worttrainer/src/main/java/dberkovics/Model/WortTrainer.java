package dberkovics.Model;
import java.util.Random;

/**
 * Die Klasse Worttrainer
 * @author David Berkovics
 * @version 17.09.2021
 */
public class WortTrainer {
    private WortListe wortListe;
    private int a,laenge;
    private int abgefragt=0, richtig=0;
    /**
     * Es wird zum Worttrainer eine Liste und eine Länge hinzugefügt
     * @param wortListe Die Wortliste
     */
    public WortTrainer(WortListe wortListe) {
        this.wortListe=wortListe;
        this.laenge=wortListe.laenge();
    }
    /**
     * Es wird ein zufälliger Eintrag ausgewählt
     * @return Der Zufällige Eintrag
     */
    public WortEintrag randomEintrag() {
        Random r = new Random();
        a = r.nextInt(laenge);
        return wortListe.getEintrag(a);
    }
    /**
     * Die Methode gibt den derzeitig ausgewählten Worteintrag zurück
     * @return Den derzeitig ausgewählten Worteintrag
     */
    public WortEintrag getEintrag() {
        return wortListe.getEintrag(a);
    }
    /**
     * Es wird ein Eintrag des Worttrainers zurückgegeben
     * @param  i Die Stelle die ausgegeben werden soll
     * @return Der Eintrag des Worttrainers an der Stelle i
     */
    public WortEintrag getEintrag(int i) {
        return wortListe.getEintrag(i);
    }
    /**
     * Die Methode überprüft ob das eingegebene Wort mit dem derzeitigen Worteintrag übereinstimmt
     * @param wort  das eingegebene Wort
     * @return Das Ergebnis der Überprüfung
     */
    public boolean checkEintrag(String wort) {
        abgefragt+=1;
         if(wortListe.getEintrag(a).getWort().equals(wort)==true) {
             richtig+=1;
             return true;
         }
         return false;
    }
    /**
     * Die Methode überprüft unabhängig von der Groß- Kleinschreibung ob das Wort übereinstimmt
     * @param wort Das eingegebene Wort
     * @return Das Ergebnis der Überprüfung
     */
    public boolean checkIgnoreCase(String wort) {
        String wort1 =wortListe.getEintrag(a).getWort().toLowerCase();
        abgefragt+=1;
        if(wort1.equals(wort.toLowerCase())==true) {
            richtig+=1;
            return true;
        }
        return false;
    }
    /**
     * Gibt die Anzahl der richtigen Wörter zurück
     * @return die Anzahl
     */
    public int getRichtig() {
        return richtig;
    }
    /**
     * Gibt die Anzahl der abgefragten Wörter zurück
     * @return die Anzahl
     */
    public int getAbgefragt() {
        return abgefragt;
    }
    /**
     * Gibt die Länge zurück
     * @return Die Länge wird zurückgegeben
     */
    public int getLaenge() {
        return laenge;
    }
    /**
     * Gibt die Wortliste zurück
     * @return Die Wortliste wird zurückgegeben
     */
    public WortListe getWortListe() {
        return wortListe;
    }
    /**
     * Setzt die Statistik
     * @param abgefragt die Statistik wird übernommen
     */
    public void setAbgefragt(int abgefragt) {
        this.abgefragt = abgefragt;
    }
    /**
     * Setzt die Statistik
     * @param richtig die Statistik wird übernommen
     */
    public void setRichtig(int richtig) {
        this.richtig = richtig;
    }
}