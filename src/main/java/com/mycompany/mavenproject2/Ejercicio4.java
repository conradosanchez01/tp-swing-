package com.mycompany.mavenproject2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio4 {

    private static final String CONTRASENA_SECRETA = "admin123";

    public static void iniciar() {
        JFrame ventana = new JFrame("Pantalla de Autenticación");
        ventana.setSize(350, 180);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        ventana.add(panel);

        JLabel etiquetaUsuario = new JLabel("  Usuario:");
        JTextField campoUsuario = new JTextField(20);
        
        JLabel etiquetaPassword = new JLabel("  Contraseña:");
        JPasswordField campoPassword = new JPasswordField("", 20);
        
        campoPassword.setEchoChar('*'); 

        JButton botonAcceder = new JButton("Acceder");

        panel.add(etiquetaUsuario);
        panel.add(campoUsuario);
        panel.add(etiquetaPassword);
        panel.add(campoPassword);
        panel.add(new JLabel("")); 
        panel.add(botonAcceder);

        botonAcceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] passwordIngresadaChars = campoPassword.getPassword();
                String passwordIngresada = String.valueOf(passwordIngresadaChars);
                String usuarioIngresado = campoUsuario.getText();

                if (usuarioIngresado.equals("admin") && passwordIngresada.equals(CONTRASENA_SECRETA)) {
                    JOptionPane.showMessageDialog(ventana, "¡Acceso concedido! Bienvenido.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ventana, "Error: Usuario o contraseña incorrectos.", "Fallo de Autenticación", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}