package org.example;

import javax.swing.*;
import java.awt.*;
import javax.swing.JComboBox;

public class MyFrame extends JFrame {

    MyFrame() {
        JPanel primaLinie = new JPanel();
        primaLinie.setBounds(0,0,750,50);

        JLabel titlu = new JLabel("Formular Masina");
        titlu.setFont(new Font("Dialog",Font.PLAIN,30));

        JPanel liniaDoi = new JPanel();
        liniaDoi.setBounds(0,100,750,50);
        liniaDoi.setLayout(new FlowLayout(FlowLayout.CENTER,100,0));


        JLabel nume = new JLabel("Nume:");
        nume.setFont(new Font("Dialog",Font.PLAIN,30));


        JTextField numeText = new JTextField();
        numeText.setPreferredSize(new Dimension(300,40));

        JPanel liniaTrei = new JPanel();
        liniaTrei.setBounds(0,150,750,50);
        liniaTrei.setLayout(new FlowLayout(FlowLayout.CENTER,45,0));

        JLabel hp = new JLabel("Cai putere:");
        hp.setFont(new Font("Dialog",Font.PLAIN,30));


        JTextField hpText = new JTextField();
        hpText.setPreferredSize(new Dimension(300,40));

        JPanel liniaPatru = new JPanel();
        liniaPatru.setBounds(0,250,750,50);

        JLabel tractiune = new JLabel("Tractiune:");
        tractiune.setFont(new Font("Dialog",Font.PLAIN,30));

        JPanel liniaCinci = new JPanel();
        liniaCinci.setBounds(0,300,750,50);
        liniaCinci.setLayout(new FlowLayout(FlowLayout.CENTER,100,0));

        JRadioButton fata = new JRadioButton("Fata");
        JRadioButton spate = new JRadioButton("Spate");
        JRadioButton integrala = new JRadioButton("Integrala");
        fata.setFont(new Font("Dialog",Font.PLAIN,20));
        spate.setFont(new Font("Dialog",Font.PLAIN,20));
        integrala.setFont(new Font("Dialog",Font.PLAIN,20));

        ButtonGroup group = new ButtonGroup();
        group.add(fata);
        group.add(spate);
        group.add(integrala);

        JLabel caroserie = new JLabel("Caroserie:");
        caroserie.setFont(new Font("Dialog",Font.PLAIN,30));

        JPanel liniaSase = new JPanel();
        liniaSase.setBounds(0,400,750,60);


        String[] caroserieAlegere = {"Combi","Sedan","Coupe","Cabrio","SUV"};
        JComboBox comboBox = new JComboBox(caroserieAlegere);
        comboBox.setFont(new Font("Dialog",Font.PLAIN,20));

        JPanel liniaSapte = new JPanel();
        liniaSapte.setBounds(0,650,750,70);

        JButton save = new JButton("SAVE");
        save.setFont(new Font("Dialog",Font.PLAIN,25));
        JButton cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Dialog",Font.PLAIN,25));



        primaLinie.add(titlu);
        liniaDoi.add(nume);
        liniaDoi.add(numeText);
        liniaTrei.add(hp);
        liniaTrei.add(hpText);
        liniaPatru.add(tractiune);
        liniaCinci.add(fata);
        liniaCinci.add(spate);
        liniaCinci.add(integrala);
        liniaSase.add(caroserie);
        liniaSase.add(comboBox);
        liniaSapte.add(save);
        liniaSapte.add(cancel);
        this.add(liniaDoi);
        this.add(liniaTrei);
        this.add(liniaPatru);
        this.add(liniaCinci);
        this.add(liniaSase);
        this.add(liniaSapte);
        this.setTitle("Formular");
        this.add(primaLinie);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(750,750);

        this.setVisible(true);
    }
}
