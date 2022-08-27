package mx.unam.ciencias.edd.proyecto1;
import mx.unam.ciencias.edd.Lista;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

  public class Bandera{
    String[] bandera;

    /*
     * Constructor de la clase
     */
     public Bandera(String[] bandera) {
       this.bandera = bandera;
     }

     /*
      * Este método verificara si se tiene que ejecutar el programa
      * con entrada normal o si leeran uno o más archivos.
      */

     public void inicio() throws IOException {
       if (bandera.length == 0) {
         entradaNormal();
         return;
       }
       boolean banderaReversa = false;
       boolean banderaDestructiva = false;
       String reconoce = ".txt";
       String archivoMaligno = null;
       Lista<Texto> lista = new Lista<>();
       for (int i = 0;i < bandera.length;i++) {
         if (bandera[i].contains(reconoce))
           UsarArchivo.carga(bandera[i],lista);
           if(bandera[i].equals("-r"))
           banderaReversa = true;
           if(bandera[i].equals("-o")){
             banderaDestructiva = true;
             try {
               archivoMaligno = bandera[i+1];
               i = i+1;
             } catch (Exception e) {
               System.out.println("No hay un archivo para guardar");
               banderaDestructiva = false;
             }
           }
         }
         realizaOperaciones(lista, banderaReversa, banderaDestructiva, archivoMaligno);
       }

       /*
        * Se mandará a llamar cuando se encuentre la banderaReversa o la banderaDestructiva.
        */

        public void realizaOperaciones(Lista<Texto> lista, boolean banderaReversa,
                                       boolean banderaDestructiva, String archivoMaligno)
        throws IOException {

        if(banderaReversa && banderaDestructiva) {
          Lista<Texto> listaM = lista.mergeSort(lista).reversa();
          UsarArchivo.imprimeConsola(listaM);
          UsarArchivo.guarda(archivoMaligno, listaM);
        }
        else if(banderaReversa) {
          Lista<Texto> listaM = lista.mergeSort(lista).reversa();
          UsarArchivo.imprimeConsola(listaM);
        }
        else if(banderaDestructiva) {
          Lista<Texto> listaM = lista.mergeSort(lista);
          UsarArchivo.guarda(archivoMaligno, listaM);
        }
        else {
          UsarArchivo.imprimeConsola(lista.mergeSort(lista));
        }
     }

     /**
      * Se mandará a llamar cuando se especifique en el inicio de la ejecución
      * del programa. Leera todo lo del usuario línea por línea y después
      * realizará la ordenación.
      */
      public void entradaNormal()
      throws IOException {
        Lista<Texto> lista = new Lista<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader((System.in), "UTF-8"))){
          String linea = br.readLine();
          while (linea != null) {
            lista.agregaFinal(new Texto(linea));
            linea = br.readLine();
          }
        } catch (Exception e) {
          System.out.println("Error en la entrada normal");
          System.exit(1);
        }
        System.out.println("");
        UsarArchivo.imprimeConsola(lista.mergeSort(lista));
      }
  }
