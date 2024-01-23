package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDashboard extends JFrame{

    JLabel labelFoto, judul, subJudul, ketMenuTambah, ketMenuTampil, ketMenuUpdateInfo, ketMenuUpdateStok, ketMenuHapus, ketMenuCariByTipe, ketMenuCariByMerk, ketMenuQuit;
    JButton menuTambah, menuTampil, menuUpdateInfo, menuUpdateStok, menuHapus, menuCariByTipe, menuCariByMerk, menuQuit;

    Font font;

    public ViewDashboard() {
        setTitle("Gudang Sepatu Wisteria");
        setSize(1024, 576);
        setLayout(null);
        elements();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void elements() {
        menuTambah();
        menuTampil();
        menuUpdateInfo();
        menuUpdateStok();
        menuHapus();
        menuCariByTipe();
        menuCariByMerk();
        menuQuit();
        judul();
    }

    private void judul() {
        judul = new JLabel("GUDANG SEPATU WISTERIA");
        font = new Font("arial", Font.BOLD, 35);
        judul.setFont(font);
        judul.setBounds(260,40,504,50);

        subJudul = new JLabel("Pilih menu yang tersedia!");
        font = new Font("calibri", NORMAL, 20);
        subJudul.setFont(font);
        subJudul.setBounds(400,80,252,50);

        labelFoto = new JLabel();
        labelFoto.setBounds(512, 0, 576, 576);
        ImageIcon icon = new ImageIcon("img/bg.png");
        Image image = icon.getImage().getScaledInstance(576, 576, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        labelFoto.setIcon(icon);

        add(judul);
        add(subJudul);
        add(labelFoto);
    }

    private void menuTambah() {
        ketMenuTambah = new JLabel("Tambah Data");
        font = new Font("calibri", Font.BOLD, 18);
        ketMenuTambah.setFont(font);
        ketMenuTambah.setBounds(130,275,150,50);
        Color color = new Color(150, 50, 50);
        ketMenuTambah.setForeground(color);

        menuTambah = new JButton();
        menuTambah.setBounds(130, 180, 100,100 );
        ImageIcon icon = new ImageIcon("img/create.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        menuTambah.setIcon(icon);
        menuTambah.setContentAreaFilled(false);
        menuTambah.addActionListener(e -> actionMenu1());

        add(menuTambah);
        add(ketMenuTambah);
    }

    private void menuTampil() {
        ketMenuTampil = new JLabel("Tampilkan Semua Data");
        font = new Font("calibri", Font.BOLD, 18);
        ketMenuTampil.setFont(font);
        ketMenuTampil.setBounds(315,275,200,50);
        Color color = new Color(150, 50, 50);
        ketMenuTampil.setForeground(color);

        menuTampil = new JButton();
        menuTampil.setBounds(345, 180, 100,100 );
        ImageIcon icon = new ImageIcon("img/read.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        menuTampil.setIcon(icon);
        menuTampil.setContentAreaFilled(false);
        menuTampil.addActionListener(e -> actionMenu2());

        add(menuTampil);
        add(ketMenuTampil);
    }

    private void menuUpdateInfo() {
        ketMenuUpdateInfo = new JLabel("Update Data");
        font = new Font("calibri", Font.BOLD, 18);
        ketMenuUpdateInfo.setFont(font);
        ketMenuUpdateInfo.setBounds(560,275,150,50);
        Color color = new Color(150, 50, 50);
        ketMenuUpdateInfo.setForeground(color);

        menuUpdateInfo = new JButton();
        menuUpdateInfo.setBounds(560, 180, 100,100 );
        ImageIcon icon = new ImageIcon("img/update1.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        menuUpdateInfo.setIcon(icon);
        menuUpdateInfo.setContentAreaFilled(false);
        menuUpdateInfo.addActionListener(e -> actionMenu3());

        add(menuUpdateInfo);
        add(ketMenuUpdateInfo);
    }

    private void menuUpdateStok() {
        ketMenuUpdateStok = new JLabel("Update Stok");
        font = new Font("calibri", Font.BOLD, 18);
        ketMenuUpdateStok.setFont(font);
        ketMenuUpdateStok.setBounds(775,275,150,50);
        Color color = new Color(150, 50, 50);
        ketMenuUpdateStok.setForeground(color);

        menuUpdateStok = new JButton();
        menuUpdateStok.setBounds(775, 180, 100,100 );
        ImageIcon icon = new ImageIcon("img/update2.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        menuUpdateStok.setIcon(icon);
        menuUpdateStok.setContentAreaFilled(false);
        menuUpdateStok.addActionListener(e -> actionMenu4());

        add(menuUpdateStok);
        add(ketMenuUpdateStok);
    }

    private void menuHapus() {
        ketMenuHapus = new JLabel("Hapus Data");
        font = new Font("calibri", Font.BOLD, 18);
        ketMenuHapus.setFont(font);
        ketMenuHapus.setBounds(135,450,150,50);
        Color color = new Color(150, 50, 50);
        ketMenuHapus.setForeground(color);

        menuHapus = new JButton();
        menuHapus.setBounds(130, 350, 100,100 );
        ImageIcon icon = new ImageIcon("img/delete.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        menuHapus.setIcon(icon);
        menuHapus.setContentAreaFilled(false);
        menuHapus.addActionListener(e -> actionMenu5());

        add(menuHapus);
        add(ketMenuHapus);
    }

    private void menuCariByTipe() {
        ketMenuCariByTipe = new JLabel(" Cari Data (Tipe)");
        font = new Font("calibri", Font.BOLD, 18);
        ketMenuCariByTipe.setFont(font);
        ketMenuCariByTipe.setBounds(335,450,200,50);
        Color color = new Color(150, 50, 50);
        ketMenuCariByTipe.setForeground(color);

        menuCariByTipe = new JButton();
        menuCariByTipe.setBounds(345, 350, 100,100 );
        ImageIcon icon = new ImageIcon("img/search1.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        menuCariByTipe.setIcon(icon);
        menuCariByTipe.setContentAreaFilled(false);
        menuCariByTipe.addActionListener(e -> actionMenu6());

        add(menuCariByTipe);
        add(ketMenuCariByTipe);
    }

    private void menuCariByMerk() {
        ketMenuCariByMerk = new JLabel(" Cari Data (Merk)");
        font = new Font("calibri", Font.BOLD, 18);
        ketMenuCariByMerk.setFont(font);
        ketMenuCariByMerk.setBounds(545,450,150,50);
        Color color = new Color(150, 50, 50);
        ketMenuCariByMerk.setForeground(color);

        menuCariByMerk = new JButton();
        menuCariByMerk.setBounds(560, 350, 100,100 );
        ImageIcon icon = new ImageIcon("img/search2.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        menuCariByMerk.setIcon(icon);
        menuCariByMerk.setContentAreaFilled(false);
        menuCariByMerk.addActionListener(e -> actionMenu7());

        add(menuCariByMerk);
        add(ketMenuCariByMerk);
    }

    private void menuQuit() {
        ketMenuQuit = new JLabel("QUIT");
        font = new Font("calibri", Font.BOLD, 18);
        ketMenuQuit.setFont(font);
        ketMenuQuit.setBounds(800,450,150,50);
        Color color = new Color(150, 50, 50);
        ketMenuQuit.setForeground(color);

        menuQuit = new JButton();
        menuQuit.setBounds(775, 350, 100,100 );
        ImageIcon icon = new ImageIcon("img/quit.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        menuQuit.setIcon(icon);
        menuQuit.setContentAreaFilled(false);
        menuQuit.addActionListener(e -> actionMenu8());

        add(menuQuit);
        add(ketMenuQuit);
    }

    public void actionMenu1() {
        new ViewTambah();
        setVisible(false);
    }
    public void actionMenu2() {
        new ViewTampilSemuaData();
        setVisible(false);
    }
    public void actionMenu3() {
        new ViewUpdateInfo();
        setVisible(false);
    }
    public void actionMenu4() {
        new ViewUpdateStok();
        setVisible(false);
    }
    public void actionMenu5() {
        new ViewHapus();
        setVisible(false);
    }
    public void actionMenu6() {
        new ViewCariByTipe();
        setVisible(false);
    }
    public void actionMenu7() {
        new ViewCariByMerk();
        setVisible(false);
    }
    public void actionMenu8() {
        JOptionPane.showMessageDialog(this,"Terimakasih!", "Informasi",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void main(String[] args) {
        new ViewDashboard();
    }
}
