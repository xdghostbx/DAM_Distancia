(: 7-marca y modelo de las impresoras con más de 1 tamaño:)
for $x in doc("impresoras.xml")/impresoras/impresora
where count($x/tamaño)>1
return <impresora>{$x/marca,$x/modelo}</impresora>