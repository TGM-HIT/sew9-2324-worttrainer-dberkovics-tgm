package dberkovics.Model;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * TxtPersistenz
 *
 * @author David Berkovics
 * @version 16.01.24
 */
public class TxtPersistenz implements PersistenzStrategy {

    @Override
    public void save(WortTrainer w) throws IOException {
        try (PrintWriter outputStream = new PrintWriter("Worttrainer.txt")) {
            for (int i = 0; i < w.getLaenge(); ++i) {
                outputStream.println(w.getEintrag(i).getWort());
                outputStream.println(w.getEintrag(i).getUrl());
                outputStream.println();
            }
            outputStream.println(w.getAbgefragt());
            outputStream.println(w.getRichtig());
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public WortTrainer load() throws IOException {
        WortListe wl = new WortListe();
        int abgefragt=-1, richtig=-1;
        try (Scanner s = new Scanner(new BufferedReader(new
                FileReader("Worttrainer.txt")))) {
            while (s.hasNext()) {
                if(s.hasNextInt()) {
                    abgefragt = s.nextInt();
                    richtig = s.nextInt();
                }else {
                    String wort = s.next();
                    String url = s.next();
                    WortEintrag wortEintrag = new WortEintrag(wort, url);
                    wl.add(wortEintrag);
                }
            }
        }
        catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        WortTrainer wt = new WortTrainer(wl);
        wt.setAbgefragt(abgefragt);
        wt.setRichtig(richtig);
        return wt;
    }
}
