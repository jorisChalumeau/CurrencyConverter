package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Currency curr1 = new Currency("USD", 1.0);
        Currency curr2 = new Currency("EUR", 0.851);
        Currency curr3 = new Currency("GBP", 0.74681);
        Currency curr4 = new Currency("INR", 65.6837);
        Currency curr5 = new Currency("AUD", 1.27916);

        ArrayList<Currency> listeCurr = new ArrayList<>(Arrays.asList(curr1, curr2, curr3, curr4, curr5));

        CurrencyManager cCmp = new CurrencyManager(listeCurr);
        cCmp.printCurrs();

        FileManager fm = new FileManager();
        fm.save(cCmp, null);
        CurrencyManager cCmp2 = fm.load(null);
        if(cCmp2 != null)
            cCmp2.printCurrs();
    }
}
