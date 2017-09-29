package modele;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class CurrencyManager {

    public ArrayList<Currency> currencies;

    public CurrencyManager(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }

    public CurrencyManager() {}

    public void printCurrs(){
        if(!currencies.isEmpty()) {
            int cpt = 1;
            NumberFormat formatter = new DecimalFormat("#00.00000");
            String s = formatter.format(1);

            System.out.println("------------------------");
            System.out.println("| XXX | CUR | USDtoCUR |");
            for (Currency c : currencies) {
                System.out.println("------------------------");
                System.out.println("| "+String.format("%03d",cpt)+" | "+c.getName()+" | "+formatter.format(c.getExchangeRate())+" |");
                cpt++;
            }
            System.out.println("------------------------");
        }
    }

    public static Double convert(Currency currSrc, Double val, Currency currDst){
        return (val / currSrc.getExchangeRate() * currDst.getExchangeRate());
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }
}
