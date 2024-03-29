package View;

import Controller.ControllerSepatu;
import Entity.EntitySepatuSpesifik;

import javax.swing.*;
import java.awt.*;

public class ViewCariByTipe extends JFrame {
    ControllerSepatu controllerSepatu = new ControllerSepatu();
    JTextField fieldTipe;
    JLabel labelFoto, labelTipe, judul, subJudul;
    JButton submit, backToMenu;
    private JPanel panelData;
    private JScrollPane scrollPane;

    Font font;

    public ViewCariByTipe() {
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
        panelData();
        buttonBackToMenu();
    }

    private void judul() {
        judul = new JLabel("Cari Data");
        font = new Font("arial", Font.BOLD, 30);
        judul.setFont(font);
        judul.setBounds(190,20,252,50);

        subJudul = new JLabel("lengkapi data dibawah!");
        font = new Font("calibri", NORMAL, 20);
        subJudul.setFont(font);
        subJudul.setBounds(180,60,252,50);

        labelFoto = new JLabel();
        labelFoto.setBounds(512, 0, 576, 576);
        ImageIcon icon = new ImageIcon("img/search1.png");
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
        labelTipe.setBounds(100,135,252,50);

        fieldTipe = new JTextField(null);
        fieldTipe.setBounds(150, 145, 252, 25);

        add(labelTipe);
        add(fieldTipe);
    }
    private void submit(){
        submit = new JButton("Cari");
        submit.setBounds(150, 190, 252, 30);
        Color color = new Color(255, 102, 102);
        submit.setBackground(color);
        submit.setForeground(Color.white);
        submit.addActionListener(e -> actionCari());

        add(submit);
    }

    public void actionCari() {
        try {
            String tipe = fieldTipe.getText();

            if(controllerSepatu.findSepatuByType(tipe)){
                EntitySepatuSpesifik data = controllerSepatu.dataSepatu(tipe);
                JTextArea areaData = new JTextArea();
                areaData.setEditable(false);

                areaData.append(data.cetakInfo());
                areaData.append("\n-------------------------------------------------------------\n");

                panelData.removeAll();
                panelData.add(areaData);

                JOptionPane.showMessageDialog(this,"Data Ditemukan", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,"Data Tidak Ditemukan!", "Informasi",JOptionPane.INFORMATION_MESSAGE);
                panelData.removeAll();
            }

            panelData.revalidate();
            panelData.repaint();
        } catch (HeadlessException e) {
            throw new RuntimeException(e);
        }
    }

    private void panelData() {
        panelData = new JPanel();
        panelData.setLayout(new GridLayout(0, 1));
        scrollPane = new JScrollPane(panelData);
        scrollPane.setBounds(150, 250, 250, 250);
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
        ViewCariByTipe viewHapus = new ViewCariByTipe();
    }
}
