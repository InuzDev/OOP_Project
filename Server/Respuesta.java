package Server;

import java.io.Serializable;

public class Respuesta implements Serializable {

   private static final long serialVersionUID = 1L;

   private boolean exito;
   private Object resultado;
   private String mensajeError;

   public static Respuesta ok(Object resultado) {
      Respuesta resp = new Respuesta();
      resp.exito = true;
      resp.resultado = resultado;
      return resp;
   }

   public static Respuesta error(String mensajeError) {
      Respuesta r = new Respuesta();
      r.exito = false;
      r.mensajeError = mensajeError;
      return r;
   }

   public boolean isExito() {
      return exito;
   }

   public Object getResultado() {
      return resultado;
   }

   public String getMensajeError() {
      return mensajeError;
   }
}
