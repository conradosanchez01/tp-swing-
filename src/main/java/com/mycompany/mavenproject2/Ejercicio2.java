package com.mycompany.mavenproject2;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 {
    
    
    // Creamos un método para levantar esta ventana específica
    public static void iniciar() {
    
    
    // 1. Crea un JFrame principal 
        JFrame ventana = new JFrame("Mini Editor de Texto");
        ventana.setSize(500, 400);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // DISPOSE cierra SOLO esta ventana, no todo el programa
  
        
        // 2. Instancia un JMenuBar y fíjala a la ventana 
        JMenuBar barraMenu = new JMenuBar();
        ventana.setJMenuBar(barraMenu);
        
        // 3. Crea un JMenu llamado "Archivo" y añádelo al JMenuBar 
        JMenu menuArchivo = new JMenu("Archivo");
        barraMenu.add(menuArchivo);
        
        // 4. Añade dos opciones instanciando JMenuItem
        JMenuItem itemLimpiar = new JMenuItem("Limpiar texto");
        JMenuItem itemSalir = new JMenuItem("Salir");
        menuArchivo.add(itemLimpiar);
        menuArchivo.add(itemSalir);
      
        // 5. Añade un JTextArea envuelto en un JScrollPane
      JTextArea areaTexto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaTexto); // Le da barras de desplazamiento si es largo
        
            /* Usamos BorderLayout para que el editor ocupe todo el centro 
            de la ventana de forma elegante*/
    
        ventana.setLayout(new BorderLayout());
        ventana.add(scrollPane, BorderLayout.CENTER);
        
    // 6. Interacción: Asocia un ActionListener a cada JMenuItem 
        itemLimpiar.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Si proviene de "Limpiar texto", borra el contenido 
                areaTexto.setText(""); 
             }      
        });
        
        itemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si proviene de "Salir", cierra el programa o la ventana 
                System.exit(0); // Cierra por completo la aplicación 
            }
        });

// Mostramos la ventana
        ventana.setVisible(true);
    }
}
