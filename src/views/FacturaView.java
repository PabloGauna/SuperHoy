package views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FacturaView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacturaView frame = new FacturaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FacturaView() {
		setResizable(false);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSupermercadoHoy = new JLabel("Supermercado Hoy");
		lblSupermercadoHoy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupermercadoHoy.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblSupermercadoHoy.setBounds(6, 20, 588, 47);
		contentPane.add(lblSupermercadoHoy);
		
		JLabel lblFactura = new JLabel("Factura");
		lblFactura.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblFactura.setBounds(6, 67, 588, 16);
		contentPane.add(lblFactura);
		
		JTextArea txtrFacturatext = new JTextArea();
		txtrFacturatext.setEditable(false);
		txtrFacturatext.setBounds(0, 105, 600, 392);
		contentPane.add(txtrFacturatext);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(466, 527, 117, 29);
		contentPane.add(btnFinalizar);
	}
}
