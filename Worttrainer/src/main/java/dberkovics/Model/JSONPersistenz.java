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
