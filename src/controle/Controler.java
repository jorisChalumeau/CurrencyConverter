package controle;

import GUI.*;
import modele.CurrencyManager;
import modele.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener {

    private Window window = null;
    private CurrencyManager currList;

    public Controler() {
        FileManager fm = new FileManager();

//        currList = fm.loadCurrency();
//        currList.printCurrs();

        window = new Window("Currency converter");

        initWindow();
    }

    public void initWindow() {
        for (Button button : window.getListTot()) {
            button.addActionListener(this);
        }
    }


    public void actionPerformed(ActionEvent actionEvent) {
        String name = actionEvent.getActionCommand();
        switch (name) {
            case "1":
                if(window.getLab().getText().equals("0")){
                    window.getLab().setText("1");
                }
                else {
                    window.getLab().setText(window.getLab().getText()+"1");
                }
                break;
            case "2":
                if(window.getLab().getText().equals("0")){
                    window.getLab().setText("2");
                }
                else {
                    window.getLab().setText(window.getLab().getText()+"2");
                }
                break;
            case "3":
                if(window.getLab().getText().equals("0")){
                    window.getLab().setText("3");
                }
                else {
                    window.getLab().setText(window.getLab().getText()+"3");
                }
                break;
            case "4":
                if(window.getLab().getText().equals("0")){
                    window.getLab().setText("4");
                }
                else {
                    window.getLab().setText(window.getLab().getText()+"4");
                }
                break;
            case "5":
                if(window.getLab().getText().equals("0")){
                    window.getLab().setText("5");
                }
                else {
                    window.getLab().setText(window.getLab().getText()+"5");
                }
                break;
            case "6":
                if(window.getLab().getText().equals("0")){
                    window.getLab().setText("6");
                }
                else {
                    window.getLab().setText(window.getLab().getText()+"6");
                }
                break;
            case "7":
                if(window.getLab().getText().equals("0")){
                    window.getLab().setText("7");
                }
                else {
                    window.getLab().setText(window.getLab().getText()+"7");
                }
                break;
            case "8":
                if(window.getLab().getText().equals("0")){
                    window.getLab().setText("8");
                }
                else {
                    window.getLab().setText(window.getLab().getText()+"8");
                }
                break;
            case "9":
                if(window.getLab().getText().equals("0")){
                    window.getLab().setText("9");
                }
                else {
                    window.getLab().setText(window.getLab().getText()+"9");
                }
                break;
            case "0":
                if(window.getLab().getText().equals("0")){
                    window.getLab().setText("0");
                }
                else {
                    window.getLab().setText(window.getLab().getText()+"0");
                }
                break;
            case ".":
                if(window.getLab().getText().equals("0")){
                    window.getLab().setText("0.");
                }
                else {
                    window.getLab().setText(window.getLab().getText()+".");
                }
                break;
            case "=":
                renvoiResult();
                break;
            case "supp":
                suppCase();
                break;
        }
    }

    public void suppCase(){
        if(window.getLab().getText().equals("0")){
            window.getLab().setText("0");
        }
        else if(window.getLab().getText().length()==1) {
            window.getLab().setText("0");
        }
        else{
            window.getLab().setText(window.getLab().getText().substring(0, window.getLab().getText().length() - 1));

        }
    }
    public void renvoiResult(){
        if(window.getStockNumVal()==1){
            window.getVal1().setText(window.getLab().getText());
            double value = Double.parseDouble(window.getLab().getText());
            window.getVal2().setText(String.valueOf(value*2/3));
            window.getVal3().setText(String.valueOf(value*2/3));
            window.getVal4().setText(String.valueOf(value*2/3));
        }
        if(window.getStockNumVal()==2){
            window.getVal2().setText(window.getLab().getText());
            double value = Double.parseDouble(window.getLab().getText());
            window.getVal1().setText(String.valueOf(value*2/3));
            window.getVal3().setText(String.valueOf(value*2/3));
            window.getVal4().setText(String.valueOf(value*2/3));
        }
        if(window.getStockNumVal()==3){
            window.getVal3().setText(window.getLab().getText());
            double value = Double.parseDouble(window.getLab().getText());
            window.getVal1().setText(String.valueOf(value*2/3));
            window.getVal2().setText(String.valueOf(value*2/3));
            window.getVal4().setText(String.valueOf(value*2/3));
        }
        if(window.getStockNumVal()==4){
            window.getVal4().setText(window.getLab().getText());
            double value = Double.parseDouble(window.getLab().getText());
            window.getVal1().setText(String.valueOf(value*2/3));
            window.getVal2().setText(String.valueOf(value*2/3));
            window.getVal3().setText(String.valueOf(value*2/3));
        }
    }
}
