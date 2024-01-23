package dberkovics.Model;
import com.google.gson.Gson;

import javax.swing.*;
import java.io.*;

/**
 * JSONPersistenz
 *
 * @author David Berkovics
 * @version 16.01.24
 */
public class JSONPersistenz implements PersistenzStrategy{
    /**
     * Die Methode speichert den WortTrainer in ein Worttrainer.json File
     * @param w der Worttrainer
     * @throws IOException
     */
    @Override
    public void save(WortTrainer w) throws IOException {
        try {
            Gson gson = new Gson();
            String jsonData = gson.toJson(w);
            PrintWriter jsonOut = new PrintWriter(new FileWriter("Worttrainer.json"));
            jsonOut.print(jsonData);
            jsonOut.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    /**
     * Die Methode ladet den Worttrainer von einem Worttrainer.json File
     * @return Der geladene Worttrainer
     * @throws IOException
     */
    @Override
    public WortTrainer load() throws IOException {
        try {
            Gson gson = new Gson();
            BufferedReader jsonIn = new BufferedReader(new FileReader("Worttrainer.json"));
            String jsonData = jsonIn.readLine();
            jsonIn.close();

            return gson.fromJson(jsonData, WortTrainer.class);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return null;
    }
}
