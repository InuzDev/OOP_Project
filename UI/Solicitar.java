package UI;

import Logic.BolsaEmpleo;
import Logic.Persona;
import Logic.Solicitud;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Solicitar extends JDialog {

   private final JPanel contentPanel = new JPanel();
   private JTextField textField;
   private JTextField textField_1;

   private BolsaEmpleo controlador;
   private Persona solicitante;

   public static void main(String[] args) {
      try {
         Solicitar dialog = new Solicitar(
            new BolsaEmpleo(),
            null,
            "Puesto de ejemplo",
            0
         );
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public Solicitar(
      BolsaEmpleo controlador,
      Persona solicitante,
      String puestoSugerido,
      int experienciaSugerida
   ) {
   	setBackground(new Color(255, 255, 240));
      this.controlador = controlador;
      this.solicitante = solicitante;

      setTitle("Solicitud");
      setBounds(100, 100, 450, 428);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBackground(new Color(255, 255, 240));
      contentPanel.setBorder(
         new LineBorder(new Color(205, 133, 63))
      );
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);
      {
         JLabel lblNewLabel = new JLabel("Puesto:");
         lblNewLabel.setBounds(12, 31, 56, 16);
         contentPanel.add(lblNewLabel);
      }
      {
         textField = new JTextField();
         textField.setBackground(new Color(255, 255, 255));
         textField.setEditable(false);
         textField.setText(puestoSugerido);
         textField.setBounds(87, 28, 333, 22);
         contentPanel.add(textField);
         textField.setColumns(10);
      }
      {
         JLabel lblNewLabel_1 = new JLabel("Mudanza:");
         lblNewLabel_1.setBounds(12, 147, 71, 16);
         contentPanel.add(lblNewLabel_1);
      }
      JCheckBox chckBxDispuestoMudar = new JCheckBox("Dispuesto");
      chckBxDispuestoMudar.setBackground(new Color(255, 255, 240));
      chckBxDispuestoMudar.setBounds(80, 143, 113, 25);
      contentPanel.add(chckBxDispuestoMudar);
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
         textField_1.setBackground(new Color(255, 255, 255));
         textField_1.setEditable(false);
         textField_1.setText(String.valueOf(experienciaSugerida));
         textField_1.setBounds(89, 81, 113, 22);
         contentPanel.add(textField_1);
         textField_1.setColumns(10);
      }
      JSpinner spnMinDeseado = new JSpinner();
      spnMinDeseado.setModel(
         new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1))
      );
      spnMinDeseado.setBounds(172, 205, 138, 22);
      contentPanel.add(spnMinDeseado);

      JSpinner spnMaxDeseado = new JSpinner();
      spnMaxDeseado.setModel(
         new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1))
      );
      spnMaxDeseado.setBounds(172, 262, 138, 22);
      contentPanel.add(spnMaxDeseado);
      {
         JPanel buttonPane = new JPanel();
         buttonPane.setBackground(new Color(255, 255, 240));
         buttonPane.setBorder(
            new LineBorder(new Color(205, 133, 63))
         );
         buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
         {
            JButton okButton = new JButton("Solicitar");
            okButton.setBackground(new Color(255, 255, 255));
            okButton.setForeground(new Color(205, 133, 63));
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);

            okButton.addActionListener(
               new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                     if (solicitante == null) {
                        JOptionPane.showMessageDialog(
                           Solicitar.this,
                           "No hay un solicitante activo (inicie sesion primero).",
                           "Error",
                           JOptionPane.ERROR_MESSAGE
                        );
                        return;
                     }

                     float min = (
                        (Number) spnMinDeseado.getValue()
                     ).floatValue();
                     float max = (
                        (Number) spnMaxDeseado.getValue()
                     ).floatValue();

                     if (max < min) {
                        JOptionPane.showMessageDialog(
                           Solicitar.this,
                           "El salario maximo no puede ser menor al minimo.",
                           "Datos invalidos",
                           JOptionPane.WARNING_MESSAGE
                        );
                        return;
                     }

                     Solicitud solicitud = new Solicitud(
                        solicitante,
                        textField.getText(),
                        min,
                        max,
                        chckBxDispuestoMudar.isSelected()
                     );

                     controlador.createRequestPersonal(solicitud);

                     JOptionPane.showMessageDialog(
                        Solicitar.this,
                        "Solicitud enviada.",
                        "Solicitar",
                        JOptionPane.INFORMATION_MESSAGE
                     );
                     dispose();
                  }
               }
            );
         }
         {
            JButton cancelButton = new JButton("Cancelar");
            cancelButton.setForeground(new Color(205, 133, 63));
            cancelButton.setBackground(new Color(255, 255, 255));
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
