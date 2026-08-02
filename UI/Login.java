package UI;

import Logic.BolsaEmpleo;
import Logic.IBolsaEmpleo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Login extends JDialog {

   private final JPanel contentPanel = new JPanel();
   private JTextField textField;
   private JPasswordField textFieldPassword;
   private IBolsaEmpleo controlador;

   /**
    * Launch the application (standalone testing only).
    */
   public static void main(String[] args) {
      try {
         Login dialog = new Login(new BolsaEmpleo());
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public Login(IBolsaEmpleo controlador) {
      this.controlador = controlador;

      setTitle("Login");
      setBounds(100, 100, 450, 290);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBackground(new Color(255, 255, 240));
      contentPanel.setBorder(new LineBorder(new Color(139, 69, 19)));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);

      JLabel lblNewLabel = new JLabel("Username:");
      lblNewLabel.setForeground(new Color(160, 82, 45));
      lblNewLabel.setBounds(30, 40, 79, 16);
      contentPanel.add(lblNewLabel);

      JLabel lblNewLabel_1 = new JLabel("Contraseña:");
      lblNewLabel_1.setForeground(new Color(160, 82, 45));
      lblNewLabel_1.setBackground(new Color(160, 82, 45));
      lblNewLabel_1.setBounds(30, 116, 79, 16);
      contentPanel.add(lblNewLabel_1);

      textField = new JTextField();
      textField.setBounds(110, 37, 195, 22);
      contentPanel.add(textField);
      textField.setColumns(10);

      // Cambiado de JTextField a JPasswordField para no mostrar la clave en texto plano.
      textFieldPassword = new JPasswordField();
      textFieldPassword.setColumns(10);
      textFieldPassword.setBounds(110, 113, 195, 22);
      contentPanel.add(textFieldPassword);

      JLabel lblNewLabel_2 = new JLabel("¿No tiene usuario? Registrese aquí");
      lblNewLabel_2.setBounds(211, 148, 209, 16);
      contentPanel.add(lblNewLabel_2);

      JButton btnNewButton = new JButton("Registrar");
      btnNewButton.setForeground(new Color(255, 255, 255));
      btnNewButton.setBackground(new Color(205, 133, 63));
      btnNewButton.setBounds(323, 170, 97, 25);
      btnNewButton.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Registrar dialogoRegistrar = new Registrar(controlador);
               dialogoRegistrar.setModal(true);
               dialogoRegistrar.setVisible(true);
            }
         }
      );
      contentPanel.add(btnNewButton);
      {
         JPanel buttonPane = new JPanel();
         buttonPane.setBackground(new Color(255, 255, 240));
         buttonPane.setBorder(new LineBorder(new Color(205, 133, 63)));
         buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
         {
            JButton okButton = new JButton("Login");
            okButton.setForeground(new Color(255, 255, 255));
            okButton.setBackground(new Color(205, 133, 63));
            okButton.setActionCommand("OK");
            okButton.addActionListener(
               new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                     String username = textField.getText().trim();
                     String password = new String(
                        textFieldPassword.getPassword()
                     );

                     if (username.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(
                           Login.this,
                           "Debe ingresar usuario y contraseña.",
                           "Datos incompletos",
                           JOptionPane.WARNING_MESSAGE
                        );
                        return;
                     }

                     Object usuario = controlador.login(username, password);

                     if (usuario == null) {
                        JOptionPane.showMessageDialog(
                           Login.this,
                           "Usuario o contraseña incorrectos.",
                           "Error de acceso",
                           JOptionPane.ERROR_MESSAGE
                        );
                        return;
                     }

                     Principal principal = new Principal(controlador, usuario);
                     principal.setVisible(true);
                     dispose();
                  }
               }
            );
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);
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
