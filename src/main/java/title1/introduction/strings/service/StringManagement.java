package title1.introduction.strings.service;

import java.util.List;

public interface StringManagement {

  /**
   * Este método compara objetos de tipo String. Si dos objetos están almacenados en la misma dirección de memoria,
   * entonces se trata del mismo objeto.
   */
  boolean compareStrings(String firstString, String secondString);

  /**
   * Este método concatena (une, enlaza) cadenas.
   */
  String concatenateStrings(String firstString, String secondString);

  /**
   * Este método separa una cadena y devuelve sus elementos en una lista.
   */
  List<String> splitString(String string);

  /**
   * Este método parsea (cambia el tipo) el objeto de tipo String.
   */
  void wrapString();

  /**
   * Este devuelve una lista con los caracteres que contiene una cadena.
   */
  char[] getCharacterListFromString(String string);

  /**
   * Este método presenta algunos métodos para el tratamiento de cadenas.
   */
  void othersMethodsForStrings(String string);
}
