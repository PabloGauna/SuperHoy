package views;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Item;
import models.MainModel;
import vendor.ButtonColumn;

public class MainView extends JFrame {

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
		
		JLabel lblItems = new JLabel("3 items");
		toolBar.add(lblItems);
		
		JLabel label = new JLabel("$350,00");
		toolBar.add(label);
		
		JButton btnFinalizarCompra = new JButton("Finalizar compra");
		toolBar.add(btnFinalizarCompra);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
	}
	
	public void ActualizarItemsTable(MainModel model) {
		JTable itemsTable = table;
		DefaultTableModel tableModel = (DefaultTableModel) itemsTable.getModel();
		
		tableModel.addColumn("Descripcion");
		tableModel.addColumn("Precio");
		tableModel.addColumn("");
		tableModel.addColumn("");
		
		for (Item i : model.tienda.getItems()) {
			tableModel.addRow(new Object[] {i.getDescripcion(), i.getPrecio(), "Agregar", "Eliminar"});
		}
		
		Action addAction = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
		    }
		};
		
		Action deleteAction = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
		    }
		};
		
		ButtonColumn buttonColumnAdd = new ButtonColumn(itemsTable, addAction, 2);
		ButtonColumn buttonColumnDelete = new ButtonColumn(itemsTable, deleteAction, 3);
	}
}
