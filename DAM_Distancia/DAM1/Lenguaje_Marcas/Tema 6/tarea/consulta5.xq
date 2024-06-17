(: 5- el numero de artistas nacidos antes de 1600:)
for $x in doc("artistas.xml")/artistas
let $y := $x/artista[number(nacimiento) < 1600]
return count($y)