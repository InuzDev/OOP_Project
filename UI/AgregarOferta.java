package UI;

import Logic.BolsaEmpleo;
import Logic.Oferta;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

public class AgregarOferta extends JDialog {

   private final JPanel contentPanel = new JPanel();
   private JTextField txtPuesto;
   private JTextField txtDescripcion;
   private JTextField txtProvincia;

   private BolsaEmpleo controlador;
   private String rncEmpresa;

   /**
    * Launch the application (standalone testing only).
    */
   public static void main(String[] args) {
      try {
         AgregarOferta dialog = new AgregarOferta(
            new BolsaEmpleo(),
            "000-000000-0"
         );
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public AgregarOferta(BolsaEmpleo controlador, String rncEmpresa) {
      this.controlador = controlador;
      this.rncEmpresa = rncEmpresa;

      setTitle("Ofertar");
      setBounds(100, 100, 530, 690);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(
         new TitledBorder(
            null,
            "",
            TitledBorder.LEADING,
            TitledBorder.TOP,
            null,
            null
         )
      );
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
      JSpinner spnCantPuestos = new JSpinner();
      spnCantPuestos.setModel(new SpinnerNumberModel(1, 1, null, 1));
      spnCantPuestos.setBounds(92, 91, 123, 22);
      contentPanel.add(spnCantPuestos);
      {
         JLabel lblNewLabel_2 = new JLabel("Sexo:");
         lblNewLabel_2.setBounds(12, 149, 56, 16);
         contentPanel.add(lblNewLabel_2);
      }
      JComboBox<String> cmbxSexo = new JComboBox<>();
      cmbxSexo.setModel(
         new DefaultComboBoxModel<>(new String[] {
            "Indistinto",
            "Masculino",
            "Femenino",
         })
      );
      cmbxSexo.setBounds(92, 146, 123, 22);
      contentPanel.add(cmbxSexo);
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
      spnSalarioMin.setModel(
         new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1))
      );
      spnSalarioMin.setBounds(133, 311, 141, 22);
      contentPanel.add(spnSalarioMin);

      JSpinner spnSalarioMax = new JSpinner();
      spnSalarioMax.setModel(
         new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1))
      );
      spnSalarioMax.setBounds(347, 311, 141, 22);
      contentPanel.add(spnSalarioMax);

      JLabel lblNewLabel_6 = new JLabel("Experiencia:");
      lblNewLabel_6.setBounds(12, 369, 124, 16);
      contentPanel.add(lblNewLabel_6);
      JSpinner spnAniosExperiencia = new JSpinner();
      spnAniosExperiencia.setModel(new SpinnerNumberModel(0, 0, null, 1));
      spnAniosExperiencia.setBounds(90, 368, 141, 22);
      contentPanel.add(spnAniosExperiencia);
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

      // Campo agregado: Oferta requiere tipoTrabajo, pero el formulario original no lo pedia.
      JLabel lblTipoTrabajo = new JLabel("Tipo de Trabajo:");
      lblTipoTrabajo.setBounds(12, 479, 100, 16);
      contentPanel.add(lblTipoTrabajo);

      JComboBox<String> cmbxTipoTrabajo = new JComboBox<>();
      cmbxTipoTrabajo.setModel(
         new DefaultComboBoxModel<>(new String[] {
            "Tiempo Completo",
            "Medio Tiempo",
            "Por Horas",
            "Freelance",
         })
      );
      cmbxTipoTrabajo.setBounds(120, 476, 200, 22);
      contentPanel.add(cmbxTipoTrabajo);

      JLabel lblProvincia = new JLabel("Provincia:");
      lblProvincia.setBounds(12, 534, 77, 16);
      contentPanel.add(lblProvincia);

      txtProvincia = new JTextField();
      txtProvincia.setBounds(92, 531, 408, 22);
      contentPanel.add(txtProvincia);
      txtProvincia.setColumns(10);

      {
         JPanel buttonPane = new JPanel();
         buttonPane.setBorder(
            new TitledBorder(
               null,
               "",
               TitledBorder.LEADING,
               TitledBorder.TOP,
               null,
               null
            )
         );
         buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
         {
            JButton okButton = new JButton("OK");
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);

            okButton.addActionListener(
               new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                     String puesto = txtPuesto.getText().trim();
                     String descripcion = txtDescripcion.getText().trim();
                     String provincia = txtProvincia.getText().trim();

                     if (puesto.isEmpty()) {
                        JOptionPane.showMessageDialog(
                           AgregarOferta.this,
                           "El puesto es obligatorio.",
                           "Datos incompletos",
                           JOptionPane.WARNING_MESSAGE
                        );
                        return;
                     }

                     // Codigo unico generado automaticamente, ya que Oferta no cuenta
                     // con un contador estatico como Persona/Representante.
                     String codigo =
                        "OF-" +
                        UUID.randomUUID()
                           .toString()
                           .substring(0, 8)
                           .toUpperCase();

                     Oferta oferta = new Oferta(
                        codigo,
                        puesto,
                        (Integer) spnCantPuestos.getValue(),
                        (String) cmbxSexo.getSelectedItem(),
                        checkBxLicencia.isSelected(),
                        chckBxDispuestoMudanza.isSelected(),
                        (String) cmbxTipoTrabajo.getSelectedItem(),
                        ((Number) spnSalarioMin.getValue()).floatValue(),
                        ((Number) spnSalarioMax.getValue()).floatValue(),
                        provincia,
                        (Integer) spnAniosExperiencia.getValue(),
                        descripcion
                     );

                     boolean agregada = controlador.addBusinessJobOffer(
                        rncEmpresa,
                        oferta
                     );

                     if (!agregada) {
                        JOptionPane.showMessageDialog(
                           AgregarOferta.this,
                           "No se pudo agregar la oferta (empresa no encontrada).",
                           "Error",
                           JOptionPane.ERROR_MESSAGE
                        );
                        return;
                     }

                     JOptionPane.showMessageDialog(
                        AgregarOferta.this,
                        "Oferta agregada exitosamente.",
                        "Ofertar",
                        JOptionPane.INFORMATION_MESSAGE
                     );
                     dispose();
                  }
               }
            );
         }
         {
            JButton cancelButton = new JButton("Cancel");
            cancelButton.setActionCommand("Cancel");
            cancelButton.addActionListener(
               new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                     dispose();
                  }
               }
            );
            buttonPane.add(cancelButton);
         }
      }
   }
}
