package View;

import Controller.ControllerAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewLogin extends JFrame{
    ControllerAdmin controllerAdmin = new ControllerAdmin();
    JTextField fieldUsername;
    JPasswordField fieldPassword;
    JLabel labelFoto, labelUsername, labelPassword, judul, subJudul;
    JButton viewPassword, signIn;

    Font font;

    public ViewLogin() {
        setTitle("Gudang Sepatu Wisteria");
        setSize(1024, 576);
        setLayout(null);
        elements();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void elements() {
        password();
        judul();
        username();
        signIn();
        addAdmin();
    }

    private void judul() {
        judul = new JLabel("Welcome Back");
        font = new Font("arial", Font.BOLD, 35);
        judul.setFont(font);
        judul.setBounds(130,40,252,50);

        subJudul = new JLabel("please enter your detail!");
        font = new Font("calibri", NORMAL, 20);
        subJudul.setFont(font);
        subJudul.setBounds(150,80,252,50);

        labelFoto = new JLabel();
        labelFoto.setBounds(512, 0, 576, 576);
        ImageIcon icon = new ImageIcon("img/login.png");
        Image image = icon.getImage().getScaledInstance(576, 576, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        labelFoto.setIcon(icon);

        add(judul);
        add(subJudul);
        add(labelFoto);
    }

    private void username() {
        labelUsername = new JLabel("Username");
        font = new Font("calibri", Font.BOLD, 18);
        labelUsername.setFont(font);
        labelUsername.setBounds(130,150,252,50);

        fieldUsername = new JTextField(null);
        fieldUsername.setBounds(130, 190, 252, 30);

        add(labelUsername);
        add(fieldUsername);
    }

    private void password() {
        labelPassword = new JLabel("Password");
        font = new Font("calibri", Font.BOLD, 18);
        labelPassword.setFont(font);
        labelPassword.setBounds(130,230,252,50);

        fieldPassword = new JPasswordField(null);
        fieldPassword.setBounds(130, 270, 252, 30);

        viewPassword = new JButton();
        viewPassword.setBounds(350, 270, 30, 30);
        ImageIcon icon2 = new ImageIcon("img/view password.png");
        Image image2 = icon2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(image2);
        viewPassword.setIcon(icon2);
        viewPassword.setFocusPainted(false);
        viewPassword.setOpaque(false);
        viewPassword.setContentAreaFilled(false);
        viewPassword.setBorderPainted(false);
        viewPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Memeriksa apakah password field sedang tersembunyi
                if (fieldPassword.getEchoChar() == '\u2022') {
                    // Jika tersembunyi, tampilkan teks biasa
                    fieldPassword.setEchoChar((char) 0);
                } else {
                    // Jika ditampilkan, gantilah dengan karakter bintang
                    fieldPassword.setEchoChar('\u2022');
                }
            }
        });

        add(viewPassword);
        add(labelPassword);
        add(fieldPassword);
    }

    private void signIn(){
        signIn = new JButton("Sign in");
        signIn.setBounds(130, 350, 252, 40);
        Color color = new Color(255, 102, 102);
        signIn.setBackground(color);
        signIn.setForeground(Color.white);
        signIn.addActionListener(e -> loginAction());

        add(signIn);
    }

    public void addAdmin() {
        controllerAdmin.controllerCreateAdmin("admin1", "pass1");
        controllerAdmin.controllerCreateAdmin("admin2", "pass2");
        controllerAdmin.controllerCreateAdmin("admin3", "pass3");
    }

    public void loginAction () {
        try {
            String username = fieldUsername.getText();
            char[] passwordCharArray = fieldPassword.getPassword();
            String password = new String(passwordCharArray);
            boolean login = controllerAdmin.controllerCekLogin(username, password);
            if (login) {
                JOptionPane.showMessageDialog(this,"Login Berhasil!", "Informasi",JOptionPane.INFORMATION_MESSAGE);
                new ViewDashboard();
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this,"Login Gagal", "informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new ViewLogin();
    }
}
