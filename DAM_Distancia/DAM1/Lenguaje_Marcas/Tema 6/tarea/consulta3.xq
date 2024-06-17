(: 3- Nombre de los artistas para los que no hay año de fallecimiento:)
for $x in doc("artistas.xml")/artistas/artista
where not ($x/fallecimiento)
return data ($x/nombreCompleto)