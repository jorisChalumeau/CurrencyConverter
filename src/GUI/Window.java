package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {
    protected ArrayList<Button> butList =new ArrayList<>();
    protected Button lab=new Button("dff");
    protected JPanel valeurs=new JPanel();
    protected JPanel result= new JPanel();
    protected JPanel tabl=new JPanel();
    protected Button val1 = new Button("kjutkyjuyej");
    protected Button val2 = new Button("1");
    protected Button val3 = new Button("zrzerf");
    protected Button val4 = new Button("4");

    public Window(String title, int height, int width) throws HeadlessException {
        super(title);
        this.setSize(width, height);
        initButton();
        initVal();
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
        Button supp = new Button("supp");
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
        Icon im1 = new ImageIcon("../currency-converter_2017/src/eur.png") ;
        flag1.setIcon(im1);
        JLabel flag2 = new JLabel();
        Icon im2 = new ImageIcon("../currency-converter_2017/src/eur.png") ;
        flag1.setIcon(im1);
        JLabel flag3 = new JLabel();
        Icon im3 = new ImageIcon("../currency-converter_2017/src/eur.png") ;
        flag1.setIcon(im1);
        JLabel flag4 = new JLabel();
        Icon im4 = new ImageIcon("../currency-converter_2017/src/eur.png") ;
        flag1.setIcon(im1);

        String[] pays = {"EUR", "USD", "GBP", "CAD", "CHF", "AUD", "INR", "TND", "AED", "GPY"};


        JComboBox list = new JComboBox(pays);
        JComboBox list2 = new JComboBox(pays);
        JComboBox list3 = new JComboBox(pays);
        JComboBox list4 = new JComboBox(pays);
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
        c.insets = new Insets(6, 0, 3, 0);
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
        c.insets = new Insets(3, 0, 3, 0);
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
        c.insets = new Insets(3, 0, 3, 0);
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
        c.insets = new Insets(3, 0, 13, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.55;
        val4.setFont(new Font(lab.getFont().getName(), Font.PLAIN, 24));
        valeurs.add(val4, c);

   /*     c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(3, 0, 3, 0);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 3;
        JLabel butvide = new JLabel("  ");
        butvide.setFont(new Font(butvide.getFont().getName(), Font.PLAIN, 22));
        valeurs.add(butvide, c);  */

    }

}