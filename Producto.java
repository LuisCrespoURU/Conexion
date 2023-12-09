package x;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Producto {

	private int id;
	private String Productos;
	private float Precio;
	
	
	public int getid() {
		return id;
	}
	public void setID(int ID) {
		id = ID;
	}
	public String getProductos() {
		return Productos;
	}
	public void setNombres(String producto) {
		Productos = producto;
	}
	public float getPrecio() {
		return Precio;
	}
	public void setPrecio(float precio) {
		Precio = precio;
	}

	
	
	public void MostarProductos(JTable paramTablaTotalProducto) {
		
		ConexionDB objetoConexion = new ConexionDB();
		
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		String sql = "";
		
		modelo.addColumn("id");
		modelo.addColumn("Productos");
		modelo.addColumn("Precio");
		
		paramTablaTotalProducto.setModel(modelo);
		
		String[] cabeceras = {"ID", "PRODUCTOS","PRECIO"};
		modelo.addRow(cabeceras);
		
		
		sql = "Select * from /Productos/;";
		
		String [] datos = new String [3];
		Statement miStatement;
		
		try {
			
			miStatement = objetoConexion.EstablecerConexion().createStatement();
			
			
			ResultSet rs = miStatement.executeQuery(sql);
			
			while(rs.next()) {
			 
				
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				
				modelo.addRow(datos);
				
				
				
				
			}
			
			paramTablaTotalProducto.setModel(modelo);
			
			
			
			
		} catch (Exception e) {

			JOptionPane.showInternalMessageDialog(null, "Error: "+e.toString());
			
			
			
		
		}
		
		
		
	}
	
	
	public void insertarIngrediente(JTextField paramID,JTextField paramNombres, JTextField paramPrecio) {
		
		setID(Integer.parseInt(paramID.getText()));
		setNombres(paramNombres.getText());
		setPrecio(Float.parseFloat(paramPrecio.getText()));
		
		ConexionDB objetoConexion = new ConexionDB();
		String Consulta ="INSERT INTO public.ingredientes(id_ingrediente, nom_ingrediente, precio_ingrediente)VALUES (?,?, ?);";
		
		
		try {
			
			CallableStatement cs = objetoConexion.EstablecerConexion().prepareCall(Consulta);
			cs.setInt(1, getid());
			cs.setString(2, getProductos());
			cs.setFloat(3, getPrecio());
		

			cs.execute();
			 JOptionPane.showInternalMessageDialog(null, "Se inserto Correctamente");
			
		} catch (Exception e) {

			JOptionPane.showInternalMessageDialog(null, "Error: "+e.toString());
			
			
		
		}
		
		
	}
	
	
	public 	void SelecionarProducto(JTable paramTablaTotalProducto, JTextField paramid, JTextField paramProducto, JTextField paramPrecio) {
		
		try {
		
			
			int fila = paramTablaTotalProducto.getSelectedRow();
			
			if (fila>=0) {
				
				paramid.setText( paramTablaTotalProducto.getValueAt(fila, 0).toString());
				paramProducto.setText( paramTablaTotalProducto.getValueAt(fila, 1).toString());
				paramPrecio.setText( paramTablaTotalProducto.getValueAt(fila, 2).toString());
 
				
				
				
			}else {
				
				JOptionPane.showInternalMessageDialog(null, "Fila no Selecionada");

				
			}
			
			
			
		} catch (Exception e) {
			
			JOptionPane.showInternalMessageDialog(null, "Error: "+e.toString());


		
		}
		
	}
	
public void ModificarIngredientes(JTextField paramid,JTextField paramProducto, JTextField paramPrecio) {
		
		setID(Integer.parseInt(paramid.getText()));
		setNombres(paramProducto.getText());
		setPrecio(Float.parseFloat(paramPrecio.getText()));
		
		ConexionDB objetoConexion = new ConexionDB();
		String Consulta ="UPDATE public.Productos SET nom_Producto=?, precio_Producto=? WHERE id_Producto = ?";
		
		
		try {
			
			CallableStatement cs = objetoConexion.EstablecerConexion().prepareCall(Consulta);
			
			cs.setString(1, getProductos());
			cs.setFloat(2, getPrecio());
			cs.setInt(3, getid());


		

			cs.execute();
			 JOptionPane.showInternalMessageDialog(null, "Se inserto Correctamente");
			
		} catch (Exception e) {

			JOptionPane.showInternalMessageDialog(null, "Error: "+e.toString());
			
			
		
		}
		
		
	}

public void EliminarIngrediente(JTextField paramID) {
	
	setID(Integer.parseInt(paramID.getText()));
	
	ConexionDB objetoConexion = new ConexionDB();
	String Consulta ="DELETE FROM public.ingredientes WHERE id_ingrediente =?;";
	
	
	try {
		
		CallableStatement cs = objetoConexion.EstablecerConexion().prepareCall(Consulta);
		cs.setInt(1, getid());


	

		cs.execute();
		 JOptionPane.showInternalMessageDialog(null, "Se Elimino Correctamente");
		
	} catch (Exception e) {

		JOptionPane.showInternalMessageDialog(null, "Error: "+e.toString());
		
		
	
	}
	
	
}

	
}
	
	
	
	
	
