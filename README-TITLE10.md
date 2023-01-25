# CASO PRÁCTICO XML PARSER
Módulo que demuestra la aplicabilidad del Metalenguaje XML para la
representación (modelamiento) y procesamiento de datos semiestructurados.

## Alcance
1. Representar el carné universitario en un modelo semántico de estructura
   jerárquica.
2. Representar el modelo del punto anterior (1) en un diagrama UML.
3. Representar el modelo identificado en el punto anterior (2) en un formato
   (documento XML-CU) basado en el metalenguaje XML.
4. Elaborar las reglas de estructuración y secuencia (esquema) para el
   documento del punto anterior (3), utilizando el lenguaje XML Schema.
5. Implementar un módulo de software que soporte el procesamiento XML (Parsing XML), para leer un documento XML- CU
   y lo valide contra el esquema XML y envié los siguientes mensajes:
    - “Documento XML- CU no está bien formado”, cuando aplique.
    - “Documento XML- CU no es válido”, cuando aplique.
    - “Documento XML- CU es bien formado y es válido”
    - Número de estudiante de Ingeniería de Sistemas.
    - Número de estudiantes de Ingeniería de Software.

## Prerrequisitos
- Configurar la ruta absoluta de XML_DOCUMENT_LIST en el archivo Constants.java

### Acceso a datos:
- El repositorio de datos es el documento XML universityCardList.xml
