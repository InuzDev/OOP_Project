package UI;

import Logic.BolsaEmpleo;
import Logic.Empresa;
import Logic.Obrero;
import Logic.Oferta;
import Logic.Persona;
import Logic.Solicitud;
import Logic.Tecnico;
import Logic.Universitario;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Principal extends JFrame {

   private JPanel contentPane;
   private JTable ofertasEmpresaTbl;
   private JTable ofertasContratTbl;
   private JTable solicitudesContratTbl;
   private JTable solitMayorCoinTbl;
   private JTable tblOfertasEnSolicitud;
   private JTable tblMisSolicitudes;

   private BolsaEmpleo controlador;
   private Persona personaActual;
   private Empresa empresaActual;

   private List<Solicitud> misSolicitudesActuales = new ArrayList<>();
   private List<Oferta> ofertasEnSolicitud = new ArrayList<>();
   private List<Oferta> ofertasDeMiEmpresa = new ArrayList<>();
   private List<Oferta> ofertasActivasParaContratar = new ArrayList<>();
   private List<Solicitud> solicitudesParaContratar = new ArrayList<>();
   private List<Solicitud> mejoresCandidatos = new ArrayList<>();

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(
         new Runnable() {
            public void run() {
               try {
                  Principal frame = new Principal(new BolsaEmpleo(), null);
                  frame.setVisible(true);
               } catch (Exception e) {
                  e.printStackTrace();
               }
            }
         }
      );
   }

   /**
    * Create the frame.
    *
    * @param controlador   instancia compartida de BolsaEmpleo
    * @param usuarioActual el Persona o Empresa que inicio sesion (puede ser null en pruebas)
    */
   public Principal(BolsaEmpleo controlador, Object usuarioActual) {
      this.controlador = controlador;

      if (usuarioActual instanceof Persona) {
         this.personaActual = (Persona) usuarioActual;
      } else if (usuarioActual instanceof Empresa) {
         this.empresaActual = (Empresa) usuarioActual;
      }

      setTitle("Bolsa de Empleos");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1057, 751);

      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      JMenu mnNewMenu = new JMenu("Administracion");
      menuBar.add(mnNewMenu);

      JMenuItem mntmNewMenuItem = new JMenuItem("Manejar Solicitudes");
      mnNewMenu.add(mntmNewMenuItem);
      contentPane = new JPanel();
      contentPane.setBorder(
         new TitledBorder(
            null,
            "",
            TitledBorder.LEADING,
            TitledBorder.TOP,
            null,
            null
         )
      );
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane.setBounds(0, 47, 1039, 631);
      contentPane.add(tabbedPane);

      JPanel panelEmpleado = new JPanel();
      tabbedPane.addTab("Empleado", null, panelEmpleado, null);
      panelEmpleado.setLayout(null);

      JPanel panel_4 = new JPanel();
      panel_4.setBounds(44, 71, 388, 466);
      panelEmpleado.add(panel_4);
      panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

      JScrollPane scrollMisSolicitudes = new JScrollPane();
      panel_4.add(scrollMisSolicitudes);

      tblMisSolicitudes = new JTable();
      scrollMisSolicitudes.setViewportView(tblMisSolicitudes);

      JLabel lblNewLabel_17 = new JLabel("Mis solicitudes actuales");
      lblNewLabel_17.setBounds(44, 42, 177, 16);
      panelEmpleado.add(lblNewLabel_17);

      JButton btnRetirarSolicitud = new JButton("Retirar");
      btnRetirarSolicitud.setBounds(335, 550, 97, 25);
      panelEmpleado.add(btnRetirarSolicitud);

      JLabel lblNewLabel_18 = new JLabel("Mis datos");
      lblNewLabel_18.setBounds(539, 42, 56, 16);
      panelEmpleado.add(lblNewLabel_18);

      JPanel panel = new JPanel();
      panel.setBounds(539, 71, 413, 466);
      panelEmpleado.add(panel);
      panel.setLayout(null);

      JLabel lblNewLabel_19 = new JLabel("Empleado:");
      lblNewLabel_19.setBounds(12, 408, 62, 16);
      panel.add(lblNewLabel_19);

      JButton btnRenunciarEmpleo = new JButton("Renunciar");
      btnRenunciarEmpleo.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {}
         }
      );
      btnRenunciarEmpleo.setBounds(304, 404, 97, 25);
      panel.add(btnRenunciarEmpleo);

      JLabel lblNewLabel_20 = new JLabel("Nombre:");
      lblNewLabel_20.setBounds(12, 37, 56, 16);
      panel.add(lblNewLabel_20);

      JLabel lblNewLabel_21 = new JLabel("Cedula: ");
      lblNewLabel_21.setBounds(12, 90, 56, 16);
      panel.add(lblNewLabel_21);

      JLabel lblSexo = new JLabel("Sexo: ");
      lblSexo.setBounds(12, 196, 56, 16);
      panel.add(lblSexo);

      JLabel lblNewLabel_22 = new JLabel("Telefono:");
      lblNewLabel_22.setBounds(12, 143, 56, 16);
      panel.add(lblNewLabel_22);

      JLabel lblNewLabel_23 = new JLabel("Correo:");
      lblNewLabel_23.setBounds(12, 249, 56, 16);
      panel.add(lblNewLabel_23);

      JLabel lblNewLabel_24 = new JLabel("Provincia:");
      lblNewLabel_24.setBounds(12, 302, 56, 16);
      panel.add(lblNewLabel_24);

      JLabel lblNewLabel_25 = new JLabel("Educacion:");
      lblNewLabel_25.setBounds(12, 355, 62, 16);
      panel.add(lblNewLabel_25);

      JLabel lblNombreEmp = new JLabel("N/A");
      lblNombreEmp.setBounds(80, 37, 258, 16);
      panel.add(lblNombreEmp);

      JLabel lblCedulaEmp = new JLabel("N/A");
      lblCedulaEmp.setBounds(80, 90, 258, 16);
      panel.add(lblCedulaEmp);

      JLabel lblTelefonoEmp = new JLabel("N/A");
      lblTelefonoEmp.setBounds(80, 143, 258, 16);
      panel.add(lblTelefonoEmp);

      JLabel lblSexoEmp = new JLabel("N/A");
      lblSexoEmp.setBounds(80, 196, 258, 16);
      panel.add(lblSexoEmp);

      JLabel lblCorreoEmp = new JLabel("N/A");
      lblCorreoEmp.setBounds(80, 249, 258, 16);
      panel.add(lblCorreoEmp);

      JLabel lblProvinciaEmp = new JLabel("N/A");
      lblProvinciaEmp.setBounds(80, 302, 258, 16);
      panel.add(lblProvinciaEmp);

      JLabel lblTipoEmpleado = new JLabel("N/A");
      lblTipoEmpleado.setBounds(80, 355, 258, 16);
      panel.add(lblTipoEmpleado);

      JLabel lblEstaEmpleado = new JLabel("N/A");
      lblEstaEmpleado.setBounds(80, 408, 190, 16);
      panel.add(lblEstaEmpleado);

      JPanel panelSolicitar = new JPanel();
      tabbedPane.addTab("Solicitar", null, panelSolicitar, null);
      panelSolicitar.setLayout(null);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(33, 40, 442, 510);
      panelSolicitar.add(scrollPane);

      tblOfertasEnSolicitud = new JTable();
      scrollPane.setViewportView(tblOfertasEnSolicitud);

      JPanel panel_1 = new JPanel();
      panel_1.setLayout(null);
      panel_1.setBounds(508, 43, 310, 507);
      panelSolicitar.add(panel_1);

      JLabel label_10 = new JLabel("Puesto: ");
      label_10.setBounds(12, 27, 56, 16);
      panel_1.add(label_10);

      JLabel label_11 = new JLabel("Vacantes: ");
      label_11.setBounds(12, 70, 68, 16);
      panel_1.add(label_11);

      JLabel label_12 = new JLabel("Sexo:");
      label_12.setBounds(12, 156, 56, 16);
      panel_1.add(label_12);

      JLabel label_13 = new JLabel("Licencia: ");
      label_13.setBounds(12, 113, 56, 16);
      panel_1.add(label_13);

      JLabel label_14 = new JLabel("Mudanza:");
      label_14.setBounds(12, 199, 56, 16);
      panel_1.add(label_14);

      JLabel label_15 = new JLabel("Salario Min:");
      label_15.setBounds(12, 242, 78, 16);
      panel_1.add(label_15);

      JLabel label_16 = new JLabel("Provincia:");
      label_16.setBounds(12, 328, 68, 16);
      panel_1.add(label_16);

      JLabel label_17 = new JLabel("Salario Max:");
      label_17.setBounds(12, 285, 78, 16);
      panel_1.add(label_17);

      JLabel label_18 = new JLabel("Experiencia:");
      label_18.setBounds(12, 371, 78, 16);
      panel_1.add(label_18);

      JLabel label_19 = new JLabel("Estado:");
      label_19.setBounds(12, 457, 56, 16);
      panel_1.add(label_19);

      JLabel label_20 = new JLabel("Descripcion:");
      label_20.setBounds(12, 414, 88, 16);
      panel_1.add(label_20);

      JLabel lblPuestoSolicitar = new JLabel("N/A");
      lblPuestoSolicitar.setBounds(102, 27, 184, 16);
      panel_1.add(lblPuestoSolicitar);

      JLabel lblVacantesSolicitar = new JLabel("N/A");
      lblVacantesSolicitar.setBounds(102, 70, 184, 16);
      panel_1.add(lblVacantesSolicitar);

      JLabel lblLicenciaNecesitada = new JLabel("N/A");
      lblLicenciaNecesitada.setBounds(102, 113, 184, 16);
      panel_1.add(lblLicenciaNecesitada);

      JLabel lblSexoSolicitar = new JLabel("N/A");
      lblSexoSolicitar.setBounds(102, 156, 184, 16);
      panel_1.add(lblSexoSolicitar);

      JLabel lblMudanzaSolicitar = new JLabel("N/A");
      lblMudanzaSolicitar.setBounds(102, 199, 184, 16);
      panel_1.add(lblMudanzaSolicitar);

      JLabel lblSalarioMinSolicitar = new JLabel("N/A");
      lblSalarioMinSolicitar.setBounds(102, 242, 184, 16);
      panel_1.add(lblSalarioMinSolicitar);

      JLabel lblSalarioMaxSolic = new JLabel("N/A");
      lblSalarioMaxSolic.setBounds(102, 285, 184, 16);
      panel_1.add(lblSalarioMaxSolic);

      JLabel lblProvinciaSoli = new JLabel("N/A");
      lblProvinciaSoli.setBounds(101, 328, 185, 16);
      panel_1.add(lblProvinciaSoli);

      JLabel lblExperienciaSoli = new JLabel("N/A");
      lblExperienciaSoli.setBounds(101, 371, 185, 16);
      panel_1.add(lblExperienciaSoli);

      JLabel lblDescripcionSoli = new JLabel("N/A");
      lblDescripcionSoli.setBounds(101, 414, 185, 16);
      panel_1.add(lblDescripcionSoli);

      JLabel lblEstadoOfertaSoli = new JLabel("N/A");
      lblEstadoOfertaSoli.setBounds(98, 457, 188, 16);
      panel_1.add(lblEstadoOfertaSoli);

      JLabel label_32 = new JLabel("Detalles de la oferta");
      label_32.setBounds(508, 14, 122, 16);
      panelSolicitar.add(label_32);

      JLabel lblNewLabel_26 = new JLabel("Ofertas de empleo");
      lblNewLabel_26.setBounds(33, 11, 122, 16);
      panelSolicitar.add(lblNewLabel_26);

      JPanel panel_2 = new JPanel();
      panel_2.setLayout(null);
      panel_2.setBounds(826, 243, 196, 128);
      panelSolicitar.add(panel_2);

      JButton btnSolicitar = new JButton("Solicitar");
      btnSolicitar.setBounds(8, 31, 180, 59);
      panel_2.add(btnSolicitar);

      JPanel panelEmpresa = new JPanel();
      panelEmpresa.setToolTipText("");
      tabbedPane.addTab("Empresa", null, panelEmpresa, null);
      panelEmpresa.setLayout(null);

      JPanel panelOfertaEmpresa = new JPanel();
      panelOfertaEmpresa.setBounds(12, 41, 411, 536);
      panelEmpresa.add(panelOfertaEmpresa);
      panelOfertaEmpresa.setLayout(
         new BoxLayout(panelOfertaEmpresa, BoxLayout.X_AXIS)
      );

      JScrollPane scrollOfertasEmpresa = new JScrollPane();
      panelOfertaEmpresa.add(scrollOfertasEmpresa);

      ofertasEmpresaTbl = new JTable();
      scrollOfertasEmpresa.setViewportView(ofertasEmpresaTbl);

      JLabel lblMisOfertas = new JLabel("Ofertas concurrentes");
      lblMisOfertas.setBounds(293, 13, 130, 16);
      panelEmpresa.add(lblMisOfertas);

      JLabel lblNewLabel = new JLabel("Detalles de la oferta");
      lblNewLabel.setBounds(461, 41, 122, 16);
      panelEmpresa.add(lblNewLabel);

      JPanel panelDatosOferta = new JPanel();
      panelDatosOferta.setBounds(461, 70, 310, 507);
      panelEmpresa.add(panelDatosOferta);
      panelDatosOferta.setLayout(null);

      JLabel lblNewLabel_1 = new JLabel("Puesto: ");
      lblNewLabel_1.setBounds(12, 27, 56, 16);
      panelDatosOferta.add(lblNewLabel_1);

      JLabel lblNewLabel_2 = new JLabel("Vacantes: ");
      lblNewLabel_2.setBounds(12, 70, 68, 16);
      panelDatosOferta.add(lblNewLabel_2);

      JLabel lblNewLabel_3 = new JLabel("Sexo:");
      lblNewLabel_3.setBounds(12, 156, 56, 16);
      panelDatosOferta.add(lblNewLabel_3);

      JLabel lblNewLabel_4 = new JLabel("Licencia: ");
      lblNewLabel_4.setBounds(12, 113, 56, 16);
      panelDatosOferta.add(lblNewLabel_4);

      JLabel lblNewLabel_5 = new JLabel("Mudanza:");
      lblNewLabel_5.setBounds(12, 199, 56, 16);
      panelDatosOferta.add(lblNewLabel_5);

      JLabel lblNewLabel_6 = new JLabel("Salario Min:");
      lblNewLabel_6.setBounds(12, 242, 78, 16);
      panelDatosOferta.add(lblNewLabel_6);

      JLabel lblNewLabel_7 = new JLabel("Provincia:");
      lblNewLabel_7.setBounds(12, 328, 68, 16);
      panelDatosOferta.add(lblNewLabel_7);

      JLabel lblNewLabel_8 = new JLabel("Salario Max:");
      lblNewLabel_8.setBounds(12, 285, 78, 16);
      panelDatosOferta.add(lblNewLabel_8);

      JLabel lblNewLabel_9 = new JLabel("Experiencia:");
      lblNewLabel_9.setBounds(12, 371, 112, 16);
      panelDatosOferta.add(lblNewLabel_9);

      JLabel lblNewLabel_10 = new JLabel("Estado:");
      lblNewLabel_10.setBounds(12, 457, 56, 16);
      panelDatosOferta.add(lblNewLabel_10);

      JLabel lblNewLabel_11 = new JLabel("Descripcion:");
      lblNewLabel_11.setBounds(12, 414, 88, 16);
      panelDatosOferta.add(lblNewLabel_11);

      JLabel lblNewLabel_12 = new JLabel("N/A");
      lblNewLabel_12.setBounds(133, 27, 56, 16);
      panelDatosOferta.add(lblNewLabel_12);

      JLabel label = new JLabel("N/A");
      label.setBounds(133, 70, 56, 16);
      panelDatosOferta.add(label);

      JLabel label_1 = new JLabel("N/A");
      label_1.setBounds(133, 113, 56, 16);
      panelDatosOferta.add(label_1);

      JLabel label_2 = new JLabel("N/A");
      label_2.setBounds(133, 156, 56, 16);
      panelDatosOferta.add(label_2);

      JLabel label_3 = new JLabel("N/A");
      label_3.setBounds(133, 199, 56, 16);
      panelDatosOferta.add(label_3);

      JLabel label_4 = new JLabel("N/A");
      label_4.setBounds(133, 242, 56, 16);
      panelDatosOferta.add(label_4);

      JLabel label_5 = new JLabel("N/A");
      label_5.setBounds(133, 285, 56, 16);
      panelDatosOferta.add(label_5);

      JLabel label_6 = new JLabel("N/A");
      label_6.setBounds(133, 328, 56, 16);
      panelDatosOferta.add(label_6);

      JLabel label_7 = new JLabel("N/A");
      label_7.setBounds(136, 371, 56, 16);
      panelDatosOferta.add(label_7);

      JLabel label_8 = new JLabel("N/A");
      label_8.setBounds(133, 414, 56, 16);
      panelDatosOferta.add(label_8);

      JLabel label_9 = new JLabel("N/A");
      label_9.setBounds(133, 457, 56, 16);
      panelDatosOferta.add(label_9);

      JPanel panelManejoOfertas = new JPanel();
      panelManejoOfertas.setBounds(799, 168, 223, 254);
      panelEmpresa.add(panelManejoOfertas);
      panelManejoOfertas.setLayout(null);

      JLabel lblNewLabel_13 = new JLabel("Manejo de Ofertas");
      lblNewLabel_13.setBounds(12, 13, 129, 16);
      panelManejoOfertas.add(lblNewLabel_13);

      JButton agregarOfertaBtn = new JButton("Agregar ");
      agregarOfertaBtn.setBounds(23, 62, 180, 59);
      panelManejoOfertas.add(agregarOfertaBtn);

      JButton btnHabilDeshabil = new JButton("Habilitar/Deshabilitar");
      btnHabilDeshabil.setBounds(24, 141, 180, 59);
      panelManejoOfertas.add(btnHabilDeshabil);

      JPanel panelContratEmpresa = new JPanel();
      tabbedPane.addTab("Contratar", null, panelContratEmpresa, null);
      panelContratEmpresa.setLayout(null);

      JPanel panel_3 = new JPanel();
      panel_3.setBounds(12, 39, 372, 507);
      panelContratEmpresa.add(panel_3);
      panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

      JScrollPane scrollOfertasContrat = new JScrollPane();
      panel_3.add(scrollOfertasContrat);

      ofertasContratTbl = new JTable();
      scrollOfertasContrat.setViewportView(ofertasContratTbl);

      JLabel lblNewLabel_14 = new JLabel("Ofertas concurrentes");
      lblNewLabel_14.setBounds(253, 13, 130, 16);
      panelContratEmpresa.add(lblNewLabel_14);

      JLabel lblNewLabel_15 = new JLabel("Solicitudes");
      lblNewLabel_15.setBounds(457, 39, 67, 16);
      panelContratEmpresa.add(lblNewLabel_15);

      JPanel panel_6 = new JPanel();
      panel_6.setBounds(457, 68, 477, 222);
      panelContratEmpresa.add(panel_6);
      panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

      JScrollPane scrollSolicitudesContrat = new JScrollPane();
      panel_6.add(scrollSolicitudesContrat);

      solicitudesContratTbl = new JTable();
      scrollSolicitudesContrat.setViewportView(solicitudesContratTbl);

      JLabel lblNewLabel_16 = new JLabel("Solicitudes con mayor coincidencia");
      lblNewLabel_16.setBounds(457, 356, 220, 16);
      panelContratEmpresa.add(lblNewLabel_16);

      JScrollPane scrollMayorCoin = new JScrollPane();
      scrollMayorCoin.setBounds(457, 385, 477, 161);
      panelContratEmpresa.add(scrollMayorCoin);

      solitMayorCoinTbl = new JTable();
      scrollMayorCoin.setViewportView(solitMayorCoinTbl);

      JButton btnNewButton_1 = new JButton("Contratar");
      btnNewButton_1.setBounds(838, 559, 97, 25);
      panelContratEmpresa.add(btnNewButton_1);

      if (empresaActual != null) {
         tabbedPane.setEnabledAt(0, false);
         tabbedPane.setEnabledAt(1, false);
      } else if (personaActual != null) {
         tabbedPane.setEnabledAt(2, false);
         tabbedPane.setEnabledAt(3, false);
      }

      if (personaActual != null) {
         lblNombreEmp.setText(personaActual.getNombre());
         lblCedulaEmp.setText(personaActual.getCedula());
         lblTelefonoEmp.setText(personaActual.getNumeroTelefono());
         lblSexoEmp.setText(personaActual.getSexo());
         lblCorreoEmp.setText(personaActual.getCorreo());
         lblProvinciaEmp.setText(personaActual.getProvincia());

         if (personaActual instanceof Tecnico) {
            lblTipoEmpleado.setText("Tecnico");
         } else if (personaActual instanceof Universitario) {
            lblTipoEmpleado.setText("Universitario");
         } else if (personaActual instanceof Obrero) {
            lblTipoEmpleado.setText("Obrero");
         }

         lblEstaEmpleado.setText(personaActual.isEmpleada() ? "Si" : "No");
      }

      final Runnable cargarMisSolicitudes = new Runnable() {
         public void run() {
            misSolicitudesActuales.clear();
            DefaultTableModel modelo = new DefaultTableModel(
               new Object[] {
                  "Puesto",
                  "Salario Min",
                  "Salario Max",
                  "Mudanza",
               },
               0
            );

            if (personaActual != null) {
               misSolicitudesActuales.addAll(
                  controlador.showListSolicitudesByPersonalId(personaActual)
               );
               for (Solicitud s : misSolicitudesActuales) {
                  modelo.addRow(new Object[] {
                     s.getPuestoDeseado(),
                     s.getSalarioMinDeseado(),
                     s.getSalarioMaxDeseado(),
                     s.isDispMudanza() ? "Si" : "No",
                  });
               }
            }

            tblMisSolicitudes.setModel(modelo);
         }
      };
      cargarMisSolicitudes.run();

      btnRetirarSolicitud.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               int fila = tblMisSolicitudes.getSelectedRow();
               if (fila < 0 || fila >= misSolicitudesActuales.size()) {
                  JOptionPane.showMessageDialog(
                     Principal.this,
                     "Seleccione una solicitud.",
                     "Retirar",
                     JOptionPane.WARNING_MESSAGE
                  );
                  return;
               }
               controlador.removeRequest(misSolicitudesActuales.get(fila));
               cargarMisSolicitudes.run();
            }
         }
      );

      btnRenunciarEmpleo.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (personaActual == null) {
                  return;
               }
               boolean ok = controlador.renunciar(personaActual);
               if (ok) {
                  lblEstaEmpleado.setText("No");
               } else {
                  JOptionPane.showMessageDialog(
                     Principal.this,
                     "No estas empleado actualmente.",
                     "Renunciar",
                     JOptionPane.WARNING_MESSAGE
                  );
               }
            }
         }
      );

      final Runnable cargarOfertasParaSolicitar = new Runnable() {
         public void run() {
            ofertasEnSolicitud.clear();
            ofertasEnSolicitud.addAll(controlador.showActiveOffers());

            DefaultTableModel modelo = new DefaultTableModel(
               new Object[] { "Puesto", "Vacantes", "Provincia" },
               0
            );
            for (Oferta o : ofertasEnSolicitud) {
               modelo.addRow(new Object[] {
                  o.getPuesto(),
                  o.getCantidadPuestos(),
                  o.getProvincia(),
               });
            }
            tblOfertasEnSolicitud.setModel(modelo);
         }
      };
      cargarOfertasParaSolicitar.run();

      tblOfertasEnSolicitud.getSelectionModel().addListSelectionListener(
         new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
               if (e.getValueIsAdjusting()) {
                  return;
               }
               int fila = tblOfertasEnSolicitud.getSelectedRow();
               if (fila < 0 || fila >= ofertasEnSolicitud.size()) {
                  return;
               }
               Oferta o = ofertasEnSolicitud.get(fila);
               lblPuestoSolicitar.setText(o.getPuesto());
               lblVacantesSolicitar.setText(
                  String.valueOf(o.getCantidadPuestos())
               );
               lblLicenciaNecesitada.setText(
                  o.isRequiereLicencia() ? "Si" : "No"
               );
               lblSexoSolicitar.setText(o.getSexo());
               lblMudanzaSolicitar.setText(
                  o.isDispuestoMudarse() ? "Si" : "No"
               );
               lblSalarioMinSolicitar.setText(
                  String.valueOf(o.getSalarioMinimo())
               );
               lblSalarioMaxSolic.setText(String.valueOf(o.getSalarioMaximo()));
               lblProvinciaSoli.setText(o.getProvincia());
               lblExperienciaSoli.setText(
                  String.valueOf(o.getExperienciaRequerida())
               );
               lblDescripcionSoli.setText(o.getDescripcion());
               lblEstadoOfertaSoli.setText(
                  o.isActiva() ? "Activa" : "Inactiva"
               );
            }
         }
      );

      btnSolicitar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (personaActual == null) {
                  JOptionPane.showMessageDialog(
                     Principal.this,
                     "Solo un solicitante puede aplicar a ofertas.",
                     "Solicitar",
                     JOptionPane.WARNING_MESSAGE
                  );
                  return;
               }
               int fila = tblOfertasEnSolicitud.getSelectedRow();
               if (fila < 0 || fila >= ofertasEnSolicitud.size()) {
                  JOptionPane.showMessageDialog(
                     Principal.this,
                     "Seleccione una oferta.",
                     "Solicitar",
                     JOptionPane.WARNING_MESSAGE
                  );
                  return;
               }
               Oferta o = ofertasEnSolicitud.get(fila);
               Solicitar dialogo = new Solicitar(
                  controlador,
                  personaActual,
                  o.getPuesto(),
                  o.getExperienciaRequerida()
               );
               dialogo.setModal(true);
               dialogo.setVisible(true);
               cargarMisSolicitudes.run();
            }
         }
      );

      final Runnable cargarOfertasEmpresa = new Runnable() {
         public void run() {
            ofertasDeMiEmpresa.clear();
            DefaultTableModel modelo = new DefaultTableModel(
               new Object[] { "Codigo", "Puesto", "Vacantes", "Activa" },
               0
            );

            if (empresaActual != null) {
               ofertasDeMiEmpresa.addAll(empresaActual.getMisOfertas());
               for (Oferta o : ofertasDeMiEmpresa) {
                  modelo.addRow(new Object[] {
                     o.getCodigo(),
                     o.getPuesto(),
                     o.getCantidadPuestos(),
                     o.isActiva() ? "Si" : "No",
                  });
               }
            }

            ofertasEmpresaTbl.setModel(modelo);
         }
      };
      cargarOfertasEmpresa.run();

      ofertasEmpresaTbl.getSelectionModel().addListSelectionListener(
         new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
               if (e.getValueIsAdjusting()) {
                  return;
               }
               int fila = ofertasEmpresaTbl.getSelectedRow();
               if (fila < 0 || fila >= ofertasDeMiEmpresa.size()) {
                  return;
               }
               Oferta o = ofertasDeMiEmpresa.get(fila);
               lblNewLabel_12.setText(o.getPuesto());
               label.setText(String.valueOf(o.getCantidadPuestos()));
               label_1.setText(o.isRequiereLicencia() ? "Si" : "No");
               label_2.setText(o.getSexo());
               label_3.setText(o.isDispuestoMudarse() ? "Si" : "No");
               label_4.setText(String.valueOf(o.getSalarioMinimo()));
               label_5.setText(String.valueOf(o.getSalarioMaximo()));
               label_6.setText(o.getProvincia());
               label_7.setText(String.valueOf(o.getExperienciaRequerida()));
               label_8.setText(o.getDescripcion());
               label_9.setText(o.isActiva() ? "Activa" : "Inactiva");
            }
         }
      );

      agregarOfertaBtn.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (empresaActual == null) {
                  JOptionPane.showMessageDialog(
                     Principal.this,
                     "Solo una empresa puede agregar ofertas.",
                     "Agregar",
                     JOptionPane.WARNING_MESSAGE
                  );
                  return;
               }
               AgregarOferta dialogo = new AgregarOferta(
                  controlador,
                  empresaActual.getRnc()
               );
               dialogo.setModal(true);
               dialogo.setVisible(true);
               cargarOfertasEmpresa.run();
            }
         }
      );

      btnHabilDeshabil.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               int fila = ofertasEmpresaTbl.getSelectedRow();
               if (
                  empresaActual == null ||
                  fila < 0 ||
                  fila >= ofertasDeMiEmpresa.size()
               ) {
                  JOptionPane.showMessageDialog(
                     Principal.this,
                     "Seleccione una oferta.",
                     "Habilitar/Deshabilitar",
                     JOptionPane.WARNING_MESSAGE
                  );
                  return;
               }
               Oferta o = ofertasDeMiEmpresa.get(fila);
               controlador.toggleOfertaActiva(
                  empresaActual.getRnc(),
                  o.getCodigo()
               );
               cargarOfertasEmpresa.run();
            }
         }
      );

      final Runnable cargarContratar = new Runnable() {
         public void run() {
            ofertasActivasParaContratar.clear();
            solicitudesParaContratar.clear();

            DefaultTableModel modeloOfertas = new DefaultTableModel(
               new Object[] { "Codigo", "Puesto", "Vacantes" },
               0
            );
            DefaultTableModel modeloSolicitudes = new DefaultTableModel(
               new Object[] { "Puesto Deseado", "Salario Min", "Salario Max" },
               0
            );

            if (empresaActual != null) {
               ofertasActivasParaContratar.addAll(
                  empresaActual.getOfertasActivas()
               );
               for (Oferta o : ofertasActivasParaContratar) {
                  modeloOfertas.addRow(new Object[] {
                     o.getCodigo(),
                     o.getPuesto(),
                     o.getCantidadPuestos(),
                  });
               }

               solicitudesParaContratar.addAll(
                  controlador.showListSolicitudes()
               );
               for (Solicitud s : solicitudesParaContratar) {
                  modeloSolicitudes.addRow(new Object[] {
                     s.getPuestoDeseado(),
                     s.getSalarioMinDeseado(),
                     s.getSalarioMaxDeseado(),
                  });
               }
            }

            ofertasContratTbl.setModel(modeloOfertas);
            solicitudesContratTbl.setModel(modeloSolicitudes);

            DefaultTableModel modeloMayor = new DefaultTableModel(
               new Object[] { "Nombre", "Puesto", "Coincidencia" },
               0
            );

            solitMayorCoinTbl.setModel(modeloMayor);
         }
      };
      cargarContratar.run();

      ofertasContratTbl.getSelectionModel().addListSelectionListener(
         new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
               if (e.getValueIsAdjusting()) {
                  return;
               }

               int fila = ofertasContratTbl.getSelectedRow();

               if (fila < 0) {
                  return;
               }

               Oferta ofertaSeleccionada = ofertasActivasParaContratar.get(
                  fila
               );

               mejoresCandidatos.clear();
               mejoresCandidatos.addAll(
                  controlador.buscarMejoresCandidatos(ofertaSeleccionada)
               );

               DefaultTableModel modelo = new DefaultTableModel(
                  new Object[] { "Nombre", "Puesto", "Coincidencia" },
                  0
               );

               for (Solicitud s : mejoresCandidatos) {
                  double porcentaje = controlador.calcularCoincidencia(
                     ofertaSeleccionada,
                     s
                  );

                  modelo.addRow(new Object[] {
                     s.getSolicitante().getNombre(),
                     s.getPuestoDeseado(),
                     porcentaje + "%",
                  });
               }

               solitMayorCoinTbl.setModel(modelo);
            }
         }
      );

      btnNewButton_1.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               int filaOferta = ofertasContratTbl.getSelectedRow();
               int filaSolicitud = solitMayorCoinTbl.getSelectedRow();

               if (
                  filaOferta < 0 ||
                  filaOferta >= ofertasActivasParaContratar.size() ||
                  filaSolicitud < 0 ||
                  filaSolicitud >= mejoresCandidatos.size()
               ) {
                  JOptionPane.showMessageDialog(
                     Principal.this,
                     "Seleccione una oferta y una solicitud.",
                     "Contratar",
                     JOptionPane.WARNING_MESSAGE
                  );
                  return;
               }

               Oferta oferta = ofertasActivasParaContratar.get(filaOferta);
               Solicitud solicitud = mejoresCandidatos.get(filaSolicitud);

               boolean contratado = controlador.contratar(solicitud, oferta);

               if (contratado) {
                  JOptionPane.showMessageDialog(
                     Principal.this,
                     "Contratacion exitosa.",
                     "Contratar",
                     JOptionPane.INFORMATION_MESSAGE
                  );

                  cargarOfertasEmpresa.run();
               } else {
                  JOptionPane.showMessageDialog(
                     Principal.this,
                     "No se pudo completar la contratacion.",
                     "Contratar",
                     JOptionPane.ERROR_MESSAGE
                  );
               }
            }
         }
      );
   }
}
