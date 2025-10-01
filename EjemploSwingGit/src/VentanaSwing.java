import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class VentanaSwing extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		VentanaSwing v = new VentanaSwing();
	
	}
	
	public VentanaSwing() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("ejemplo");
		setSize(640,460);
		setLocationRelativeTo(null);
		
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		JMenu menuFichero = new JMenu("Fichero");
		barraMenu.add(menuFichero);

		JMenuItem itemMostrar = new JMenuItem("Mostrar"); //texto
		JMenuItem itemLimpiar = new JMenuItem("Limpiar");
		JMenuItem itemSalir = new JMenuItem("Exit");
		menuFichero.add(itemMostrar);
		menuFichero.add(itemLimpiar);
		menuFichero.add(itemSalir);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel mainPanel2 = new JPanel(new BorderLayout());
		JPanel mainPanel3 = new JPanel(new BorderLayout());
		
		JPanel infoPersPanel = new JPanel(new GridLayout(2,2,10,10));
		infoPersPanel.setBorder(BorderFactory.createTitledBorder("Información Personal"));
		infoPersPanel.add(new JLabel("Nombre: "), BorderLayout.WEST);
		infoPersPanel.add(new JTextField(15),  BorderLayout.EAST);
		infoPersPanel.add(new JLabel("Email: "));
		infoPersPanel.add(new JTextField(15));
		
		JPanel infoAdiPanel = new JPanel(new GridLayout(4,2,10,10));
		infoAdiPanel.setBorder(BorderFactory.createTitledBorder("Informacion Adicional"));
		infoAdiPanel.add(new JLabel("Telefono:"));
		infoAdiPanel.add(new JTextField(15));
		infoAdiPanel.add(new JLabel("Direccion"));
		infoAdiPanel.add(new JTextField(15));
		infoAdiPanel.add(new JLabel("Ciudad"));
		infoAdiPanel.add(new JTextField(15));
		infoAdiPanel.add(new JLabel("País"));
		JComboBox<String> comboCaja = new JComboBox<String>();
	
		comboCaja.addItem("Seleccione Pais");
		comboCaja.addItem("Espanya");
		infoAdiPanel.add(comboCaja);
		
		JPanel generoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		generoPanel.setBorder(BorderFactory.createTitledBorder("Genero"));
		JRadioButton botonM = new JRadioButton("Masculino");
		JRadioButton botonF = new JRadioButton("Femenino");
		JRadioButton botonO = new JRadioButton("Otro");
		generoPanel.add(botonM);
		generoPanel.add(botonF);
		generoPanel.add(botonO);
	
		JPanel lengPanel = new JPanel(new GridLayout(2,2,10,10));
		lengPanel.setBorder(BorderFactory.createTitledBorder("Lenguajes Programacion"));
		JCheckBox checkjava = new JCheckBox("Java");
		JCheckBox checkpython = new JCheckBox("Python");
		JCheckBox checkjs = new JCheckBox("JavaScript");
		JCheckBox checkc = new JCheckBox("C++");
		lengPanel.add(checkjava);
		lengPanel.add(checkpython);
		lengPanel.add(checkjs);
		lengPanel.add(checkc);
		
		JPanel opcPanel = new JPanel(new GridLayout(3,1,10,10));
		opcPanel.setBorder(BorderFactory.createTitledBorder("Opciones Adicionales"));
		JCheckBox chNotis = new JCheckBox("Recibir notificaciones");
		JCheckBox chSub = new JCheckBox("Suscirbirse al newsletter");
		JCheckBox chActus = new JCheckBox("Notificar actualizaciones");
		opcPanel.add(chNotis);
		opcPanel.add(chSub);
		opcPanel.add(chActus);
		
		JPanel panCom = new JPanel(new BorderLayout());
		panCom.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel coments = new JLabel("Comentarios adicionales: ");
		panCom.add(coments);
		JPanel escr = new JPanel(new GridLayout(1,1,10,10));
		escr.setBorder(BorderFactory.createTitledBorder("Area de texto"));
		JTextArea area = new JTextArea();
		escr.add(area);
		
		
		mainPanel.add(infoAdiPanel);
		mainPanel.add(infoPersPanel, BorderLayout.NORTH);
		mainPanel.add(generoPanel,BorderLayout.SOUTH);
		mainPanel2.add(lengPanel);
		mainPanel2.add(opcPanel, BorderLayout.SOUTH);
		mainPanel3.add(panCom, BorderLayout.NORTH);
		mainPanel3.add(escr);
		
		JButton botonMostrar = new JButton("Mostrar Datos");
		JButton botonLimpiar = new JButton("Limpiar");
		JButton botonSalir = new JButton("Salir");
		
		JPanel panelBotones = new JPanel();
		JTabbedPane panelPestanyas = new JTabbedPane();
		add(panelPestanyas);
		
		panelBotones.add(botonMostrar);
		panelBotones.add(botonLimpiar);
		panelBotones.add(botonSalir);
		add(panelBotones, BorderLayout.SOUTH);
		
		
		panelPestanyas.addTab("Datos Personales", mainPanel);
		panelPestanyas.add("Informacion", mainPanel2);
		panelPestanyas.add("Comentarios", mainPanel3);
		
		
		setVisible(true);
		
	}

}
