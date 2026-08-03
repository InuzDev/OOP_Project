package UI;

import Logic.BolsaEmpleo;
import Logic.IBolsaEmpleo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class DatosBolsa extends JDialog {

   private final JPanel contentPanel = new JPanel();
   private IBolsaEmpleo controlador;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      try {
         DatosBolsa dialog = new DatosBolsa(new BolsaEmpleo());
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public DatosBolsa(IBolsaEmpleo controlador) {
      this.controlador = controlador;
      setBackground(new Color(255, 250, 240));
      setTitle("Datos");
      setBounds(100, 100, 1003, 774);
      setLocationRelativeTo(null);

      getContentPane().setLayout(new BorderLayout());

      contentPanel.setBackground(new Color(255, 255, 240));
      contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 80));
      contentPanel.setBorder(new LineBorder(new Color(160, 82, 45), 3));
      getContentPane().add(contentPanel, BorderLayout.CENTER);

      int totalUniversitarios = controlador.listCollegeStudent().size();
      int totalTecnicos = controlador.showListTecnicians().size();
      int totalObreros = controlador.listLaborer().size();

      int totalOfertasActivas = controlador.showActiveOffers().size();
      int totalSolicitudesActivas = controlador.showListSolicitudes().size();

      DefaultPieDataset pieDataset = new DefaultPieDataset();
      pieDataset.setValue("Universitarios", totalUniversitarios);
      pieDataset.setValue("Técnicos", totalTecnicos);
      pieDataset.setValue("Obreros", totalObreros);

      JFreeChart pieChart = ChartFactory.createPieChart3D(
         "Distribución de Candidatos",
         pieDataset,
         true,
         true,
         false
      );

      PiePlot3D pieplot3d = (PiePlot3D) pieChart.getPlot();
      pieplot3d.setDepthFactor(0.2);
      pieplot3d.setStartAngle(290D);
      pieplot3d.setDirection(Rotation.CLOCKWISE);
      pieplot3d.setForegroundAlpha(0.7F);

      ChartPanel pieChartPanel = new ChartPanel(pieChart);
      pieChartPanel.setPreferredSize(new java.awt.Dimension(430, 450));
      contentPanel.add(pieChartPanel);

      DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
      barDataset.setValue(totalOfertasActivas, "Cantidad", "Ofertas Activas");
      barDataset.setValue(
         totalSolicitudesActivas,
         "Cantidad",
         "Solicitudes de Empleo"
      );

      JFreeChart barChart = ChartFactory.createBarChart3D(
         "Estado del Mercado",
         "Categoría",
         "Total",
         barDataset,
         PlotOrientation.VERTICAL,
         true,
         true,
         false
      );

      ChartPanel barChartPanel = new ChartPanel(barChart);
      barChartPanel.setPreferredSize(new java.awt.Dimension(430, 450));
      contentPanel.add(barChartPanel);

      JPanel buttonPane = new JPanel();
      buttonPane.setBackground(new Color(255, 255, 240));
      buttonPane.setBorder(new LineBorder(new Color(160, 82, 45), 3));
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);

      JButton cancelButton = new JButton("Cerrar");
      cancelButton.setForeground(new Color(255, 255, 240));
      cancelButton.setBackground(new Color(160, 82, 45));
      cancelButton.setActionCommand("Cancel");
      cancelButton.addActionListener(e -> dispose());
      buttonPane.add(cancelButton);
   }
}
