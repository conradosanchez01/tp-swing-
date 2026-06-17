package com.mycompany.mavenproject2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio1 {

    public static void iniciar() {
        // 1. Creamos la ventana principal (JFrame) y le damos tamaño
        JFrame ventana = new JFrame("Mi Primer Formulario");
        ventana.setSize(400, 200); 
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // DISPOSE para que no te cierre todo el programa si abrís otras

        // 2. Creamos el contenedor intermedio (JPanel)
        JPanel panel = new JPanel();
        ventana.add(panel); 

        // 3. Creamos y añadimos la etiqueta y el campo de texto (20 columnas)
        JLabel etiquetaInstruccion = new JLabel("Introduce tu nombre:");
        panel.add(etiquetaInstruccion);

        JTextField campoNombre = new JTextField(20);
        panel.add(campoNombre);

        // 4. Creamos el botón y la etiqueta vacía para el resultado
        JButton botonSaludar = new JButton("Saludar");
        panel.add(botonSaludar);

        JLabel etiquetaResultado = new JLabel(""); 
        panel.add(etiquetaResultado);

        // 5. Interacción: Implementamos el ActionListener para el botón
        botonSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                etiquetaResultado.setText("¡Hola, " + nombre + "!");
            }
        });

        // Hacemos visible la ventana
        ventana.setLocationRelativeTo(null); // La centra en la pantalla
        ventana.setVisible(true);
    }
}