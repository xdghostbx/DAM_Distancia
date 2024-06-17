_______________________________________________________________________________________________________________________________________

_______________________________________________________________________________________________________________________________________


<?xml version="1.0" encoding="UTF-8"?> <!-- Esta línea especifica que el documento es XML, utiliza versión 1.0 y codificación UTF-8 -->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
<!-- Define el documento como una hoja de estilo XSLT versión 1.0 y declara el espacio de nombres XSLT -->

<xsl:template match="/"> 
<!-- Inicia una plantilla que se aplica al nodo raíz del documento XML de entrada -->

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
        <!-- Inicia un bucle para cada elemento 'character' dentro de la estructura especificada -->
        <tr> <!-- Comienza una fila de tabla por cada personaje -->
          <td><xsl:value-of select="name"/></td> <!-- Celda que muestra el nombre del personaje -->
      <td><xsl:value-of select="house"/></td> <!-- Celda que muestra la casa del personaje -->
      <td><xsl:value-of select="title"/></td> <!-- Celda que muestra el título del personaje -->
      <td><img><xsl:attribute name="src"><xsl:value-of select="img"/></xsl:attribute></img></td> 

          <!-- Celda que contiene una imagen. Utiliza un elemento <img> y establece dinámicamente su atributo 'src' al valor del elemento 'img' del XML -->
        </tr>
        </xsl:for-each> <!-- Termina el bucle for-each -->
      </table>
    </body> <!-- Cierra el cuerpo del documento HTML -->
  </html>
</xsl:template>

</xsl:stylesheet> <!-- Cierra la hoja de estilo XSLT -->

