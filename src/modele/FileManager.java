package modele;

import com.google.gson.Gson;
import java.io.*;

public class FileManager {

    public final static String FLAGS_DIR_PATH = "../currency-converter_2017/src/files";
    private final static String FILE_CURLIST_PATH = "../currency-converter_2017/src/files/curList.txt";

    /**
     * save the currency list (with the exchange rates) in the file
     */
    public void saveCurrency(CurrencyManager curr){
        Gson gson = new Gson();

        // mettre json dans le fichier
        try{
            FileWriter fw = new FileWriter(new File(FILE_CURLIST_PATH));
            fw.write(gson.toJson(curr));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * loadImage the currency list (with the exchange rates) from the file
     */
    public CurrencyManager loadCurrency(){
        Gson gson = new Gson();

        // recuperer json dans le fichier
        try{
            FileReader fr = new FileReader(new File(FILE_CURLIST_PATH));
            return gson.fromJson(fr, CurrencyManager.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
