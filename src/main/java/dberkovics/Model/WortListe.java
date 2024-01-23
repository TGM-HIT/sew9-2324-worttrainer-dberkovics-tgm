package dberkovics.Model;

/**
 * Die Wortliste
 * @author David Berkovics
 * @version 16.01.2024
 */

public class WortListe {
    private WortEintrag[] liste=new WortEintrag[0];
    /**
     * Die Methode addet ein Worteintrag in die Wortliste
     * @param wort Der Worteintrag wird übernommen
     */
    public void add(WortEintrag wort) {
        WortEintrag[] liste1=new WortEintrag[liste.length+1];
        for(int i=0;i< liste.length;i++) {
            liste1[i]=liste[i];
        }
        liste1[liste1.length-1]=wort;
        liste=liste1;
    }
    /**
     * Die Methode gibt den derzeit ausgewählten Worteintrag zurück
     * @param i der Index des Eintrages
     * @return den WortEintrag
     */
    public WortEintrag getEintrag(int i) {
        return liste[i];
    }
    /**
     * Die Methode überprüft ein übergebenes Wort, ob dieser mit dem derzeitigen übereinstimmt
     * @param wort Das Wort wird übernommen
     * @return Das Ergebnis der Überprüfung
     */
    public boolean ueberprüfen(String wort){
        boolean temp=false;
        for(int i=0;i< liste.length;i++){
            if(wort.equals(liste[i].getWort())){
                liste[i]=null;
                temp=true;
            }
        }
        for(int i=0;i<liste.length;i++){
            if(liste[i]==null&&liste.length>1){
                liste[i]=liste[i+1];
            }
        }
        return temp;
    }
    /**
     * Die Wortliste wird in einem String geschrieben
     * @return den String mit der Wortliste
     */
    @Override
    public String toString() {
        String r="";
        for (int i=0;i<liste.length;i++) {
            r=r+liste[i]+"\n";
        }
        return r;
    }

    /**
     * Die Methode gibt die Länge der liste aus
     * @return Die Länge der Liste
     */
    public int laenge() {
        return liste.length;
    }
}

