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
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

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
   	setForeground(new Color(205, 133, 63));
   	setBackground(new Color(205, 133, 63));
      this.controlador = controlador;
      this.rncEmpresa = rncEmpresa;

      setTitle("Ofertar");
      setBounds(100, 100, 530, 690);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setForeground(new Color(205, 133, 63));
      contentPanel.setBackground(new Color(255, 255, 240));
      contentPanel.setBorder(
         new LineBorder(new Color(160, 82, 45))







      );
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);
@@ -110,6 +110,7 @@
      }

      JCheckBox checkBxLicencia = new JCheckBox("Requerida");
      checkBxLicencia.setBackground(new Color(255, 255, 240));
      checkBxLicencia.setBounds(92, 200, 113, 25);
      contentPanel.add(checkBxLicencia);

@@ -118,6 +119,7 @@
      contentPanel.add(lblMudanza);

      JCheckBox chckBxDispuestoMudanza = new JCheckBox("Requerida");
      chckBxDispuestoMudanza.setBackground(new Color(255, 255, 240));
      chckBxDispuestoMudanza.setBounds(92, 255, 113, 25);
      contentPanel.add(chckBxDispuestoMudanza);

@@ -193,104 +195,103 @@
      txtProvincia.setColumns(10);

      {
         JPanel buttonPane = new JPanel();
         buttonPane.setForeground(new Color(205, 133, 63));
         buttonPane.setBackground(new Color(255, 255, 240));
         buttonPane.setBorder(
            new LineBorder(new Color(160, 82, 45))







         );
         buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
         {
            JButton okButton = new JButton("Agregar");
            okButton.setForeground(new Color(255, 255, 255));
            okButton.setBackground(new Color(205, 133, 63));
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
            JButton cancelButton = new JButton("Cancelar");
            cancelButton.setForeground(new Color(255, 255, 255));
            cancelButton.setBackground(new Color(205, 133, 63));
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
