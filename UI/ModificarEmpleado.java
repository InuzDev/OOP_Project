package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class ModificarEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtModNombre;
	private JTextField txtModCedula;
	private JTextField txtModTelefono;
	private JTextField txtModProvincia;
	private JTextField txtModCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarEmpleado dialog = new ModificarEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarEmpleado() {
		setBackground(new Color(255, 255, 240));
		getContentPane().setBackground(new Color(205, 133, 63));
		setTitle("Datos");
		setBounds(100, 100, 425, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(205, 133, 63));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(160, 82, 45)));
			panel.setBackground(new Color(255, 255, 240));
			panel.setLayout(null);
			panel.setBounds(0, 1, 407, 405);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(12, 37, 56, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Cedula: ");
				label.setBounds(12, 90, 56, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Sexo: ");
				label.setBounds(12, 305, 56, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Telefono:");
				label.setBounds(12, 143, 56, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Correo:");
				label.setBounds(12, 196, 56, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Provincia:");
				label.setBounds(12, 249, 56, 16);
				panel.add(label);
			}
			{
				txtModNombre = new JTextField();
				txtModNombre.setBounds(80, 34, 258, 22);
				panel.add(txtModNombre);
				txtModNombre.setColumns(10);
			}
			{
				txtModCedula = new JTextField();
				txtModCedula.setColumns(10);
				txtModCedula.setBounds(80, 87, 258, 22);
				panel.add(txtModCedula);
			}
			{
				txtModTelefono = new JTextField();
				txtModTelefono.setColumns(10);
				txtModTelefono.setBounds(80, 140, 258, 22);
				panel.add(txtModTelefono);
			}
			{
				txtModProvincia = new JTextField();
				txtModProvincia.setColumns(10);
				txtModProvincia.setBounds(80, 246, 258, 22);
				panel.add(txtModProvincia);
			}
			{
				txtModCorreo = new JTextField();
				txtModCorreo.setColumns(10);
				txtModCorreo.setBounds(80, 196, 258, 22);
				panel.add(txtModCorreo);
			}
			{
				JComboBox cmbxModSexo = new JComboBox();
				cmbxModSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
				cmbxModSexo.setBounds(200, 302, 138, 22);
				panel.add(cmbxModSexo);
			}
			{
				JLabel lblNewLabel = new JLabel("Años de experiencia:");
				lblNewLabel.setBounds(12, 363, 138, 16);
				panel.add(lblNewLabel);
			}
			{
				JSpinner spnModAniosExp = new JSpinner();
				spnModAniosExp.setBounds(200, 360, 138, 22);
				panel.add(spnModAniosExp);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(160, 82, 45)));
			buttonPane.setBackground(new Color(255, 255, 240));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Modificar");
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(205, 133, 63));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(205, 133, 63));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
