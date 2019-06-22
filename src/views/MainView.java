package views;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
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
		
		JLabel lblItems = new JLabel("0 items");
		toolBar.add(lblItems);
		
		JLabel label = new JLabel("$0,00");
		toolBar.add(label);
		
		JButton btnFinalizarCompra = new JButton("Finalizar compra");
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
		
		for (Item i : model.tienda.getItems()) {
			tableModel.addRow(new Object[] {i.getId(), i.getDescripcion(), i.getPrecio(), "Agregar", "Eliminar"});
		}
		
		Action addAction = new ItemsTableAction() {
			public void actionPerformed(ActionEvent e)
		    {
				int id = this.getItemId(e);
				
				for (Item i : model.tienda.getItems()) {
					if (i.getId() == id) {
						model.carrito.getItems().add(i);
						break;
					}
				}
		    }
		};		
		Action deleteAction = new ItemsTableAction() {
			public void actionPerformed(ActionEvent e)
		    {
				int id = this.getItemId(e);
				
				for (Item i : model.carrito.getItems()) {
					if (i.getId() == id) {
						model.carrito.getItems().remove(i);
					}
				}
		    }
		};		
		
		ButtonColumn buttonColumnAdd = new ButtonColumn(itemsTable, addAction, 3);
		ButtonColumn buttonColumnDelete = new ButtonColumn(itemsTable, deleteAction, 4);
	}
}
