(: 2- El nombre (sin etiquetas) de los que nacieron antes de 1500 :)
for $x in doc ("artistas.xml")/artistas/artista
where number ($x/nacimiento) < 1500
return data ($x/nombreCompleto)