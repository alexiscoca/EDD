package mx.unam.ciencias.edd.proyecto1;

import java.text.Collator;

public class Texto implements Comparable<Texto>{

  String texto;
  /**
  * Constructor de la clase.
  * @param texto El texto
  */
  public Texto(String texto){
    this.texto = texto;
  }
  @Override public String toString(){
    return texto;
  }
  /**
  * Criterio de comparacion entre dos textos.
  * @param texto El nombre del archivo en el cual se guardará.
  */
  @Override public int compareTo(Texto p){
      Collator collator = Collator.getInstance();
      collator.setStrength(Collator.PRIMARY);
      return collator.compare(texto.replaceAll("\\P{L}+",""), p.toString().replaceAll("\\P{L}+",""));
  }
}
