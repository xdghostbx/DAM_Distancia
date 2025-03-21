(: 8-Marca y modelo de las impresoras con tamaño A3 (pueden tener otro):)
for $x in doc("impresoras.xml")/impresoras/impresora
where ($x/tamaño) = "A3"
return <impresora>
      <marca>
          {$x/marca/text()}
      </marca>
      <modelo>
          {$x/modelo/text()}
      </modelo>
  </impresora>


  (: Marca y modelo de las impresoras con tamaño A3 (puede tener otros) :)
for $x in doc("impresoras.xml")/impresoras/impresora
where  $x/tamaño = "A3"
return <impresora>{$x/marca, $x/modelo}</impresora>,