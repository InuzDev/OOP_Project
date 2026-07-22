package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class Registrar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField universidadTxt;
	private JTextField carreraTxt;
	private JTextField tecnicoTxt;
	private JTextField habilidadesTxt;
	private JTextField nombreTxt;
	private JTextField cedulaTxt;
	private JTextField correoTxt;
	private JTextField provinciaTxt;
	private JTextField telefonoTxt;
	private JTextField claveSoliTxt;
	private JTextField nombreEmpresaTxt;
	private JTextField claveEmpresaTxt;
	private JTextField rncTxt;
	private JTextField direccionTxt;
	private JTextField sitioWebTxt;
	private JTextField representanteTxt;
	private JTextField tipoEmpresaTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registrar dialog = new Registrar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registrar() {
		setTitle("Registrar");
		setBounds(100, 100, 518, 556);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Empresa");
		rdbtnNewRadioButton.setBounds(139, 9, 127, 25);
		contentPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Solicitante");
		rdbtnNewRadioButton_1.setBounds(8, 9, 127, 25);
		contentPanel.add(rdbtnNewRadioButton_1);
		
		JPanel panelSolicitante = new JPanel();
		panelSolicitante.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSolicitante.setBounds(8, 43, 489, 333);
		contentPanel.add(panelSolicitante);
		panelSolicitante.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(12, 26, 56, 16);
		panelSolicitante.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula: ");
		lblNewLabel_1.setBounds(12, 110, 56, 16);
		panelSolicitante.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sexo:");
		lblNewLabel_2.setBounds(12, 152, 56, 16);
		panelSolicitante.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono:");
		lblNewLabel_3.setBounds(234, 152, 62, 16);
		panelSolicitante.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Correo:");
		lblNewLabel_4.setBounds(12, 194, 56, 16);
		panelSolicitante.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Provincia:");
		lblNewLabel_5.setBounds(12, 236, 56, 16);
		panelSolicitante.add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Universitario");
		rdbtnNewRadioButton_2.setBounds(27, 300, 127, 25);
		panelSolicitante.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Tecnico");
		rdbtnNewRadioButton_3.setBounds(181, 300, 127, 25);
		panelSolicitante.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Obrero");
		rdbtnNewRadioButton_4.setBounds(335, 300, 127, 25);
		panelSolicitante.add(rdbtnNewRadioButton_4);
		
		nombreTxt = new JTextField();
		nombreTxt.setBounds(72, 23, 363, 22);
		panelSolicitante.add(nombreTxt);
		nombreTxt.setColumns(10);
		
		cedulaTxt = new JTextField();
		cedulaTxt.setColumns(10);
		cedulaTxt.setBounds(72, 107, 363, 22);
		panelSolicitante.add(cedulaTxt);
		
		correoTxt = new JTextField();
		correoTxt.setColumns(10);
		correoTxt.setBounds(72, 191, 363, 22);
		panelSolicitante.add(correoTxt);
		
		provinciaTxt = new JTextField();
		provinciaTxt.setColumns(10);
		provinciaTxt.setBounds(72, 233, 363, 22);
		panelSolicitante.add(provinciaTxt);
		
		JComboBox sexoCbx = new JComboBox();
		sexoCbx.setBounds(72, 149, 115, 22);
		panelSolicitante.add(sexoCbx);
		
		telefonoTxt = new JTextField();
		telefonoTxt.setColumns(10);
		telefonoTxt.setBounds(308, 149, 127, 22);
		panelSolicitante.add(telefonoTxt);
		
		JLabel lblNewLabel_9 = new JLabel("Clave:");
		lblNewLabel_9.setBounds(12, 68, 82, 16);
		panelSolicitante.add(lblNewLabel_9);
		
		claveSoliTxt = new JTextField();
		claveSoliTxt.setColumns(10);
		claveSoliTxt.setBounds(72, 65, 363, 22);
		panelSolicitante.add(claveSoliTxt);
		
		JPanel panelTecnico = new JPanel();
		panelTecnico.setLayout(null);
		panelTecnico.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTecnico.setBounds(8, 376, 489, 99);
		contentPanel.add(panelTecnico);
		
		JLabel lblHabilidades = new JLabel("Habilidades:");
		lblHabilidades.setBounds(12, 45, 80, 16);
		panelTecnico.add(lblHabilidades);
		
		habilidadesTxt = new JTextField();
		habilidadesTxt.setColumns(10);
		habilidadesTxt.setBounds(89, 42, 285, 22);
		panelTecnico.add(habilidadesTxt);
		
		JPanel panelUniversitario = new JPanel();
		panelUniversitario.setLayout(null);
		panelUniversitario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelUniversitario.setBounds(8, 376, 489, 99);
		contentPanel.add(panelUniversitario);
		
		JLabel lblTecnicoProf = new JLabel("Tecnico:");
		lblTecnicoProf.setBounds(12, 13, 80, 16);
		panelUniversitario.add(lblTecnicoProf);
		
		JLabel lblExperiencia = new JLabel("Años de experiencia:");
		lblExperiencia.setBounds(12, 68, 126, 16);
		panelUniversitario.add(lblExperiencia);
		
		tecnicoTxt = new JTextField();
		tecnicoTxt.setColumns(10);
		tecnicoTxt.setBounds(95, 10, 285, 22);
		panelUniversitario.add(tecnicoTxt);
		
		JSpinner AniosExperienciaSpn = new JSpinner();
		AniosExperienciaSpn.setBounds(137, 65, 58, 22);
		panelUniversitario.add(AniosExperienciaSpn);
		
		JPanel panelObrero = new JPanel();
		panelObrero.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelObrero.setBounds(8, 376, 489, 99);
		contentPanel.add(panelObrero);
		panelObrero.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Carrera:");
		lblNewLabel_6.setBounds(12, 13, 56, 16);
		panelObrero.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Universidad:");
		lblNewLabel_7.setBounds(12, 68, 71, 16);
		panelObrero.add(lblNewLabel_7);
		
		universidadTxt = new JTextField();
		universidadTxt.setBounds(95, 65, 285, 22);
		panelObrero.add(universidadTxt);
		universidadTxt.setColumns(10);
		
		carreraTxt = new JTextField();
		carreraTxt.setColumns(10);
		carreraTxt.setBounds(95, 10, 285, 22);
		panelObrero.add(carreraTxt);
		
		JPanel panelEmpresa = new JPanel();
		panelEmpresa.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpresa.setBounds(8, 43, 489, 432);
		contentPanel.add(panelEmpresa);
		panelEmpresa.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Nombre:");
		lblNewLabel_8.setBounds(12, 14, 56, 16);
		panelEmpresa.add(lblNewLabel_8);
		
		nombreEmpresaTxt = new JTextField();
		nombreEmpresaTxt.setBounds(110, 11, 335, 22);
		panelEmpresa.add(nombreEmpresaTxt);
		nombreEmpresaTxt.setColumns(10);
		
		claveEmpresaTxt = new JTextField();
		claveEmpresaTxt.setBounds(110, 71, 335, 22);
		panelEmpresa.add(claveEmpresaTxt);
		claveEmpresaTxt.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Clave:");
		lblNewLabel_10.setBounds(12, 73, 56, 16);
		panelEmpresa.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("RNC:");
		lblNewLabel_11.setBounds(12, 133, 56, 16);
		panelEmpresa.add(lblNewLabel_11);
		
		rncTxt = new JTextField();
		rncTxt.setColumns(10);
		rncTxt.setBounds(110, 131, 335, 22);
		panelEmpresa.add(rncTxt);
		
		direccionTxt = new JTextField();
		direccionTxt.setColumns(10);
		direccionTxt.setBounds(110, 191, 335, 22);
		panelEmpresa.add(direccionTxt);
		
		JLabel lblNewLabel_12 = new JLabel("Direccion:");
		lblNewLabel_12.setBounds(12, 193, 73, 16);
		panelEmpresa.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Sitio Web:");
		lblNewLabel_13.setBounds(12, 254, 73, 16);
		panelEmpresa.add(lblNewLabel_13);
		
		sitioWebTxt = new JTextField();
		sitioWebTxt.setColumns(10);
		sitioWebTxt.setBounds(110, 251, 335, 22);
		panelEmpresa.add(sitioWebTxt);
		
		JLabel lblNewLabel_14 = new JLabel("Representante:");
		lblNewLabel_14.setBounds(12, 374, 97, 16);
		panelEmpresa.add(lblNewLabel_14);
		
		representanteTxt = new JTextField();
		representanteTxt.setColumns(10);
		representanteTxt.setBounds(110, 371, 335, 22);
		panelEmpresa.add(representanteTxt);
		
		JLabel lblNewLabel_15 = new JLabel("Tipo:");
		lblNewLabel_15.setBounds(12, 313, 56, 16);
		panelEmpresa.add(lblNewLabel_15);
		
		tipoEmpresaTxt = new JTextField();
		tipoEmpresaTxt.setColumns(10);
		tipoEmpresaTxt.setBounds(110, 311, 335, 22);
		panelEmpresa.add(tipoEmpresaTxt);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
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
