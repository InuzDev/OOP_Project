package UI;

import Logic.BolsaEmpleo;
import Logic.Empresa;
import Logic.Obrero;
import Logic.Persona;
import Logic.Representante;
import Logic.Tecnico;
import Logic.Universitario;
import Logic.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
   private JPasswordField claveSoliTxt;
   private JTextField nombreEmpresaTxt;
   private JPasswordField claveEmpresaTxt;
   private JTextField correoEmpresaTxt;
   private JTextField telefonoEmpresaTxt;
   private JTextField rncTxt;
   private JTextField provinciaEmpresaTxt;
   private JTextField direccionTxt;
   private JTextField sitioWebTxt;
   private JTextField representanteTxt;
   private JComboBox<String> tipoEmpresaCbx;

   private BolsaEmpleo controlador;

   /**
    * Launch the application (standalone testing only).
    */
   public static void main(String[] args) {
      try {
         Registrar dialog = new Registrar(new BolsaEmpleo());
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public Registrar(BolsaEmpleo controlador) {
      setBackground(new Color(255, 255, 255));
      this.controlador = controlador;

      setTitle("Registrar");
      setBounds(100, 100, 518, 682);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBackground(new Color(255, 255, 240));
      contentPanel.setBorder(new LineBorder(new Color(205, 133, 63)));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);

      JPanel panelUniversitario = new JPanel();
      panelUniversitario.setBackground(new Color(255, 255, 240));
      panelUniversitario.setBorder(new LineBorder(new Color(205, 133, 63)));
      panelUniversitario.setBounds(8, 376, 489, 99);
      contentPanel.add(panelUniversitario);
      panelUniversitario.setLayout(null);

      JLabel lblNewLabel_6 = new JLabel("Carrera:");
      lblNewLabel_6.setBounds(12, 13, 56, 16);
      panelUniversitario.add(lblNewLabel_6);

      JLabel lblNewLabel_7 = new JLabel("Universidad:");
      lblNewLabel_7.setBounds(12, 68, 71, 16);
      panelUniversitario.add(lblNewLabel_7);

      universidadTxt = new JTextField();
      universidadTxt.setBounds(95, 65, 285, 22);
      panelUniversitario.add(universidadTxt);
      universidadTxt.setColumns(10);

      carreraTxt = new JTextField();
      carreraTxt.setColumns(10);
      carreraTxt.setBounds(95, 10, 285, 22);
      panelUniversitario.add(carreraTxt);

      JPanel panelTecnico = new JPanel();
      panelTecnico.setLayout(null);
      panelTecnico.setBorder(
         new TitledBorder(
            null,
            "",
            TitledBorder.LEADING,
            TitledBorder.TOP,
            null,
            null
         )
      );
      panelTecnico.setBounds(8, 376, 489, 99);
      contentPanel.add(panelTecnico);

      JLabel lblTecnicoProf = new JLabel("Tecnico:");
      lblTecnicoProf.setBounds(12, 45, 80, 16);
      panelTecnico.add(lblTecnicoProf);

      tecnicoTxt = new JTextField();
      tecnicoTxt.setColumns(10);
      tecnicoTxt.setBounds(87, 42, 285, 22);
      panelTecnico.add(tecnicoTxt);

      JPanel panelObrero = new JPanel();
      panelObrero.setLayout(null);
      panelObrero.setBorder(
         new TitledBorder(
            null,
            "",
            TitledBorder.LEADING,
            TitledBorder.TOP,
            null,
            null
         )
      );
      panelObrero.setBounds(8, 376, 489, 99);
      contentPanel.add(panelObrero);

      JLabel lblHabilidades = new JLabel("Habilidades:");
      lblHabilidades.setBounds(12, 45, 80, 16);
      panelObrero.add(lblHabilidades);

      habilidadesTxt = new JTextField();
      habilidadesTxt.setColumns(10);
      habilidadesTxt.setBounds(89, 42, 285, 22);
      panelObrero.add(habilidadesTxt);

      JRadioButton rdbtnEmpresa = new JRadioButton("Empresa");
      rdbtnEmpresa.setBackground(new Color(255, 255, 240));
      rdbtnEmpresa.setBounds(139, 9, 127, 25);
      contentPanel.add(rdbtnEmpresa);

      JRadioButton rdbtnSolicitante = new JRadioButton("Solicitante");
      rdbtnSolicitante.setBackground(new Color(255, 255, 240));
      rdbtnSolicitante.setBounds(8, 9, 127, 25);
      contentPanel.add(rdbtnSolicitante);

      ButtonGroup grupoTipoUsuario = new ButtonGroup();
      grupoTipoUsuario.add(rdbtnEmpresa);
      grupoTipoUsuario.add(rdbtnSolicitante);

      JPanel panelSolicitante = new JPanel();
      panelSolicitante.setBackground(new Color(255, 255, 240));
      panelSolicitante.setBorder(new LineBorder(new Color(205, 133, 63)));
      panelSolicitante.setBounds(8, 43, 489, 333);
      contentPanel.add(panelSolicitante);
      panelSolicitante.setLayout(null);

      JLabel lblNewLabel = new JLabel("Nombre: ");
      lblNewLabel.setBounds(12, 13, 56, 16);
      panelSolicitante.add(lblNewLabel);

      JLabel lblNewLabel_1 = new JLabel("Cedula: ");
      lblNewLabel_1.setBounds(12, 99, 56, 16);
      panelSolicitante.add(lblNewLabel_1);

      JLabel lblNewLabel_2 = new JLabel("Sexo:");
      lblNewLabel_2.setBounds(12, 142, 56, 16);
      panelSolicitante.add(lblNewLabel_2);

      JLabel lblNewLabel_3 = new JLabel("Telefono:");
      lblNewLabel_3.setBounds(237, 142, 62, 16);
      panelSolicitante.add(lblNewLabel_3);

      JLabel lblNewLabel_4 = new JLabel("Correo:");
      lblNewLabel_4.setBounds(12, 185, 56, 16);
      panelSolicitante.add(lblNewLabel_4);

      JLabel lblNewLabel_5 = new JLabel("Provincia:");
      lblNewLabel_5.setBounds(12, 228, 56, 16);
      panelSolicitante.add(lblNewLabel_5);

      JRadioButton rdbtnUniversitario = new JRadioButton("Universitario");
      rdbtnUniversitario.setBackground(new Color(255, 255, 240));
      rdbtnUniversitario.setBounds(27, 300, 127, 25);
      panelSolicitante.add(rdbtnUniversitario);

      JRadioButton rdbtnTecnico = new JRadioButton("Tecnico");
      rdbtnTecnico.setBackground(new Color(255, 255, 240));
      rdbtnTecnico.setBounds(181, 300, 127, 25);
      panelSolicitante.add(rdbtnTecnico);

      JRadioButton rdbtnObrero = new JRadioButton("Obrero");
      rdbtnObrero.setBackground(new Color(255, 255, 240));
      rdbtnObrero.setBounds(335, 300, 127, 25);
      panelSolicitante.add(rdbtnObrero);

      ButtonGroup grupoSubtipo = new ButtonGroup();
      grupoSubtipo.add(rdbtnUniversitario);
      grupoSubtipo.add(rdbtnTecnico);
      grupoSubtipo.add(rdbtnObrero);

      nombreTxt = new JTextField();
      nombreTxt.setBounds(94, 10, 356, 22);
      panelSolicitante.add(nombreTxt);
      nombreTxt.setColumns(10);

      cedulaTxt = new JTextField();
      cedulaTxt.setColumns(10);
      cedulaTxt.setBounds(94, 96, 356, 22);
      panelSolicitante.add(cedulaTxt);

      correoTxt = new JTextField();
      correoTxt.setColumns(10);
      correoTxt.setBounds(94, 182, 356, 22);
      panelSolicitante.add(correoTxt);

      provinciaTxt = new JTextField();
      provinciaTxt.setColumns(10);
      provinciaTxt.setBounds(94, 225, 356, 22);
      panelSolicitante.add(provinciaTxt);

      JComboBox<String> sexoCbx = new JComboBox<>();
      sexoCbx.setModel(
         new DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" })
      );
      sexoCbx.setBounds(94, 139, 115, 22);
      panelSolicitante.add(sexoCbx);

      telefonoTxt = new JTextField();
      telefonoTxt.setColumns(10);
      telefonoTxt.setBounds(311, 139, 138, 22);
      panelSolicitante.add(telefonoTxt);

      JLabel lblNewLabel_9 = new JLabel("Clave:");
      lblNewLabel_9.setBounds(12, 56, 82, 16);
      panelSolicitante.add(lblNewLabel_9);

      claveSoliTxt = new JPasswordField();
      claveSoliTxt.setColumns(10);
      claveSoliTxt.setBounds(94, 53, 356, 22);
      panelSolicitante.add(claveSoliTxt);

      JLabel lblNewLabel_16 = new JLabel("Experiencia:");
      lblNewLabel_16.setBounds(12, 271, 70, 16);
      panelSolicitante.add(lblNewLabel_16);

      JSpinner spnExperienciaAnios = new JSpinner();
      spnExperienciaAnios.setBounds(94, 269, 103, 22);
      panelSolicitante.add(spnExperienciaAnios);

      JCheckBox chckBxLicenciado = new JCheckBox("Licenciado");
      chckBxLicenciado.setBackground(new Color(255, 255, 240));
      chckBxLicenciado.setBounds(235, 268, 113, 25);
      panelSolicitante.add(chckBxLicenciado);

      JPanel panelEmpresa = new JPanel();
      panelEmpresa.setBackground(new Color(255, 255, 240));
      panelEmpresa.setBorder(new LineBorder(new Color(205, 133, 63)));
      panelEmpresa.setBounds(0, 43, 500, 555);
      contentPanel.add(panelEmpresa);
      panelEmpresa.setLayout(null);

      JLabel lblNewLabel_8 = new JLabel("Nombre:");
      lblNewLabel_8.setBounds(12, 14, 56, 16);
      panelEmpresa.add(lblNewLabel_8);

      nombreEmpresaTxt = new JTextField();
      nombreEmpresaTxt.setBounds(110, 11, 335, 22);
      panelEmpresa.add(nombreEmpresaTxt);
      nombreEmpresaTxt.setColumns(10);

      JLabel lblNewLabel_10 = new JLabel("Clave:");
      lblNewLabel_10.setBounds(12, 69, 56, 16);
      panelEmpresa.add(lblNewLabel_10);

      claveEmpresaTxt = new JPasswordField();
      claveEmpresaTxt.setBounds(110, 66, 335, 22);
      panelEmpresa.add(claveEmpresaTxt);
      claveEmpresaTxt.setColumns(10);

      JLabel lblCorreoEmpresa = new JLabel("Correo:");
      lblCorreoEmpresa.setBounds(12, 124, 56, 16);
      panelEmpresa.add(lblCorreoEmpresa);

      correoEmpresaTxt = new JTextField();
      correoEmpresaTxt.setColumns(10);
      correoEmpresaTxt.setBounds(110, 121, 335, 22);
      panelEmpresa.add(correoEmpresaTxt);

      JLabel lblTelefonoEmpresa = new JLabel("Telefono:");
      lblTelefonoEmpresa.setBounds(12, 179, 73, 16);
      panelEmpresa.add(lblTelefonoEmpresa);

      telefonoEmpresaTxt = new JTextField();
      telefonoEmpresaTxt.setColumns(10);
      telefonoEmpresaTxt.setBounds(110, 176, 335, 22);
      panelEmpresa.add(telefonoEmpresaTxt);

      JLabel lblNewLabel_11 = new JLabel("RNC:");
      lblNewLabel_11.setBounds(12, 234, 56, 16);
      panelEmpresa.add(lblNewLabel_11);

      rncTxt = new JTextField();
      rncTxt.setColumns(10);
      rncTxt.setBounds(110, 231, 335, 22);
      panelEmpresa.add(rncTxt);

      JLabel lblProvinciaEmpresa = new JLabel("Provincia:");
      lblProvinciaEmpresa.setBounds(12, 289, 73, 16);
      panelEmpresa.add(lblProvinciaEmpresa);

      provinciaEmpresaTxt = new JTextField();
      provinciaEmpresaTxt.setColumns(10);
      provinciaEmpresaTxt.setBounds(110, 286, 335, 22);
      panelEmpresa.add(provinciaEmpresaTxt);

      direccionTxt = new JTextField();
      direccionTxt.setColumns(10);
      direccionTxt.setBounds(110, 341, 335, 22);
      panelEmpresa.add(direccionTxt);

      JLabel lblNewLabel_12 = new JLabel("Direccion:");
      lblNewLabel_12.setBounds(12, 344, 73, 16);
      panelEmpresa.add(lblNewLabel_12);

      JLabel lblNewLabel_13 = new JLabel("Sitio Web:");
      lblNewLabel_13.setBounds(12, 399, 73, 16);
      panelEmpresa.add(lblNewLabel_13);

      sitioWebTxt = new JTextField();
      sitioWebTxt.setColumns(10);
      sitioWebTxt.setBounds(110, 396, 335, 22);
      panelEmpresa.add(sitioWebTxt);

      JLabel lblNewLabel_15 = new JLabel("Tipo:");
      lblNewLabel_15.setBounds(12, 454, 56, 16);
      panelEmpresa.add(lblNewLabel_15);

      tipoEmpresaCbx = new JComboBox<>();
      tipoEmpresaCbx.setModel(
         new DefaultComboBoxModel<>(new String[] {
            "Turismo",
            "Salud",
            "Educacion",
            "Tecnologia",
            "Manufactura",
            "Comercio",
            "Otro",
         })
      );
      tipoEmpresaCbx.setBounds(110, 451, 335, 22);
      panelEmpresa.add(tipoEmpresaCbx);

      JLabel lblNewLabel_14 = new JLabel("Representante:");
      lblNewLabel_14.setBounds(12, 509, 97, 16);
      panelEmpresa.add(lblNewLabel_14);

      representanteTxt = new JTextField();
      representanteTxt.setColumns(10);
      representanteTxt.setBounds(110, 506, 335, 22);
      panelEmpresa.add(representanteTxt);
      {
         JPanel buttonPane = new JPanel();
         buttonPane.setBorder(new LineBorder(new Color(139, 69, 19)));
         buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
         {
            JButton okButton = new JButton("Registrar");
            okButton.setForeground(new Color(255, 255, 255));
            okButton.setBackground(new Color(205, 133, 63));
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);

            okButton.addActionListener(
               new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                     if (rdbtnSolicitante.isSelected()) {
                        String nombre = nombreTxt.getText().trim();
                        String cedula = cedulaTxt.getText().trim();
                        String sexo = (String) sexoCbx.getSelectedItem();
                        String telefono = telefonoTxt.getText().trim();
                        String correo = correoTxt.getText().trim();
                        String provincia = provinciaTxt.getText().trim();
                        String clave = new String(claveSoliTxt.getPassword());
                        int aniosExperiencia = (Integer) spnExperienciaAnios.getValue();

                        if (
                           nombre.isEmpty() ||
                           cedula.isEmpty() ||
                           correo.isEmpty() ||
                           clave.isEmpty()
                        ) {
                           JOptionPane.showMessageDialog(
                              Registrar.this,
                              "Nombre, cedula, correo y clave son obligatorios.",
                              "Datos incompletos",
                              JOptionPane.WARNING_MESSAGE
                           );
                           return;
                        }

                        Persona persona;
                        

                        if (rdbtnUniversitario.isSelected()) {
                           persona = new Universitario(
                              nombre,
                              cedula,
                              sexo,
                              telefono,
                              correo,
                              provincia,
                              aniosExperiencia,
                              carreraTxt.getText().trim(),
                              universidadTxt.getText().trim()
                           );
                        } else if (rdbtnTecnico.isSelected()) {
                          
                           persona = new Tecnico(
                              nombre,
                              cedula,
                              sexo,
                              telefono,
                              correo,
                              provincia,
                              tecnicoTxt.getText().trim(),
                              aniosExperiencia
                           );
                        } else if (rdbtnObrero.isSelected()) {
                           persona = new Obrero(
                              nombre,
                              cedula,
                              sexo,
                              telefono,
                              correo,
                              provincia,
                              aniosExperiencia,
                              habilidadesTxt.getText().trim()
                           );
                        } else {
                           JOptionPane.showMessageDialog(
                              Registrar.this,
                              "Debe seleccionar un tipo: Universitario, Tecnico u Obrero.",
                              "Datos incompletos",
                              JOptionPane.WARNING_MESSAGE
                           );
                           return;
                        }

                        Usuario usuario = new Usuario(
                           persona.getNumIdentificador(),
                           correo,
                           clave,
                           "SOLICITANTE",
                           false
                        );
                        persona.setUsuarioEmpleado(usuario);

                        controlador.registerPersonal(persona);

                        JOptionPane.showMessageDialog(
                           Registrar.this,
                           "Registro exitoso.",
                           "Registrar",
                           JOptionPane.INFORMATION_MESSAGE
                        );
                        dispose();
                     } else if (rdbtnEmpresa.isSelected()) {
                        String nombreEmpresa = nombreEmpresaTxt
                           .getText()
                           .trim();
                        String rnc = rncTxt.getText().trim();
                        String correoEmpresa = correoEmpresaTxt
                           .getText()
                           .trim();
                        String claveEmpresa = new String(
                           claveEmpresaTxt.getPassword()
                        );

                        if (
                           nombreEmpresa.isEmpty() ||
                           rnc.isEmpty() ||
                           correoEmpresa.isEmpty() ||
                           claveEmpresa.isEmpty()
                        ) {
                           JOptionPane.showMessageDialog(
                              Registrar.this,
                              "Nombre, RNC, correo y clave son obligatorios.",
                              "Datos incompletos",
                              JOptionPane.WARNING_MESSAGE
                           );
                           return;
                        }

                        Representante representante = new Representante(
                           representanteTxt.getText().trim(),
                           "",
                           "",
                           "",
                           "",
                           ""
                        );

                        Usuario usuario = new Usuario(
                           representante.getIdRepresentante(),
                           correoEmpresa,
                           claveEmpresa,
                           "EMPRESA",
                           true
                        );

                        Empresa empresa = new Empresa(
                           rnc,
                           nombreEmpresa,
                           direccionTxt.getText().trim(),
                           provinciaEmpresaTxt.getText().trim(),
                           telefonoEmpresaTxt.getText().trim(),
                           correoEmpresa,
                           sitioWebTxt.getText().trim(),
                           (String) tipoEmpresaCbx.getSelectedItem(),
                           representante,
                           usuario
                        );

                        controlador.registerEmpresa(empresa);

                        JOptionPane.showMessageDialog(
                           Registrar.this,
                           "Registro exitoso.",
                           "Registrar",
                           JOptionPane.INFORMATION_MESSAGE
                        );
                        dispose();
                     } else {
                        JOptionPane.showMessageDialog(
                           Registrar.this,
                           "Debe seleccionar Empresa o Solicitante.",
                           "Datos incompletos",
                           JOptionPane.WARNING_MESSAGE
                        );
                     }
                  }
               }
            );
         }
         {
            JButton cancelButton = new JButton("Cancelar");
            cancelButton.setBackground(new Color(205, 133, 63));
            cancelButton.setForeground(new Color(255, 255, 255));
            cancelButton.setActionCommand("Cancel");
            cancelButton.addActionListener(
               new ActionListener() {
                  public void actionPerformed(ActionEvent err) {
                     dispose();
                  }
               }
            );
            buttonPane.add(cancelButton);
         }
      }

      rdbtnSolicitante.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent err) {
               panelSolicitante.setVisible(true);
               panelEmpresa.setVisible(false);

               panelUniversitario.setVisible(rdbtnUniversitario.isSelected());
               panelTecnico.setVisible(rdbtnTecnico.isSelected());
               panelObrero.setVisible(rdbtnObrero.isSelected());
            }
         }
      );

      rdbtnEmpresa.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent err) {
               panelSolicitante.setVisible(false);
               panelEmpresa.setVisible(true);

               panelUniversitario.setVisible(false);
               panelTecnico.setVisible(false);
               panelObrero.setVisible(false);
            }
         }
      );

      rdbtnUniversitario.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent err) {
               panelUniversitario.setVisible(true);
               panelTecnico.setVisible(false);
               panelObrero.setVisible(false);
            }
         }
      );
      rdbtnTecnico.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent err) {
               panelUniversitario.setVisible(false);
               panelTecnico.setVisible(true);
               panelObrero.setVisible(false);
            }
         }
      );
      rdbtnObrero.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent err) {
               panelUniversitario.setVisible(false);
               panelTecnico.setVisible(false);
               panelObrero.setVisible(true);
            }
         }
      );

      rdbtnSolicitante.setSelected(true);
      panelSolicitante.setVisible(true);
      panelEmpresa.setVisible(false);

      rdbtnUniversitario.setSelected(true);
      panelUniversitario.setVisible(true);
      panelTecnico.setVisible(false);
      panelObrero.setVisible(false);
   }
}
