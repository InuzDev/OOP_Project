package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;

public class AgregarOferta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPuesto;
	private JTextField txtDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarOferta dialog = new AgregarOferta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarOferta() {
		setTitle("Ofertar");
		setBounds(100, 100, 530, 569);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Puesto: ");
			lblNewLabel.setBounds(12, 39, 56, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			txtPuesto = new JTextField();
			txtPuesto.setBounds(92, 36, 396, 22);
			contentPanel.add(txtPuesto);
			txtPuesto.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Vacantes:");
			lblNewLabel_1.setBounds(12, 94, 65, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JSpinner spnCantPuestos = new JSpinner();
			spnCantPuestos.setBounds(92, 91, 123, 22);
			contentPanel.add(spnCantPuestos);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Sexo:");
			lblNewLabel_2.setBounds(12, 149, 56, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JComboBox cmbxSexo = new JComboBox();
			cmbxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
			cmbxSexo.setBounds(92, 146, 123, 22);
			contentPanel.add(cmbxSexo);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Licencia:");
			lblNewLabel_3.setBounds(12, 204, 56, 16);
			contentPanel.add(lblNewLabel_3);
		}
		
		JCheckBox checkBxLicencia = new JCheckBox("Requerida");
		checkBxLicencia.setBounds(92, 200, 113, 25);
		contentPanel.add(checkBxLicencia);
		
		JLabel lblMudanza = new JLabel("Mudanza:");
		lblMudanza.setBounds(12, 259, 56, 16);
		contentPanel.add(lblMudanza);
		
		JCheckBox chckBxDispuestoMudanza = new JCheckBox("Requerida");
		chckBxDispuestoMudanza.setBounds(92, 255, 113, 25);
		contentPanel.add(chckBxDispuestoMudanza);
		
		JLabel lblNewLabel_4 = new JLabel("Rango:");
		lblNewLabel_4.setBounds(12, 314, 56, 16);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Minimo:");
		lblNewLabel_5.setBounds(80, 314, 56, 16);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblMaximo = new JLabel("Maximo:");
		lblMaximo.setBounds(286, 314, 56, 16);
		contentPanel.add(lblMaximo);
		
		JSpinner spnSalarioMin = new JSpinner();
		spnSalarioMin.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnSalarioMin.setBounds(133, 311, 141, 22);
		contentPanel.add(spnSalarioMin);
		
		JSpinner spnSalarioMax = new JSpinner();
		spnSalarioMax.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnSalarioMax.setBounds(347, 311, 141, 22);
		contentPanel.add(spnSalarioMax);
		
		JLabel lblNewLabel_6 = new JLabel("Experiencia:");
		lblNewLabel_6.setBounds(12, 369, 124, 16);
		contentPanel.add(lblNewLabel_6);
		{
			JSpinner spnAniosExperiencia = new JSpinner();
			spnAniosExperiencia.setBounds(90, 368, 141, 22);
			contentPanel.add(spnAniosExperiencia);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Descripcion:");
			lblNewLabel_7.setBounds(12, 424, 77, 16);
			contentPanel.add(lblNewLabel_7);
		}
		{
			txtDescripcion = new JTextField();
			txtDescripcion.setBounds(92, 421, 408, 22);
			contentPanel.add(txtDescripcion);
			txtDescripcion.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
