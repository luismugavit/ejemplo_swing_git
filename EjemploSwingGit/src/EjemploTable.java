import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class EjemploTable extends JFrame{

	
	/**
	 * 
	 */
	
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
	public EjemploTable() {
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ejemplo Tablas");
		setSize(640,480);
		setLocationRelativeTo(null);
		
		List<Persona> personas = new ArrayList<EjemploTable.Persona>();
		for(int i = 0; i<100; i++) {
			personas.add(new Persona("N"+i, "A"+1, i));
		}
		JTable jtable = new JTable();
		add(jtable, BorderLayout.CENTER);
		
		jtable.setModel(new ModeloTabla(personas));
		
		setVisible(true);
	}
	
	public class ModeloTabla extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private List<Persona> personas;
		
		private String[] cabecera = {
				"Nombre",
				"Apellido",
				"edad"
		};
		public ModeloTabla(List<Persona> personas) {
			this.personas = personas;
		}
		
		@Override
		public String getColumnName(int column) {
			return cabecera[column];
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 2;
		}
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			
			return personas.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 3;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Persona p = personas.get(rowIndex);
			
			switch(columnIndex) {
				case 0: return p.getNombre();
				case 1: return p.getApellido();
				case 2: return p.getEdad();
			}
			return null;
		}
		
		
	}
	
	public static void main(String[] args) {
		new EjemploTable();

	}

}
