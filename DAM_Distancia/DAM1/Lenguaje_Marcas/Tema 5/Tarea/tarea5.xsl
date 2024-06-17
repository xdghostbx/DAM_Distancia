<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/"> <!-- Plantilla principal para la tabla -->
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Tabla de artistas</title>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Año de nacimiento</th>
                        <th>Año de fallecimiento</th>
                        <th>País</th>
                        <th>Página web</th>
                    </tr>
                    <xsl:for-each select="artistas/artista"> <!-- Empieza el bucle for-each -->
                    <tr>
                        <td><xsl:value-of select="@cod"/></td>
                        <td><xsl:value-of select="nombreCompleto"/></td>
                        <td><xsl:value-of select="nacimiento"/></td>
                        <td>
                            <xsl:choose> 
                                <xsl:when test="string(fallecimiento)"> <!-- Verifica si hay un valor de fallecimiento -->
                                    <xsl:value-of select="fallecimiento"/>
                                </xsl:when>
                                <xsl:otherwise> <!-- Si no hay valor de fallecimiento, muestra "desconocido" -->
                                    Desconocido
                                </xsl:otherwise>
                            </xsl:choose>
                        </td>
                        <td><xsl:value-of select="pais"/></td>
                        <td>
                            <a>
                                <xsl:attribute name="href">
                                    <xsl:value-of select="fichaCompleta"/>
                                </xsl:attribute>
                                <xsl:attribute name="target">_blank</xsl:attribute>
                                Saber más
                            </a>
                        </td>
                    </tr>
                    </xsl:for-each> <!-- Termina el bucle for-each -->
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>