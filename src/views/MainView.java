package views;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.MainController;
import models.Item;
import models.MainModel;
import vendor.ButtonColumn;

public class MainView extends JFrame {

	private MainController controller;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblItems;
	private JLabel lblPrecio;
	private JButton btnFinalizarCompra;

	/**
	 * Create the frame.
	 */
	public MainView() {
		setVisible(true);
		setTitle("Supermercado Hoy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel toolBar = new JPanel();
		FlowLayout flowLayout = (FlowLayout) toolBar.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JLabel lblCarrito = new JLabel("Carrito:");
		toolBar.add(lblCarrito);
		
		lblItems = new JLabel("0 items");
		toolBar.add(lblItems);
		
		lblPrecio = new JLabel("$0,00");
		toolBar.add(lblPrecio);
		
		btnFinalizarCompra = new JButton("Finalizar compra");
		toolBar.add(btnFinalizarCompra);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
	}
	
	public void setControlador(MainController viewController) {
		controller = viewController;
	}
	
	public void ActualizarItemsTable(MainModel model) {
		JTable itemsTable = table;
		DefaultTableModel tableModel = (DefaultTableModel) itemsTable.getModel();
		
		tableModel.addColumn("Id");
		tableModel.addColumn("Descripcion");
		tableModel.addColumn("Precio");
		tableModel.addColumn("");
		tableModel.addColumn("");
		
		for (Item i : model.tienda.getItems().values()) {
			tableModel.addRow(new Object[] {i.getId(), i.getDescripcion(), i.getPrecio(), "Agregar", "Eliminar"});
		}
		
		Action addAction = new ItemsTableAction() {
			public void actionPerformed(ActionEvent e)
		    {
				int id = this.getItemId(e);
				controller.agregarItemAlCarrito(id);			
		    }
		};	
		
		Action deleteAction = new ItemsTableAction() {
			public void actionPerformed(ActionEvent e)
		    {
				int id = this.getItemId(e);
				
				controller.eliminarItemDelCarrito(id);
		    }
		};		
		
		new ButtonColumn(itemsTable, addAction, 3);
		new ButtonColumn(itemsTable, deleteAction, 4);
	}
	
	public void ActualizarBarraDeCarrito(MainModel model) {
		lblItems.setText(model.carrito.getCantidadItems() + " items");
		lblPrecio.setText("$" + model.carrito.getImporteTotal());
	}
	
	public void addFinalizarCompraActionListener(ActionListener al) {
		btnFinalizarCompra.addActionListener(al);
	}
}
