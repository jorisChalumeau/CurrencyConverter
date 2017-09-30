package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {
    private ArrayList<Button> butList =new ArrayList<>();
    private ArrayList<Button> listTot =new ArrayList<>();
    private ArrayList<Button> listVal =new ArrayList<>();
    private Button lab=new Button("0");
    private JPanel valeurs=new JPanel();
    private JPanel result= new JPanel();
    private JPanel tabl=new JPanel();
    private Button val1 = new Button("1");
    private Button val2 = new Button("2");
    private Button val3 = new Button("3");
    private Button val4 = new Button("4");
    private int stockNumVal;
    private Button supp = new Button("supp");


    private JComboBox list = new JComboBox();
    private JComboBox list2 = new JComboBox();
    private JComboBox list3 = new JComboBox();
    private JComboBox list4 = new JComboBox();

    public Window(String title) throws HeadlessException {
        super(title);
        this.setSize(450, 650);
        initButton();
        initVal();
        for (Button b: butList) {
            listTot.add(b);
        }
        listTot.add(supp);
        listVal.add(val1);
        listVal.add(val2);
        listVal.add(val3);
        listVal.add(val4);

        Dimension dim = new Dimension(120, 45);
        val1.setPreferredSize(dim);
        val2.setPreferredSize(dim);
        val3.setPreferredSize(dim);
        val4.setPreferredSize(dim);

        this.add(valeurs, BorderLayout.NORTH);
        this.add(result, BorderLayout.CENTER);
        this.add(tabl, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public ArrayList<Button> getListTot() {
        return listTot;
    }
    public ArrayList<Button> getListVal() {
        return listVal;
    }
    public Button getLab() {
        return lab;
    }
    public void setLab(Button lab) {
        this.lab = lab;
    }

    public Button getVal1() {
        return val1;
    }
    public void setVal1(Button val1) {
        this.val1 = val1;
    }
    public Button getVal2() {
        return val2;
    }
    public void setVal2(Button val2) {
        this.val2 = val2;
    }
    public Button getVal3() {
        return val3;
    }
    public void setVal3(Button val3) {
        this.val3 = val3;
    }
    public Button getVal4() {
        return val4;
    }
    public void setVal4(Button val4) {
        this.val4 = val4;
    }

    public int getStockNumVal() {
        return stockNumVal;
    }

    public void initButton(){

        result.setLayout(new GridBagLayout());
        GridBagConstraints bres = new GridBagConstraints();
        result.setBackground(Color.GRAY);

        tabl.setLayout(new GridBagLayout());
        GridBagConstraints bc = new GridBagConstraints();
        tabl.setBackground(Color.GRAY);

        bres.gridx = 0;
        bres.gridy = 0;
        bres.insets = new Insets(3, 3, 3, 3);
        bres.fill = GridBagConstraints.HORIZONTAL;
        lab.setEnabled(false);
        lab.setFont(new Font(lab.getFont().getName(), Font.PLAIN, 24));
        Dimension dim = new Dimension(328, 70);
        lab.setPreferredSize(dim);
        result.add(lab, bres);

        bres.gridx = 3;
        bres.gridy = 0;
        bres.insets = new Insets(3, 3, 3, 3);
        bres.fill = GridBagConstraints.HORIZONTAL;
        Dimension dimLab = new Dimension(105, 70);
        supp.setPreferredSize(dimLab);
        supp.setCursor( Cursor.getPredefinedCursor(12) );
        result.add(supp, bres);

// -------------------Ligne--------------
        Button b1 = new Button("1");
        butList.add(b1);
        Button b2 = new Button("2");
        butList.add(b2);
        Button b3 = new Button("3");
        butList.add(b3);
     //   Button bPlus = new Button("+");
     //   butList.add(bPlus);

// -------------------Ligne--------------
        Button b4 = new Button("4");
        butList.add(b4);
        Button b5 = new Button("5");
        butList.add(b5);
        Button b6 = new Button("6");
        butList.add(b6);
     //   Button bMoins = new Button("-");
     //   butList.add(bMoins);

// -------------------Ligne--------------
        Button b7 = new Button("7");
        butList.add(b7);
        Button b8 = new Button("8");
        butList.add(b8);
        Button b9 = new Button("9");
        butList.add(b9);
     //   Button bMult = new Button("*");
     //   butList.add(bMult);

// -------------------Ligne--------------
        Button bEgal = new Button("=");
        butList.add(bEgal);
        Button b0 = new Button("0");
        butList.add(b0);
        Button bVirg = new Button(".");
        butList.add(bVirg);
     //   Button bDiv = new Button("/");
     //   butList.add(bDiv);

        int i =0;
        int j =1;

        for (Button nb:butList) {
            bc.gridx = i;
            bc.gridy = j;
            bc.insets = new Insets(3, 5, 3, 5);
            Dimension dimBut = new Dimension(120, 70);
            nb.setPreferredSize(dimBut);
            nb.setFont(new Font(tabl.getFont().getName(), Font.PLAIN, 22));
            tabl.add(nb, bc);
            i++;
            if(i==3){
                i=0;
                j++;
            }
        }
    }

    public void initVal() {


        valeurs.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel flag1 = new JLabel();
        Icon im1 = new ImageIcon("./src/flags/eur.png") ;
        flag1.setIcon(im1);
        JLabel flag2 = new JLabel();
        flag2.setIcon(im1);
        JLabel flag3 = new JLabel();
        flag3.setIcon(im1);
        JLabel flag4 = new JLabel();
        flag4.setIcon(im1);

        String[] pays = {"EUR", "USD", "GBP", "CAD", "CHF", "AUD", "INR", "TND", "AED", "GPY"};


        list = new JComboBox(pays);
        list2 = new JComboBox(pays);
        list3 = new JComboBox(pays);
        list4 = new JComboBox(pays);

        list.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        String cygle = (String)combo.getSelectedItem();
                        String image = changeFlag(cygle);
                        flag1.setIcon(new ImageIcon(image));
                    }
                }
        );
        list2.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        String cygle = (String)combo.getSelectedItem();
                        String image = changeFlag(cygle);
                        flag2.setIcon(new ImageIcon(image));
                    }
                }
        );
        list3.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        String cygle = (String)combo.getSelectedItem();
                        String image = changeFlag(cygle);
                        flag3.setIcon(new ImageIcon(image));
                    }
                }
        );
        list4.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        String cygle = (String)combo.getSelectedItem();
                        String image = changeFlag(cygle);
                        flag4.setIcon(new ImageIcon(image));
                    }
                }
        );

        val1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        lab.setText(val1.getText());
                        stockNumVal=1;
                    }
                }
        );
        val2.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        lab.setText(val2.getText());
                        stockNumVal=2;
                    }
                }
        );
        val3.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        lab.setText(val3.getText());
                        stockNumVal=3;
                    }
                }
        );
        val4.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        lab.setText(val4.getText());
                        stockNumVal=4;
                    }
                }
        );


        list.setBackground(Color.CYAN);
        list2.setBackground(Color.CYAN);
        list3.setBackground(Color.CYAN);
        list4.setBackground(Color.CYAN);
        list.setFont(new Font(lab.getFont().getName(), Font.PLAIN, 20));
        list2.setFont(new Font(lab.getFont().getName(), Font.PLAIN, 20));
        list3.setFont(new Font(lab.getFont().getName(), Font.PLAIN, 20));
        list4.setFont(new Font(lab.getFont().getName(), Font.PLAIN, 20));

        JScrollPane listCur1 = new JScrollPane(list);
        JScrollPane listCur2 = new JScrollPane(list2);
        JScrollPane listCur3 = new JScrollPane(list3);
        JScrollPane listCur4 = new JScrollPane(list4);


        Color newC = new Color(30,144,255);
        valeurs.setBackground(newC);


        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(6, 0, 3, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.10;
        flag1.setHorizontalAlignment(JLabel.CENTER);
        valeurs.add(flag1, c);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(6, 5, 3, 5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.35;
        valeurs.add(listCur1, c);
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(6, 6, 3, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.55;
        val1.setFont(new Font(lab.getFont().getName(), Font.PLAIN, 24));
        valeurs.add(val1, c);

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(3, 0, 3, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.10;
        flag2.setHorizontalAlignment(JLabel.CENTER);
        valeurs.add(flag2, c);
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(3, 5, 3, 5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.35;
        valeurs.add(listCur2, c);
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(3, 6, 3, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.55;
        val2.setFont(new Font(lab.getFont().getName(), Font.PLAIN, 24));
        valeurs.add(val2, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(3, 0, 3, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.10;
        flag3.setHorizontalAlignment(JLabel.CENTER);
        valeurs.add(flag3, c);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(3, 5, 3, 5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.35;
        valeurs.add(listCur3, c);
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(3, 6, 3, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.55;
        val3.setFont(new Font(lab.getFont().getName(), Font.PLAIN, 24));
        valeurs.add(val3, c);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(3, 0, 13, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.10;
        flag4.setHorizontalAlignment(JLabel.CENTER);
        valeurs.add(flag4, c);
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(3, 5, 13, 5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.35;
        valeurs.add(listCur4, c);
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(3, 6, 13, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.55;
        val4.setFont(new Font(lab.getFont().getName(), Font.PLAIN, 24));
        valeurs.add(val4, c);

    }

    public String changeFlag(String name) {
        switch (name) {
            case "EUR":
                return new String("./src/flags/eur.png");
            case "USD":
                return new String("./src/flags/usd.png");
            case "GBP":
                return new String("./src/flags/gbp.png");
            case "CAD":
                return new String("./src/flags/cad.png");
            case "CHF":
                return new String("./src/flags/chf.png");
            case "AUD":
                return new String("./src/flags/aud.png");
            case "INR":
                return new String("./src/flags/inr.png");
            case "TND":
                return new String("./src/flags/tnd.png");
            case "AED":
                return new String("./src/flags/aed.png");
            case "GPY":
                return new String("./src/flags/jpy.png");
        }
        return "";
    }
}