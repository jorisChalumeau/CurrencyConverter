package modele;

import com.google.gson.Gson;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;

public class FileManager {

    /**
     * select file to save currency exchange rates
     * @param cCmp
     * @param parent
     */
    public void save(CurrencyManager cCmp, Component parent){
        JFileChooser choice = new JFileChooser();
        choice.addChoosableFileFilter(new FileNameExtensionFilter("Currency Rate Files (.curr)", "curr"));
        choice.setAcceptAllFileFilterUsed(false);

        if(choice.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION)
            this.saveCurrency(choice.getSelectedFile(), cCmp);
        else
            System.out.println("aucun fichier sélectionné");
    }

    /**
     * select file to load currency exchange rates
     * @param parent
     * @return
     */
    public CurrencyManager load(Component parent){
        JFileChooser choice = new JFileChooser();
        choice.addChoosableFileFilter(new FileNameExtensionFilter("Currency Rate Files (.curr)", "curr"));
        choice.setAcceptAllFileFilterUsed(false);

        if(choice.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            return this.loadCurrency(choice.getSelectedFile());
        } else {
            System.out.println("aucun fichier sélectionné");
            return null;
        }
    }


    /**
     * save the currency list (with the exchange rates) in the file
     */
    private void saveCurrency(File file, CurrencyManager curr){
        Gson gson = new Gson();

        // mettre json dans le fichier
        try{
            FileWriter fw = new FileWriter(file);
            fw.write(gson.toJson(curr));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * load the currency list (with the exchange rates) from the file
     */
    private CurrencyManager loadCurrency(File file){
        Gson gson = new Gson();

        // recuperer json dans le fichier
        try{
            FileReader fr = new FileReader(file);
            return gson.fromJson(fr, CurrencyManager.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
