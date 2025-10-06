import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EjemploJList extends JFrame {
	
	/**
	 * 
	 */
	public static void main(String args[]) {
		EjemploJList ej =new EjemploJList();
	
	}
	

	
	private static final long serialVersionUID = 1L;
	public static class Persona {
		private String nombre;
		private String apellido;
		private int edad;
		
		public Persona(String nombre, String apellido, int edad) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.edad = edad;
		}

		@Override
		public String toString() {
			return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}
		
		
		
	}
	
	
	
	public EjemploJList() {
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ejemplo Listas");
		setSize(640,480);
		setLocationRelativeTo(null);
		
		List<Persona> personas = new ArrayList<Persona>();
		for(int i = 0; i<20; i++) {
			personas.add(new Persona("Nombre"+i, "Apellido"+i, i));
		}
		//List<Persona> personas = List.of(
		//		new Persona("N1","A1",4),
		//		new Persona("N2","A2",12),
		//		new Persona("N3","A3",6));
		
		DefaultListModel<Persona> modeloJListPersonas = new DefaultListModel<EjemploJList.Persona>();
		modeloJListPersonas.addAll(personas);
		
		JList<Persona> jList = new JList<Persona>(modeloJListPersonas);
		JScrollPane scroll = new JScrollPane(jList);
		add(scroll,BorderLayout.WEST);
		
		
		jList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					System.out.println("Ha cambiado la selección");
					Persona p = jList.getSelectedValue();
					System.out.println(p);
				}
				// TODO Auto-generated method stub
			}
		});
		
		
		jList.setCellRenderer(new ListCellRenderer<Persona>() {

			@Override
			public Component getListCellRendererComponent(JList<? extends Persona> jList,
					Persona value, int index, boolean isSelected, boolean cellHasFocus) {
				// TODO Auto-generated method stub
				JLabel label =  new JLabel(value.getNombre());
				
				if(value.getEdad()<18) {
					label.setForeground(Color.red);
				}
				if(index%2==0) {
					
					label.setOpaque(true);
					label.setBackground(new Color(100,100,120));
					
					
				}else {

					label.setOpaque(true);
					label.setBackground(new Color(150,100,120));
				
				}
				
				if(isSelected) {
					label.setBackground(Color.green);
				}
				return label;
				
			}
			
		});
		
		ListCellRenderer<Persona> checkbox = new ListCellRenderer<EjemploJList.Persona>() {
			
			@Override
			public Component getListCellRendererComponent(JList<? extends EjemploJList.Persona> list,
					EjemploJList.Persona value, int index, boolean isSelected, boolean cellHasFocus) {
				// TODO Auto-generated method stub
				return new JCheckBox(value.getNombre() + " " + value.getApellido());
			}
		};
		
		add(jList,BorderLayout.WEST);
		//jList.setCellRenderer(checkbox);
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setVisible(true);
		
		
	}

}

