package View;

import Controller.ControllerSepatu;
import Entity.EntitySepatuSpesifik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ViewTampilSemuaData extends JFrame{
    ControllerSepatu controllerSepatu = new ControllerSepatu();
    JLabel labelFoto, judul, subJudul;
    private JPanel panelData;
    private JScrollPane scrollPane;

    Font font;

    public ViewTampilSemuaData() {
        setTitle("Gudang Sepatu Wisteria");
        setSize(1024, 576);
        setLayout(null);
        elements();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                backToMenu();
            }
        });
    }

    private void elements() {
        judul();
        panelData();
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

            areaData.append("Merk \t: " + data.getMerk() + "\n");
            areaData.append("Jenis \t: " + data.getJenis() + "\n");
            areaData.append("Tipe \t: " + data.getType() + "\n");
            areaData.append("Warna \t: " + data.getWarna() + "\n");
            areaData.append("Ukuran \t: " + data.getUkuran() + "\n");
            areaData.append("Stok \t: " + data.getStok() + "\n");
            areaData.append(data.infoLokasi());
            areaData.append("\n--------------------------------------------------------------------------------------\n");

            panelData.add(areaData);
        }
        scrollPane = new JScrollPane(panelData);
        scrollPane.setBounds(120, 150, 350, 350);
        add(scrollPane);
    }

    public void backToMenu(){
        dispose();
        new ViewDashboard();
    }

    public static void main(String[] args) {
        ViewTampilSemuaData viewHapus = new ViewTampilSemuaData();
    }
}
