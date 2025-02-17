<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>
<xsl:template match="/">
    <html>
        <head>
		<meta charset="UTF-8"/>
			<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
				<title>Aplicación Web MatchAI</title>
				<link rel="stylesheet" href="css/style.css"/>
		</head>

        <body>
        <header id="inicio">
            <h1><xsl:value-of select="//programa/nombre"/></h1>
            <p><xsl:value-of select="//programa/titulo"/></p>

            <div class="header-images">
                <xsl:element name="img">
                    <xsl:attribute name="src">
                        <xsl:value-of select="//programa/imagen"/>
                    </xsl:attribute>
                </xsl:element>
            </div>
            <nav>
                Candidatos
                <form id="candidateForm">
                <select name="selectedId" id="candidateSelector">
                <option value="">Selecciona el candidato</option>
                <!--Recorremos desde candidato y ordenamos por el nodo nombre y salimos con un option -->
                                
                <xsl:for-each select="//candidato">
                <xsl:sort select="nombre" order="ascending"/>
                <option value="@id">
                 <xsl:if test="@id='DF05'">
                                            <xsl:attribute name="selected">
                                                selected
                                            </xsl:attribute>
                                        </xsl:if>
                 <xsl:value-of select="nombre"/></option>
                </xsl:for-each>
                </select>
                 <br/>
                <button type="button">Buscar perfil candidato</button>
                </form>
            </nav>
            </header>

            <section class="contenedor-80">
                <h1>candidato seleccionado: 
                <!-- ** <xsl:value-of select="//candidato/@id"/></h1>
                Seleccionariamos las etiquetas del candidato con id DF05 -->
                 <xsl:value-of select="//candidato[@id='DF05']/@id"/></h1>
            </section>

            <main id="candidatos" class="contenedor-80">
                <div>
                
                    <ul>CARACTERISTICAS QUE VALORA
                        <!--* <xsl:for-each select="//candidato/desea_pareja">
                          faltaría seleccionar el candidato DF05 por su id
                         *** bucle recorre a nivel etiqueta -->
                           <xsl:for-each select="//candidato[@id='DF05']/desea_pareja/etiqueta"> 
                            <li><xsl:value-of select="."/></li>
                        </xsl:for-each>
                    </ul>
                </div>



                <div class="card">
                <!--** Faltó el id del candidato que estamos seleccionando -->
                    <h3><xsl:value-of select="//candidato[@id='DF05']/edad"/></h3>

                        <div class="card-image">
                            <xsl:element name="img">
                                <xsl:attribute name="src">
                                    <xsl:value-of select="//candidato[@id='DF05']/imagen"/>
                                </xsl:attribute>
                        </xsl:element>
                        </div>
                

                    <div class="text">
                        <h2><xsl:value-of select="//candidato[@id='DF05']/nombre"/></h2>
                        <h4><xsl:value-of select="//candidato[@id='DF05']/profesion"/></h4>
                        <p><xsl:value-of select="//candidato[@id='DF05']/bio"/></p>
                    </div>
                </div>
            </main>
        </body>
    </html>

</xsl:template>
</xsl:stylesheet>