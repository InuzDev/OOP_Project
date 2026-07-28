package UI;

import Logic.BolsaEmpleo;
import java.awt.BorderLayout;
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
import javax.swing.border.TitledBorder;

public class Login extends JDialog {

   private final JPanel contentPanel = new JPanel();
   private JTextField textField;
   private JPasswordField textFieldPassword;
   private BolsaEmpleo controlador;

   public static void main(String[] args) {
      try {
         Login dialog = new Login(new BolsaEmpleo());
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public Login(BolsaEmpleo controlador) {
      this.controlador = controlador;

      setTitle("Login");
      setBounds(100, 100, 450, 290);
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

      JLabel lblNewLabel = new JLabel("Username:");
      lblNewLabel.setBounds(30, 40, 79, 16);
      contentPanel.add(lblNewLabel);

      JLabel lblNewLabel_1 = new JLabel("Contraseña:");
      lblNewLabel_1.setBounds(30, 116, 79, 16);
      contentPanel.add(lblNewLabel_1);

      textField = new JTextField();
      textField.setBounds(110, 37, 195, 22);
      contentPanel.add(textField);
      textField.setColumns(10);

      textFieldPassword = new JPasswordField();
      textFieldPassword.setColumns(10);
      textFieldPassword.setBounds(110, 113, 195, 22);
      contentPanel.add(textFieldPassword);

      JLabel lblNewLabel_2 = new JLabel("¿No tiene usuario? Registrese aquí");
      lblNewLabel_2.setBounds(211, 148, 209, 16);
      contentPanel.add(lblNewLabel_2);

      JButton btnNewButton = new JButton("Registrar");
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
            JButton okButton = new JButton("Login");
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
