package views;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class ItemsTableAction extends AbstractAction
{	
	public void actionPerformed(ActionEvent e)
    {	
    }
	
	protected int getItemId(ActionEvent e) {
		JTable table = (JTable)e.getSource();
        int modelRow = Integer.valueOf( e.getActionCommand() );
        DefaultTableModel model = ((DefaultTableModel)table.getModel());
        return (int) ((Vector) model.getDataVector().elementAt(modelRow)).elementAt(0);
	}
};