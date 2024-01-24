package View;

import Controller.ControllerSepatu;

import javax.swing.*;
import java.awt.*;

public class ViewUpdateInfo extends JFrame{
    ControllerSepatu controllerSepatu = new ControllerSepatu();
    JTextField fieldTipe, fieldJenis, fieldWarna, fieldUkuran, fieldLokasi;
    JLabel labelFoto, labelTipe, judul, subJudul, labelJenis, labelWarna, labelUkuran, labelLokasi;
    JButton submit, backToMenu;

    Font font;

    public ViewUpdateInfo() {
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
        tipe();
        jenis();
        warna();
        ukuran();
        lokasi();
        submit();
        buttonBackToMenu();
    }

    private void judul() {
        judul = new JLabel("Update Data");
        font = new Font("arial", Font.BOLD, 30);
        judul.setFont(font);
        judul.setBounds(190,20,252,50);

        subJudul = new JLabel("lengkapi data dibawah!");
        font = new Font("calibri", NORMAL, 20);
        subJudul.setFont(font);
        subJudul.setBounds(180,60,252,50);

        labelFoto = new JLabel();
        labelFoto.setBounds(512, 0, 576, 576);
        ImageIcon icon = new ImageIcon("img/update1.png");
        Image image = icon.getImage().getScaledInstance(576, 576, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        labelFoto.setIcon(icon);

        add(judul);
        add(subJudul);
        add(labelFoto);
    }

    private void tipe() {
        labelTipe = new JLabel("Tipe");
        font = new Font("calibri", Font.BOLD, 15);
        labelTipe.setFont(font);
        labelTipe.setBounds(40,135,252,50);

        fieldTipe = new JTextField(null);
        fieldTipe.setBounds(150, 145, 252, 25);

        add(labelTipe);
        add(fieldTipe);
    }

    private void jenis() {
        labelJenis = new JLabel("Jenis");
        font = new Font("calibri", Font.BOLD, 15);
        labelJenis.setFont(font);
        labelJenis.setBounds(40,175,252,50);

        fieldJenis = new JTextField(null);
        fieldJenis.setBounds(150, 185, 252, 25);

        add(labelJenis);
        add(fieldJenis);
    }

    private void warna() {
        labelWarna = new JLabel("Warna");
        font = new Font("calibri", Font.BOLD, 15);
        labelWarna.setFont(font);
        labelWarna.setBounds(40,215,252,50);

        fieldWarna = new JTextField(null);
        fieldWarna.setBounds(150, 225, 252, 25);

        add(labelWarna);
        add(fieldWarna);
    }

    private void ukuran() {
        labelUkuran = new JLabel("Ukuran");
        font = new Font("calibri", Font.BOLD, 15);
        labelUkuran.setFont(font);
        labelUkuran.setBounds(40,255,252,50);

        fieldUkuran = new JTextField(null);
        fieldUkuran.setBounds(150, 265, 252, 25);

        add(labelUkuran);
        add(fieldUkuran);
    }

    private void lokasi() {
        labelLokasi = new JLabel("Lokasi (No. Rak)");
        font = new Font("calibri", Font.BOLD, 15);
        labelLokasi.setFont(font);
        labelLokasi.setBounds(40,295,252,50);

        fieldLokasi = new JTextField(null);
        fieldLokasi.setBounds(150, 305, 252, 25);

        add(labelLokasi);
        add(fieldLokasi);
    }

    private void submit(){
        submit = new JButton("Submit");
        submit.setBounds(150, 360, 252, 30);
        Color color = new Color(255, 102, 102);
        submit.setBackground(color);
        submit.setForeground(Color.white);
        submit.addActionListener(e -> actionUpdateInfo());

        add(submit);
    }

    public void actionUpdateInfo() {
        try{
            String tipe = fieldTipe.getText();
            String jenis = fieldJenis.getText();
            String warna = fieldWarna.getText();
            int ukuran = Integer.parseInt(fieldUkuran.getText());
            int lokasi = Integer.parseInt(fieldLokasi.getText());

            if(controllerSepatu.findSepatuByType(tipe)){
                controllerSepatu.updateDataSepatu(tipe, jenis, warna, ukuran, lokasi);
                JOptionPane.showMessageDialog(this,"Data Berhasil Diupdate!", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,"Data Tidak Ditemukan!", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ukuran, dan Lokasi harus berupa angka!", "Informasi", JOptionPane.ERROR_MESSAGE);
        }
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
        ViewUpdateInfo viewTambah = new ViewUpdateInfo();
    }
}
