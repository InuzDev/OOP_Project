import Logic.BolsaEmpleo;
import UI.Login;
import java.awt.EventQueue;

public class Main {

   public static void main(String[] args) {
      EventQueue.invokeLater(
         new Runnable() {
            public void run() {
               BolsaEmpleo controlador = new BolsaEmpleo();
               Login login = new Login(controlador);
               login.setModal(true);
               login.setDefaultCloseOperation(Login.DISPOSE_ON_CLOSE);
               login.setVisible(true);
            }
         }
      );
   }
}
