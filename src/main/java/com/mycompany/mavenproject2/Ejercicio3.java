package com.mycompany.mavenproject2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio3 {

    public static void iniciar() {
        // 1. Ventana Principal: Crea un JFrame con un JPanel
        JFrame ventanaPrincipal = new JFrame("Panel de Control Principal");
        ventanaPrincipal.setSize(400, 200);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panelPrincipal = new JPanel();
        ventanaPrincipal.add(panelPrincipal);

        // Colocamos la JLabel y el JButton solicitados
        JLabel etiquetaOpciones = new JLabel("Opciones seleccionadas: Ninguna");
        JButton botonConfigurar = new JButton("Configurar Preferencias");
        
        panelPrincipal.add(etiquetaOpciones);
        panelPrincipal.add(botonConfigurar);

        // 4. Interacción 1 (Abrir Diálogo): ActionListener al botón principal
        botonConfigurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instanciamos nuestra ventana secundaria pasándole la principal como "dueña"
                VentanaPreferencias dialogo = new VentanaPreferencias(ventanaPrincipal, etiquetaOpciones);
                // Hace que el JDialog se haga visible
                dialogo.setVisible(true); 
            }
        });

        ventanaPrincipal.setVisible(true);
    }
}

// 2. Ventana Secundaria: Clase que herede de JDialog
class VentanaPreferencias extends JDialog {
    
    // Pasamos la etiqueta principal por constructor para poder actualizar su texto desde acá
    public VentanaPreferencias(JFrame padre, JLabel etiquetaAActualizar) {
        // Al invocar al constructor de JDialog pasándole 'true', lo configuramos como MODAL
        super(padre, "Preferencias", true); 
        this.setSize(300, 200);
        this.setLocationRelativeTo(padre); // Centra el diálogo respecto a la ventana principal

        JPanel panelDialogo = new JPanel();
        panelDialogo.setLayout(new FlowLayout());
        this.add(panelDialogo);

        // 3. Añade tres JCheckBox representando diferentes opciones
        JCheckBox chkOscuro = new JCheckBox("Modo Oscuro");
        JCheckBox chkNotif = new JCheckBox("Notificaciones");
        JCheckBox chkAuto = new JCheckBox("Autoguardado");
        
        JButton botonAceptar = new JButton("Aceptar");

        panelDialogo.add(chkOscuro);
        panelDialogo.add(chkNotif);
        panelDialogo.add(chkAuto);
        panelDialogo.add(botonAceptar);

        // 5. Interacción 2 (Procesar Opciones): ActionListener al botón "Aceptar" del JDialog
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 6. Construye una cadena de texto (String) comprobando el estado de cada JCheckBox con isSelected()
                StringBuilder opcionesMarcadas = new StringBuilder();

                if (chkOscuro.isSelected()) {
                    opcionesMarcadas.append("Modo Oscuro, ");
                }
                if (chkNotif.isSelected()) {
                    opcionesMarcadas.append("Notificaciones, ");
                }
                if (chkAuto.isSelected()) {
                    opcionesMarcadas.append("Autoguardado, ");
                }

                // Limpiamos la última coma si se seleccionó algo, o ponemos "Ninguna"
                String textoFinal = opcionesMarcadas.toString();
                if (!textoFinal.isEmpty()) {
                    // Quitamos la última coma y espacio sobrante
                    textoFinal = textoFinal.substring(0, textoFinal.length() - 2);
                } else {
                    textoFinal = "Ninguna";
                }

                // Finalmente, actualiza el texto de la JLabel de la ventana principal
                etiquetaAActualizar.setText("Opciones seleccionadas: " + textoFinal);

                // Cierra el diálogo liberando sus recursos
                dispose();
            }
        });
    }
}