package View;

import Controller.ControllerSepatu;
import Entity.EntitySepatuSpesifik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewHapus extends JFrame {
    ControllerSepatu controllerSepatu = new ControllerSepatu();
    JTextField fieldTipe;
    JLabel labelFoto, labelTipe, judul, subJudul;
    JButton submit, backToMenu;

    Font font;

    public ViewHapus() {
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
        submit();
        buttonBackToMenu();
    }

    private void judul() {
        judul = new JLabel("Hapus Data");
        font = new Font("arial", Font.BOLD, 30);
        judul.setFont(font);
        judul.setBounds(190,20,252,50);

        subJudul = new JLabel("lengkapi data dibawah!");
        font = new Font("calibri", NORMAL, 20);
        subJudul.setFont(font);
        subJudul.setBounds(180,60,252,50);

        labelFoto = new JLabel();
        labelFoto.setBounds(512, 0, 576, 576);
        ImageIcon icon = new ImageIcon("img/delete.png");
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
        labelTipe.setBounds(40,200,252,50);

        fieldTipe = new JTextField(null);
        fieldTipe.setBounds(150, 210, 252, 25);

        add(labelTipe);
        add(fieldTipe);
    }
    private void submit(){
        submit = new JButton("Submit");
        submit.setBounds(150, 270, 252, 30);
        Color color = new Color(255, 102, 102);
        submit.setBackground(color);
        submit.setForeground(Color.white);
        submit.addActionListener(e -> actionHapus());

        add(submit);
    }

    public void actionHapus() {
        try {
            String tipe = fieldTipe.getText();
            if(controllerSepatu.findSepatuByType(tipe)){
                controllerSepatu.deleteSepatu(tipe);
                JOptionPane.showMessageDialog(this,"Data Berhasil Dihapus!", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,"Data Tidak Ditemukan!", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException e) {
            throw new RuntimeException(e);
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
        ViewHapus viewHapus = new ViewHapus();
    }
}
