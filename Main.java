import Logic.BolsaEmpleo;
import Logic.IBolsaEmpleo;
import Server.BolsaEmpleoRemoto;
import UI.Login;
import java.awt.EventQueue;
import java.io.IOException;

public class Main {

   public static void main(String[] args) {
      EventQueue.invokeLater(
         new Runnable() {
            public void run() {
               IBolsaEmpleo controlador;

               if (args.length >= 2) {
                  // Modo cliente de red: java Main <host> <puerto>
                  String host = args[0];
                  int puerto = Integer.parseInt(args[1]);

                  try {
                     controlador = new BolsaEmpleoRemoto(host, puerto);
                     System.out.println(
                        "Conectado al servidor " + host + ":" + puerto
                     );
                  } catch (IOException e) {
                     System.out.println(
                        "No se pudo conectar al servidor: " + e.getMessage()
                     );
                     return;
                  }
               } else {
                  // Modo local: sin sockets, BolsaEmpleo lee/escribe los .dat directamente.
                  controlador = new BolsaEmpleo();
               }

               Login login = new Login(controlador);
               login.setModal(true);
               login.setDefaultCloseOperation(Login.DISPOSE_ON_CLOSE);
               login.setVisible(true);
            }
         }
      );
   }
}
