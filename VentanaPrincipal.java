package Practica;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class VentanaPrincipal extends JFrame { 
    private Controlador controlador = new Controlador();
    private JTextField txtNombre, txtCedula, txtEspecifico;
    private JComboBox<String> cmbTipo;
    private JLabel lblEspecifico;
    private JTextArea txtAreaResultado;

    public VentanaPrincipal() {
    	getContentPane().setBackground(new Color(0, 128, 128));
        setTitle("Sistema de Gestión de Empleados - UPS");
        setSize(480, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblTipo = new JLabel("Tipo de Personal:");
        lblTipo.setBounds(30, 20, 120, 25);
        getContentPane().add(lblTipo);

        String[] tipos = {"Administrativo", "Obrero", "Técnico"};
        cmbTipo = new JComboBox<>(tipos);
        cmbTipo.setBounds(160, 20, 250, 25);
        getContentPane().add(cmbTipo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 60, 120, 25);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(160, 60, 250, 25);
        getContentPane().add(txtNombre);

        JLabel lblCedula = new JLabel("Cédula (10 dig):");
        lblCedula.setBounds(30, 100, 120, 25);
        getContentPane().add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(160, 100, 250, 25);
        getContentPane().add(txtCedula);

        lblEspecifico = new JLabel("Cargo:");
        lblEspecifico.setBounds(30, 140, 120, 25);
        getContentPane().add(lblEspecifico);

        txtEspecifico = new JTextField();
        txtEspecifico.setBounds(160, 140, 250, 25);
        getContentPane().add(txtEspecifico);

        cmbTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) cmbTipo.getSelectedItem();
                if ("Administrativo".equals(seleccion)) {
                    lblEspecifico.setText("Cargo:");
                } else if ("Obrero".equals(seleccion)) {
                    lblEspecifico.setText("Código:");
                } else if ("Técnico".equals(seleccion)) {
                    lblEspecifico.setText("Clave Acceso:");
                }
            }
        });

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(160, 180, 115, 30);
        getContentPane().add(btnRegistrar);

        JButton btnListar = new JButton("Listar / Consultar");
        btnListar.setBounds(285, 180, 125, 30);
        getContentPane().add(btnListar);

        txtAreaResultado = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtAreaResultado);
        scroll.setBounds(30, 230, 380, 200);
        getContentPane().add(scroll);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) cmbTipo.getSelectedItem();
                String nombre = txtNombre.getText();
                String cedula = txtCedula.getText();
                String extra = txtEspecifico.getText();
                String respuesta = "";

                if ("Administrativo".equals(tipo)) {
                    respuesta = controlador.registrarAdministrativo(nombre, cedula, extra);
                } else if ("Obrero".equals(tipo)) {
                    respuesta = controlador.registrarObrero(nombre, cedula, extra);
                } else if ("Técnico".equals(tipo)) {
                    respuesta = controlador.registrarTecnico(nombre, cedula, "COD-TECH", extra);
                }
                txtAreaResultado.setText(respuesta);
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAreaResultado.setText(controlador.listarTodos());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}