
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal_Pro extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable Tabla;
	private JTextField txtid;
	private JTextField txtPro;
	private JTextField txtPrecio;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_Pro frame = new Principal_Pro();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Principal_Pro() {
		setBackground(new Color(0, 0, 64));
		setTitle("Tienda");
		
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 254, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 232, 243));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 212, 405);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 50, 74, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Producto:\r\n");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(10, 75, 66, 14);
		panel.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:\r\n\t\t");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(10, 100, 74, 14);
		panel.add(lblPrecio);
		
		txtid = new JTextField();
		txtid.setBackground(new Color(255, 185, 220));
		txtid.setBounds(100, 49, 102, 20);
		panel.add(txtid);
		txtid.setColumns(10);
		
		txtPro = new JTextField();
		txtPro.setBackground(new Color(255, 185, 220));
		txtPro.setColumns(10);
		txtPro.setBounds(100, 74, 102, 20);
		panel.add(txtPro);
		
		txtPrecio = new JTextField();
		txtPrecio.setBackground(new Color(255, 185, 220));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(100, 99, 102, 20);
		panel.add(txtPrecio);
		
		JButton btnGuardar = new JButton("GUARDAR\r\n");
		btnGuardar.setBackground(new Color(255, 147, 255));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto objetProductos = new Producto();
				objetProductos.insertarProducto(txtid, txtPro,txtPrecio);
				objetProductos.MostarProductos(Tabla);
				
			}
		});
		btnGuardar.setBounds(10, 264, 192, 23);
		panel.add(btnGuardar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(255, 147, 255));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Producto insertarProductos = new Producto();
				insertarProductos.EliminarProductos(txtid);
				insertarProductos.MostarProductos(Tabla);
				
			}
			
		});
		
		btnEliminar.setBounds(10, 306, 192, 23);
		panel.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBackground(new Color(255, 147, 255));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Producto insertarProductos = new Producto();
				insertarProductos.ModificarIngredientes	(txtid, txtPro,txtPrecio);
				insertarProductos.MostarProductos(Tabla);
				
			}
		});
		btnModificar.setBounds(10, 352, 192, 23);
		panel.add(btnModificar);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBackground(new Color(255, 153, 204));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtid.setText(null);
				txtPro.setText(null);
				txtPrecio.setText(null);
				
			}
		});
		btnLimpiar.setBounds(10, 219, 192, 23);
		panel.add(btnLimpiar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(129, 214, 254));
		panel_1.setBorder(new TitledBorder(null, "Listade Ingredientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(232, 11, 402, 405);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
	
		
		Tabla = new JTable();
		Tabla.setBackground(new Color(210, 255, 255));
		Tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Producto insertarProductos = new Producto();
				insertarProductos.SelecionarProducto(Tabla, txtid, txtPro, txtPrecio);
			}
		});
		Tabla.setBounds(10, 47, 382, 347);
		panel_1.add(Tabla);
		
		
		this.setLocationRelativeTo(null);
		
		Producto objetoProductos = new Producto();
		objetoProductos.MostarProductos(Tabla);
	}
}