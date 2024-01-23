package View;

import Controller.ControllerSepatu;
import Entity.EntitySepatuSpesifik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ViewCariByMerk extends JFrame {
    ControllerSepatu controllerSepatu = new ControllerSepatu();
    JTextField fieldMerk;
    JLabel labelFoto, labelMerk, judul, subJudul;
    JButton submit;
    private JPanel panelData;
    private JScrollPane scrollPane;

    Font font;

    public ViewCariByMerk() {
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
        merk();
        submit();
        panelData();
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
        ImageIcon icon = new ImageIcon("img/search2.png");
        Image image = icon.getImage().getScaledInstance(576, 576, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        labelFoto.setIcon(icon);

        add(judul);
        add(subJudul);
        add(labelFoto);
    }

    private void merk() {
        labelMerk = new JLabel("Merk");
        font = new Font("calibri", Font.BOLD, 15);
        labelMerk.setFont(font);
        labelMerk.setBounds(100,135,252,50);

        fieldMerk = new JTextField(null);
        fieldMerk.setBounds(150, 145, 252, 25);

        add(labelMerk);
        add(fieldMerk);
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
            String merk = fieldMerk.getText();

            if(controllerSepatu.findSepatuByMerk(merk)){
                ArrayList<EntitySepatuSpesifik> listSepatu = controllerSepatu.readDataSepatu();
                panelData.removeAll();
                for (EntitySepatuSpesifik data : listSepatu) {
                    if(merk.equals(data.getMerk())){
                        JTextArea areaData = new JTextArea();
                        areaData.setEditable(false);

                        areaData.append("Merk \t: " + data.getMerk() + "\n");
                        areaData.append("Jenis \t: " + data.getJenis() + "\n");
                        areaData.append("Tipe \t: " + data.getType() + "\n");
                        areaData.append("Warna \t: " + data.getWarna() + "\n");
                        areaData.append("Ukuran \t: " + data.getUkuran() + "\n");
                        areaData.append("Stok \t: " + data.getStok() + "\n");
                        areaData.append(data.infoLokasi());
                        areaData.append("\n---------------------------------------------------------\n");

                        panelData.add(areaData);
                    }
                }
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

    public void backToMenu(){
        dispose();
        new ViewDashboard();
    }

    public static void main(String[] args) {
        ViewCariByMerk viewHapus = new ViewCariByMerk();
    }
}
