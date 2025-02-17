_______________________________________________________________________________________________________________________________________
XML, normal de los que llevamos haciendo desde el principio de curso
_______________________________________________________________________________________________________________________________________

<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet href="plantilla.xsl" type="text/xsl"?>  <!-- Esta línea es el enlace con el xsl, que es como una forma de aplicar estilos a xml, para que se entienda -->
<stormlightArchive>
    <book number="1">
        <characters>
            <character>
                <name>Dalinar Kholin</name>
                <house>Kholin</house>
                <title>Blackthorn</title>
                <img>https://static.wikia.nocookie.net/stormlightarchive/images/c/ca/Dalinar_Kholin.jpg</img>
            </character>
            <character>
                <name>Kaladin</name>
                <house>-</house>
                <title>Stormblessed</title>
                <img>https://static.wikia.nocookie.net/stormlightarchive/images/6/64/LighteyedKaladin.jpg</img>
            </character>
            <character>
                <name>Shallan Davar</name>
                <house>Davar</house>
                <title>Brightness</title>
               <img>https://static.wikia.nocookie.net/stormlightarchive/images/c/c7/SbC_CS.jpg</img>
            </character>
            <character>
                <name>Szeth</name>
                <house>-</house>
                <title>Truthless</title>
               <img>https://static.wikia.nocookie.net/stormlightarchive/images/3/30/Szeth_BMS.jpg</img>
           </character>
            <character>
                <name>Adolin Kholin</name>
                <house>Kholin</house>
                <title>Brihtlord</title>
                <img>https://static.wikia.nocookie.net/stormlightarchive/images/2/25/Adolin_TS.jpg</img>
            </character>
            <character>
                <name>Sylphrena</name>
                <house>Honorspren</house>
                <title>Ancient Daughter</title>
                <img>https://static.wikia.nocookie.net/stormlightarchive/images/6/64/Kaladin_and_syl.jpg</img>
            </character>
           
        </characters>
    </book>
</stormlightArchive>

_______________________________________________________________________________________________________________________________________
XSL, la parte nueva, tendrían que estar separados en 2 documentos
_______________________________________________________________________________________________________________________________________

<?xml version="1.0" encoding="UTF-8"?> <!-- Esta línea especifica que el documento es XML, utiliza versión 1.0 y codificación UTF-8 -->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
<!-- Define el documento como una hoja de estilo XSLT versión 1.0 y declara el espacio de nombres XSLT -->

<xsl:template match="/"> 
<!-- 
Inicia una plantilla que se aplica al nodo raíz del documento XML de entrada, no se que hace, pero todos lados de internet lo usan.

A partir de este punto es hace un HTML con lo que te pida el ejercicio, como nos piden tablas, hacemos una tabla y le aplicamos la estetica 
que más se asemeje a lo que nos piden.
 -->

  <html> <!-- Comienza el documento HTML  -->
    <head> <!-- Inicia la sección head del HTML -->
      <style> 
      img{width:100px; height:auto; } 
      </style> <!-- Define estilos CSS para las imágenes, estableciendo su ancho a 100px y su altura automática -->
    </head> <!-- Cierra la sección head -->
    <body> <!-- Comienza el cuerpo del documento HTML -->
      <h2>Personajes del Archivo de las Tormentas - Libro 1</h2> <!-- Título de la sección -->
      <table border="1"> <!-- Comienza la tabla con un borde -->
        <tr bgcolor="#9acd32"> <!-- Primera fila de la tabla con un color de fondo específico -->
          <th>Nombre</th> <!-- Encabezado de columna para nombres -->
          <th>Casa</th> <!-- Encabezado de columna para casas -->
          <th>Título</th> <!-- Encabezado de columna para títulos -->
          <th>Imagen</th> <!-- Encabezado de columna para imágenes -->
        </tr>
        <xsl:for-each select="stormlightArchive/book/characters/character"> 
        <!-- Inicia un bucle para cada elemento 'character' dentro de la estructura especificada 
        Esto son los atributos del xml, tienen que estar igual si no no funciona o da error-->
        <tr> <!-- Comienza una fila de tabla por cada personaje -->
          <td><xsl:value-of select="name"/></td> <!-- Celda que muestra el nombre del personaje -->
      <td><xsl:value-of select="house"/></td> <!-- Celda que muestra la casa del personaje -->
      <td><xsl:value-of select="title"/></td> <!-- Celda que muestra el título del personaje -->
      <td><img><xsl:attribute name="src"><xsl:value-of select="img"/></xsl:attribute></img></td> 
          <!-- Celda que contiene una imagen. Utiliza un elemento <img> y establece dinámicamente su atributo 'src' al valor del elemento 'img' del XML
          En otras palabras... Abre atributo, selecciona la imagen que esta enlazada en el xml, cierra atributo -->
        </tr>
        </xsl:for-each> <!-- Termina el bucle for-each -->
      </table>
    </body> <!-- Cierra el cuerpo del documento HTML -->
  </html>
</xsl:template>

</xsl:stylesheet> <!-- Cierra la hoja de estilo XSLT -->