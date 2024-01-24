package View;

import Controller.ControllerSepatu;
import Entity.EntitySepatuSpesifik;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewTampilSemuaData extends JFrame{
    ControllerSepatu controllerSepatu = new ControllerSepatu();
    JLabel labelFoto, judul, subJudul;
    private JPanel panelData;
    private JScrollPane scrollPane;
    private JButton backToMenu;

    Font font;

    public ViewTampilSemuaData() {
        setTitle("Gudang Sepatu Wisteria");
        setSize(1024, 576);
        setLayout(null);
        elements();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void elements() {
        judul();
        panelData();
        buttonBackToMenu();
    }

    private void judul() {
        judul = new JLabel("Data Semua Sepatu");
        font = new Font("arial", Font.BOLD, 30);
        judul.setFont(font);
        judul.setBounds(150,20,500,50);

        subJudul = new JLabel("berikut adalah semua data yang ada!");
        font = new Font("calibri", NORMAL, 20);
        subJudul.setFont(font);
        subJudul.setBounds(140,60,500,50);

        labelFoto = new JLabel();
        labelFoto.setBounds(512, 0, 576, 576);
        ImageIcon icon = new ImageIcon("img/read.png");
        Image image = icon.getImage().getScaledInstance(576, 576, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        labelFoto.setIcon(icon);

        add(judul);
        add(subJudul);
        add(labelFoto);
    }

    private void panelData() {
        panelData = new JPanel();
        panelData.setLayout(new GridLayout(0, 1));
//        controllerSepatu.createSepatu("a","a","a","a",1,1,1);
//        controllerSepatu.createSepatu("a","a","b","a",1,1,1);
//        controllerSepatu.createSepatu("a","a","c","a",1,1,1);
        ArrayList<EntitySepatuSpesifik> listSepatu = controllerSepatu.readDataSepatu();

        for (EntitySepatuSpesifik data : listSepatu) {
            JTextArea areaData = new JTextArea();
            areaData.setEditable(false);

            areaData.append(data.cetakInfo());
            areaData.append("\n--------------------------------------------------------------------------------\n");

            panelData.add(areaData);
        }
        scrollPane = new JScrollPane(panelData);
        scrollPane.setBounds(120, 150, 350, 350);
        add(scrollPane);
    }

    public void buttonBackToMenu() {
        backToMenu = new JButton();
        backToMenu.setBounds(20, 20, 30,30 );
        ImageIcon icon = new ImageIcon("img/back.png");
        Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        backToMenu.setIcon(icon);
        backToMenu.setContentAreaFilled(false);
        backToMenu.setBorderPainted(false);
        backToMenu.addActionListener(e -> backToMenu());

        add(backToMenu);
    }
    public void backToMenu(){
        dispose();
        new ViewDashboard();
    }

    public static void main(String[] args) {
        ViewTampilSemuaData viewHapus = new ViewTampilSemuaData();
    }
}
