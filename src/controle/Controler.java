package controle;

import GUI.Button;
import GUI.Window;
import modele.CurrencyManager;
import modele.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener {

    private Window window = null;
    private CurrencyManager currList;
    private int stockNumVal = 1;

    public Controler() {
        FileManager fm = new FileManager();
        currList = fm.loadCurrency();
        window = new Window("Currency converter");
        initVal();
        initWindow();

        window.setVisible(true);
    }

    public void initWindow() {
        window.initDisp();

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
        window.getLab().setText("0");

        /*
        if(window.getLab().getText().equals("0")){
            window.getLab().setText("0");
        }
        else if(window.getLab().getText().length()==1) {
            window.getLab().setText("0");
        }
        else{
            window.getLab().setText(window.getLab().getText().substring(0, window.getLab().getText().length() - 1));

        }*/
    }

    /**
     * initie l'affichage des monnaies
     */
    public void initVal() {

        String[] pays = currList.getCurrNames();
        String[] tabImgPath = {
                currList.getCurrencies().get(0).getImagePath(),
                currList.getCurrencies().get(1).getImagePath(),
                currList.getCurrencies().get(2).getImagePath(),
                currList.getCurrencies().get(3).getImagePath()
        };

        window.initFlagsLists(pays, tabImgPath);

        // lorsqu'on sélectionne un des boutons ou sont affichées les valeurs correspondant à chaque devise
        window.getVal1().addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        window.getLab().setText(window.getVal1().getText());
                        stockNumVal=1;
                    }
                }
        );
        window.getVal2().addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        window.getLab().setText(window.getVal2().getText());
                        stockNumVal=2;
                    }
                }
        );
        window.getVal3().addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        window.getLab().setText(window.getVal3().getText());
                        stockNumVal=3;
                    }
                }
        );
        window.getVal4().addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        window.getLab().setText(window.getVal4().getText());
                        stockNumVal=4;
                    }
                }
        );


        /**
         * lorsqu'on modifie la valeur d'un combobox
          */
        window.getList1().addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        String cygle = (String)combo.getSelectedItem();
                        String imgPath = currList.getCurFromStr(cygle).getImagePath();
                        window.getFlag1().setIcon(new ImageIcon(imgPath));

                        // on convertit également la valeur de son val
                        String curr = (String) window.getList2().getSelectedItem();
                        window.getVal1().setText(""+currList.convert(curr, Double.parseDouble(window.getVal2().getText())
                                , (String) window.getList1().getSelectedItem()));
                    }
                }
        );
        window.getList2().addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        String cygle = (String)combo.getSelectedItem();
                        String imgPath = currList.getCurFromStr(cygle).getImagePath();
                        window.getFlag2().setIcon(new ImageIcon(imgPath));

                        // on convertit également la valeur de son val
                        String curr = (String) window.getList1().getSelectedItem();
                        window.getVal2().setText(""+currList.convert(curr, Double.parseDouble(window.getVal1().getText())
                                , (String) window.getList2().getSelectedItem()));
                    }
                }
        );
        window.getList3().addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        String cygle = (String)combo.getSelectedItem();
                        String imgPath = currList.getCurFromStr(cygle).getImagePath();
                        window.getFlag3().setIcon(new ImageIcon(imgPath));

                        // on convertit également la valeur de son val
                        String curr = (String) window.getList1().getSelectedItem();
                        window.getVal3().setText(""+currList.convert(curr, Double.parseDouble(window.getVal1().getText())
                                , (String) window.getList3().getSelectedItem()));
                    }
                }
        );
        window.getList4().addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        String cygle = (String)combo.getSelectedItem();
                        String imgPath = currList.getCurFromStr(cygle).getImagePath();
                        window.getFlag4().setIcon(new ImageIcon(imgPath));

                        // on convertit également la valeur de son val
                        String curr = (String) window.getList1().getSelectedItem();
                        window.getVal4().setText(""+currList.convert(curr, Double.parseDouble(window.getVal1().getText())
                                , (String) window.getList4().getSelectedItem()));

                    }
                }
        );

        // valeurs initiale des listBox
        window.getList1().setSelectedIndex(0);
        window.getList2().setSelectedIndex(1);
        window.getList3().setSelectedIndex(2);
        window.getList4().setSelectedIndex(3);

        // valeurs initiales des vals
        window.getVal1().setText("1");
        String curr1 = (String) window.getList1().getSelectedItem();
        window.getVal2().setText(""+currList.convert(curr1, 1.0, (String) window.getList2().getSelectedItem()));
        window.getVal3().setText(""+currList.convert(curr1, 1.0, (String) window.getList3().getSelectedItem()));
        window.getVal4().setText(""+currList.convert(curr1, 1.0, (String) window.getList4().getSelectedItem()));
    }



    public void renvoiResult(){
        double value = Double.parseDouble(window.getLab().getText());
        String cur1 = (String) window.getList1().getSelectedItem();
        String cur2 = (String) window.getList2().getSelectedItem();
        String cur3 = (String) window.getList3().getSelectedItem();
        String cur4 = (String) window.getList4().getSelectedItem();

        switch(stockNumVal){
            case 1:
                window.getVal1().setText(window.getLab().getText());
                window.getVal2().setText(""+currList.convert(cur1, value, cur2));
                window.getVal3().setText(""+currList.convert(cur1, value, cur3));
                window.getVal4().setText(""+currList.convert(cur1, value, cur4));
                break;
            case 2:
                window.getVal2().setText(window.getLab().getText());
                window.getVal1().setText(""+currList.convert(cur2, value, cur1));
                window.getVal3().setText(""+currList.convert(cur2, value, cur3));
                window.getVal4().setText(""+currList.convert(cur2, value, cur4));
                break;
            case 3:
                window.getVal3().setText(window.getLab().getText());
                window.getVal1().setText(""+currList.convert(cur3, value, cur1));
                window.getVal2().setText(""+currList.convert(cur3, value, cur2));
                window.getVal4().setText(""+currList.convert(cur3, value, cur4));
                break;
            case 4:
                window.getVal4().setText(window.getLab().getText());
                window.getVal1().setText(""+currList.convert(cur4, value, cur1));
                window.getVal2().setText(""+currList.convert(cur4, value, cur2));
                window.getVal3().setText(""+currList.convert(cur4, value, cur3));
                break;
            default:
        }
    }
}
