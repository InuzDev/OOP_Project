package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Contratar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable todosSolicitTable;
	private JTable ofertasTable;
	private JTable mejoresSolicitTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Contratar dialog = new Contratar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Contratar() {
		setTitle("Solicitudes");
		setBounds(100, 100, 917, 569);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(34, 51, 402, 233);
			contentPanel.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					ofertasTable = new JTable();
					scrollPane.setViewportView(ofertasTable);
				}
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Ofertas de mi empresa:");
			lblNewLabel.setBounds(34, 22, 150, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(471, 51, 397, 385);
			contentPanel.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					todosSolicitTable = new JTable();
					scrollPane.setViewportView(todosSolicitTable);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(34, 336, 402, 100);
			contentPanel.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					mejoresSolicitTable = new JTable();
					scrollPane.setViewportView(mejoresSolicitTable);
				}
			}
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Solicitantes con mejor compatibilidad:");
			lblNewLabel_1.setBounds(34, 307, 234, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JButton contratarSolitBtn = new JButton("Contratar");
			contratarSolitBtn.setBounds(339, 449, 97, 25);
			contentPanel.add(contratarSolitBtn);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Solicitantes segun la oferta:");
			lblNewLabel_2.setBounds(471, 22, 198, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton guardarButton = new JButton("Guardar");
				guardarButton.setActionCommand("OK");
				buttonPane.add(guardarButton);
				getRootPane().setDefaultButton(guardarButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
