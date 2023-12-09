package x;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionDB {

	Connection miConexion = null;	
	
	public Connection EstablecerConexion() {

		try {
			
			miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Tienda","postgres","4582");			
			try (Statement miStatement = miConexion.createStatement()) {
			}

			JOptionPane.showInternalMessageDialog(null, "Conectado");
			
			
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, "Error:"+e.toString() );
		
		}
		
		return miConexion;
		
		
	}
			
			
	
	
}
