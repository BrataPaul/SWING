package org.example;

import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class MyFrame extends JFrame {

    private JRadioButton fata;
    private JRadioButton spate;
    private JRadioButton integrala;

    MyFrame() {
        JPanel primaLinie = new JPanel();
        primaLinie.setBounds(0, 0, 750, 50);

        JLabel titlu = new JLabel("Formular Masina");
        titlu.setFont(new Font("Dialog", Font.PLAIN, 30));

        JPanel liniaDoi = new JPanel();
        liniaDoi.setBounds(0, 100, 750, 50);
        liniaDoi.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));

        JLabel nume = new JLabel("Nume:");
        nume.setFont(new Font("Dialog", Font.PLAIN, 30));

        JTextField numeText = new JTextField();
        numeText.setPreferredSize(new Dimension(300, 40));

        JPanel liniaTrei = new JPanel();
        liniaTrei.setBounds(0, 150, 750, 50);
        liniaTrei.setLayout(new FlowLayout(FlowLayout.CENTER, 45, 0));

        JLabel hp = new JLabel("Cai putere:");
        hp.setFont(new Font("Dialog", Font.PLAIN, 30));

        JTextField hpText = new JTextField();
        hpText.setPreferredSize(new Dimension(300, 40));

        JPanel liniaPatru = new JPanel();
        liniaPatru.setBounds(0, 250, 750, 50);

        JLabel tractiune = new JLabel("Tractiune:");
        tractiune.setFont(new Font("Dialog", Font.PLAIN, 30));

        JPanel liniaCinci = new JPanel();
        liniaCinci.setBounds(0, 300, 750, 50);
        liniaCinci.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));

        fata = new JRadioButton("Fata");
        spate = new JRadioButton("Spate");
        integrala = new JRadioButton("Integrala");
        fata.setFont(new Font("Dialog", Font.PLAIN, 20));
        spate.setFont(new Font("Dialog", Font.PLAIN, 20));
        integrala.setFont(new Font("Dialog", Font.PLAIN, 20));

        ButtonGroup group = new ButtonGroup();
        group.add(fata);
        group.add(spate);
        group.add(integrala);

        JLabel caroserie = new JLabel("Caroserie:");
        caroserie.setFont(new Font("Dialog", Font.PLAIN, 30));

        JPanel liniaSase = new JPanel();
        liniaSase.setBounds(0, 400, 750, 60);

        String[] caroserieAlegere = {"Combi", "Sedan", "Coupe", "Cabrio", "SUV"};
        JComboBox<String> comboBox = new JComboBox<>(caroserieAlegere);
        comboBox.setFont(new Font("Dialog", Font.PLAIN, 20));

        JPanel liniaSapte = new JPanel();
        liniaSapte.setBounds(0, 650, 750, 70);

        JButton save = new JButton("SAVE");
        save.setFont(new Font("Dialog", Font.PLAIN, 25));
        JButton cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Dialog", Font.PLAIN, 25));

        // Adăugare ActionListener pentru butonul de salvare
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvareDateJSON(numeText.getText(), hpText.getText(), getTractiuneSelectata(), (String) comboBox.getSelectedItem());
            }
        });

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
        this.setSize(750, 750);

        this.setVisible(true);
    }

    private String getTractiuneSelectata() {
        if (fata.isSelected()) {
            return "Fata";
        } else if (spate.isSelected()) {
            return "Spate";
        } else if (integrala.isSelected()) {
            return "Integrala";
        }
        return "";
    }

    private void salvareDateJSON(String nume, String caiPutere, String tractiune, String caroserie) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Nume", nume);
        jsonObject.put("Cai putere", caiPutere);
        jsonObject.put("Tractiune", tractiune);
        jsonObject.put("Caroserie", caroserie);

        try (FileWriter fileWriter = new FileWriter("date_masini.json", true)) {
            fileWriter.write(jsonObject.toJSONString() + "\n");
            fileWriter.flush();
            JOptionPane.showMessageDialog(this, "Datele au fost salvate cu succes!");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "A apărut o eroare la salvarea datelor.", "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }
}
