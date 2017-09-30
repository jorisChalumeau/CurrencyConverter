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

    /**
     * affiche la liste des devises dans la console
     */
    public void printCurrs(){
        if(!currencies.isEmpty()) {
            int cpt = 1;
            NumberFormat formatter = new DecimalFormat("#00.00000");
            String s = formatter.format(1);

            System.out.println("---------------------------------------------");
            System.out.println("| id | CUR | USDtoCUR |      file path      |");
            for (Currency c : currencies) {
                System.out.println("---------------------------------------------");
                System.out.println("| "+String.format("%02d",cpt)+" | "+c.getName()+" | "
                        +formatter.format(c.getExchangeRate())+" | "+c.getImagePath()+" |");
                cpt++;
            }
            System.out.println("---------------------------------------------");
        }
    }

    public Double convert(String currSrc, Double val, String currDst){
        return (val / this.getCurFromStr(currSrc).getExchangeRate() * this.getCurFromStr(currDst).getExchangeRate());
    }

    public Currency getCurFromStr(String str){
        for (Currency cur : this.currencies)
            if(cur.getName().equals(str))
                return cur;
        return currencies.get(0);
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public String[] getCurrNames() {
        String[] tabNames = new String[currencies.size()];
        int i = 0;
        for(Currency cur : currencies) {
            tabNames[i] = cur.getName();
            i++;
        }
        return tabNames;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }
}
