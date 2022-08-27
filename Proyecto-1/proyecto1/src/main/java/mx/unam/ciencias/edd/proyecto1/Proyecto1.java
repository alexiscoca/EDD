package mx.unam.ciencias.edd.proyecto1;
import java.io.IOException;

/**
 * Clase para correr el Proyecto1 ("Ordenador Lexicografico")
 */
 public class Proyecto1 {

   public static void main(String[] args) throws IOException {
      String[] bandera = args;
      Bandera banderaProyecto = new Bandera(bandera);
      banderaProyecto.inicio();
      
        }
 }
