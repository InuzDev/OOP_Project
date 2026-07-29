package Server;

import java.io.Serializable;
import java.util.Arrays;

public class Peticion implements Serializable {

   private static final long serialVersionUID = 1L;

   public static final String LOGIN = "LOGIN";
   public static final String REGISTRAR_PERSONAL = "REGISTRAR_PERSONAL";
   public static final String REMOVER_PERSONAL = "REMOVER_PERSONAL";
   public static final String BUSCAR_PERSONAL_POR_ID = "BUSCAR_PERSONAL_POR_ID";
   public static final String BUSCAR_PERSONAL_POR_CEDULA =
      "BUSCAR_PERSONAL_POR_CEDULA";
   public static final String LISTAR_PERSONAL = "LISTAR_PERSONAL";
   public static final String LISTAR_TECNICOS = "LISTAR_TECNICOS";
   public static final String LISTAR_UNIVERSITARIOS = "LISTAR_UNIVERSITARIOS";
   public static final String LISTAR_OBREROS = "LISTAR_OBREROS";
   public static final String REGISTRAR_EMPRESA = "REGISTRAR_EMPRESA";
   public static final String REMOVER_EMPRESA = "REMOVER_EMPRESA";
   public static final String BUSCAR_EMPRESA_POR_RNC = "BUSCAR_EMPRESA_POR_RNC";
   public static final String LISTAR_EMPRESAS = "LISTAR_EMPRESAS";
   public static final String LISTAR_EMPRESAS_POR_TIPO =
      "LISTAR_EMPRESAS_POR_TIPO";
   public static final String CREAR_SOLICITUD = "CREAR_SOLICITUD";
   public static final String REMOVER_SOLICITUD = "REMOVER_SOLICITUD";
   public static final String LISTAR_SOLICITUDES = "LISTAR_SOLICITUDES";
   public static final String LISTAR_SOLICITUDES_POR_PERSONA =
      "LISTAR_SOLICITUDES_POR_PERSONA";
   public static final String AGREGAR_OFERTA = "AGREGAR_OFERTA";
   public static final String LISTAR_TODAS_OFERTAS = "LISTAR_TODAS_OFERTAS";
   public static final String LISTAR_OFERTAS_ACTIVAS = "LISTAR_OFERTAS_ACTIVAS";
   public static final String CONTRATAR = "CONTRATAR";
   public static final String RENUNCIAR = "RENUNCIAR";
   public static final String TOGGLE_OFERTA_ACTIVA = "TOGGLE_OFERTA_ACTIVA";
   public static final String CALCULAR_COINCIDENCIA = "CALCULAR_COINCIDENCIA";
   public static final String BUSCAR_MEJORES_CANDIDATOS =
      "BUSCAR_MEJORES_CANDIDATOS";
   public static final String DESCONECTAR = "DESCONECTAR";

   private String accion;
   private Object[] parametros;

   public Peticion(String accion, Object... parametros) {
      this.accion = accion;
      this.parametros = parametros;
   }

   public String getAccion() {
      return accion;
   }

   public Object[] getParametros() {
      return parametros;
   }

   @Override
   public String toString() {
      return (
         "Peticion{accion='" +
         accion +
         "', parametros=" +
         Arrays.toString(parametros) +
         '}'
      );
   }
}
