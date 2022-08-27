package mx.unam.ciencias.edd.proyecto1;
import mx.unam.ciencias.edd.Lista;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

  public class UsarArchivo {
    private UsarArchivo(){}

      /**
       * Guarda es un método que guardará todas las cadenas de la lista en el archivo.
       * @param nombreDelArchivo es el nombre del archivo a guardar.
       * @param lista será la lista donde se sacarán todas las cadenas de texto.
       */
       public static <T> void guarda(String nombreDelArchivo, Lista<T> lista)
       throws IOException {
         FileOutputStream fileOut = new FileOutputStream(nombreDelArchivo);
         OutputStreamWriter osOut = new OutputStreamWriter(fileOut);
         BufferedWriter out = new BufferedWriter(osOut);
         for (T s : lista) {
           out.write(s.toString());
         }
         out.close();
       }

      /**
       * carga guardará las cadenas en una lista específica.
       * @param nombreDelArchivo nombre del archivo dónde se leeran las cadenas.
       * @param lista la lista donde se guardará las cadenas de texto.
       */
       public static void carga(String nombreDelArchivo, Lista<Texto> lista)
       throws IOException {
           FileInputStream fileIn = new FileInputStream(nombreDelArchivo);
           InputStreamReader isIn = new InputStreamReader(fileIn);
           BufferedReader in = new BufferedReader(isIn);
           String l = in.readLine();
           while(l != null){
             lista.agregaFinal(new Texto(l));
             l = in.readLine();
           }
      }

      /**
      * Imprimirá todos los elementos de una lista en consola.
      * @param lista: la lista que imprimirá.
      */
      public static <T> void imprimeConsola(Lista<T> lista){
        for(T r : lista){
          System.out.println(r.toString() + " ");
        }
      }

  }
