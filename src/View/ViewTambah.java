package View;

import Controller.ControllerSepatu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewTambah extends JFrame{
    ControllerSepatu controllerSepatu = new ControllerSepatu();
    JTextField fieldTipe, fieldMerk, fieldJenis, fieldWarna, fieldUkuran, fieldStok, fieldLokasi;
    JLabel labelFoto, labelTipe, judul, subJudul, labelMerk, labelJenis, labelWarna, labelUkuran, labelStok, labelLokasi;
    JButton submit;

    Font font;

    public ViewTambah() {
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
        tipe();
        merk();
        jenis();
        warna();
        ukuran();
        stok();
        lokasi();
        submit();
    }

    private void judul() {
        judul = new JLabel("Tambah Data");
        font = new Font("arial", Font.BOLD, 30);
        judul.setFont(font);
        judul.setBounds(190,20,252,50);

        subJudul = new JLabel("lengkapi data dibawah!");
        font = new Font("calibri", NORMAL, 20);
        subJudul.setFont(font);
        subJudul.setBounds(180,60,252,50);

        labelFoto = new JLabel();
        labelFoto.setBounds(512, 0, 576, 576);
        ImageIcon icon = new ImageIcon("img/create.png");
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

    private void merk() {
        labelMerk = new JLabel("Merk");
        font = new Font("calibri", Font.BOLD, 15);
        labelMerk.setFont(font);
        labelMerk.setBounds(40,175,252,50);

        fieldMerk = new JTextField(null);
        fieldMerk.setBounds(150, 185, 252, 25);

        add(labelMerk);
        add(fieldMerk);
    }

    private void jenis() {
        labelJenis = new JLabel("Jenis");
        font = new Font("calibri", Font.BOLD, 15);
        labelJenis.setFont(font);
        labelJenis.setBounds(40,215,252,50);

        fieldJenis = new JTextField(null);
        fieldJenis.setBounds(150, 225, 252, 25);

        add(labelJenis);
        add(fieldJenis);
    }

    private void warna() {
        labelWarna = new JLabel("Warna");
        font = new Font("calibri", Font.BOLD, 15);
        labelWarna.setFont(font);
        labelWarna.setBounds(40,255,252,50);

        fieldWarna = new JTextField(null);
        fieldWarna.setBounds(150, 265, 252, 25);

        add(labelWarna);
        add(fieldWarna);
    }

    private void ukuran() {
        labelUkuran = new JLabel("Ukuran");
        font = new Font("calibri", Font.BOLD, 15);
        labelUkuran.setFont(font);
        labelUkuran.setBounds(40,295,252,50);

        fieldUkuran = new JTextField(null);
        fieldUkuran.setBounds(150, 305, 252, 25);

        add(labelUkuran);
        add(fieldUkuran);
    }

    private void stok() {
        labelStok = new JLabel("Stok");
        font = new Font("calibri", Font.BOLD, 15);
        labelStok.setFont(font);
        labelStok.setBounds(40,335,252,50);

        fieldStok = new JTextField(null);
        fieldStok.setBounds(150, 345, 252, 25);

        add(labelStok);
        add(fieldStok);
    }

    private void lokasi() {
        labelLokasi = new JLabel("Lokasi (No. Rak)");
        font = new Font("calibri", Font.BOLD, 15);
        labelLokasi.setFont(font);
        labelLokasi.setBounds(40,375,100,50);

        fieldLokasi = new JTextField(null);
        fieldLokasi.setBounds(150, 385, 252, 25);

        add(labelLokasi);
        add(fieldLokasi);
    }

    private void submit(){
        submit = new JButton("Submit");
        submit.setBounds(150, 430, 252, 30);
        Color color = new Color(255, 102, 102);
        submit.setBackground(color);
        submit.setForeground(Color.white);
        submit.addActionListener(e -> actionTambah());

        add(submit);
    }

    public void backToMenu(){
        dispose();
        new ViewDashboard();
    }

    public void actionTambah() {
        try {
            String tipe = fieldTipe.getText();
            String merk = fieldMerk.getText();
            String jenis = fieldJenis.getText();
            String warna = fieldWarna.getText();
            int ukuran = Integer.parseInt(fieldUkuran.getText());
            int stok = Integer.parseInt(fieldStok.getText());
            int lokasi = Integer.parseInt(fieldLokasi.getText());

            if(!controllerSepatu.findSepatuByType(tipe)){
                controllerSepatu.createSepatu(merk, jenis, tipe, warna, ukuran, stok, lokasi);
                JOptionPane.showMessageDialog(this,"Data Berhasil Ditambahkan", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,"Tipe Sepatu Sudah Ada!", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ukuran, Stok, dan Lokasi harus berupa angka!", "Informasi", JOptionPane.ERROR_MESSAGE);
        }

    }



    public static void main(String[] args) {
        new ViewTambah();
    }
}
