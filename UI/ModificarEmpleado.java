package UI;

import Logic.BolsaEmpleo;
import Logic.IBolsaEmpleo;
import Logic.Persona;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ModificarEmpleado extends JDialog {

   private final JPanel contentPanel = new JPanel();
   private JTextField txtModNombre;
   private JTextField txtModCedula;
   private JTextField txtModTelefono;
   private JTextField txtModProvincia;
   private JTextField txtModCorreo;

   private IBolsaEmpleo controlador;
   private Persona persona;

   /**
    * Launch the application (standalone testing only).
    */
   public static void main(String[] args) {
      try {
         ModificarEmpleado dialog = new ModificarEmpleado(
            new BolsaEmpleo(),
            null
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
   public ModificarEmpleado(IBolsaEmpleo controlador, Persona persona) {
      this.controlador = controlador;
      this.persona = persona;

      getContentPane().setBackground(new Color(205, 133, 63));
      setTitle("Datos");
      setBounds(100, 100, 425, 492);
      setLocationRelativeTo(null);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBackground(new Color(205, 133, 63));
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);

      JPanel panel = new JPanel();
      panel.setBorder(new LineBorder(new Color(160, 82, 45)));
      panel.setBackground(new Color(255, 255, 240));
      panel.setLayout(null);
      panel.setBounds(0, 1, 407, 405);
      contentPanel.add(panel);

      JLabel label = new JLabel("Nombre:");
      label.setBounds(12, 37, 56, 16);
      panel.add(label);

      JLabel label_1 = new JLabel("Cedula: ");
      label_1.setBounds(12, 90, 56, 16);
      panel.add(label_1);

      JLabel label_2 = new JLabel("Sexo: ");
      label_2.setBounds(12, 305, 56, 16);
      panel.add(label_2);

      JLabel label_3 = new JLabel("Telefono:");
      label_3.setBounds(12, 143, 56, 16);
      panel.add(label_3);

      JLabel label_4 = new JLabel("Correo:");
      label_4.setBounds(12, 196, 56, 16);
      panel.add(label_4);

      JLabel label_5 = new JLabel("Provincia:");
      label_5.setBounds(12, 249, 56, 16);
      panel.add(label_5);

      txtModNombre = new JTextField();
      txtModNombre.setBounds(80, 34, 258, 22);
      panel.add(txtModNombre);
      txtModNombre.setColumns(10);

      txtModCedula = new JTextField();
      txtModCedula.setColumns(10);
      txtModCedula.setBounds(80, 87, 258, 22);
      panel.add(txtModCedula);

      txtModTelefono = new JTextField();
      txtModTelefono.setColumns(10);
      txtModTelefono.setBounds(80, 140, 258, 22);
      panel.add(txtModTelefono);

      txtModProvincia = new JTextField();
      txtModProvincia.setColumns(10);
      txtModProvincia.setBounds(80, 246, 258, 22);
      panel.add(txtModProvincia);

      txtModCorreo = new JTextField();
      txtModCorreo.setColumns(10);
      txtModCorreo.setBounds(80, 196, 258, 22);
      panel.add(txtModCorreo);

      JComboBox<String> cmbxModSexo = new JComboBox<>();
      cmbxModSexo.setModel(
         new DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" })
      );
      cmbxModSexo.setBounds(200, 302, 138, 22);
      panel.add(cmbxModSexo);

      JLabel lblNewLabel = new JLabel("Años de experiencia:");
      lblNewLabel.setBounds(12, 363, 138, 16);
      panel.add(lblNewLabel);

      JSpinner spnModAniosExp = new JSpinner();
      spnModAniosExp.setModel(new SpinnerNumberModel(0, 0, null, 1));
      spnModAniosExp.setBounds(200, 360, 138, 22);
      panel.add(spnModAniosExp);

      // Precargar los campos con los datos actuales de la persona.
      if (persona != null) {
         txtModNombre.setText(persona.getNombre());
         txtModCedula.setText(persona.getCedula());
         txtModTelefono.setText(persona.getNumeroTelefono());
         txtModCorreo.setText(persona.getCorreo());
         txtModProvincia.setText(persona.getProvincia());
         cmbxModSexo.setSelectedItem(persona.getSexo());
         spnModAniosExp.setValue(persona.getAniosExperiencia());
      }

      JPanel buttonPane = new JPanel();
      buttonPane.setBorder(new LineBorder(new Color(160, 82, 45)));
      buttonPane.setBackground(new Color(255, 255, 240));
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);

      JButton okButton = new JButton("Modificar");
      okButton.setForeground(new Color(255, 255, 255));
      okButton.setBackground(new Color(205, 133, 63));
      okButton.setActionCommand("OK");
      buttonPane.add(okButton);
      getRootPane().setDefaultButton(okButton);

      okButton.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (persona == null) {
                  JOptionPane.showMessageDialog(
                     ModificarEmpleado.this,
                     "No hay una persona activa (inicie sesion primero).",
                     "Error",
                     JOptionPane.ERROR_MESSAGE
                  );
                  return;
               }

               String nombre = txtModNombre.getText().trim();
               String cedula = txtModCedula.getText().trim();
               String telefono = txtModTelefono.getText().trim();
               String correo = txtModCorreo.getText().trim();
               String provincia = txtModProvincia.getText().trim();
               String sexo = (String) cmbxModSexo.getSelectedItem();
               int aniosExperiencia = (Integer) spnModAniosExp.getValue();

               if (nombre.isEmpty() || cedula.isEmpty() || correo.isEmpty()) {
                  JOptionPane.showMessageDialog(
                     ModificarEmpleado.this,
                     "Nombre, cedula y correo son obligatorios.",
                     "Datos incompletos",
                     JOptionPane.WARNING_MESSAGE
                  );
                  return;
               }

               boolean actualizado = controlador.actualizarPersonal(
                  persona.getNumIdentificador(),
                  nombre,
                  cedula,
                  sexo,
                  telefono,
                  correo,
                  provincia,
                  aniosExperiencia
               );

               if (!actualizado) {
                  JOptionPane.showMessageDialog(
                     ModificarEmpleado.this,
                     "No se pudo actualizar la informacion.",
                     "Error",
                     JOptionPane.ERROR_MESSAGE
                  );
                  return;
               }

               // Reflejar los cambios en el objeto local, para que la pantalla
               // que abrio este dialogo (Principal) los muestre sin necesidad
               // de volver a iniciar sesion.
               persona.setNombre(nombre);
               persona.setCedula(cedula);
               persona.setNumeroTelefono(telefono);
               persona.setCorreo(correo);
               persona.setProvincia(provincia);
               persona.setSexo(sexo);
               persona.setAniosExperiencia(aniosExperiencia);

               JOptionPane.showMessageDialog(
                  ModificarEmpleado.this,
                  "Datos actualizados correctamente.",
                  "Modificar",
                  JOptionPane.INFORMATION_MESSAGE
               );
               dispose();
            }
         }
      );

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
