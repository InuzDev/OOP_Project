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
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Solicitar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Solicitar dialog = new Solicitar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Solicitar() {
		setTitle("Solicitud");
		setBounds(100, 100, 450, 428);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Puesto:");
			lblNewLabel.setBounds(12, 31, 56, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(87, 28, 333, 22);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Mudanza:");
			lblNewLabel_1.setBounds(12, 147, 71, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JCheckBox chckBxDispuestoMudar = new JCheckBox("Dispuesto");
			chckBxDispuestoMudar.setBounds(80, 143, 113, 25);
			contentPanel.add(chckBxDispuestoMudar);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Salario Minimo Deseado:");
			lblNewLabel_2.setBounds(12, 208, 148, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblSalarioMaximoDeseado = new JLabel("Salario Maximo Deseado:");
			lblSalarioMaximoDeseado.setBounds(12, 265, 148, 16);
			contentPanel.add(lblSalarioMaximoDeseado);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Experiencia:");
			lblNewLabel_3.setBounds(12, 84, 71, 16);
			contentPanel.add(lblNewLabel_3);
		}
		{
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setBounds(89, 81, 113, 22);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JSpinner spnMinDeseado = new JSpinner();
			spnMinDeseado.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnMinDeseado.setBounds(172, 205, 138, 22);
			contentPanel.add(spnMinDeseado);
		}
		{
			JSpinner spnMaxDeseado = new JSpinner();
			spnMaxDeseado.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
			spnMaxDeseado.setBounds(172, 262, 138, 22);
			contentPanel.add(spnMaxDeseado);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Solicitar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
